/**
 * 
 */
//    var myApp = angular.module('myApp', []);
    
	  var option1Options = ["1","2","3","4","5"];
	    
	    var option2Options = [["A","B","C"],
	                   ["D","E","F"],
	                   ["G","H","I"]];
	    
	    var seats = [["20","10"],
	   	             ["44","33"],
	   	             ["22","11"]];
	    
	    var year=["2016-2017", "2017-2018", "2018-2019"];
	    var totalSeat=40;
    
    
	    mainApp.controller('AdmissionCtrl', function ($scope,$http){
    	
    	  $http.get('resources/modules/admission/standards.json').success(function(data) { 
              $scope.students = data; 
            });

    	  
    	  
    	  $scope.years = year;
    	  $scope.myFieldLabel = 'Total Seat Count:';
    	  $scope.myFieldLabel1 = 'Available Seat Count is:';
    	  $scope.myFieldLabel2 = 'Academic Year';
    	  $scope.myFieldLabel3 = 'First Name:';
    	  $scope.myFieldLabel4 = 'Last Name:';
    	  $scope.myFieldLabel5 = 'Standard:';
    	  $scope.myFieldLabel6 = 'Division:';
    	  
    	  
    	  $scope.options1 = option1Options;
    	    $scope.options2 = []; // we'll get these later
    	    $scope.getOptions2 = function(){
    	        // just some silly stuff to get the key of what was selected since we are using simple arrays.
    	        var key = $scope.options1.indexOf($scope.option1);
    	        // Here you could actually go out and fetch the options for a server.
    	        var myNewOptions = option2Options[key];
    	        // Now set the options.
    	        // If you got the results from a server, this would go in the callback
    	        $scope.options2 = myNewOptions;
    	  }
    	    $scope.getSeatCount = function(){
    	    
    	    	var div = $scope.options2.indexOf($scope.option2); 
    	    	var seat = seats[div];
    	    	$scope.TotalSeatCount = seat[0];
    	    	$scope.AvailableSeatCount = seat[1];
    	    }
    	    
    	    $scope.ButtonClick = function () {
                $scope.Message = "Successfully Added Student."
    	    }
      });
      
