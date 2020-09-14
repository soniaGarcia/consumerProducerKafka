var app = angular.module('detalle', ["ngResource"]);

app.controller('DetalleController', ['$scope', '$http',

    function ($scope, $http) {
        $scope.getVehiculos = function () {
            $http.get('/detalles').success(function (data) {
                $scope.detalle = data;
            });
        }
 

    }]);


