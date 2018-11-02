package com.servlet;

import java.io.IOException;

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
 * Servlet implementation class ViewDetails
 */
@WebServlet("/ViewPatientDetails")
public class ViewPatientDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPatientDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// generating HttpSession for Receptionist entity
		try
		{
		HttpSession sessionReceptionist=request.getSession(false);
		// creting object for storing the attributes of session
		Object attribute = sessionReceptionist.getAttribute("receptionist");
		if(sessionReceptionist.getAttribute("receptionist")==null)
		{
			// redirecting to logout page if session attribute is null
			response.sendRedirect("/EyeCare/Pages/Logout.jsp");
		}
		else
		{
			// Retrieving parameter from jsp page.
			String tempcardid = request.getParameter("cardid");
			int CardId = Integer.parseInt(tempcardid);
			// creating object of PatientDetailsService
			PatientDetailsService patientservice= new PatientDetailsService();
			// creating object of PatientDetails to get patientDetails of particular card id
			PatientDetails patientDetails = patientservice.getPatientDetails(CardId);
			
			
			// setting attributes to the patientDetails object
			request.setAttribute("patientDetails", patientDetails);
			sessionReceptionist.setAttribute("patientDetails", patientDetails);
			// creating object of RequestDispatcher that receives requests from
			// the client and sends them to jsp file on the server
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Pages/ViewAndEditPatientDetails.jsp");
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
		// calling doGet() method
		doGet(request, response);
		
	}

}
