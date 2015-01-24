'use strict';

angular.module('ruta50App')
    .controller('MainController', function ($scope,Bundle) {
    	
    	  $scope.bundles = Bundle.get();
    	  

    });
