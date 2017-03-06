mainApp.controller('NoticeController', ['$scope', 'NoticeService', '$cookieStore', function ($scope, NoticeService, $cookieStore) {
   	console.log('Notice Controller');
	var noticeAccessed = $cookieStore.get('noticeAccessed');
   	console.log('noticeAccessed -- >>' + noticeAccessed);
   	if(noticeAccessed != 'yes') {
   		var promise = NoticeService.getNoticeList();
   		promise.then(
   				function(data) {
   					console.log(data);
   					$scope.noticeList = data;
   					$cookieStore.put('noticeAccessed','yes');
   					$cookieStore.put('noticeList', $scope.noticeList);
   				},
   				function(errorData) {
   					$scope.error = 'Error occcured while accessing the Notice screen';
   				});
   	} else {
   		var noticeList = $cookieStore.get('noticeList');
   		console.log('noticeList -- >> ' + noticeList);
   		$scope.noticeList = noticeList;
   	}
   	
   	$scope.noticeRefresh = function() {
		$scope.collegeNotice = [];
		$scope.noticeForm.noticeTitle.$dirty = false;
		$scope.noticeForm.noticeContent.$dirty = false;
		$scope.noticeForm.noticeDate.$dirty = false;
	}
   	
   	$scope.noticeSubmit = function() {
		console.log($scope.collegeNotice);
		var notice = $scope.collegeNotice;
		var noticeId = notice.noticeId;
		console.log('noticeId -- ' + noticeId);
		if(typeof noticeId != 'undefined' && noticeId != '') {
			for(var noticeIndex in $scope.noticeList) {
				 var notice = $scope.noticeList[noticeIndex];
				 if(notice.noticeId == noticeId) {
					 notice.noticeTitle = $scope.collegeNotice.noticeTitle;
					 notice.noticeContent = $scope.collegeNotice.noticeContent;
					 notice.noticeDate = $scope.collegeNotice.noticeDate;
				 }
			 }
		} else  {
			var noticeId = getNoticeId($scope.noticeList);
			console.log('noticeId -- >>' + noticeId);
			$scope.collegeNotice.noticeId = noticeId;
			$scope.noticeList.unshift($scope.collegeNotice);
		}
		$scope.collegeNotice = [];
		$scope.noticeForm.noticeTitle.$dirty = false;
		$scope.noticeForm.noticeContent.$dirty = false;
		$scope.noticeForm.noticeDate.$dirty = false;
		$cookieStore.put('noticeList', $scope.noticeList);
	}
   	
   	function getNoticeId(noticeList)  {
		var count = 1;
		for(var noticeIndex in noticeList) {
			var notice = noticeList[noticeIndex];
			if(notice.noticeId >= count) {
				count = notice.noticeId + 1;
			}
		}
		return count;
	}
   	
    $scope.noticeEdit = function (noticeId) {
		 console.log('noticeId edit -- ' + noticeId);
		 for(var noticeIndex in $scope.noticeList) {
			 var notice = $scope.noticeList[noticeIndex];
			 if(notice.noticeId == noticeId) {
				 notice.noticeDate=new Date(notice.noticeDate);
				 $scope.collegeNotice = angular.copy(notice);
			 }
		 }
    }
   	
   	$scope.noticeRemove = function (noticeId) {
		 console.log('noticeId remove -- ' + noticeId);
		 for(var noticeIndex in $scope.noticeList) {
			 var notice = $scope.noticeList[noticeIndex];
			 if(notice.noticeId == noticeId) {
				 $scope.noticeList.splice(noticeIndex, 1);
			 }
		 }
		 $cookieStore.put('noticeList', $scope.noticeList);
    }
}]);