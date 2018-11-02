package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.model.CheckupDetails;

/**
 * 
 * @author Administrator This is WebService For booking Appointment with other
 *         hospital
 */

@WebService(name = "OtherHospital", targetNamespace = "http://soap.com/")
public class OtherHospital {
	@WebMethod(operationName = "bookAppointment")
	public String bookAppointment(int CardId, float leftEyeNo, float rightEyeNo, String suggested_treatment) {
		
		PreparedStatement pst;
		try {
			Connection connection = DBConnection.getConnection();
			String sqlQuery = "insert into Hospital2" + " values(?,?,?,?)";
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, CardId);
			pst.setFloat(2, leftEyeNo);
			pst.setFloat(3, rightEyeNo);
			pst.setString(4, suggested_treatment);
			pst.executeUpdate();

			return "Thank you...You Are Enrolled in Our Hospital...Your Appointment is Stored in our Database. ";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Sorry Something went Wrong";

	}
}
