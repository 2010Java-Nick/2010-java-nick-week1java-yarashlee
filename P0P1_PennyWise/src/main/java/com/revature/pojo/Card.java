package com.revature.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;




public class Card {

	private static int cardCount;
	private int cardID;
	private int accountID;
	private String cardType;
	private String cardholderName;
	private String cardNumber;
	private String cvcCode;
	private String expirationDate;

	

	

	public Card(int accountID, String cardType, String cardholderName, String cardNumber, String cvcCode,
			String expirationDate, int cardID) {
		super();
		Card.cardCount++;
		this.cardID = Card.cardCount;
		this.accountID = accountID;
		this.cardType = cardType;
		this.cardholderName = cardholderName;
		this.cardNumber = cardNumber;
		this.cvcCode = cvcCode;
		this.expirationDate = expirationDate;
	}



	public Card() {
		this(0, "", "", "", "", "", 0);
	}



	/**
	 * @return the cardCount
	 */
	public static int getCardCount() {
		return cardCount;
	}



	/**
	 * @param cardCount the cardCount to set
	 */
	public static void setCardCount(int cardCount) {
		Card.cardCount = cardCount;
	}



	/**
	 * @return the cardID
	 */
	public int getCardID() {
		return cardID;
	}



	/**
	 * @param cardID the cardID to set
	 */
	public void setCardID(int cardID) {
		this.cardID = cardID;
	}



	/**
	 * @return the accountID
	 */
	public int getAccountID() {
		return accountID;
	}



	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}



	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}



	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}



	/**
	 * @return the cardholderName
	 */
	public String getCardholderName() {
		return cardholderName;
	}



	/**
	 * @param cardholderName the cardholderName to set
	 */
	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}



	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}



	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}



	/**
	 * @return the cvcCode
	 */
	public String getCvcCode() {
		return cvcCode;
	}



	/**
	 * @param cvcCode the cvcCode to set
	 */
	public void setCvcCode(String cvcCode) {
		this.cvcCode = cvcCode;
	}



	/**
	 * @return the expirationDate
	 */
	public String getExpirationDate() {
		return expirationDate;
	}



	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}



	@Override
	public String toString() {
		return "Card [cardID=" + cardID + ", accountID=" + accountID + ", cardType=" + cardType + ", cardholderName="
				+ cardholderName + ", cardNumber=" + cardNumber + ", cvcCode=" + cvcCode + ", expirationDate="
				+ expirationDate + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		result = prime * result + cardID;
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((cardholderName == null) ? 0 : cardholderName.hashCode());
		result = prime * result + ((cvcCode == null) ? 0 : cvcCode.hashCode());
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (accountID != other.accountID)
			return false;
		if (cardID != other.cardID)
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (cardholderName == null) {
			if (other.cardholderName != null)
				return false;
		} else if (!cardholderName.equals(other.cardholderName))
			return false;
		if (cvcCode == null) {
			if (other.cvcCode != null)
				return false;
		} else if (!cvcCode.equals(other.cvcCode))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		return true;
	}



}
