package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import models.User;

/**
 * Servlet implementation class RegisterFormController
 */
@WebServlet("/RegisterFormController")
public class RegisterFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterFormController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
		try {
		   // Fills the User Bean with the parameters that are passed into the request
			//NOTE: This will assign a value to each parameter from the class User()
			//All the parameters come from the Form request
		   BeanUtils.populate(user, request.getParameterMap());		  
	
		   //Checks if all the user attributes are filled correctly,
		   //if so, store the user into the DB. Otherwiese, render the 
		   if (user.isComplete()) {
			   System.out.println("Inserting the user into the DB...");
			   user.insertUser();
			   System.out.println("User inserted successfully!");
			   
			   //After inserting the user into the DB, redirect the user to its home page
			   RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.jsp");
			   dispatcher.forward(request, response);
		   }
		   else {
			   // Puts the bean into the request as an attribute
			   request.setAttribute("user",user);
			   //TODO: if you want to test the HTML5 version you have to call the correspondent view or vice versa
			   RequestDispatcher dispatcher = request.getRequestDispatcher("/RegisterFormViewerHTML5.jsp");
			   dispatcher.forward(request, response);
		   }
	    } 
		catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
	    }		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
