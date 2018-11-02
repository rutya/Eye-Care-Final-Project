package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ViewReportToMainDoctor
 */
@WebServlet("/ViewReportToMainDoctor")
public class ViewReportToMainDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReportToMainDoctor() {
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
		// generating HttpSession for Junior Doctor  Doctor entity
		HttpSession sessionMainDoctor=request.getSession(false);
		
		if(sessionMainDoctor.getAttribute("mainDoctor")==null)
		{
			// redirecting to Logout page if session attribute is null
			response.sendRedirect("/EyeCare/Pages/Logout.jsp");
		}
		else
		{
		
			// Retrieving parameter from jsp page.
		String cardid = request.getParameter("cardid");
		sessionMainDoctor.setAttribute("cardid", cardid);
		
		int cardId = Integer.parseInt(cardid);
		// creating object of CheckupDetailsService
		CheckupDetailsService checkupdetailsservice = new CheckupDetailsService();
		// creating object of CheckupDetails to get patientDetails of
		// particular card id
		CheckupDetails checkupDetails = checkupdetailsservice.getCheckupDetails(cardId);
		// setting attributes to the checkupDetails object
		request.setAttribute("checkupDetails", checkupDetails);
		// creating object of RequestDispatcher that receives requests from
		// the client and sends them to jsp file on the server
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Pages/MainDoctorViewReport.jsp");
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
