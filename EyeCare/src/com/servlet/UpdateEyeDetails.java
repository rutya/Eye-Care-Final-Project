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

import com.serviceLayer.CheckupDetailsService;
import com.dao.CheckupDetailsDaoimpl;
import com.model.CheckupDetails;

/**
 * Servlet implementation class UpdateEyeDetails
 */
@WebServlet("/UpdateEyeDetails")
public class UpdateEyeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEyeDetails() {
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
		try
		{
		PrintWriter writer = response.getWriter();

		// generating HttpSession for Receptionist entity
		HttpSession sessionReceptionist = request.getSession(false);
		if (sessionReceptionist.getAttribute("receptionist") == null) {
			// redirecting to logout page if session attribute is null
			response.sendRedirect("/EyeCare/Pages/Logout.jsp");
			
		} else {
			// Retrieving parameter from jsp page.
			int cardid = Integer.parseInt(request.getParameter("CardId"));
			float LeftEyeNo = Float.parseFloat(request.getParameter("LeftEye"));
			float RightEyeNo = Float.parseFloat(request
					.getParameter("RightEye"));
			// creating object of CheckupDetailsService
			CheckupDetailsService checkupDetailsService = new CheckupDetailsService();

			// Fetch the details of the patient
			CheckupDetails checkupDetails = checkupDetailsService
					.getCheckupDetails(cardid);

			// set all the attributes of checkupDetails
			checkupDetails.setLeftEyeNo(LeftEyeNo);
			checkupDetails.setRightEyeNo(RightEyeNo);
			checkupDetailsService.updateEyeNo(checkupDetails);

			response.sendRedirect("/EyeCare/Pages/AlreadyRegistered.jsp");
		}
		}
		catch (NumberFormatException|NullPointerException e) {
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
