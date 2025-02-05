package com.offers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OfferServlet")
public class OfferServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch offers from database
        List<Offer> offers = offerDBUtil.getOffers();

        // Set the offers as a request attribute
        request.setAttribute("offerList", offers);

        // Forward to JSP page to display the data
        RequestDispatcher dispatcher = request.getRequestDispatcher("offers.jsp");
        dispatcher.forward(request, response);
    }
}
