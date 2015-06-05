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
        when('/todo', {
            templateUrl: '/partials/todo.html',
            controller: 'TodoCtrl'
        }).
        when('/student/id/:id', {
            templateUrl: '/partials/student.html',
            controller: 'StudentController'
        }).
        otherwise({
            redirectTo: '/overview'
        });
}]);