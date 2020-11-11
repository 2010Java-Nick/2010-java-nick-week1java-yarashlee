package com.revature.Javaline.controller;

import org.apache.log4j.Logger;

import com.revature.pojo.Transaction;
import com.revature.service.TransactionService;
import com.revature.service.TransactionServiceFullStack;

import io.javalin.http.Context;

public class TransactionController {

	TransactionService transactionService = new TransactionServiceFullStack();
	
	private static Logger log = Logger.getRootLogger();

	public void createtransaction(Context ctx) {

		log.info("Controller --> create transaction");

		Integer cardID = Integer.parseInt(ctx.formParam("cardID"));

		String transactionType = ctx.formParam("transactionType");

		String nameMoneySentTo = ctx.formParam("nameMoneySentTo");

		String transactionTime = ctx.formParam("transactionTime");

		String phoneNumber = ctx.formParam("phoneNumber");

		Double withdraws = Double.parseDouble(ctx.formParam("withdraws"));

		Transaction transaction = new Transaction(cardID, transactionType, nameMoneySentTo, transactionTime,
				phoneNumber, withdraws);

		transactionService.createTransaction(transaction);

		ctx.html(Integer.toString(transaction.getTransactionID()));

	}

	public void getTransaction(Context ctx) {
		
		log.info("Controller --> read a transaction");
		
		int transactionID = Integer.parseInt(ctx.formParam("transactionID"));

		ctx.html(transactionService.readTransaction(transactionID).toString());

	}

	public void getAllTransactions(Context ctx) {
		
		log.info("Controller --> read all transaction");


		ctx.html(transactionService.readAllTransactions().toString());

	}

	public void updateTransaction(Context ctx) {

	}

	public void deteleTransactions(Context ctx) {

	}
}
