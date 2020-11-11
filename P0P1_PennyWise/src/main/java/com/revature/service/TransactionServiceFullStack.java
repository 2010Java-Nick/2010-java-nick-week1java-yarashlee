package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.TransactionDao;
import com.revature.dao.TransactionDaoPostgres;
import com.revature.pojo.Transaction;

public class TransactionServiceFullStack implements TransactionService {
	
	TransactionDao transactionDao = new TransactionDaoPostgres();
	
	private static Logger log = Logger.getRootLogger();	

	@Override
	public Transaction createTransaction(Transaction transaction) {
		log.info("Transaction Service --> create transaction");
		transactionDao.createTransaction(transaction);
		return transaction;
	}

	@Override
	public Transaction readTransaction(int transactionID) {
		log.info("Transaction Service --> read transaction");
		return transactionDao.readTransaction(transactionID);
	}

	@Override
	public List<Transaction> readAllTransactions() {
		log.info("Transaction Service --> read all transactions");
		return transactionDao.readAllTransactions();
	}

	@Override
	public Transaction updateTransaction(int transactionID, Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

}
