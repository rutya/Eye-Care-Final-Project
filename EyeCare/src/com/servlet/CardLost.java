package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.serviceLayer.CardDetailsService;
import com.serviceLayer.PatientDetailsService;
import com.model.CardDetails;
import com.model.PatientDetails;

/**
 * Servlet implementation class CardLost
 */
@WebServlet("/CardLost")
public class CardLost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CardLost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		// generating HttpSession for Receptionist entity
		
		try
		{
		HttpSession sessionReceptionist = request.getSession(false);
		if (sessionReceptionist.getAttribute("receptionist") == null) {
             //redirecting to logout page if session attribute is null
			response.sendRedirect("/EyeCare/Pages/Logout.jsp");
			
		} else {
			// retriving parameter from jsp page.
			String name = request.getParameter("name");
			String mobileno = request.getParameter("phoneno");

			// creating list of CardDetails
			CardDetailsService cardDetailsService = new CardDetailsService();
			List<CardDetails> allCardDetails = cardDetailsService.getAllCardDetails();

			CardDetails cardDetails = null;

			// Printing list of CardDetails
			for (CardDetails card : allCardDetails) {
				if (card.getPatient().getPatientName().equalsIgnoreCase(name)
						&& card.getPatient().getMobileNo().equals(mobileno)) {
					cardDetails = card;
					break;

				}
			}

			
			//setting attributes to request
			request.setAttribute("cardDetails", cardDetails);

			// creating object of RequestDispatcher that receives requests from
			// the client and sends them to jsp file on the server
			System.out.println(cardDetails);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Pages/CardDisplay.jsp");
			requestDispatcher.forward(request, response);

		}
		}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("/EyeCare/Pages/ErrorPage.jsp");
			System.out.println("invalid entries");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// calling to the get method
		doGet(request, response);
	}

}
