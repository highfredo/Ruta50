'use strict';

angular.module('ruta50App')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


