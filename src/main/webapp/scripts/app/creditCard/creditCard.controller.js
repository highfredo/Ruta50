'use strict';

'use strict';

angular.module('ruta50App')
    .controller('CreditCardController', function ($scope,CreditCard) {
            
            $scope.pay = function () {
            	CreditCard.save({
                   
                	number: $scope.number,
                	expirationDate: $scope.expirationDate,
                	ownerName: $scope.ownerName,
                	houseNumber: $scope.houseNumber,
                	street: $scope.street,
                	city: $scope.city,
                	state: $scope.state,
                	postalCode: $scope.postalCode,
                	country: $scope.country,
                
                }).then(function () {
                    $scope.payError = false;
                    $rootScope.back();
                }).catch(function () {
                    $scope.payError = true;
                });
            };
            
            
            

    });