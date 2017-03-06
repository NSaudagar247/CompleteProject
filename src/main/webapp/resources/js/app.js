/**
 * 
 */
var mainApp = angular.module("mainApp", ['ngRoute', 'angularModalService', 'ngAnimate', 'ngCookies', 'angularUtils.directives.dirPagination']);

mainApp.config(function($routeProvider) {
	$routeProvider
		.when('/home', {
//			template:'<h1>Homepage goes here</h1>'
			templateUrl: 'modules/homepage/home.html',
			activetab: 'home'
//			controller: 'homeController'
		})
		.when('/admission/inquiry', {
			templateUrl: 'modules/inquiry/inquiry.html',
			controller: 'EnquiryListController',
			activetab: 'inquiry'
		})
		.when('/blog/create', {
			templateUrl: 'modules/blog/blog.html',
			controller: 'blogController',
			activetab: 'blog'
		})
		.when('/notice/create', {
			templateUrl: 'modules/notice/notice.html',
			controller: 'NoticeController'
		})
		.when('/admission/admissionForm', {
			templateUrl: 'modules/admission/admission.html',
			controller: 'AdmissionCtrl'
		})
		.when('/attendance/attendanceForm', {
			templateUrl: 'modules/attendance/attendanceForm.html',
			controller: 'attendanceController'
		})
		.otherwise({
			redirectTo: '/home'
		});
});
