var loginApp = angular.module("loginApp", []);
loginApp.controller("HttpController", [ '$scope', '$http',
    function($scope, $http) {
        $http({
            method : 'GET',
            url : '/users'
        }).success(function(data, status, headers, config) {
            $scope.profiles = data;
        }).error(function(data, status, headers, config) {
            alert( "failure");
        });
    } ])