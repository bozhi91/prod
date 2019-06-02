package com.twitter.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import com.twitter.beans.BeanLogin;
import com.twitter.beans.User;
import com.twitter.model.UserDao;
import com.twitter.utils.Constants;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController(){
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BeanLogin loginBean = new BeanLogin();
		request.getSession().setAttribute("error", "");//clean the error messages from the session first.
		
	    try {
			BeanUtils.populate(loginBean, request.getParameterMap());
			
			if(loginBean.isComplete()) {
				boolean login = UserDao.authenticateUser(request.getParameter("email"), request.getParameter("password"));
				
				//Check if the username and password are correct, if so, redirect to the home page
				if(login) {
					User user = new User();
					user = UserDao.getUserByEmail(request.getParameter("email"));
					
					//if the login is correct, redirect to the home page
					request.getSession().setAttribute("userName", user.getUsername());	
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("error", "");
					request.getRequestDispatcher(Constants.PRIVATE_HOME_PAGE).forward(request, response);	
				}
				//If the login is incorrect, an error message appears ont hte login screen
				else{										
					request.getSession().setAttribute("error", "Sorry, your email or password are incorrect. Please, try again.");
					request.getRequestDispatcher(Constants.LOGIN_PAGE).forward(request, response);			
				}
			}
			else{
				request.getSession().setAttribute("error", "Sorry, you need to fill the username and the password fields.");
				request.getRequestDispatcher(Constants.LOGIN_PAGE).forward(request, response);			
			}
			
		} catch (IllegalAccessException | InvocationTargetException e){
			e.printStackTrace();
		}
	}
}

