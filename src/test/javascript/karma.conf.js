// Karma configuration
// http://karma-runner.github.io/0.10/config/configuration-file.html

module.exports = function (config) {
    config.set({
        // base path, that will be used to resolve files and exclude
        basePath: '../../',

        // testing framework to use (jasmine/mocha/qunit/...)
        frameworks: ['jasmine'],

        // list of files / patterns to load in the browser
        files: [
            'main/webapp/lib/modernizr/modernizr.js',
            'main/webapp/lib/jquery/dist/jquery.js',
            'main/webapp/lib/angular/angular.js',
            'main/webapp/lib/angular-mocks/angular-mocks.js',
            'main/webapp/lib/angular-ui-router/release/angular-ui-router.js',
            'main/webapp/lib/angular-resource/angular-resource.js',
            'main/webapp/lib/angular-cookies/angular-cookies.js',
            'main/webapp/lib/angular-sanitize/angular-sanitize.js',
            'main/webapp/lib/angular-translate/angular-translate.js',
            'main/webapp/lib/angular-translate-storage-cookie/angular-translate-storage-cookie.js',
            'main/webapp/lib/angular-translate-loader-partial/angular-translate-loader-partial.js',
            'main/webapp/lib/angular-dynamic-locale/src/tmhDynamicLocale.js',
            'main/webapp/lib/angular-local-storage/dist/angular-local-storage.min.js',
            'main/webapp/lib/angular-cache-buster/angular-cache-buster.js',
            'main/webapp/scripts/app/app.js',
            'main/webapp/scripts/app/**/*.js',
            'main/webapp/scripts/components/**/*.js',
            'test/javascript/**/!(karma.conf).js'
        ],


        // list of files / patterns to exclude
        exclude: [],

        // web server port
        port: 9876,

        // level of logging
        // possible values: LOG_DISABLE || LOG_ERROR || LOG_WARN || LOG_INFO || LOG_DEBUG
        logLevel: config.LOG_INFO,

        // enable / disable watching file and executing tests whenever any file changes
        autoWatch: false,

        // Start these browsers, currently available:
        // - Chrome
        // - ChromeCanary
        // - Firefox
        // - Opera
        // - Safari (only Mac)
        // - PhantomJS
        // - IE (only Windows)
        browsers: ['PhantomJS'],

        // Continuous Integration mode
        // if true, it capture browsers, run tests and exit
        singleRun: false
    });
};
