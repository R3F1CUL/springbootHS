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

app.controller('TodoCtrl', function($scope) {

    $scope.todos = [
        {text: 'Learn AngularJS', done: false},
        {text: 'Build an app', done: false}
    ];

    $scope.getTotalTodos = function () {
        return $scope.todos.length;
    };


    $scope.addTodo = function () {
        $scope.todos.push({text: $scope.formTodoText, done: false});
        $scope.formTodoText = '';
    };

    $scope.clearCompleted = function () {
        $scope.todos = _.filter($scope.todos, function (todo) {
            return !todo.done;
        });
    };
});