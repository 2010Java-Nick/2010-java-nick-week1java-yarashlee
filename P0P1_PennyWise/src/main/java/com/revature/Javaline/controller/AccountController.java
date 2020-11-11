package com.revature.Javaline.controller;

import org.apache.log4j.Logger;

import com.revature.pojo.Account;
import com.revature.service.AccountService;
import com.revature.service.AccountServiceFullStack;

import io.javalin.http.Context;

public class AccountController {

	AccountService accountService = new AccountServiceFullStack();
	
	private static Logger log = Logger.getRootLogger();
	
	public void signIn(Context ctx) {
		
		log.info("Controller --> sign in account");
		
		String username = ctx.formParam("username");

		String password = ctx.formParam("password");

		ctx.html(accountService.signIn(username, password).toString());


	}
	
	public void createAccount(Context ctx) {
		
		log.info("Controller --> create account");

		String firstName = ctx.formParam("firstName");

		String lastName = ctx.formParam("lastName");

		String phoneNumber = ctx.formParam("phoneNumber");

		String email = ctx.formParam("email");

		String username = ctx.formParam("username");

		String password = ctx.formParam("password");

		Account account = new Account(username, password, email, phoneNumber, firstName, lastName);

		accountService.createAccount(account);

		ctx.html(Integer.toString(account.getAccountID()));

	}

	public void getAccount(Context ctx) {
		
		log.info("Controller --> read an account");
		
		int accountID = Integer.parseInt(ctx.formParam("accountID"));
		
		ctx.html(accountService.readAccount(accountID).toString());
		
	}

	public void getAllAccounts(Context ctx) {
		
		log.info("Controller --> read all accounts");
		
		ctx.html(accountService.readAllAccount().toString());
			
	}

	public void updateAccount(Context ctx) {
		
		log.info("Controller -->  update account");

		System.out.println("Responding update account request");
		
		int accountID = Integer.parseInt(ctx.formParam("accountID"));

		String firstName = ctx.formParam("firstName");

		String lastName = ctx.formParam("lastName");

		String phoneNumber = ctx.formParam("phoneNumber");

		String email = ctx.formParam("email");

		String username = ctx.formParam("username");

		String password = ctx.formParam("password");

		Account account = new Account(username, password, email, phoneNumber, firstName, lastName);
		
		accountService.updateAccount(accountID, account);
		
		ctx.html(Integer.toString(account.getAccountID()));

	}
	
	public void deleteAccount(Context ctx) {
		
		log.info("Controller --> delete account");		
		
		String username = ctx.formParam("username");
		
		accountService.deleteAccount(username);
		
		
	}

}
