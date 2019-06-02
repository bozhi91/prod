package com.twitter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twitter.utils.Constants;

public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeController() {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Constants.HOME_PAGE).forward(request, response);

		// String userName = request.getParameter("username");
		// String password = request.getParameter("password");
		// User loginBean = new User();
		// loginBean.setUserName(userName);
		// loginBean.setPassword(password);
		// LoginDAO loginDao = new LoginDAO();
		// String userValidate = loginDao.authenticateUser(loginBean);
		//
		// if (userValidate.equals("SUCCESS")) {
		// // success login
		// request.setAttribute("userName", userName);
		// request.getRequestDispatcher(Constants.HOME_PAGE).forward(request, response);
		//
		// } else {
		// // error login
		// request.setAttribute("errMessage", userValidate);
		// request.getRequestDispatcher(Constants.LOGIN_PAGE).forward(request, response);
		// }
	}

}