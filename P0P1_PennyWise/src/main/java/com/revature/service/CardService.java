package com.revature.service;

import java.util.List;
import com.revature.pojo.Card;

public interface CardService {

	public Card createCard(Card card);

	public Card readCard(int cardID);

	public List<Card> readAllCards();

	public Card updateCard(int cardID, Card card);

	public void deleteCard(String cardNumber);
	
	
}
