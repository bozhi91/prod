<%@include file="Init.jsp" %>
<head>
<!-- Required meta tags -->

<title>Twitter</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
		<div class="container">
			
			<img src="./media/logo.png" style="width:150px" id="logo"/> 	
			
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div id="head_menu" class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<%!String user = "";%>
					<%user = (String) session.getAttribute("userName");%>
					<%if (user != null && !user.isEmpty()) {%>
					
					<li class="nav-item"><a class="nav-link" href="#"><%=user %></a>
					</li>|
					<li class="nav-item"><a class="nav-link"
						href="/twitter/Logout">Logout</a></li>
				
					<%}else{%>
					<li class="nav-item"><a class="nav-link" href="LoginView.jsp">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="RegisterFormView.jsp">Register</a></li>
					<%}%>
					
				</ul>

			</div>
		</div>
	</nav>