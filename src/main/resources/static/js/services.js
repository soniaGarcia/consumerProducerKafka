var app = angular.module('detalles', ["ngResource"]);

app.controller('DetalleController', ['$scope', '$http',

    function ($scope, $http) {
        $scope.getDetalle = function () {
            $http.get('/detalle').success(function (data) {
                $scope.detalles = data;
            });
        }
 

    }]);


