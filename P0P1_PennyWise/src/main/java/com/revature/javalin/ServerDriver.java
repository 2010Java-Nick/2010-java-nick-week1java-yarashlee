package com.revature.javalin;

import com.revature.Javaline.controller.AccountController;

import com.revature.Javaline.controller.CardController;
import com.revature.Javaline.controller.TransactionController;

import io.javalin.Javalin;

public class ServerDriver {
	
	private static AccountController acccountController = new AccountController();
	
	private static CardController cardController = new CardController();
	
	private static TransactionController transactionController = new TransactionController();
	
	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create().start(9906);
		
		app.get("/HelloYara", ctx -> ctx.html("Hello Yara!"));
		
		/*
		 * Sign in
		 */
		
		app.post("/signIn", ctx -> acccountController.signIn(ctx));

		/*
		 * CRUD for Account 
		 */
		app.post("/createAccount", ctx -> acccountController.createAccount(ctx));
		
		app.post("/readAccount", ctx -> acccountController.getAccount(ctx));
		
		app.get("/readAllAccounts", ctx -> acccountController.getAllAccounts(ctx));
				
		app.put("/updateAccount", ctx -> acccountController.updateAccount(ctx));
		
		app.post("/deleteAccount", ctx -> acccountController.deleteAccount(ctx));
		
		
		
		/*
		 * CRUD for Card
		 */
		
		app.post("/createCard", ctx -> cardController.createCard(ctx));
		
		app.post("/readCard", ctx -> cardController.getCard(ctx));
		
		app.get("/readAllCards", ctx -> cardController.getAllCards(ctx));
		
		app.put("/updateCard", ctx -> cardController.updateCard(ctx));
		
		app.post("/deleteCard", ctx -> cardController.deleteCard(ctx));
	
		
		/*
		 * CRUD for Transaction
		 */
		
		app.post("/createTransaction", ctx -> transactionController.createtransaction(ctx));
		
		app.post("/readTransaction", ctx -> transactionController.getTransaction(ctx));
		
		app.get("/readAllTransactions", ctx -> transactionController.getAllTransactions(ctx));
		
		
		
	}
}
