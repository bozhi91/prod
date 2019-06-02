

<%@include file="Init.jsp"%>
<%@include file="Head.jsp"%>

<!--  DISPLAY THE ERROR MESSAGES HERE -->
<%
	String error = (String) session.getAttribute("registerError");
	if(error != null && !error.isEmpty()) {%>

	<div class="alert alert-danger" role="alert">
		<%=error%>
	</div>
<%}%>
<!--  DISPLAY THE ERROR MESSAGES HERE -->


<!-- ===== Begin of the form ===== -->
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
		<form  action="RegisterController" method="post" id="registerForm">
		
		  	<table cellpadding="20">
		  	<tr>
		  	  <td>Full name*(Minimum 5 characters)</td> <td><input type="text" name="username" id="username" value="John Doe"
		  	   value=""  placeholder="John Doe" required minlength="5"/></td>
		    </tr>

		    <tr>
		  	  <td>Email*</td> <td><input type="email" placeholder="john_doe@gmail.com" value="johndoe@gmail.com"
		  	   name="email" id="email" value="" required email />
		  	   <label style="color: red;">
				<% 	//if ( user.getError()[0] == 1) 
					//	out.println("User with that email already exists in our DB!");
				%>
				</label>
		  	   </td>
		    </tr>
		    
			<tr>
		  	  <td>Phone</td><td><input type="text" name="phone" id="phone" value="" placeholder="+34 123 456 789"/></td>
		    </tr>
		    
		    <tr>
		  	  <td>Password*(>5 chars, digit and uppercase)</td> 
		  	  <td>		  	  	
				<input value="aaaAAA1" type="password" name="pwd" id="pwd" required pattern="^(?=.*[0-9])(?=.*?[A-Z])(?=.*?[a-z]).{5,}$"
				 onkeyup="verifyData(event)" onfoucs="verifyData(event)" />					 						
		  	  </td>
		    </tr>

 			<tr>
		  	  <td>Retype Password*</td> 
		  	  <td>
				<input  value="aaaAAA1" type="password" name="repwd" id="repwd" required onkeyup="verifyData(event)" onfoucs="verifyData(event)"/>
				<label id="pwdSection" style="color:#ff0000; display: none;">Password Mismatch. Type the same password in both fields!</label>				
		  	  </td>		
		    </tr>
		   
		    <tr>
		  	  <td>Birthdate*</td> <td>
		  	  	<input value="28/05/1991" type="date" name="birthdate" id="birthdate" value="" required onchange="verifyData(event)"/>
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
		    	<input class="btn btn-primary btn-sm" id="subBtn" type="submit" value="Sign up" onclick="verifyData(event)"/>		    	
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

<!-- Display the footer -->
<%@include file="Footer.jsp"%>

