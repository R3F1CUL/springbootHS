var app = angular.module('Main', ['ngRoute']);

app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $routeProvider.
        when('/overview', {
            templateUrl: '/partials/first.html',
            controller: 'first'
        }).
        when('/reports', {
            templateUrl: '/partials/second.html',
            controller: 'second'
        }).
        when('/settings', {
            templateUrl: '/partials/settings.html',
            controller: 'second'
        }).
        when('/analytics', {
            templateUrl: '/partials/analytics.html',
            controller: 'AnalyticsController'
        }).
        otherwise({
            redirectTo: '/overview'
        });
}]);

app.controller('AnalyticsController', function ($scope, $http) {
    $http.get("/students/lastName/Bauer").success(function (result) {
        $scope.students = result;
    });
});

app.controller('first', function () {

});

app.controller('second', function () {

});

$(document).ready(function () {
    $(".nav li").on("click", function() {
        $(".nav li").removeClass("active");
        $(this).addClass("active");
    });

});
