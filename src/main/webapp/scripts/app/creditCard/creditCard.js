'use strict';

angular.module('ruta50App')
    .config(function ($stateProvider) {
        $stateProvider
            .state('creditCard', {
                parent: 'site',
                url: '/compra/:id/:price/:numberOfPerson/:fecha',
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
