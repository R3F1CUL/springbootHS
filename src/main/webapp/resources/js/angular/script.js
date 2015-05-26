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
     otherwise({
         redirectTo: '/overview'
     });
}]); 
 
app.controller('first', function($scope) {
  $scope.list = [1,2,3,4,5];
});

app.controller('second', function($scope) {
  $scope.list = [1,2,3];
});
