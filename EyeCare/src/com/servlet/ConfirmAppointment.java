package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.serviceLayer.AppointmentDetailsService;
import com.serviceLayer.PatientDetailsService;
import com.dao.AppointmentDetailsDao;
import com.dao.AppointmentDetailsExistsException;
import com.model.AppointmentDetails;

/**
 * Servlet implementation class ConfirmAppointment
 */
@WebServlet("/ConfirmAppointment")
public class ConfirmAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmAppointment() {
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
		

		// Creating object for storing the attributes of session
		Object attribute = sessionReceptionist.getAttribute("receptionist");
		
		if (sessionReceptionist.getAttribute("receptionist") == null) 
		{

			

			// //redirecting to logout page if session attribute is null
			response.sendRedirect("/EyeCare/Pages/Logout.jsp");
		} else {
			// Retrieving parameter from jsp page.
			int cardid = Integer.parseInt(request.getParameter("cardid").trim());
			String temp = request.getParameter("AppointmentDate").trim();
			Date AppointmentDate = Date.valueOf(temp);
			String appointmenttime = request.getParameter("appointmenttime").trim();
			

			// creating object of Appointmentdetails in which inovoke the object
			// of patientdetailsService to get all details of patient
			AppointmentDetails appointmentdetails = new AppointmentDetails(new PatientDetailsService().getPatientDetails(cardid),AppointmentDate, appointmenttime);
			AppointmentDetailsService appointmentservice = new AppointmentDetailsService();

			
				// insert appointmentdetail by calling addAppointmentdetail
				// function of object of A AppointmentDetailsService.
				appointmentservice.addAppointmentDetail(appointmentdetails);
			}
		
			// AppointmentDetailsExistsException handling
			

			// creating object of RequestDispatcher that receives requests from
			// the client and sends them to jsp file on the server
			response.sendRedirect("/EyeCare/Pages/AlreadyRegistered.jsp");
	}catch (AppointmentDetailsExistsException|NullPointerException|IllegalArgumentException e) {
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
		// calling to the get method

		doGet(request, response);
		// response.sendRedirect("");
	}

}
