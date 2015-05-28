var app = angular.module('Main', ['ngRoute']);

app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $routeProvider.
        when('/overview', {
            templateUrl: '/partials/overview.html',
            controller: 'OverviewController'
        }).
        when('/settings', {
            templateUrl: '/partials/settings.html',
            controller: 'second'
        }).
        when('/student/id/:id', {
            templateUrl: '/partials/student.html',
            controller: 'StudentController'
        }).
        otherwise({
            redirectTo: '/overview'
        });
}]);

app.controller('StudentController',  ['$scope','$http','$routeParams',
    function ($scope, $http, $routeParams) {
        $scope.params = $routeParams;
        $http.get("/student/id/" + $scope.params.id).success(function (result) {
            $scope.student = result;
        });
    }]
);

app.controller('OverviewController', function ($scope, $http) {
    $http.get("/students").success(function (result) {
        $scope.students = result;
    });
});

$(document).ready(function () {
    $(".nav-sidebar li").on("click", function() {
        $(".nav-sidebar li").removeClass("active");
        $(this).addClass("active");
    });
});
