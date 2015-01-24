'use strict';

angular.module('ruta50App')
.factory('Bundle', function ($resource) {
    return $resource('api/public/bundle/:id', {}, {
    	'get': { method: 'GET', params: {}, isArray: true,
            interceptor: {
                response: function(response) {
                    // expose response
                    return response;
                }
            }
        }
      
    });
});

