package com.serviceLayer;

import java.util.List;

import com.dao.CardDetailsDao;
import com.dao.CardDetailsDaoimpl;
import com.dao.CardDetailsExistsException;

import com.model.CardDetails;

/**
 * 
 * @author Administrator this class provides carddetails function from
 *         carddetailsDaoimpl class
 */
public class CardDetailsService {

	CardDetailsDao carddetailimpl = new CardDetailsDaoimpl();

	/**
	 * calling getCardDetails() from CardDetailDao
	 * 
	 * @param cardId
	 * @return cardDetails
	 */
	public CardDetails getCardDetails(int cardId) {

		CardDetails cardDetails = carddetailimpl.getCardDetails(cardId);
		return cardDetails;
	}

	/**
	 * calling getAllCardDetails() from CardDetailDao
	 * 
	 * @return
	 */
	public List<CardDetails> getAllCardDetails() {
		List<CardDetails> allCardDetails = carddetailimpl.getAllCardDetails();
		return allCardDetails;
	}

	/**
	 * calling addCardDetail() from CardDetailDao
	 * 
	 * @param cardDetails
	 * @throws CardDetailsExistsException
	 */
	public void addCardDetail(CardDetails cardDetails) throws CardDetailsExistsException {

		carddetailimpl.addCardDetail(cardDetails);
	}

	/**
	 * calling updateCardDetails() from CardDetailDao
	 * 
	 * @param cardDetails
	 */
	public void updateCardDetails(CardDetails cardDetails) {

		carddetailimpl.updateCardDetails(cardDetails);
	}

	/**
	 * calling deleteCardDetails() from CardDetailDao
	 * 
	 * @param cardDetails
	 */
	public void deleteCardDetails(CardDetails cardDetails) {

		carddetailimpl.deleteCardDetails(cardDetails);
	}

}
