var webApp = angular.module('webApp', ['ngRoute']);				

webApp.config(function ($routeProvider) {
    
	 $routeProvider
	 .when('/', {
		controller: 'MainController',
		controllerAs: 'vm'
	})
     .when('/ludoking', {
         controller: 'ludoKingController',
         templateUrl: 'views/ludoking.html',
         controllerAs: 'vm'
     })
    .otherwise({ redirectTo: '/' })
    ;
	})
	.run(function($rootScope,$location,$http) {
	});