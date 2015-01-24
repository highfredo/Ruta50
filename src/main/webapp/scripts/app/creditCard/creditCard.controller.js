'use strict';

angular.module('ruta50App')
    .controller('CreditCardController', function ($scope, CreditCard, $stateParams) {
            
            $scope.pay = function () {
            	CreditCard.save({
            	bundleId: $stateParams.id,
            	maxPrecio: $stateParams.price,
            	numberOfPeople: $stateParams.numberOfPerson,
            	creditCard: {
                   
                	number: $scope.number,
                	expirationDate: $scope.expirationDate,
                	ownerName: $scope.ownerName,
                	houseNumber: $scope.houseNumber,
                	street: $scope.street,
                	city: $scope.city,
                	state: $scope.state,
                	postalCode: $scope.postalCode,
                	country: $scope.country,
                
                }}, function() {
                	alert("Su compra se ha realizado con exito")
                    window.location = "/";
                })
                
                /*.then(function () {
                    $scope.payError = false;
                    $rootScope.back();
                    
                    alert("Su compra se ha realizado con exito")
                    window.location = "/";
                }).catch(function () {
                    $scope.payError = true;
                });*/
            };
            
            
            

    });