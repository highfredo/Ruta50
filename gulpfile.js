// Generated on 2015-01-21 using generator-jhipster 2.0.0
/* jshint camelcase: false */
'use strict';

var gulp = require('gulp'),
    prefix = require('gulp-autoprefixer'),
    minifyCss = require('gulp-minify-css'),
    usemin = require('gulp-usemin'),
    uglify = require('gulp-uglify'),
    minifyHtml = require('gulp-minify-html'),
    imagemin = require('gulp-imagemin'),
    ngAnnotate = require('gulp-ng-annotate'),
    jshint = require('gulp-jshint'),
    rev = require('gulp-rev'),
    connect = require('gulp-connect'),
    proxy = require('proxy-middleware'),
    es = require('event-stream'),
    flatten = require('gulp-flatten'),
    clean = require('gulp-clean'),
    replace = require('gulp-replace'),
    url = require('url'),
    nib = require('nib'),
    inject = require('gulp-inject'),
    wiredep = require('wiredep').stream,
    stylus= require('gulp-stylus'),
    historyApiFallBack = require('connect-history-api-fallback');

var karma = require('gulp-karma')({configFile: 'src/test/javascript/karma.conf.js'});

var yeoman = {
    app: 'src/main/webapp/',
    dist: 'src/main/webapp/dist/',
    test: 'src/test/javascript/spec/',
    tmp: '.tmp/',
    port: 9000,
    apiPort: 8080,
    liveReloadPort: 35729
};

gulp.task('inject',function(){
	var sources= gulp.src([yeoman.app+"scripts/**/*.js", yeoman.app+"assets/styles/**/*.css"]);
	return gulp.src(yeoman.app+'index.html',{cwd: yeoman.app})
	  .pipe(inject(sources,{
	      read:false,
	      ignorePath: yeoman.app
	  }))
	  .pipe(gulp.dest(yeoman.app));
});

gulp.task('wiredep',function(){
    gulp.src(yeoman.app+'index.html')
    .pipe(wiredep({
        directory: yeoman.app + '/lib'
    }))
    .pipe(gulp.dest(yeoman.app));
});


gulp.task('clean', function() {
    return gulp.src(yeoman.dist, {read: false}).
        pipe(clean());
});

gulp.task('clean:tmp', function() {
    return gulp.src(yeoman.tmp, {read: false}).
        pipe(clean());
});

gulp.task('test', function() {
    karma.once();
});

gulp.task('copy', ['clean'], function() {
    return es.merge(gulp.src(yeoman.app + 'i18n/**').
              pipe(gulp.dest(yeoman.dist + 'i18n/')),
              gulp.src(yeoman.app + 'assets/**/*.{woff,svg,ttf,eot}').
              pipe(flatten()).
              pipe(gulp.dest(yeoman.dist + 'assets/fonts/')));
});

gulp.task('images', function() {
    return gulp.src(yeoman.app + 'assets/images/**').
        pipe(imagemin({optimizationLevel: 5})).
        pipe(gulp.dest(yeoman.dist + 'assets/images')).
        pipe(connect.reload());
});

gulp.task('css', [], function() {
    return gulp.src(yeoman.app + 'assets/styles/**/*.css').
    	pipe(stylus({ use: nib() })).
        pipe(gulp.dest(yeoman.tmp)).
        pipe(connect.reload());
});

gulp.task('scripts', function () {
    gulp.src(yeoman.app + 'scripts/**').
        pipe(connect.reload());
});

gulp.task('server', ['watch'], function() {
    var baseUri = 'http://localhost:' + yeoman.apiPort;
    // Routes to proxy to the backend
    var proxyRoutes = [
        '/api',
        '/health',
        '/configprops',
        '/api-docs',
        '/metrics',
        '/dump',
        '/oauth/token'
    ];

    connect.server({
        root: [yeoman.app, yeoman.tmp],
        // hostname: '0.0.0.0',
        port: yeoman.port,
        livereload: {
            port: yeoman.liveReloadPort
        },/*
        middleware: function(connect,opt) {
            return [ historyApiFallBack ];
        }*/
        
        middleware: function() {
            // Build a list of proxies for routes: [route1_proxy, route2_proxy, ...]
            return proxyRoutes.map(function (r) {
                var options = url.parse(baseUri + r);
                options.route = r;
                return proxy(options);
            });
        }
        
    });
});

// Aqui juan lanza jshint, pero no veo necesario hacerlo cada vez que se edita algo
gulp.task('watch', function() {
    gulp.watch(yeoman.app + '*.html', ['usemin']);
    gulp.watch(yeoman.app + 'scripts/**', ['scripts']);
    gulp.watch(yeoman.app + 'assets/styles/**/*.css', ['styles']);
    gulp.watch('src/images/**', ['images']);
});

gulp.task('server:dist', ['build'], function() {
    var baseUri = 'http://localhost:' + yeoman.apiPort;
    // Routes to proxy to the backend
    var proxyRoutes = [
        '/api',
        '/metrics',
        '/dump',
        '/api-docs',
        '/oauth/token'
    ];

    connect.server({
        root: [yeoman.dist],
        port: yeoman.port,
        /*livereload: {
         port: yeoman.liveReloadPort
         },*/
        middleware: function() {
            // Build a list of proxies for routes: [route1_proxy, route2_proxy, ...]
            return proxyRoutes.map(function (r) {
                var options = url.parse(baseUri + r);
                options.route = r;
                return proxy(options);
            });
        }
    });
});

gulp.task('build', ['inject', 'copy'], function () {
    gulp.run('usemin');
});

// juan lo llama "html", pero parece que esta tarea hace mas cosas
gulp.task('usemin', ['images', 'css'], function() {
    return gulp.src(yeoman.app + '*.html').
        pipe(usemin({
            css: [
                prefix.apply(),
                replace(/[0-9a-zA-Z\-_\s\.\/]*\/([a-zA-Z\-_\.0-9]*\.(woff|eot|ttf|svg))/g, '/assets/fonts/$1'),
                //minifyCss(),
                'concat',
                rev()
            ],
            html: [
                minifyHtml({empty: true, conditionals:true})
            ],
            js: [
                ngAnnotate(),
                uglify(),
                'concat',
                rev()
            ]
        })).
        pipe(gulp.dest(yeoman.dist)).
        pipe(connect.reload());
});

gulp.task('jshint', function() {
    return gulp.src(['gulpfile.js', yeoman.app + 'scripts/**/*.js'])
        .pipe(jshint('.jshintrc'))
        .pipe(jshint.reporter('jshint-stylish'))
        .pipe(jshint.reporter('fail'));
});

gulp.task('default',['server', 'inject', 'wiredep']);

