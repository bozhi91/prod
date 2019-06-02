
package com.twitter.controller; 

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import com.twitter.beans.*;
import com.twitter.beans.User;
import com.twitter.model.UserDao;
import com.twitter.utils.Constants;

/**
 * Servlet implementation class RegisterFormController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
		try {
			//Fill all the parameters of the user
			BeanUtils.populate(user, request.getParameterMap());
			
			System.out.println("*** Inserting the user into the DB...");
			boolean result = UserDao.createUser(user);	
			
			if(!result) {
				request.getRequestDispatcher(Constants.REGISTER_VIEW).forward(request, response);						
				request.getSession().setAttribute("registerError", "User with that email already exists.");
			}	
			else{
				request.getRequestDispatcher(Constants.COUNT_CREATED_VIEW).forward(request, response);
				request.getSession().setAttribute("registerError", "");				
			}	
		} catch (IllegalAccessException | InvocationTargetException e) {
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

/*
 package com.twitter.controller;
 

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.twitter.beans.User;
import com.twitter.model.UserDao;
import com.twitter.utils.Constants;

public class RegisterController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public RegisterController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String birthday = req.getParameter("birthday");
		String email = req.getParameter("email");
		String male = req.getParameter("male");

		String female = req.getParameter("female");
		String password = req.getParameter("password");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date mySqlDate = null;
		try {
			Date birthdayDate = formatter.parse(birthday);
			mySqlDate = new java.sql.Date(birthdayDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Part filePart = req.getPart("file");
		// if(filePart!=null) {
		// isImage = filePart.getInputStream();
		// }
		InputStream isImage = null;
		try {
			Part filePart = req.getPart("imageFile"); // Retrieves <input type="file" name="file">
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			isImage = filePart.getInputStream();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		User user = new User(name, email, 'F', mySqlDate, password, isImage);
		UserDao.createUser(user);

		// String gender =

		req.getRequestDispatcher(Constants.COUNT_CREATED_VIEW).forward(req, resp);
	}
}*/
