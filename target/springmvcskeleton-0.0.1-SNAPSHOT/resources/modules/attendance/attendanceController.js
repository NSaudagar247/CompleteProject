/**
 * 
 */
'use strict';

mainApp.controller(
		'attendanceController',
		[
				'$scope',
				'$http',
				function($scope, $http) {
					var url = "resources/modules/attendance/attendanceData.json";
					$http.get(url).success(function(response) {
						$scope.students = response;
					});

					$scope.gridOptions = {
						data : 'students',
						jqueryUITheme : true
					};

					$scope.getStdData = function() {
						var url = "resources/modules/attendance/studentData.json";
						$scope.stuList = true;
						$http.get(url).success(function(response) {
							$scope.standards = response;
							$scope.selectedStd = $scope.standards[0];
						});
					}

					$scope.showData = function() {
						$scope.stuList = angular.equals($scope.selectedStd,
								$scope.standards[0]);
						if (!$scope.stuList) {
							$scope.error = "No Data found!!!";
						} else {
							$scope.error = false;
						}
					}

					$scope.Checked = function() {
						$scope.Checkedval = "";
						$scope.CheckedId = "";
						$scope.spn = false;
						$scope.dataObj = "";
						angular.forEach($scope.students, function(value, key) {
							$scope.dataObj = "[";
							if (!value.checked) {
								$scope.spn = true;
								if ($scope.Checkedval.length == 0) {
									$scope.Checkedval = value.Name;
									$scope.CheckedId = value.RollNo;

								} else {
									$scope.Checkedval += ", " + value.Name;
									$scope.CheckedId += ", " + value.RollNo;
								}
							}
							$scope.dataObj += "]";
						});
					}
				} ]);
