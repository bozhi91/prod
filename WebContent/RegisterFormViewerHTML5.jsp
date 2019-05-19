<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="models.User"%>
<!DOCTYPE html>
<html>
<head>
	<title> Register form - TEvent(c) </title>
	
	<!-- INCLUDE SOME LIBRARIES AND SCRIPTS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="./scripts/css/style.css">
	<script src="./scripts/js/signup.js"></script>
</head>
<body>

<% 
/* This java code is only for debbuging purposes it avoids errors when calling 
   the view before the controller. Using the MVC design pattern this will not occur
   and this java code can be safely removed. */
User user = null;
if (request.getAttribute("user")!=null) 
	user = (User)request.getAttribute("user");
else 
	user = new User();
%>
<!-- ===== Begin of the form ===== -->

<div class="container-fluid">
	<!-- Logo-->
	<div class="row">
		<div class="col-sm-8" id="logoDiv">	
			<img src="./media/logo.png" id="logo"/> 	
		</div>
	</div>
	<!-- Logo-->


  <!-- Signup form-->
<br/><br/>
<div class="row" style=" margin-right: 10%;">
	<div class="col-sm-2"></div>
    <div class="col-sm-8" style="background-color: lightyellow;  width:80%;" id="signupDiv">
  	   <h2 style="text-align: center;">CREATE AN ACCOUNT</h2>
    </div>
    <div class="col-sm-2"></div>
</div>

  <div class="row" style="margin-right: 10%; padding-top: 17px;margin-top: -17px;">

	<div class="col-sm-2"></div>
    <div class="col-sm-8" id="signupDiv" style="margin-top: -12px; text-align:center;  width:80%;">
	<center> 
		<form  action="RegisterFormController" method="post" id="registerForm">
		
		  	<table cellpadding="20">
		  	<tr>
		  	  <td>Full name*(Minimum 5 characters)</td> <td><input type="text" name="username" id="username"
		  	   value="<%=user.getUsername() %>"  placeholder="John Doe" required minlength="5"/></td>
		    </tr>

		    <tr>
		  	  <td>Email*</td> <td><input type="email" placeholder="john_doe@gmail.com"
		  	   name="mail" id="mail" value="<%=user.getMail() %>" required email />
		  	   <label style="color: red;">
				<% 	if ( user.getError()[0] == 1) 
						out.println("User with that email already exists in our DB!");
				%>
				</label>
		  	   </td>
		    </tr>
		    
			<tr>
		  	  <td>Phone</td><td><input type="text" name="phone" id="phone" value="<%=user.getPhone() %>" placeholder="+34 123 456 789"/></td>
		    </tr>
		    
		    <tr>
		  	  <td>Password*(>5 chars, digit and uppercase)</td> 
		  	  <td>		  	  	
				<input type="password" name="pwd" id="pwd" required pattern="^(?=.*[0-9])(?=.*?[A-Z])(?=.*?[a-z]).{5,}$"
				 onkeyup="verifyData(event)" onfoucs="verifyData(event)" />					 						
		  	  </td>
		    </tr>

 			<tr>
		  	  <td>Retype Password*</td> 
		  	  <td>
				<input type="password" name="repwd" id="repwd" required onkeyup="verifyData(event)" onfoucs="verifyData(event)"/>
				<label id="pwdSection" style="color:#ff0000; display: none;">Password Mismatch. Type the same password in both fields!</label>				
		  	  </td>		
		    </tr>
		   
		    <tr>
		  	  <td>Birthdate*</td> <td>
		  	  	<input type="date" name="birthdate" id="birthdate" value="<%=user.getBirthdate() %>" required onchange="verifyData(event)"/>
		  	  	<label id="dateSection" style="color:#ff0000; display: none;">You must be at least 18 years old in order to register.</label>				
		  	  </td>		  	  
		    </tr>
		  
		    <!-- GENDER -->
		    <tr>
		    	<td>Gender</td>
		    	<td>
	    		<input type="radio" name="gender" value="m"> Male
				<input type="radio" name="gender" value="f"> Female
				<input type="radio" name="gender" value="o" checked="true"> Other
				</td>
			</tr>
			
		   	<tr>
		   		<td colspan="2" style="text-align: center;"><br/>
		    	<input id="subBtn" type="submit" value="Sign up" onclick="verifyData(event)"/>
		    	</td>
			</tr>		    
		    </table>
		</center>
		</form>
    </div>
    <div class="col-sm-2"></div>
	<!-- Signup form-->
  </div>
</div>

<!-- ===== End of the form ===== -->
	
	<div id="footer">
		<p>Copyright(c) T-Event 2019  
		<a href="https://www.linkedin.com/in/bozhidar-peychev-4a6b76106/" target=_blank>Bozhidar</a>,
		<a href="" target=_blank>Rachida</a>,
		<a href="" target=_blank>Imane</a>
		- Software engineers - </p>
	</div>

</body>
</html>