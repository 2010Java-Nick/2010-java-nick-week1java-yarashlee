package com.revature.dao;

import java.sql.Connection;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Authentication.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoPostgres implements AccountDao {

	private PreparedStatement stmt;

	private static Logger log = Logger.getRootLogger();

	private ConnectionUtil connUtil = new ConnectionUtil();

	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public Account signIn(String username, String password) {
		int rows = 0;

		String sql = "select * from account where username = ? and password = ? ;";

		Account account = new Account();

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, (username));
			stmt.setString(2, (password));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				int accountID = rs.getInt("account_id");
				username = rs.getString("username");
				password = rs.getString("password");
				String email = rs.getString("email");
				String phoneNumber =rs.getString("phone_number");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				
	
				account.setAccountID(accountID);
				account.setUsername(username);
				account.setPassword(password);
				account.setEmail(email);
				account.setPhoneNumber(phoneNumber);
				account.setFirstName(firstName);
				account.setLastName(lastName);
				
	
				rows++;
			}
			if (rows == 0) {
				System.out.println("No found user with those credentials");
				log.info(" Controller failed to authenticate " + username);
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return account;
	}

	@Override
	public void createAccount(Account account) {

		String sql = "insert into account(username, password, email, phone_number, first_name, last_name)"
				+ "values(?, ?, ?, ?, ?, ?);";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, account.getUsername());
			stmt.setString(2, account.getPassword());
			stmt.setString(3, account.getEmail());
			stmt.setString(4, account.getPhoneNumber());
			stmt.setString(5, account.getFirstName());
			stmt.setString(6, account.getLastName());

			stmt.executeUpdate();

			log.info("Controller creating account");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Account readAccount(int accountID) {

		String sql = "select * from account where account_id = " + accountID;

		Account account = new Account();

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read account by accountID = " + accountID);

			while (rs.next()) {
				
				accountID = rs.getInt("account_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phone_number");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

				account.setAccountID(accountID);
				account.setUsername(username);
				account.setPassword(password);
				account.setEmail(email);
				account.setPhoneNumber(phoneNumber);
				account.setFirstName(firstName);
				account.setLastName(lastName);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;

	}

	@Override
	public List<Account> readAllAccount() {

		List<Account> accountList = new ArrayList();

		String sql = "select * from account";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller reading all accounts");

			while (rs.next()) {

				Account account = new Account();

				int accountID = rs.getInt("account_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phone_number");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

				account.setAccountID(accountID);
				account.setUsername(username);
				account.setPassword(password);
				account.setEmail(email);
				account.setPhoneNumber(phoneNumber);
				account.setFirstName(firstName);
				account.setLastName(lastName);

				accountList.add(account);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountList;
	}

	@Override
	public int updateAccount(int accountID, Account account) {

		String sql = "update account " + "set username = ?, password = ?, email = ?, "
				+ "phone_number = ?, first_name = ?, last_name= ?" + "where account_id = ?";
		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, account.getUsername());
			stmt.setString(2, account.getPassword());
			stmt.setString(3, account.getEmail());
			stmt.setString(4, account.getPhoneNumber());
			stmt.setString(5, account.getFirstName());
			stmt.setString(6, account.getLastName());
			stmt.setInt(7, accountID);

			rows = stmt.executeUpdate();

			log.info("Controller updating account by accountID = " + accountID);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int deleteAccount(String username) {

		String sql = "delete from account where username = ?";
		int rowsToDelete = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);

			rowsToDelete = stmt.executeUpdate();

			log.info("Controller deleting account by username = " + username);

			if (rowsToDelete == 0) {
				System.out.println("No rows to delete.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsToDelete;

	}

}
