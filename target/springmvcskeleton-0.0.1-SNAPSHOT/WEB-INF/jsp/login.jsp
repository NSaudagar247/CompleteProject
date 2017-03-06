<%@ include file = "/WEB-INF/jsp/fragments/resources.jspf" %>
<html ng-app="loginApp">
    <head>
        <meta charset="utf-8" />
        <title>ATOS School of Technology - Login </title>

		<!-- JS -->
		<script src="${jqueryJs}"></script>
		<script src="${angularJs}"></script>
		<script src="${bootstrapJs}"></script>

		<script src="${loginCtrlJs}"></script>

		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
		<link rel="stylesheet" type="text/css" href="${styleCss}" />

    </head>
    <body>
<div class="container">
  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
<div class="col-md-4" ng-controller="LoginController">
<section class="login-form">
<img src="${ATOSLogoPng}" class="img-responsive" alt="ATOS"/>
<h1>College of Technology</h1>
	<div ng-show="error" class="alert alert-danger">{{error}}</div>
	<form name="form" ng-submit="login()" role="form">
	    <div class="form-group">
	        <label for="username">Username</label>
	        <i class="fa fa-key"></i>
	        <input type="text" name="username" tabindex="1" id="username" class="form-control" ng-model="username" required />
	        <span ng-show="form.username.$dirty && form.username.$error.required" class="help-block">Username is required</span>
	    </div>
	    <div class="form-group">
	        <label for="password">Password</label>
	        <i class="fa fa-lock"></i>
	        <input type="password" name="password" tabindex="2" id="password" class="form-control" ng-model="password" required />
	        <span ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</span>
	    </div>
	    <div class="form-actions" style="margin-top: 30px">
	        <button type="submit" tabindex="3" ng-disabled="form.$invalid || dataLoading" class="btn btn-lg btn-primary btn-block">Login</button>
	    </div>
	</form>
	</section>
</div>
 </div></div></div> 
    </body>

</html>
