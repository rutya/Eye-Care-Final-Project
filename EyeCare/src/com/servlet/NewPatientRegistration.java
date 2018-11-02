package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.serviceLayer.PatientDetailsService;
import com.dao.PatientDetailsExistsException;
import com.model.PatientDetails;

/**
 * Servlet implementation class NewPatientRegistration
 */
@WebServlet("/NewPatientRegistration")
public class NewPatientRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewPatientRegistration() {
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
		if (sessionReceptionist.getAttribute("receptionist") == null) {
			// redirecting to logout page if session attribute is null
			response.sendRedirect("/EyeCare/Pages/Logout.jsp");
			
		} else {
			// Retrieving parameter from jsp page.

			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String mobile_No = request.getParameter("mobile_No");
			String adress = request.getParameter("address");

			// creating object of PatientDetails to store the retrieved
			// parameter
			PatientDetails patient = new PatientDetails(name, age, mobile_No,adress);
			// creating object of PatientDetailsService
			PatientDetailsService patientService = new PatientDetailsService();
			PrintWriter out = response.getWriter();
			// printing message after insert operation
			out.println("values inserted into database");
			
				// inserting object of patient into into function of
				// PatientDetailsService
				patientService.addPatientDetails(patient);
			
			// AppointmentDetailsExistsException handling
			
			// creating object of RequestDispatcher that receives requests from
			// the client and sends them to jsp file on the server
			
			response.sendRedirect("/EyeCare/Pages/ReceptionistFunctionality.jsp");
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Pages/ReceptionistFunctionality.jsp");
//			requestDispatcher.forward(request, response);
		}
		}
		catch (PatientDetailsExistsException|NumberFormatException e) {
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
