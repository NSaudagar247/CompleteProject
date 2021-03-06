<%@ include file = "/WEB-INF/jsp/fragments/jspheader.jspf" %>
<%@ include file = "/WEB-INF/jsp/fragments/resources.jspf" %>

<!doctype html>
<html>
	<head>
		<title>ATOS School of Technology</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- JS -->
		<script src="${jqueryJs}"></script>
		<script src="${angularJs}"></script>
		<script src="${angularRouteJs}"></script>
		<script src="${bootstrapJs}"></script>
		<script src="${uiBootstrapTplsJs}"></script>		
		<script src="${angularAnimateJs}"></script>
		<script src="${angularModalServiceJs}"></script>
		<script src="${angularCookiesJs}"></script>
		<script src="${dirPaginationJs}"></script>
		
		
		<script src="${appJs}"></script>
		<script src="${editorJs}"></script>
		<script src="${inquiryCtrlJs}"></script>
		<script src="${inquiryServiceJs}"></script>
		<script src="${blogCtrlJs}"></script>
		<script src="${noticeCtrlJs}"></script>
		<script src="${noticeServiceJs}"></script>
		<script src="${admissionCtrlJs}"></script>
		<script src="${attendanceCtrlJs}"></script>
		
		
		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
		
		<link rel="stylesheet" type="text/css" href="${fontAwesomeCss}" />
		<link rel="stylesheet" type="text/css" href="${styleCss}" />
		<link rel="stylesheet" type="text/css" href="${editorCss}" />

	</head>
	<body ng-app="mainApp">

		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>                        
		      </button>
		      <b><a class="navbar-brand" href>ATOS College of Technology</a></b>
		    </div>
 			<div class="collapse navbar-collapse" id="myNavbar" ng-click="$event.preventDefault()">
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="#" ng-click="logOut()"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		      </ul>
		    </div>
		   </div>
		</nav>
		  
		
		<div class="container-fluid">
		  <div class="row content">
		    <div class="col-sm-3 sidenav">
		      <ul class="nav nav-pills nav-stacked">
		        <li ><a href="#/home">Homepage</a></li>
		        <li ng-class="{active: $scope.activeTab == 'inquiry'}"><a href="#/admission/inquiry">Inquiry</a></li>
		        <li ng-class="{active: $scope.activeTab == 'blog'}"><a href="#/blog/create">Blog</a></li>
		        <li ng-class="{active: $scope.activeTab == 'inquiry'}"><a href="#/notice/create">Notice</a></li>
		        <li ng-class="{active: $scope.activeTab == 'blog'}"><a href="#/admission/admissionForm">Admission</a></li>
		        <li ng-class="{active: $scope.activeTab == 'inquiry'}"><a href="#/attendance/attendanceForm">Attendence</a></li>


<li ></li>
<li ng-class="{active: $route.current.activetab == 'lab'}"></li>

<!-- 		        <li><a href="#notice_board">Notice Board</a></li> -->
<!-- 		        <li><a href="#faculty">Faculty</a></li> -->
<!-- 		        <li><a href="#courses">Courses</a></li> -->
		      </ul>
		
<!-- 		      <div class="input-group"> -->
<!-- 		        <input type="text" class="form-control" placeholder="Search Blog.."> -->
<!-- 		        <span class="input-group-btn"> -->
<!-- 		          <button class="btn btn-default" type="button"> -->
<!-- 		            <span class="glyphicon glyphicon-search"></span> -->
<!-- 		          </button> -->
<!-- 		        </span> -->
<!-- 		      </div> -->

		    </div>
		
		    <div class="col-sm-9">
<!-- 		    <h3>template comes here</h3> -->
		

		    
				<ng-view></ng-view>
		    
		    
		<!-- 	     <h4 class="text-right"> -->
		<!-- 		<button type="submit" class="btn btn-success">Submit</button>	   -->
		<!-- 	  </h4> -->
			
		<!-- 	     <hr> -->
		<!-- 	     <h2>I Love Food</h2> -->
		<!-- 	     <h5><span class="glyphicon glyphicon-time"></span> Post by Jane Dane, Sep 27, 2015.</h5> -->
		<!-- 	     <h5><span class="label label-danger">Food</span> <span class="label label-primary">Ipsum</span></h5><br> -->
		<!-- 	     <p>Food is my passion. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p> -->
		<!-- 	     <br><br> -->
			     
		<!-- 	     <h4><small>RECENT POSTS</small></h4> -->
		<!-- 	     <hr> -->
		<!-- 	     <h2>Officially Blogging</h2> -->
		<!-- 	     <h5><span class="glyphicon glyphicon-time"></span> Post by John Doe, Sep 24, 2015.</h5> -->
		<!-- 	     <h5><span class="label label-success">Lorem</span></h5><br> -->
		<!-- 	     <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p> -->
		<!-- 	     <hr> -->
		
		<!--       <h4>Leave a Comment:</h4> -->
		<!--       <form role="form"> -->
		<!--         <div class="form-group"> -->
		<!--           <textarea class="form-control" rows="3" required></textarea> -->
		<!--         </div> -->
		<!--         <button type="submit" class="btn btn-success">Submit</button> -->
		<!--       </form> -->
		<!--       <br><br> -->
		
		<!--       <p><span class="badge">2</span> Comments:</p><br> -->
		      
		<!--       <div class="row"> -->
		<!--         <div class="col-sm-2 text-center"> -->
		<!--           <img src="bandmember.jpg" class="img-circle" height="65" width="65" alt="Avatar"> -->
		<!--         </div> -->
		<!--         <div class="col-sm-10"> -->
		<!--           <h4>Anja <small>Sep 29, 2015, 9:12 PM</small></h4> -->
		<!--           <p>Keep up the GREAT work! I am cheering for you!! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p> -->
		<!--           <br> -->
		<!--         </div> -->
		<!--         <div class="col-sm-2 text-center"> -->
		<!--           <img src="bird.jpg" class="img-circle" height="65" width="65" alt="Avatar"> -->
		<!--         </div> -->
		<!--         <div class="col-sm-10"> -->
		<!--           <h4>John Row <small>Sep 25, 2015, 8:25 PM</small></h4> -->
		<!--           <p>I am so happy for you man! Finally. I am looking forward to read about your trendy life. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p> -->
		<!--           <br> -->
		<!--           <p><span class="badge">1</span> Comment:</p><br> -->
		<!--           <div class="row"> -->
		<!--             <div class="col-sm-2 text-center"> -->
		<!--               <img src="bird.jpg" class="img-circle" height="65" width="65" alt="Avatar"> -->
		<!--             </div> -->
		<!--             <div class="col-xs-10"> -->
		<!--               <h4>Nested Bro <small>Sep 25, 2015, 8:28 PM</small></h4> -->
		<!--               <p>Me too! WOW!</p> -->
		<!--               <br> -->
		<!--             </div> -->
		<!--           </div> -->
		<!--         </div> -->
		<!--       </div> -->
		
		
		
		    </div>
		  </div>
		</div>
		
		<footer class="container-fluid">
		  <p>Footer Text</p>
		</footer>

	</body>
</html>