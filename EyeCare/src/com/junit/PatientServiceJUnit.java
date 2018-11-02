package com.junit;

import static org.junit.Assert.*;

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
 *   PatientServiceJUnit
 */

public class PatientServiceJUnit {

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

//	@Test
//	public void testGetPatientDetails() {
//		
//		
//		
//	}
	/**
	 * This function is used to test GetAllPatientDetails
	 */
	@Test
	public void testGetAllPatientDetails() {
		PatientDetailsDaoimpl patientdetailimpl=new PatientDetailsDaoimpl();
		PatientDetailsService patientservice=new PatientDetailsService();
		int size = patientdetailimpl.getAllPatientDetails().size();
		int expected = patientservice.getAllPatientDetails().size();
		assertEquals(expected,size );
		
	}
	/**
	 * This function is used to test AddPatientDetails
	 */
	@Test
	public void testAddPatientDetails() throws PatientDetailsExistsException {
		PatientDetailsDaoimpl patientdetailsimpl=new PatientDetailsDaoimpl();
		PatientDetailsService patientservice1=new PatientDetailsService();
		PatientDetails patientdetails=new PatientDetails("Rutuja Kulkarni",22,"9623511929","sahakarnagar");
		patientdetailsimpl.addPatientDetails(patientdetails);
		int patientdetails1=patientservice1.getAllPatientDetails().size();
		int expected=new PatientDetailsDaoimpl().getAllPatientDetails().size();
		assertEquals(expected, patientdetails1);
	}

	@Test
	public void testUpdatePatientDetails() {
		
	}

	

}
