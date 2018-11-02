package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceLayer.CheckupDetailsService;
import com.model.CheckupDetails;
import com.soap.OtherHospital;
import com.soap.OtherHospitalService;
//import com.soap.BookAppointment;
//import com.soap.OtherHospital;
//import com.soap.OtherHospitalService;


/**
 * Servlet implementation class ReferredHospital
 */
@WebServlet("/ReferredHospital")
public class ReferredHospital extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReferredHospital() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//String hospitalname=request.getParameter("Hospitalname");
		int cardid=1;
		//String patientname="Rahul";
		
//		BookAppointment ba=new BookAppointment();
//		//BookAppointmentResponse br=new BookAppointmentResponse();
//		ba.setArg0(1);
//		ba.setArg1((float) 1.5);
//		ba.setArg2((float) 0.5);
//		ba.setArg3("eye cancer");
		OtherHospitalService objectHosp = new OtherHospitalService();
		OtherHospital otherHospitalPort = (OtherHospital) objectHosp.getOtherHospitalPort();
		String confirmation = otherHospitalPort.bookAppointment(cardid,(float)5.0,(float)5.8, "Eye cancer");
		System.out.println("status:"+confirmation);
		
		//redirect confirmation with details to jsp
		request.setAttribute("confirmation",confirmation);

	RequestDispatcher requestdispatcher=request.getRequestDispatcher("/Pages/HospitalConfirmation.jsp");
		requestdispatcher.forward(request, response);
		
//		response.sendRedirect("/Pages/HospitalConfirmation.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
