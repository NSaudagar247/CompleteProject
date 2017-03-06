'use strict';

mainApp.service('EnquiryService', function ($http, $q) {
	 var REST_SERVICE_URI = 'enquiryList/';
	 var REST_SERVICE_URI_ID = 'enquiryById/';
		 
		 this.getEnquiryList = function () {
			 //console.log('enquiryList method in service ');
			 var promise = $http.get(REST_SERVICE_URI)
			 .then(function(response) {
					 return response.data;
				 });
			 return promise;
		 }
		 
		 this.getEnquiryDetailsById = function(enquiryId) {
			 console.log('enquiryId in service -- >>' + enquiryId)
			 var promise = $http.get(REST_SERVICE_URI_ID+enquiryId)
			 .then(function(response) {
					 console.log('in enquiryList service -- ' + response.data);
					 return response.data;
				 });
			 return promise;
		 }
    });