'use strict';

angular.module('ruta50App')
    .config(function ($stateProvider) {
        $stateProvider
            .state('bundle', {
                parent: 'site',
                url: '/bundle/:id',
                data: {
                    roles: []
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/bundle/bundle.html',
                        controller: 'BundleController'
                    }
                },
                
            });
    });
