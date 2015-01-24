'use strict';

angular.module('ruta50App')
.factory('CreditCard', function ($resource) {
    return $resource('api/payment/:id', {}, {
      
    });
});

