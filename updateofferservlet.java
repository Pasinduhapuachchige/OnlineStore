package com.offers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateofferservlet")
public class updateofferservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("offerid");
		String date =request.getParameter("offerdate");
		String date2 =request.getParameter("offerdate2");
		String offer=request.getParameter("offer");
		
		
		boolean isTrue;
		
		isTrue= offerDBUtil.updateoffer(id, date,date2, offer);
		
		if(isTrue== true) {
			RequestDispatcher dis=request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		}
		else {
			
			RequestDispatcher dis=request.getRequestDispatcher("error.jsp");
			dis.forward(request, response);
			
		}
		
		
		
	}

}
