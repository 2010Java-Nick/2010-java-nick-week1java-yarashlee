package com.revature.dao;

import java.util.List;

import com.revature.pojo.Transaction;

public interface TransactionDao {
	
	public void createTransaction(Transaction transaction);
	
	public Transaction readTransaction(int transactionID);
	
	public List<Transaction> readAllTransactions();
	
	public Transaction updateTransaction(int transactionID, Transaction transaction);
	
	public void deleteTransaction(Transaction transaction);

}
