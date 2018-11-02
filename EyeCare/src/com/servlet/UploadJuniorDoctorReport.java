package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.serviceLayer.CheckupDetailsService;
import com.model.CheckupDetails;

/**
 * Servlet implementation class UploadJuniorDoctorReport
 */
@WebServlet("/UploadJuniorDoctorReport")
public class UploadJuniorDoctorReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadJuniorDoctorReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// generating HttpSession for junior Doctor entity
		HttpSession sessionJuniorDoctor=request.getSession(false);
		
		if(sessionJuniorDoctor.getAttribute("juniorDoctor")==null)
		{
			// redirecting to logout page if session attribute is null
			response.sendRedirect("/EyeCare/Pages/Logout.jsp");
		}
		else
		{
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// creating object of CheckupDetailsService
		CheckupDetailsService checkupdetailsservice = new CheckupDetailsService();
		// Retrieving parameter from jsp page
		String treatmentName = request.getParameter("treatment");
		Object tempcardid = sessionJuniorDoctor.getAttribute("cardId");
		String cardIdstr = tempcardid.toString();
		int cardid = Integer.parseInt(cardIdstr);
	
	
		
		
		// creating object of CheckupDetails to store the checkupdetails of
					// patient by giving tempercardid
		
		CheckupDetails checkupdetails = checkupdetailsservice.getCheckupDetails(cardid);
		
		// setSuggestedTreatment of CheckupDetails's object
		checkupdetails.setSuggestedTreatment(treatmentName);
		
		// update the SuggestedTreatment to checkupdetails
		checkupdetailsservice.updateSuggestedTreatment(checkupdetails);
		

		response.sendRedirect("/EyeCare/Pages/Logout.jsp");
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
