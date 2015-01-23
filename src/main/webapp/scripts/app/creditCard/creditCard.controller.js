'use strict';

'use strict';

angular.module('ruta50App')
    .controller('CreditCardController', function ($scope,CreditCard) {
        
            $scope.creditCard = CreditCard.get()
            
            

    });