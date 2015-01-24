'use strict';

angular.module('ruta50App')
    .config(function ($stateProvider) {
        $stateProvider
            .state('creditCard', {
                parent: 'site',
                url: '/compra',
                data: {
                    roles: []
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/creditCard/creditCard.html',
                        controller: 'CreditCardController'
                    }
                },
                
            });
    });
