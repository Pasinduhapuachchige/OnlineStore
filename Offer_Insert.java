package com.offers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 


public class Offer_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date= request.getParameter("date");
		String date2= request.getParameter("Edate");
		String offer=request.getParameter("offer");
		
		
		boolean isTrue;
		
		isTrue = offerDBUtil.insertoffer(date,date2,offer);
		
		if(isTrue==true) {
			RequestDispatcher dis = request.getRequestDispatcher("offersuccess.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2=request.getRequestDispatcher("error.jsp");
			dis2.forward(request, response);
		}
		
	}

}
