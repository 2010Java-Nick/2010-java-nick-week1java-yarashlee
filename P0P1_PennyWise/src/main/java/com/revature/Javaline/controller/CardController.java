package com.revature.Javaline.controller;

import java.util.Date;

import org.apache.log4j.Logger;

import com.revature.pojo.Account;
import com.revature.pojo.Card;
import com.revature.service.CardService;
import com.revature.service.CardServiceFullStack;

import io.javalin.http.Context;

public class CardController {

	CardService cardService = new CardServiceFullStack();
	
	private static Logger log = Logger.getRootLogger();

	public void createCard(Context ctx) {

		log.info("Controller --> creat card");

		Integer accountID = Integer.parseInt(ctx.formParam("accountID"));

		String cardType = ctx.formParam("cardType");

		String cardHolderName = ctx.formParam("cardHolderName");

		String cardNumber = ctx.formParam("cardNumber");

		String cvcCode = ctx.formParam("cvcCode");

		String expirationDate = ctx.formParam("expirationDate");
		
		int cardID = Integer.parseInt(ctx.formParam("cardID"));

		Card card = new Card(accountID, cardType, cardHolderName, cardNumber, cvcCode, expirationDate, cardID);

		cardService.createCard(card);

		ctx.html(Integer.toString(card.getCardID()));

	}

	public void getCard(Context ctx) {
		
		log.info("Controller --> read card");

		int cardID = Integer.parseInt(ctx.formParam("cardID"));

		ctx.html(cardService.readCard(cardID).toString());
	}

	public void getAllCards(Context ctx) {
		
		log.info("Controller --> read all cards");

		ctx.html(cardService.readAllCards().toString());

	}
	

	public void updateCard(Context ctx) {

		log.info("Controller --> update card");

		Integer accountID = Integer.parseInt(ctx.formParam("accountID"));

		String cardType = ctx.formParam("cardType");

		String cardHolderName = ctx.formParam("cardHolderName");

		String cardNumber = ctx.formParam("cardNumber");

		String cvcCode = ctx.formParam("cvcCode");

		String expirationDate = ctx.formParam("expirationDate");
		
		Integer cardID = Integer.parseInt(ctx.formParam("cardID"));

		Card card = new Card(accountID, cardType, cardHolderName, cardNumber, cvcCode, expirationDate, cardID);

		cardService.updateCard(cardID, card);

		ctx.html(Integer.toString(card.getCardID()));

	}
	
	public void deleteCard(Context ctx) {
		
		log.info("Controller --> delete card");

		String cardNumber = ctx.formParam("cardNumber");
		
		cardService.deleteCard(cardNumber);
	}
}
