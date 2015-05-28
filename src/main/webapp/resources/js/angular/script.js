var app = angular.module('Main', ['ngRoute']);

app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $routeProvider.
        when('/overview', {
            templateUrl: '/partials/overview.html',
            controller: 'OverviewController'
        }).
        when('/reports', {
            templateUrl: '/partials/reports.html',
            controller: 'ReportsController'
        }).
        when('/settings', {
            templateUrl: '/partials/settings.html',
            controller: 'second'
        }).
        when('/analytics', {
            templateUrl: '/partials/analytics.html',
            controller: 'AnalyticsController'
        }).
        when('/student/id/:id', {
            templateUrl: '/partials/student.html',
            controller: 'StudentController'
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

app.controller('StudentController',  ['$scope','$http','$routeParams',
    function ($scope, $http, $routeParams) {
        $scope.params = $routeParams;
        $http.get("/student/id/" + $scope.params).success(function (result) {
            $scope.student = result;
        });
    }]
);

app.controller('ReportsController', function ($scope, $http) {
    $http.get("/students").success(function (result) {
        $scope.students = result;
    });
});

app.controller('OverviewController', function ($scope, $http) {
    $http.get("/students").success(function (result) {
        $scope.students = result;
    });
});

$(document).ready(function () {
    $(".nav li").on("click", function() {
        $(".nav li").removeClass("active");
        $(this).addClass("active");
    });
});
