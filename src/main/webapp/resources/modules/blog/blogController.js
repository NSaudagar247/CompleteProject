/**
 * 
*/

mainApp.controller('blogController',function($scope, $http, $route, $rootScope, ModalService) {

	$scope.blog = {title: '', story:'', writer:'', writtenOn:''};
	$scope.message = "This message has set in blogController";
	$scope.activeTab = $route.current.activetab;
	
	$scope.fetchAllBlogs = function() {
		
//		$scope.$on('refreshBlogs', function(event) {
	        $http.get('blog/getAllBlogs').success(function(blogs){
	            $scope.blogs = blogs;
	        });
//		});
    };
	$scope.fetchAllBlogs();
	
	$scope.show = function() {
        ModalService.showModal({
            templateUrl: 'addBlog.html',
            controller: "ModalController"
        }).then(function(modal) {
            modal.element.modal();
            modal.close.then(function(result) {
                $scope.message = "You said " + result;
//                $scope.blog = {title: $scope.blogTitle, story:$scope.blogStory, writer:$scope.writer};
            });
        });
    };
	
});


mainApp.controller('ModalController', function($scope, $http, close, $rootScope) {
	 $scope.close = function(result) {
	 	close(result, 500); // close, but give 500ms for bootstrap to animate
	 };
	 
		$scope.add_blog = function(){
			
			console.log(" $rootScope.username "+ $rootScope.username)
			var blog = {};			
			blog = $scope.blog;
			blog.writer = $rootScope.username;
			blog.writtenOn = new Date();			
			
			var res = $http.post('/springmvcskeleton/blog/addBlog', blog);
			res.success(function(data, status, headers, config) {
				$scope.message = data;
				$scope.fetchAllBlogs();
//				$scope.$emit('refreshBlogs');
				
			});
			res.error(function(data, status, headers, config) {
				console.log( "failure message: " + JSON.stringify({data: data}));
			});
			
	    };
	    
	    $scope.fetchAllBlogs = function() {
			
//			$scope.$on('refreshBlogs', function(event) {
		        $http.get('blog/getAllBlogs').success(function(blogs){
		            $scope.blogs = blogs;
		        });
//			});
	    };
});
