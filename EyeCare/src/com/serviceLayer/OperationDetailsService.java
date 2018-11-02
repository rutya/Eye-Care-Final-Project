package com.serviceLayer;

import java.util.List;

import com.dao.OperationDetailDaoimpl;
import com.dao.OperationDetailsDao;
import com.model.OperationDetails;

/**
 * @author Administrator this class provides operation details that are
 *         available or not in the hospital.
 */
public class OperationDetailsService {
	OperationDetailsDao operationdetailsdao = new OperationDetailDaoimpl();

	/**
	 * calling getOperationalDetails()from OperationDetailsDao
	 * 
	 * @param operationName
	 * @return operationalDetails
	 */
	public List<OperationDetails> getOperationalDetails(String operationName) {
		List<OperationDetails> operationalDetails = operationdetailsdao.getOperationalDetails(operationName);
		return operationalDetails;
	}

	/**
	 * calling from getAllOpeartionDetails() OperationDetailsDao
	 * 
	 * @return allOpeartionDetails
	 */
	public List<OperationDetails> getAllOpeartionDetails() {
		List<OperationDetails> allOpeartionDetails = operationdetailsdao.getAllOpeartionDetails();
		return allOpeartionDetails;
	}

	/**
	 * calling addOperationDetails from OperationDetailsDao
	 * 
	 * @param operationDetails
	 */
	public void addOperationDetails(OperationDetails operationDetails) {
		operationdetailsdao.addOperationDetails(operationDetails);
	}

	/**
	 * calling updateOpeartionDetails from OperationDetailsDao
	 * 
	 * @param operationDetails
	 */
	public void updateOpeartionDetails(OperationDetails operationDetails) {

	}

	/**
	 * calling deleteOpeartionDetails()from OperationDetailsDao
	 * 
	 * @param opeartionDetails
	 */
	public void deleteOpeartionDetails(OperationDetails opeartionDetails) {
		operationdetailsdao.deleteOpeartionDetails(opeartionDetails);
	}

	/**
	 * calling CheckAvailabilityOfTreatment() from OperationDetailsDao
	 * 
	 * @param treatmentName
	 */
	public boolean CheckAvailabilityOfTreatment(String treatmentName) {
		OperationDetailsService operationdetailservice = new OperationDetailsService();
		List<OperationDetails> operationalDetails = operationdetailservice.getOperationalDetails(treatmentName);
		System.out.println("List\n" + operationalDetails);
		int flag = 0;
		for (OperationDetails operationdetails : operationalDetails) {
			if ((operationdetails.getHospitalName()).equals("Eye Care")) {
				flag = 1;

				break;
			} else {
				flag = 0;
			}

		}
		if (flag == 0) {

			return false;
		} else {

			return true;
		}
		// return null;
	}
}
