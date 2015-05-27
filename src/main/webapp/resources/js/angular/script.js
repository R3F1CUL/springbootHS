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
     otherwise({
         redirectTo: '/overview'
     });
}]); 
 
app.controller('first', function() {

});

app.controller('second', function() {

});
