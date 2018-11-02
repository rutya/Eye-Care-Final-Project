package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CardDetails;
import com.serviceLayer.CardDetailsService;

/**
 * Servlet implementation class DisplayCardDetails
 */
@WebServlet("/DisplayCardDetails")
public class DisplayCardDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCardDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		// generating HttpSession for Receptionist entity
				HttpSession sessionReceptionist = request.getSession(false);
				// printing HttpSession Object
				

				// creting object for storing the attributes of session
				Object attribute = sessionReceptionist.getAttribute("receptionist");
				
				if (sessionReceptionist.getAttribute("receptionist") == null) {

					// redirecting to logout page if session attribute is null
					response.sendRedirect("/EyeCare/Pages/Logout.jsp");


				} else {
					// Retrieving parameter from jsp page.
					int CardId = Integer.parseInt(request.getParameter("cardid"));// Get card id of patient
					System.out.println("Card ID: "+CardId);
					CardDetailsService cardDetailsService = new CardDetailsService();

					// Fetch the details of the patient
					CardDetails cardDetails = cardDetailsService.getCardDetails(CardId);
					// Fetch the details of the patient
					System.out.println("Details: "+cardDetails);
					request.setAttribute("cardDetails", cardDetails);
					// creating object of RequestDispatcher that receives requests from
					// the client and sends them to jsp file on the server
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("/Pages/CardDisplay.jsp");
					requestDispatcher.forward(request, response);
	
				}
		}
		catch (NumberFormatException|NullPointerException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("/EyeCare/Pages/ErrorPage.jsp");
			System.out.println("invalid entries");
		}
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
