'use strict';

angular.module('ruta50App')
    .controller('BundleController', function ($stateParams,$scope,Bundle) {
        
        Bundle.get({id:$stateParams.id},function(data){
        	$scope.bundle = data.data[0];
        });

    });
