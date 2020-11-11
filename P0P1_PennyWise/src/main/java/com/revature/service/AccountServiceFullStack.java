package com.revature.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Authentication.User;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoPostgres;
import com.revature.pojo.Account;
import com.revature.pojo.Card;

public class AccountServiceFullStack implements AccountService {

	AccountDao accountDao = new AccountDaoPostgres();

	private PreparedStatement stmt;

	private static Logger log = Logger.getRootLogger();

	@Override
	public Account signIn(String username, String password) {
		log.info("Account Service --> Sign In Authentication");
		return accountDao.signIn(username, password);
	}

	@Override
	public Account createAccount(Account account) {
		log.info("Account Service --> create account");
		accountDao.createAccount(account);
		return account;
	}

	@Override
	public Account readAccount(int accountID) {
		log.info("Account Service --> read account");
		return accountDao.readAccount(accountID);
	}

	@Override
	public List<Account> readAllAccount() {
		log.info("Account Service --> read all accounts");
		return accountDao.readAllAccount();
	}

	@Override
	public Account updateAccount(int accountID, Account account) {
		log.info("Account Service --> update account");
		accountDao.updateAccount(accountID, account);
		return account;
	}

	@Override
	public void deleteAccount(String username) {
		log.info("Account Service --> delete account");
		accountDao.deleteAccount(username);
	}

}