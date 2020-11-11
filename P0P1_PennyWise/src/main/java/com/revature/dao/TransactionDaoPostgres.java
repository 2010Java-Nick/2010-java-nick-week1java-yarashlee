package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.pojo.Card;
import com.revature.pojo.Transaction;
import com.revature.util.ConnectionUtil;

public class TransactionDaoPostgres implements TransactionDao {

	private PreparedStatement stmt;
	
	private static Logger log = Logger.getRootLogger();

	private ConnectionUtil connUtil = new ConnectionUtil();

	public void setConnUtil(ConnectionUtil connUtil) {

	}

	@Override
	public void createTransaction(Transaction transaction) {

		String sql = "insert into transaction(card_id, transaction_type, name_money_reciever, transaction_time_stamp, phone_number, withdraws)"
				+ "values(?, ?, ?, ?, ?, ?);";

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, transaction.getCardID());
			stmt.setString(2, transaction.getTransactionType());
			stmt.setString(3, transaction.getNameMoneySentTo());
			stmt.setDate(4, Date.valueOf(transaction.getTransactionDate()));
			stmt.setString(5, transaction.getPhoneNumber());
			stmt.setDouble(6, transaction.getWithdraws());

			stmt.executeUpdate();
			
			log.info("Controller create transaction");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Transaction readTransaction(int transactionID) {
		String sql = "select * from transaction where transaction_id = " + transactionID;

		Transaction transaction = new Transaction();

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			log.info("Controller read transaction by transactionID = " + transactionID);

			while (rs.next()) {

				transactionID = rs.getInt("transaction_id");
				int cardID = rs.getInt("card_id");
				String transactionType = rs.getString("transaction_type");
				String nameMoneySentTo = rs.getString("name_money_reciever");
				String transactionDate = rs.getString("transaction_time_stamp");
				String phoneNumber = rs.getString("phone_number");
				int withdraws = rs.getInt("withdraws");
				
				transaction.setTransactionID(transactionID);
				transaction.setNameMoneySentTo(nameMoneySentTo);
				transaction.setTransactionDate(transactionDate);
				transaction.setPhoneNumber(phoneNumber);
				transaction.setWithdraws(withdraws);

				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transaction;
	}

	@Override
	public List<Transaction> readAllTransactions() {
		
		List<Transaction> transactionList = new ArrayList();
		
		String sql = "select * from transaction";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			log.info("Controller read all transactions");

			while (rs.next()) {
				
				Transaction transaction = new Transaction();
				

				int cardID = rs.getInt("card_id");
				int transactionID = rs.getInt("transaction_id");
				String transactionType = rs.getString("transaction_type");
				String nameMoneySentTo = rs.getString("name_money_reciever");
				String transactionDate = rs.getString("transaction_time_stamp");
				String phoneNumber = rs.getString("phone_number");
				int withdraws = rs.getInt("withdraws");
				
				transaction.setTransactionID(transactionID);
				transaction.setNameMoneySentTo(nameMoneySentTo);
				transaction.setTransactionDate(transactionDate);
				transaction.setPhoneNumber(phoneNumber);
				transaction.setWithdraws(withdraws);

				transactionList.add(transaction);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactionList;
	}

	@Override
	public Transaction updateTransaction(int TransactionID, Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTransaction(Transaction transaction) {
		// TODO Auto-generated method stub

	}

}
