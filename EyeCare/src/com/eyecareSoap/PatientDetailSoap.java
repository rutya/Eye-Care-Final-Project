package com.eyecareSoap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.serviceLayer.PatientDetailsService;
import com.model.PatientDetails;

/**
 * @author Administrator class PatientDetailSoap implements class
 *         PatientDetailsInterface as interface. this class used to create
 *         webservice for getting all patient details.
 *
 */
@WebService(name = "PatientDetailSoap", serviceName = "PatientDetailSoap", portName = "newPort", targetNamespace = "http://soap.com/")
public class PatientDetailSoap implements PatientDetailsInterface {

	@WebMethod(exclude = false, operationName = operationNameparam)
	/**
	 * @return allPatientDetails this method returns allPatientDetails list.
	 */
	public List<PatientDetails> getAllPatientDetails() {
		// TODO Auto-generated method stub

		PatientDetailsService patientdetailimpl = new PatientDetailsService();
		List<PatientDetails> allPatientDetails = patientdetailimpl.getAllPatientDetails();
		return allPatientDetails;
	}

}
