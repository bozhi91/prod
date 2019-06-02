
<%@include file="Head.jsp"%>

<div class="container-fluid">	
	<!--  HEADER  OF THE PROFILE PAGE-->
	<div class="row"  style="background-color:lightblue; height:200px;">
		<div class="col-sm-12" id="logoDiv">	
			
		</div>
	</div>
	<!-- END OF HEADER -->

	<!-- FOLLOWERS INFO -->	
	<div class="row" style="background-color:grey;">	
		<div class="col-sm-3" id="logoDiv"></div>
		<div class="col-sm-6" id="logoDiv"  >	
			Tweets: 100; Following: 200; Followers: 300
		</div>
	</div> 

	<img id="avatar" src="./media/avatar.png">
	

	<div class="row"> 
		<div class="col-sm-3" id="logoDiv"  style="background-color:lightgrey;">				
			<b>User info</b>
			<h3>
				<%Object name = request.getSession().getAttribute("userName");
				  out.println(name);
				%>
			</h3>
			email: ${user.email}
		</div>
		<div class="col-sm-6" id="logoDiv"  style="background-color:lightgrey;">	
			<b>Tweets</b>
		</div>
	<div class="col-sm-2" id="logoDiv"  style="background-color:lightgrey;">	
			<b>Who to follow</b>
		</div>
	</div>
</div>