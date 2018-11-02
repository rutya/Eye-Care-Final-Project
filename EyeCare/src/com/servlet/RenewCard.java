package com.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.serviceLayer.CardDetailsService;
import com.serviceLayer.PatientDetailsService;
import com.dao.AppointmentDetailsExistsException;
import com.dao.CardDetailsDaoimpl;
import com.model.CardDetails;

/**
 * Servlet implementation class RenewCard
 */
@WebServlet("/RenewCard")
public class RenewCard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RenewCard() {
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
		// generating HttpSession for Receptionist entity
		try
		{
		HttpSession sessionReceptionist = request.getSession(false);
		// printing HttpSession Object
		

		// creting object for storing the attributes of session
		Object attribute = sessionReceptionist.getAttribute("receptionist");
		
		if (sessionReceptionist.getAttribute("receptionist") == null) {

			
			response.sendRedirect("/EyeCare/Pages/Logout.jsp");


		} else {
			// Retrieving parameter from jsp page.
			int CardId = Integer.parseInt(request.getParameter("cardid"));// Get card id of patient
																			
			long currentTimeMillis = System.currentTimeMillis();// Get current
																// date of the
																// system

			Date issueDate = new Date(currentTimeMillis);
			// creating object of CardDetailsService
			CardDetailsService cardDetailsService = new CardDetailsService();

			// Fetch the details of the patient
			CardDetails cardDetails = cardDetailsService.getCardDetails(CardId);
			// Fetch the details of the patient

			// Set issue date as current date of the system
			cardDetails.setIssueDate(issueDate);

			// Set due date of the card
			Date dat = java.sql.Date.valueOf(issueDate.toString());

			LocalDate localDate = dat.toLocalDate();

			// Get day,month and year from the current date
			int day = localDate.getDayOfMonth();
			System.out.println("day: " + day);
			int month = localDate.getMonthValue();
			System.out.println("month: " + month);
			int year = localDate.getYear();
			// Set due year as next year from the current year
			int dueyear = year + 1;
			int newmonth = month - 1;

			// Set the date to carddetails
			Calendar c = Calendar.getInstance();
			c.set(dueyear, newmonth, day);
			java.sql.Date sqlDate = new java.sql.Date(c.getTimeInMillis());

			cardDetails.setDueDate(sqlDate);

			cardDetailsService.updateCardDetails(cardDetails);

			request.setAttribute("cardDetails", cardDetails);
			// creating object of RequestDispatcher that receives requests from
			// the client and sends them to jsp file on the server
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Pages/CardDisplay.jsp");
			requestDispatcher.forward(request, response);
		}
		}
		catch (NumberFormatException|NullPointerException es) {
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
		// TODO Auto-generated method stub
		// calling doGet() method
		doGet(request, response);
	}

}
