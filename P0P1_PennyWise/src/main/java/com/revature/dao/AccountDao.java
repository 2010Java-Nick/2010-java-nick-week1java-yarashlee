package com.revature.dao;

import java.util.List;


import com.revature.pojo.Account;

public interface AccountDao {
	
	public Account signIn(String username, String password);

	public void createAccount(Account account);

	public Account readAccount(int accountID);

	public List<Account> readAllAccount();

	public int updateAccount(int accountID, Account account);

	public int deleteAccount(String username);

}
