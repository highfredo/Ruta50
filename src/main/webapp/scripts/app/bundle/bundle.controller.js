'use strict';

angular.module('ruta50App')
    .controller('BundleController', function ($stateParams,$scope,Bundle,Principal) {
        
        Bundle.get({id:$stateParams.id},function(data){
        	$scope.bundle = data.data[0];
        });
        
        Principal.identity().then(function(account) {
            $scope.account = account;
            $scope.isAuthenticated = Principal.isAuthenticated;
        });
    });
