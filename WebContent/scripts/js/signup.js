	
	function verifyData(event){
				
				var formElement = document.getElementById("registerForm");
				formData = new FormData(formElement);
				
				var error = 0;
				var pass1 = document.getElementById("pwd").value;
				var pass2 = document.getElementById("repwd").value;
				var date  = formData.get("birthdate");
				var year  = date.split("-");
						
				
			    if(pass1.localeCompare(pass2)!=0 && error==0){
					//alert("Password mismatch");		
					 $( "#pwdSection" ).css("display", "inline");
					error=1;			
				}
				
			    if((new Date().getFullYear()-year[0])<18){
			    	error=1;	
			    	$( "#dateSection" ).css("display", "inline");
			    }
			    else{					
			    	 $( "#dateSection" ).css("display", "none");
				}		
			    
			    if(error!=0){
			    	//Don't send the request if there is any validation error
					event.preventDefault();
				}
				else{					
					request.send(formData);
				}				    		   
	}