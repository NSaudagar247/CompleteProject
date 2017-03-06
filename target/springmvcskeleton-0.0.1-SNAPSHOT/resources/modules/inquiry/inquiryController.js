//mainApp.controller('EnquiryController', ['$scope', '$location', function ($scope, $location) {
//   	console.log('Enquiry Controller');
//}]);
//

mainApp.controller('EnquiryListController', ['$scope', 'EnquiryService', '$cookieStore', function ($scope, EnquiryService, $cookieStore) {
   	console.log('EnquiryListController Controller');
   		$scope.showListdata = true;
   		$scope.showDetaildata = false;
   		var promise = EnquiryService.getEnquiryList();
   		promise.then(
   				function(data) {
   					console.log(data);
   					$scope.enquiryList = data;
   				},
   				function(errorData) {
   					$scope.error = 'Error occcured while accessing the Enquiry List screen';
   				});
   		
   		$scope.viewEnqDetails = function(enquiryId) {
   			$scope.showListdata = false;
   	   		$scope.showDetaildata = true;
   			console.log('enquiryId -- >> ' + enquiryId);
   			var promise = EnquiryService.getEnquiryDetailsById(enquiryId);
   	   		promise.then(
   	   				function(data) {
   	   					console.log(data);
   	   					$scope.enquiry = data;
   	   				},
   	   				function(errorData) {
   	   					$scope.error = 'Error occcured while accessing the Enquiry List screen';
   	   				});
   		}
   		$scope.gotoListScreen = function() {
   			$scope.showListdata = true;
   	   		$scope.showDetaildata = false;
   		}
}]);

