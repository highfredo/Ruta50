'use strict';

angular.module('ruta50App')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
