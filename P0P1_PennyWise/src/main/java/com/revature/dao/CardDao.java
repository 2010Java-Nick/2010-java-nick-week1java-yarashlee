package com.revature.dao;

import java.util.List;

import com.revature.pojo.Account;
import com.revature.pojo.Card;

public interface CardDao {
	
	public void createCard(Card card);

	public Card readCard(int cardID);

	public List<Card> readAllCards();

	public int updateCard(int cardID, Card card);

	public int deleteCard(String cardNumber);

}
