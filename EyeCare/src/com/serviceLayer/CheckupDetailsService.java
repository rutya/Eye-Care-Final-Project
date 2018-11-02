package com.serviceLayer;

import java.util.List;

import com.dao.CheckupDetailsDao;
import com.dao.CheckupDetailsDaoimpl;
import com.dao.CheckupDetailsExistsException;
import com.model.CheckupDetails;

public class CheckupDetailsService {

	CheckupDetailsDao checkupdaoimpl = new CheckupDetailsDaoimpl();

	/**
	 * calling getCheckupDetails() from CheckupDetailsDao
	 * 
	 * @param cardId
	 * @return checkupDetails
	 */
	public CheckupDetails getCheckupDetails(int cardId) {
		CheckupDetails checkupDetails = checkupdaoimpl.getCheckupDetails(cardId);
		return checkupDetails;
	}

	/**
	 * calling from getAllCheckupDetails() CheckupDetailsDao
	 * 
	 * @return allCheckupDetails
	 */
	public List<CheckupDetails> getAllCheckupDetails() {
		List<CheckupDetails> allCheckupDetails = checkupdaoimpl.getAllCheckupDetails();
		return allCheckupDetails;
	}

	/**
	 * calling from addCheckupDetails()CheckupDetailsDao
	 * 
	 * @param checkupdetail
	 * @throws CheckupDetailsExistsException
	 */
	public void addCheckupDetails(CheckupDetails checkupdetail) throws CheckupDetailsExistsException {
		checkupdaoimpl.addCheckupDetails(checkupdetail);

	}

	/**
	 * calling updateEyeNo() from CheckupDetailsDao
	 * 
	 * @param checkupDetail
	 *            update lefteyeno and righteyeno
	 */
	//
	public void updateEyeNo(CheckupDetails checkupDetail) {
		checkupdaoimpl.updateEyeNo(checkupDetail);
	}

	/**
	 * calling updateGlassGrantedStatus() from CheckupDetailsDao
	 * 
	 * @param checkupDetail
	 */
	public void updateGlassGrantedStatus(CheckupDetails checkupDetail) {
		checkupdaoimpl.updateGlassGrantedStatus(checkupDetail);
	}

	/**
	 * calling updateSuggestedTreatmentfrom CheckupDetailsDao
	 * 
	 * @param checkupDetail
	 */
	public void updateSuggestedTreatment(CheckupDetails checkupDetail) {
		checkupdaoimpl.updateSuggestedTreatment(checkupDetail);
	}

	/**
	 * calling updateMainTreatment() from CheckupDetailsDao
	 * 
	 * @param checkupDetail
	 *            update maintreatmentname,operationdate,suggestedhospital
	 */
	//
	public void updateMainTreatment(CheckupDetails checkupDetail) {
		checkupdaoimpl.updateMainTreatment(checkupDetail);

	}

	/**
	 * calling deleteCheckupDetails() from CheckupDetailsDao
	 * 
	 * @param checkupdetail
	 */
	public void deleteCheckupDetails(CheckupDetails checkupdetail) {
		checkupdaoimpl.deleteCheckupDetails(checkupdetail);
	}

}
