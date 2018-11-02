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
import com.dao.PatientDetailsDao;
import com.dao.PatientDetailsDaoimpl;
import com.model.PatientDetails;

/**
 * Servlet implementation class EditDetailsForm
 */
@WebServlet("/EditDetailsForm")
public class EditDetailsForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditDetailsForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// generating HttpSession for Receptionist entity
		try
		{
		
		HttpSession sessionReceptionist = request.getSession(false);

		// printing HttpSession Object
		System.out.println(sessionReceptionist);

		// creting object for storing the attributes of session
		Object attribute = sessionReceptionist.getAttribute("receptionist");

		System.out.println(attribute);
		if (sessionReceptionist.getAttribute("receptionist") == null) {
			// redirecting to logout page if session attribute is null

			response.sendRedirect("/EyeCare/Pages/Logout.jsp");
		} else {
			// Retrieving parameter from jsp page.
			String tempage = request.getParameter("age");
			int Age = Integer.parseInt(tempage);
			String address = request.getParameter("address");
			String phone_no = request.getParameter("phone_no");
			System.out.println("Address: "+address);
			
			if(address.equals("")||tempage.equals("")||phone_no.equals(""))
			{
				
				response.sendRedirect("/EyeCare/Pages/EditDetailsForm.jsp");
			}
			
			else
			{
			// Creating object for storing the attributes of session
			Object attrPatient = sessionReceptionist.getAttribute("patientDetails");

			// creating object of PatientDetailsService
			PatientDetailsService patientService = new PatientDetailsService();

			PatientDetails patient = (PatientDetails) attrPatient;
			

			// setting attributes to the patientDetails object
			patient.setAge(Age);
			patient.setAddress(address);
			patient.setMobileNo(phone_no);
			patientService.updatePatientDetails(patient);

			response.sendRedirect("/EyeCare/Pages/AlreadyRegistered.jsp");
			}
		}
		}
		catch (NumberFormatException |NullPointerException e) {
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

	}

}
