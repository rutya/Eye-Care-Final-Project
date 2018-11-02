package com.junit;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.serviceLayer.AppointmentDetailsService;
import com.serviceLayer.PatientDetailsService;
import com.dao.AppointmentDetailsDaoimpl;
import com.dao.AppointmentDetailsExistsException;
import com.model.AppointmentDetails;
import com.model.PatientDetails;


/**
 * @author Administrator this class is used for Junit testing of
 * AppointmentServiceJUnit        
 */

public class AppointmentServiceJUnit {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * This function is used to test GetAllAppointmentDetails
	 */
	@Test
	public void testGetAllAppointmentDetails() {
		AppointmentDetailsService appointmentservice=new AppointmentDetailsService();
		AppointmentDetailsDaoimpl appointmnetdetailsimpl=new AppointmentDetailsDaoimpl();
		int actual = appointmentservice.getAllAppointmentDetails().size();
		 int expected=new AppointmentDetailsDaoimpl().getAllAppointmentDetails().size();
		 assertEquals(expected, actual);
	}
	/**
	 * This function is used to test AddAppointmentDetail
	 */
	@Test
	public void testAddAppointmentDetail() throws AppointmentDetailsExistsException {
		AppointmentDetailsDaoimpl appointmentimpl=new AppointmentDetailsDaoimpl();
		AppointmentDetailsService appointmentservice=new AppointmentDetailsService();
		
		PatientDetailsService patientdetailsservice = new PatientDetailsService();
		PatientDetails patientDetails = patientdetailsservice.getPatientDetails(1);
		
		String tempdate = "2017-01-01";
		 Date appointmnetdate = Date.valueOf(tempdate);
		 
		 
//		 
		AppointmentDetails appointmnetdetails1=new AppointmentDetails(patientDetails,appointmnetdate,"12");
		int expected=new AppointmentDetailsDaoimpl().getAllAppointmentDetails().size();
		appointmentimpl.addAppointmentDetail(appointmnetdetails1);
		int actual=appointmentservice.getAllAppointmentDetails().size();
		expected=expected+1;
		assertEquals(expected, actual);
	}

	/**
	 * This function is used to test UpdateAppointmentDetails
	 */
	
	@Test
	public void testUpdateAppointmentDetails() {
		AppointmentDetailsDaoimpl appointmentetailsimpl=new AppointmentDetailsDaoimpl();
		AppointmentDetailsService appointmentdetailsservice=new AppointmentDetailsService();
		AppointmentDetails appointmnetdetails=new AppointmentDetails();
		PatientDetailsService patientdetailsservice = new PatientDetailsService();
		PatientDetails patientDetails = patientdetailsservice.getPatientDetails(1);
		String tempissuedate = "2017-01-01";
		
		 Date issuedate = Date.valueOf(tempissuedate);
		 AppointmentDetails appointmentdetails1=new AppointmentDetails(patientDetails,issuedate,"1:0");
		
		 appointmentetailsimpl.updateAppointmentDetails(appointmentdetails1);
		 AppointmentDetails appointmentDetails = appointmentetailsimpl.getAppointmentDetails(1);
		Date actual = appointmentDetails.getAppointmentDate();
		appointmentDetails = appointmentdetailsservice.getAppointmentDetails(1);
		assertEquals(issuedate,actual);
	}

	

}
