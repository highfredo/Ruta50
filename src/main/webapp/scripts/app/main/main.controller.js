'use strict';

angular.module('ruta50App')
    .controller('MainController', function ($scope,CreditCard) {
        
            $scope.creditCard = CreditCard.get()

    });
