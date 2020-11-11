package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.CardDao;
import com.revature.dao.CardDaoPostgres;
import com.revature.pojo.Card;

public class CardServiceFullStack implements CardService {
	
	CardDao cardDao = new CardDaoPostgres();
	
	private static Logger log = Logger.getRootLogger();

	@Override
	public Card createCard(Card card) {
		log.info("Card Service --> create card");
		cardDao.createCard(card);
		return card;
	}

	@Override
	public Card readCard(int cardID) {
		log.info("Card Service --> read card");
		return cardDao.readCard(cardID);
	}

	@Override
	public List<Card> readAllCards() {
		log.info("Card Service --> read all cards");
		return cardDao.readAllCards();
	}

	@Override
	public Card updateCard(int cardID, Card card) {
		log.info("Card Service --> update card");
		cardDao.updateCard(cardID, card);
		return card;
	}

	@Override
	public void deleteCard(String cardNumber) {
		log.info("Card Service --> delete card");
		cardDao.deleteCard(cardNumber);
	}


	
}
