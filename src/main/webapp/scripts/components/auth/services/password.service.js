'use strict';

angular.module('ruta50App')
    .factory('Password', function ($resource) {
        return $resource('api/account/change_password', {}, {
        });
    });
