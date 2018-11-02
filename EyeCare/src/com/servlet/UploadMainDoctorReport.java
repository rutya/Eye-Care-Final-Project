package com.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.serviceLayer.CheckupDetailsService;
import com.serviceLayer.OperationDetailsService;
import com.model.CheckupDetails;
import com.model.OperationDetails;

/**
 * Servlet implementation class UploadMainDoctorReport
 */
@WebServlet("/UploadMainDoctorReport")
public class UploadMainDoctorReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadMainDoctorReport() {
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
		try
		{
		// generating HttpSession for Main Doctor entity
		HttpSession sessionMainDoctor = request.getSession(false);

		if (sessionMainDoctor.getAttribute("mainDoctor") == null) {
			// redirecting to Logout page if session attribute is null
			response.sendRedirect("/EyeCare/Pages/Logout.jsp");
			
		} else {
			// Retrieving parameter from jsp page
			String treatmentName = request.getParameter("treatment");
			String tempoperationdate = request.getParameter("OperationDate");
			
			Object tempcardid = sessionMainDoctor.getAttribute("cardid");
			String cardidstr = tempcardid.toString();
			int cardId = Integer.parseInt(cardidstr);
			
			
			
			Date operationdate = Date.valueOf(tempoperationdate);
			// creating object of CheckupDetailsService
			CheckupDetailsService checkupdetailservice = new CheckupDetailsService();
			// creating object of operationDetailsService
			OperationDetailsService operationdetailservice = new OperationDetailsService();

			// calling getCheckupDetails by object of CheckupDetailsService
			CheckupDetails checkupdetails = checkupdetailservice
					.getCheckupDetails(cardId);

			// get the status of CheckAvailabilityOfTreatment
			boolean checkAvailabilityOfTreatment = operationdetailservice
					.CheckAvailabilityOfTreatment(treatmentName);
			String checkavailability;

			if (checkAvailabilityOfTreatment == true) {
				// set the attributes of checkupdetails if
				// checkAvailabilityOfTreatment is true
				checkupdetails.setMainTreatmentName(treatmentName);
				checkupdetails.setSuggestedHospitalName("Eye Care");
				checkupdetails.setOperationDate(operationdate);
				checkupdetailservice.updateMainTreatment(checkupdetails);
				checkavailability = "available";
				request.setAttribute("available", checkavailability);
				
				// creating object of RequestDispatcher that receives requests
				// from
				// the client and sends them to jsp file on the server
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/Pages/CheckAvailabilityOfMainTreatment.jsp");
				requestDispatcher.forward(request, response);
			} else {
				// set the attributes of checkupdetails if
				// checkAvailabilityOfTreatment is not true
				checkavailability = "not available";
				checkupdetails.setMainTreatmentName(treatmentName);
				checkupdetailservice.updateMainTreatment(checkupdetails);
				request.setAttribute("available", checkavailability);
				System.out.println("In false: " + checkavailability);

				// creating a list of OperationDetails
				List<OperationDetails> operationalDetailsList = operationdetailservice
						.getOperationalDetails(treatmentName);
				request.setAttribute("operationalDetailsList",
						operationalDetailsList);

				// creating object of RequestDispatcher that receives requests
				// from
				// the client and sends them to jsp file on the server
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/Pages/CheckAvailabilityOfMainTreatment.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		}
		catch (IllegalArgumentException e) {
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
