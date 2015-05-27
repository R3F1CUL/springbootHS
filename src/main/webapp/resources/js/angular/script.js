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

app.controller('AnalyticsController', function($scope, $http) {
    $http.get("http://www.w3schools.com/angular/customers.php")
        .success(function(response) {$scope.names = response.records;});
});

app.controller('first', function() {

});

app.controller('second', function() {

});
