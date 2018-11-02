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
 * Servlet implementation class UploadGlassesGrantedStatus
 */
@WebServlet("/UploadGlassesGrantedStatus")
public class UploadGlassesGrantedStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadGlassesGrantedStatus() {
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
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
		// generating HttpSession for MainDoctor entity

		HttpSession eyeGlassShopKeepersession = request.getSession(false);
		if (eyeGlassShopKeepersession.getAttribute("Eyeglass") == null) {
			// redirecting to logout page if session attribute is null

			response.sendRedirect("/EyeCare/Pages/Logout.jsp");
					} else {
			// creating object of CheckupDetailsService
			CheckupDetailsService checkupdetailsservice = new CheckupDetailsService();

			// Retrieving parameter from jsp page.
			String status = request.getParameter("glassstatus");


			Object cardidobject= eyeGlassShopKeepersession.getAttribute("cardId");
			String tempcardid=cardidobject.toString();
			int cardId = Integer.parseInt(tempcardid);
			
			

			// creating object of CheckupDetails to store the checkupdetails of
			// patient by giving tempercardid
			CheckupDetails checkupdetails = checkupdetailsservice.getCheckupDetails(cardId);

			// checking condition of status
			if (status == null) {
				// if session is null then setGlassesGrantedStatus as no
				checkupdetails.setGlassesGrantedStatus("no");
				// update the GlassGrantedStatus to checkupdetails
				checkupdetailsservice.updateGlassGrantedStatus(checkupdetails);
			}

			else if (status.equals("on")) {
				// if session is null then setGlassesGrantedStatus as yes
				checkupdetails.setGlassesGrantedStatus("yes");
				// update the GlassGrantedStatus to checkupdetails
				checkupdetailsservice.updateGlassGrantedStatus(checkupdetails);
			}

			response.sendRedirect("/EyeCare/Pages/AfterEyeGlassLogin.jsp");
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
