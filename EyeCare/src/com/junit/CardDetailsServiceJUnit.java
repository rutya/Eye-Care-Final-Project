package com.junit;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.serviceLayer.CardDetailsService;
import com.serviceLayer.PatientDetailsService;
import com.dao.CardDetailsDaoimpl;
import com.dao.CardDetailsExistsException;
import com.model.CardDetails;
import com.model.PatientDetails;
/**
 * @author Administrator this class is used for Junit testing of
 * CardDetailsServiceJUnit
 */

public class CardDetailsServiceJUnit {

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
	 * This function is used to test GetAllCardDetails.
	 */
	@Test
	public void testGetAllCardDetails() {
		CardDetailsService carddetails=new CardDetailsService();
		int patientdetails=carddetails.getAllCardDetails().size();
		 int expected=new CardDetailsDaoimpl().getAllCardDetails().size();
		 assertEquals(expected, patientdetails);
	}
	/**
	 * This function is used to test AddCardDetail
	 */
	@Test
	public void testAddCardDetail() throws CardDetailsExistsException {
		CardDetailsDaoimpl carddetailsimpl=new CardDetailsDaoimpl();
		CardDetailsService carddetailsservice=new CardDetailsService();
		
		PatientDetailsService patientdetailsservice = new PatientDetailsService();
		PatientDetails patientDetails = patientdetailsservice.getPatientDetails(5);
		
		String tempissuedate = "2017-01-01";
		 Date issuedate = Date.valueOf(tempissuedate);
		 String tempduedate = "2018-01-01";
		 Date duedate = Date.valueOf(tempduedate);
		 
		 
		CardDetails carddetails1=new CardDetails(patientDetails,issuedate,duedate);
		int expected=new CardDetailsDaoimpl().getAllCardDetails().size();
		carddetailsimpl.addCardDetail(carddetails1);
		int actual=carddetailsservice.getAllCardDetails().size();
		expected=expected+1;
		assertEquals(expected, actual);
	}
	/**
	 * This function is used to test UpdateCardDetails
	 */
	@Test
	public void testUpdateCardDetails() {
		CardDetailsDaoimpl carddetailsimpl=new CardDetailsDaoimpl();
		CardDetailsService carddetailsservice=new CardDetailsService();
		CardDetailsService carddetails=new CardDetailsService();
		PatientDetailsService patientdetailsservice = new PatientDetailsService();
		PatientDetails patientDetails = patientdetailsservice.getPatientDetails(4);
		String tempissuedate = "2017-01-01";
		
		 Date issuedate = Date.valueOf(tempissuedate);
		 String tempduedate = "2018-01-01";
		 Date duedate = Date.valueOf(tempduedate);
		CardDetails carddetails1=new CardDetails(patientDetails,issuedate,duedate);
		
		carddetailsimpl.updateCardDetails(carddetails1);
		CardDetails card=carddetailsservice.getCardDetails(4);
		Date actual = card.getIssueDate();
		patientDetails = patientdetailsservice.getPatientDetails(4);
		assertEquals(issuedate,actual);
	}

	
}
