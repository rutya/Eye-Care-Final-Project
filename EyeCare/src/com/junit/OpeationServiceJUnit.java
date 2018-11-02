package com.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.serviceLayer.OperationDetailsService;
import com.dao.OperationDetailDaoimpl;
import com.model.OperationDetails;

/**
 * @author Administrator this class is used for Junit testing of
 *  OpeationServiceJUnit  
 */

public class OpeationServiceJUnit {

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
	 * This function is used to test GetAllOpeartionDetails
	 */
	@Test
	public void testGetAllOpeartionDetails() {
		OperationDetailDaoimpl operationdetailsimpl=new OperationDetailDaoimpl();
		OperationDetailsService operationservice=new OperationDetailsService();
		int actual = operationdetailsimpl.getAllOpeartionDetails().size();
		int expected=operationservice.getAllOpeartionDetails().size();
		assertEquals(expected, actual);
	}
	/**
	 * This function is used to test AddOperationDetails
	 */

	@Test
	public void testAddOperationDetails() {
		OperationDetailDaoimpl operationdetailsimpl=new OperationDetailDaoimpl();
		OperationDetailsService operationservice=new OperationDetailsService();
		OperationDetails operationdetails=new OperationDetails("cateract sergery","AIMS",7);
		int expected = operationservice.getAllOpeartionDetails().size()+1;
		operationdetailsimpl.addOperationDetails(operationdetails);
		int actual = operationdetailsimpl.getAllOpeartionDetails().size();
		
		
		System.out.println(expected);
		assertEquals(expected, actual);
		
	}
	/**
	 * This function is used to test CheckAvailabilityOfTreatment
	 */
	@Test
	public void CheckAvailabilityOfTreatment()
	{
		OperationDetailsService operationdetailservice = new OperationDetailsService();
		OperationDetailDaoimpl operationimpl=new OperationDetailDaoimpl();
	//	operationimpl.getOperationalDetails();
		boolean expected= operationdetailservice.CheckAvailabilityOfTreatment("Cataract Sergery");
		System.out.println("e"+expected);
		boolean actual=false;
		assertEquals(expected, actual);

		//List<>
		//List<OperationDetails> actual=
				//getOpeartionDetails("Cataract Surgery");

}
}