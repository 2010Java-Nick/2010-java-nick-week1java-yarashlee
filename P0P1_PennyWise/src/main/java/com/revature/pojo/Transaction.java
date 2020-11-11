package com.revature.pojo;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Transaction {


	private static int transactionCount;
	private int transactionID;
	private int cardID;
	private String transactionType;
	private String nameMoneySentTo;
	private String transactionDate;	
	private String phoneNumber;
	private double withdraws;
	
	
	

	public Transaction(int cardID, String transactionType, String nameMoneySentTo, String transactionDate,
			String phoneNumber, double withdraws) {
		super();
		Transaction.transactionCount++;
		this.transactionID = Transaction.transactionCount;
		this.cardID = cardID;
		this.transactionType = transactionType;
		this.nameMoneySentTo = nameMoneySentTo;
		this.transactionDate = transactionDate;
		this.phoneNumber = phoneNumber;
		this.withdraws = withdraws;
	}


	public Transaction() {
		this(0, "", "", "", "", 0.0);
	}


	/**
	 * @return the transactionCount
	 */
	public static int getTransactionCount() {
		return transactionCount;
	}


	/**
	 * @param transactionCount the transactionCount to set
	 */
	public static void setTransactionCount(int transactionCount) {
		Transaction.transactionCount = transactionCount;
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
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}


	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	/**
	 * @return the nameMoneySentTo
	 */
	public String getNameMoneySentTo() {
		return nameMoneySentTo;
	}


	/**
	 * @param nameMoneySentTo the nameMoneySentTo to set
	 */
	public void setNameMoneySentTo(String nameMoneySentTo) {
		this.nameMoneySentTo = nameMoneySentTo;
	}


	/**
	 * @return the transactionDate
	 */
	public String getTransactionDate() {
		return transactionDate;
	}


	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}


	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	/**
	 * @return the withdraws
	 */
	public double getWithdraws() {
		return withdraws;
	}


	/**
	 * @param withdraws the withdraws to set
	 */
	public void setWithdraws(double withdraws) {
		this.withdraws = withdraws;
	}


	/**
	 * @return the transactionID
	 */
	public int getTransactionID() {
		return transactionID;
	}

	

	/**
	 * @param transactionID the transactionID to set
	 */
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}


	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", cardID=" + cardID + ", transactionType="
				+ transactionType + ", nameMoneySentTo=" + nameMoneySentTo + ", transactionDate=" + transactionDate
				+ ", phoneNumber=" + phoneNumber + ", withdraws=" + withdraws + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cardID;
		result = prime * result + ((nameMoneySentTo == null) ? 0 : nameMoneySentTo.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + transactionID;
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(withdraws);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Transaction other = (Transaction) obj;
		if (cardID != other.cardID)
			return false;
		if (nameMoneySentTo == null) {
			if (other.nameMoneySentTo != null)
				return false;
		} else if (!nameMoneySentTo.equals(other.nameMoneySentTo))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionID != other.transactionID)
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		if (Double.doubleToLongBits(withdraws) != Double.doubleToLongBits(other.withdraws))
			return false;
		return true;
	}


	
}
