'use strict';

angular.module('ruta50App')
.factory('CreditCard', function ($resource) {
    return $resource('api/payment/creditCard/54c298e3e4b00dffd56f6a76', {}, {
      
    });
});

