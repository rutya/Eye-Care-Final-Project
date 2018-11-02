package com.junit;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.serviceLayer.PatientDetailsService;
import com.dao.PatientDetailsDaoimpl;
import com.dao.PatientDetailsExistsException;
import com.model.PatientDetails;


/**
 * @author Administrator this class is used for Junit testing of
 *        PatientDetailsJUint 
 */

public class PatientDetailsJUint {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 //PatientDetailsDaoimpl patientDetailsDaoimpl = new PatientDetailsDaoimpl();
		PatientDetailsService patientservice=new PatientDetailsService();
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

//	@Test
//	public void testGetPatientDetails() {
//		PatientDetailsService patientservice1=new PatientDetailsService();
//		PatientDetails patientDetails = patientservice1.getPatientDetails(1);
//		//PatientDetails patientdetails=new PatientDetailsDaoimpl().getPatientDetails(1);
//		PatientDetails patient=new PatientDetails(1,22,"Rutuja Kulkarni","9623511929","sahakarnagar");
//		assertEquals(patientDetails,patient);
//		
//		
//	}

	/**
	 * This function is used to test GetAllPatientDetails
	 */
	@Test
	public void testGetAllPatientDetails() {
		PatientDetailsService patientservice1=new PatientDetailsService();
	int patientdetails=patientservice1.getAllPatientDetails().size();
	 int expected=new PatientDetailsDaoimpl().getAllPatientDetails().size();
	 assertEquals(expected, patientdetails);
	}

	@Test
	public void testAddPatientDetails() throws PatientDetailsExistsException {
		PatientDetailsDaoimpl patientdetailsimpl=new PatientDetailsDaoimpl();
		PatientDetailsService patientservice1=new PatientDetailsService();
		PatientDetails patientdetails=new PatientDetails(1,"Rutuja Kulkarni",22,"9623511929","sahakarnagar");
		patientdetailsimpl.addPatientDetails(patientdetails);
		int patientdetails1=patientservice1.getAllPatientDetails().size();
		int expected=new PatientDetailsDaoimpl().getAllPatientDetails().size();
		assertEquals(expected, patientdetails1);
		
		
		
	}
	/**
	 * This function is used to test UpdatePatientDetails
	 */
	@Test
	public void testUpdatePatientDetails() {
		PatientDetailsDaoimpl patientdetailsimpl=new PatientDetailsDaoimpl();
		PatientDetailsService patientdetailsservice=new PatientDetailsService();
		//PatientDetails patientDetails = patientdetailsservice.getPatientDetails(4);
		String tempissuedate = "2017-01-01";
		
		 Date issuedate = Date.valueOf(tempissuedate);
		 String tempduedate = "2018-01-01";
		 Date duedate = Date.valueOf(tempduedate);
		PatientDetails patientDetails2 = new PatientDetails (1,"Rutuja Kulkarni",25,"9720511929","shastriarnagar");
		
		patientdetailsimpl.updatePatientDetails(patientDetails2);
		PatientDetails patientDetails3 = patientdetailsservice.getPatientDetails(1);
		int age = patientDetails3.getAge();
		int patientDetails = patientdetailsservice.getPatientDetails(1).getAge();
		assertEquals(age,patientDetails);
	}


}
