package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.pojo.Account;
import com.revature.pojo.Card;
import com.revature.util.ConnectionUtil;

public class CardDaoPostgres implements CardDao {

	private PreparedStatement stmt;
	
	private static Logger log = Logger.getRootLogger();

	private ConnectionUtil connUtil = new ConnectionUtil();

	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public void createCard(Card card) {

		String sql = "insert into card (account_id, card_type, card_holder_name, card_number, cvc_code, card_expiration_date)"
				+ "values(?, ?, ?, ?, ?, ?);";

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, card.getAccountID());
			stmt.setString(2, card.getCardType());
			stmt.setString(3, card.getCardholderName());
			stmt.setString(4, card.getCardNumber());
			stmt.setString(5, card.getCvcCode());
			stmt.setDate(6, Date.valueOf(card.getExpirationDate()));

			stmt.executeUpdate();
			
			log.info("Controller creating card");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Card readCard(int cardID) {
		String sql = "select * from card where card_id = " + cardID;

		Card card = new Card();

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);
			
			log.info("Controller read card by cardID = " + cardID);

			while (rs.next()) {

				cardID = rs.getInt("card_id");
				int accountID = rs.getInt("account_id");
				String cardType = rs.getString("card_type");
				String cardholderName = rs.getString("card_holder_name");
				String cardNumber = rs.getString("card_number");
				String cvcCode = rs.getString("cvc_code");
				String expirationDate = rs.getString("card_expiration_date");

				card.setCardID(cardID);
				card.setCardType(cardType);
				card.setCardholderName(cardholderName);
				card.setCardNumber(cardNumber);
				card.setCvcCode(cvcCode);
				card.setExpirationDate(expirationDate);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return card;
	}

	@Override
	public List<Card> readAllCards() {

		List<Card> cardList = new ArrayList();

		String sql = "select * from card";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			log.info("Controller read all cards");

			while (rs.next()) {

				Card card = new Card();
				
				int cardID = rs.getInt("card_id");
				int accountID = rs.getInt("account_id");
				String cardType = rs.getString("card_type");
				String cardholderName = rs.getString("card_holder_name");
				String cardNumber = rs.getString("card_number");
				String cvcCode = rs.getString("cvc_code");
				String expirationDate = rs.getString("card_expiration_date");

				card.setCardID(cardID);
				card.setCardType(cardType);
				card.setCardholderName(cardholderName);
				card.setCardNumber(cardNumber);
				card.setCvcCode(cvcCode);
				card.setExpirationDate(expirationDate);

				cardList.add(card);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cardList;
	}

	@Override
	public int updateCard(int cardID, Card card) {

		String sql = "update card "
				+ "set account_id = ?, card_type = ?, card_holder_name = ?, card_number = ?, cvc_code = ?, card_expiration_date = ?"
				+ "where card_id = ?";
		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, card.getAccountID());
			stmt.setString(2, card.getCardType());
			stmt.setString(3, card.getCardholderName());
			stmt.setString(4, card.getCardNumber());
			stmt.setString(5, card.getCvcCode());
			stmt.setDate(6, Date.valueOf(card.getExpirationDate()));
			stmt.setInt(7, cardID);

			rows = stmt.executeUpdate();
			
			log.info("Controller updating card by cardID = " + cardID);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int deleteCard(String cardNumber) {
		
		String sql = "delete from card where card_number = ?";
		
		int rowsToDelete = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, cardNumber);

			rowsToDelete = stmt.executeUpdate();
		
			log.info("Controller deleting card by card number = " + cardNumber);

			if (rowsToDelete == 0) {
				System.out.println("No rows to delete.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsToDelete;
				
	}

}
