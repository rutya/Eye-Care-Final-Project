package com.serviceLayer;

import java.util.List;

import com.dao.AppointmentDetailsDao;
import com.dao.AppointmentDetailsDaoimpl;
import com.dao.AppointmentDetailsExistsException;
import com.model.AppointmentDetails;

/**
 * @author Administrator this class provides appointmentdetails of patient.
 */

public class AppointmentDetailsService {

	AppointmentDetailsDao appointmentdetailsimpl = new AppointmentDetailsDaoimpl();

	/**
	 * calling getAppointmentDetails() from AppointmentDao
	 * 
	 * @param cardId
	 * @return appointmentDetails
	 */
	public AppointmentDetails getAppointmentDetails(int cardId) {

		AppointmentDetails appointmentDetails = appointmentdetailsimpl.getAppointmentDetails(cardId);
		return appointmentDetails;
	}

	/**
	 * calling getAllAppointmentDetails() from AppointmentDao
	 * 
	 * @return allAppointmentDetails
	 */
	public List<AppointmentDetails> getAllAppointmentDetails() {
		List<AppointmentDetails> allAppointmentDetails = appointmentdetailsimpl.getAllAppointmentDetails();
		return allAppointmentDetails;
	}

	/**
	 * calling addAppointmentDetail() from AppointmentDao
	 * 
	 * @param appointmentDetails
	 * @throws AppointmentDetailsExistsException
	 */
	public void addAppointmentDetail(AppointmentDetails appointmentDetails) throws AppointmentDetailsExistsException {
		appointmentdetailsimpl.addAppointmentDetail(appointmentDetails);

	}

	/**
	 * calling updateAppointmentDetails() from AppointmentDao
	 * 
	 * @param appointmentDetails
	 */
	public void updateAppointmentDetails(AppointmentDetails appointmentDetails) {
		appointmentdetailsimpl.updateAppointmentDetails(appointmentDetails);
	}

	/**
	 * calling deleteAppointmentDetails() from AppointmentDao
	 * 
	 * @param appointmentDetails
	 */
	public void deleteAppointmentDetails(AppointmentDetails appointmentDetails) {
		appointmentdetailsimpl.deleteAppointmentDetails(appointmentDetails);
	}

}
