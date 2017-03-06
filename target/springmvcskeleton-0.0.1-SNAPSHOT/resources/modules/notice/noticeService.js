'use strict';

mainApp.service('NoticeService', function ($http, $q) {
	 var REST_SERVICE_URI = 'noticeList/';
		 
		 this.getNoticeList = function () {
			 console.log('notice list method in service ');
			 var promise = $http.get(REST_SERVICE_URI)
			 .then(function(response) {
					 console.log('in notice list service -- ' + response.data);
					 return response.data;
				 });
			 return promise;
		 }
    });