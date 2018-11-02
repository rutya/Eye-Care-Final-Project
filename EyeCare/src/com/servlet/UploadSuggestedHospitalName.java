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
import com.soap.OtherHospital;
import com.soap.OtherHospitalService;
import com.model.CheckupDetails;

/**
 * Servlet implementation class UploadSuggestedHospitalName
 */
@WebServlet("/UploadSuggestedHospitalName")
public class UploadSuggestedHospitalName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadSuggestedHospitalName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// generating HttpSession for Main Doctor entity
		HttpSession sessionMainDoctor=request.getSession(false);
		
		if(sessionMainDoctor.getAttribute("mainDoctor")==null)
		{
			// redirecting to logout page if session attribute is null
			response.sendRedirect("/EyeCare/Pages/Logout.jsp");
		}
		else
		{
			// Retrieving parameter from jsp page
		
		String hospitalName = request.getParameter("Hospitalname");
		System.out.println("name: "+hospitalName);
		
		Object cardid = sessionMainDoctor.getAttribute("cardid");
		String tempcardid = cardid.toString();
		int cardId = Integer.parseInt(tempcardid);
		
		// creating object of CheckupDetailsService
		CheckupDetailsService checkupdetailservice = new CheckupDetailsService();
		// creating object of CheckupDetails to get checkupdetails of particular cardid
		CheckupDetails checkupDetails = checkupdetailservice.getCheckupDetails(cardId);
		//set SuggestedHospitalName attribute of checkupdetails
		checkupDetails.setSuggestedHospitalName(hospitalName);
		checkupDetails.setOperationDate(null);
		//update SuggestedHospitalName attribute of checkupdetails
		checkupdetailservice.updateMainTreatment(checkupDetails);
		
		float leftEyeNo=checkupDetails.getLeftEyeNo();
		float rightEyeNo = checkupDetails.getRightEyeNo();
		String mainTreatmentName = checkupDetails.getMainTreatmentName();
		
		OtherHospitalService objectHosp = new OtherHospitalService();
		OtherHospital otherHospitalPort = (OtherHospital) objectHosp.getOtherHospitalPort();
		String confirmation = otherHospitalPort.bookAppointment(cardId,leftEyeNo,rightEyeNo, mainTreatmentName);
		System.out.println("status:"+confirmation);
		
		//redirect confirmation with details to jsp
		request.setAttribute("confirmation",confirmation);

		RequestDispatcher requestdispatcher=request.getRequestDispatcher("/Pages/HospitalConfirmation.jsp");
		requestdispatcher.forward(request, response);
		
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
