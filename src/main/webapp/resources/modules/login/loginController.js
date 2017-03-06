'use strict';

var loginApp = angular.module('loginApp', []);

loginApp.service('LoginService', function ($http, $q) {
	 	var REST_SERVICE_URI = 'loginValidate/';
		 
		 this.validateUser = function (username,password) {
			 console.log('login method in service 22-- ' + username);
			 var user = {};
			 user.username = username;
			 user.password = password;
			 var promise = $http.post(REST_SERVICE_URI, user)
			 .then(function(response) {
					 console.log('in service -- ' + response.data);
					 return response.data;
				 });
			 return promise;
		 }
   });

loginApp.controller('LoginController', ['$scope', '$window', 'LoginService', '$rootScope', function ($scope, $window, LoginService, $rootScope) {
        $scope.login = function () {
        	console.log('login method called  -- user 22 --- ' + $scope.username);
        	$rootScope.username = $scope.username;
        	console.log("login $rootScope.username "+ $rootScope.username)
        	var promise = LoginService.validateUser($scope.username, $scope.password);
        	promise.then(
        		function(data) {
        			console.log('data -- 22 --' + data);
        			if(data) {
        				
        				$window.location.href = "loginSuccess";
        			} else {
        				$scope.error = 'Invalid Username or Password';
        			}
	        	},
			  	function(errorData) {
			  		console.log('errData -- ' + errorData);
			  		$scope.error = 'Invalid Username or Password';
			  	});
        };
        
        $scope.logOut = function() {
    		console.log('logout');
    		var app = 'AngularTechStudio';
    		var url = $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/' + app;
    		console.log('url -- >> ' + url);
    		$cookieStore.remove('blogAccessed');
    		$cookieStore.remove('noticeAccessed');
    		$window.location.href = url;
	    }
        
    }]);


