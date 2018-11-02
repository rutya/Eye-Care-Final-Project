package com.eyecareSoap;

import java.util.List;

import com.model.PatientDetails;

/**
 * @author Administrator This class provides interface to class
 *         PatientDetailSoap. function getAllPatientDetails gives list of all
 *         the patients registered in the hospital.
 */
public interface PatientDetailsInterface {

	String operationNameparam = "getAllPatientDetails";

	public List<PatientDetails> getAllPatientDetails();

}
