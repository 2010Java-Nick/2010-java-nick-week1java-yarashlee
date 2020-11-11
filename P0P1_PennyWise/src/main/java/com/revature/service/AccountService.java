package com.revature.service;

import java.util.List;

import org.eclipse.jetty.server.Authentication.User;

import com.revature.pojo.Account;
import com.revature.pojo.Card;



public interface AccountService {
	
	public Account signIn(String username, String password);

	public Account createAccount(Account account);

	public Account readAccount(int accountID);

	public List<Account> readAllAccount();

	public Account updateAccount(int accountID, Account account);

	public void deleteAccount(String username);
	

}
