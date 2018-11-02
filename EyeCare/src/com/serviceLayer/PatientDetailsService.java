package com.serviceLayer;

import java.util.List;

import com.dao.PatientDetailsDao;
import com.dao.PatientDetailsDaoimpl;
import com.dao.PatientDetailsExistsException;
import com.model.PatientDetails;

/**
 * @author Administrator this class provides patient details from class
 *         patientdetaildDaoimpl
 */
public class PatientDetailsService {

	PatientDetailsDao patientdetailimpl = new PatientDetailsDaoimpl();

	/**
	 * calling getPatientDetails() from PatientDetailsDao
	 * 
	 * @param cardId
	 * @return patientDetails
	 */
	public PatientDetails getPatientDetails(int cardId) {

		PatientDetails patientDetails = patientdetailimpl.getPatientDetails(cardId);
		return patientDetails;
	}

	/**
	 * calling getAllPatientDetails() from PatientDetailsDao
	 * 
	 * @return allPatientDetails
	 */
	public List<PatientDetails> getAllPatientDetails() {

		List<PatientDetails> allPatientDetails = patientdetailimpl.getAllPatientDetails();
		return allPatientDetails;
	}

	/**
	 * calling addPatientDetails() from PatientDetailsDao
	 * 
	 * @param patient
	 * @throws PatientDetailsExistsException
	 */
	public void addPatientDetails(PatientDetails patient) throws PatientDetailsExistsException {

		patientdetailimpl.addPatientDetails(patient);

	}

	/**
	 * calling updatePatientDetails() from PatientDetailsDao
	 * 
	 * @param patient
	 */
	public void updatePatientDetails(PatientDetails patient) {

		patientdetailimpl.updatePatientDetails(patient);
	}

	/**
	 * calling deletePatientDetails() from PatientDetailsDao
	 * 
	 * @param patient
	 */
	public void deletePatientDetails(PatientDetails patient) {

		patientdetailimpl.deletePatientDetails(patient);
	}

}
