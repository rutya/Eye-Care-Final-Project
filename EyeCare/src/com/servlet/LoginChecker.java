package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLoginChecker
 */
@WebServlet("/LoginChecker")
public class LoginChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginChecker() {
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

		// calling doPost() method
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Retrieving parameter from jsp page
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();

		// printing the username and password
		System.out.println("reading the username and password " + username
				+ " " + password);

		// creating Strings to store all users's Username.
		String username1 = "receptionist";
		String username2 = "juniord";
		String username3 = "maind";
		String username4 = "eyeglass";

		// condition for checking whether the user is receptionist or not
		if (username != null && username.equals(password)
				&& username.equals(username1)) {

			// generating HttpSession for Receptionist entity
			HttpSession sessionReceptionist = request.getSession(true);
			sessionReceptionist.setAttribute("receptionist", username1);
			System.out.println(" your username and password is correct");

			// Redirecting to patientRegistration
			response.sendRedirect("/EyeCare/Pages/ReceptionistFunctionality.jsp");
		}
		// condition for checking whether the user is junior doctor or not
		else if (username != null && username.equals(password)
				&& username.equals(username2)) {

			// generating HttpSession for Junior doctor entity
			HttpSession sessionJuniorDoctor = request.getSession(true);
			sessionJuniorDoctor.setAttribute("juniorDoctor", username2);
			System.out.println(" your username and password is correct");

			// Redirecting to JuniorDoctorPatient
			response.sendRedirect("/EyeCare/Pages/JuniorDoctorPatient.jsp");
		}
		// condition for checking whether the user is MainDoctor or not
		else if (username != null && username.equals(password)
				&& username.equals(username3)) {
			// generating HttpSession for Main doctor entity
			HttpSession sessionMainDoctor = request.getSession(true);
			sessionMainDoctor.setAttribute("mainDoctor", username3);
			System.out.println(" your username and password is correct");

			// Redirecting to MainDoctorPatient
			response.sendRedirect("/EyeCare/Pages/MainDoctorPatient.jsp");
		}
		// condition for checking whether the user is eyeglass or not
		else if (username != null && username.equals(password)
				&& username.equals(username4)) {

			// generating HttpSession for Eye Glass entity
			HttpSession sessionEyeglass = request.getSession(true);
			sessionEyeglass.setAttribute("Eyeglass", username4);
			System.out.println(" your username and password is correct");
			// Redirecting to AfterEyeGlassLogin
			response.sendRedirect("/EyeCare/Pages/AfterEyeGlassLogin.jsp");
		}
		// Redirecting to Login page if all conditions for login checking are
		// failed
		else {
			System.out.println("username or password is incorrect");
			response.sendRedirect("/EyeCare/Pages/Login.jsp");

		}

		response.flushBuffer();

	}

}
