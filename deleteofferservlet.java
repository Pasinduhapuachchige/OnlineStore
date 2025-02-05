package com.offers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteofferservlet")
public class deleteofferservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String id=request.getParameter("offerid");
		boolean isTrue;
		
		isTrue=offerDBUtil.deleteoffer(id);
		
		if(isTrue==true) {
			RequestDispatcher dispatcher= request.getRequestDispatcher("offersuccess.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			RequestDispatcher dispatcher= request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		
	}

}
