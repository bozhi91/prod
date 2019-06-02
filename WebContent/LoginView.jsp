<%@include file="Init.jsp"%>
<!-- Latest compiled and minified CSS -->
<!-- Optional theme 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">-->
<!-- <a class="btn btn-default login-btn" href="#loginform">Login</a> -->
<!-- <a class="btn btn-default sign-up-btn" href="RegisterFormView.jsp">Sign Up</a> -->
<%@include file="Head.jsp"%>

<%!String error = "";%>
<% error = (String) session.getAttribute("error");%>
<%	if (error != null && !error.isEmpty()) {%>

<div class="alert alert-danger" role="alert">
	<%=error%>
</div>
<%}%>

<!--  this is the header of our login form -->
<br/><br/>
<div class="row" style=" margin-right: 10%;">
	<div class="col-sm-4"></div>
    <div class="col-sm-4" style="background-color: lightyellow; width:80%;" id="signupDiv">
  	   <h2 style="text-align: center;">LOG IN</h2>
    </div>
    <div class="col-sm-4"></div>
</div>


<div class="row" style="margin-right: 10%; padding-top: 17px;margin-top: -17px;">

	<div class="col-sm-4"></div>
	<div class="col-sm-4" id="signupDiv" style="margin-top: -12px; text-align:center;  width:80%;">
	
			<div class="cotainer">
			<div class="row justify-content-center">
		<br/><br/><br/><br/>
		
		<form class="needs-validation" action="LoginController" method="post" onsubmit="return validate()">
			<div class="form-row">
				<div class="col-md-14 mb-3">
					<label for="validationCustomUsername">Email</label>
						<div class="input-group">
							<input type="email" name="email" class="form-control"
								id="validationCustomUsername" placeholder="Email"
								aria-describedby="inputGroupPrepend"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
						</div>
					</div>
				</div>
				<div class="form-row">
				<div class="col-md-14 mb-3">
							
				<label for="exampleInputPassword1">Password</label>
				<div class="input-group"> 
				<input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
				</div>	
			</div>
		</div>
	<button class="btn btn-primary btn-sm" type="submit">Sign In</button>
	</form>
			</div>
		</div>
	</div>
	<div class="col-sm-4"></div>
</div><!-- End of the row -->

<%@include file="Footer.jsp"%>

