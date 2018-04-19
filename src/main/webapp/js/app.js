var myApp = angular.module('myApp', ["ngRoute"]);

myApp.config(function($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/#', {
            templateUrl : 'index.html'
        })
         .when('/login', {
            templateUrl : 'views/login.html',
            controller  : 'studentController'
        })

        // route for the about page
        .when('/student', {
            templateUrl : 'views/student.html',
            controller  : 'studentController'
        })

});
