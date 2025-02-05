package com.offers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DisplayOffers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Fetch the list of offers from the database
        List<Offer> offers = offerDBUtil.getOffers();

        // Set the offers list into the request scope
        request.setAttribute("offersList", offers);

        // Forward the request to displayoffers.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayOffers.jsp");
        dispatcher.forward(request, response);
    }
}
