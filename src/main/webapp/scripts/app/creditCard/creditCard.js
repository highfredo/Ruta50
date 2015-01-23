'use strict';

angular.module('ruta50App')
    .config(function ($stateProvider) {
        $stateProvider
            .state('creditCard', {
                parent: 'site',
                url: '/creditCard',
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
