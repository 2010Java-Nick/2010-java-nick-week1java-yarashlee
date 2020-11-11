package com.revature.util;

import java.sql.Connection;

import java.sql.DriverManager; // JDBC Java Data Base connectivity 
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoPostgres;
import com.revature.dao.CardDao;
import com.revature.dao.CardDaoPostgres;
import com.revature.dao.TransactionDao;
import com.revature.dao.TransactionDaoPostgres;

/**
 * 
 * Class used to retrieve DAO Implementations. Serves as a factory. Also manages a single instance of the database connection.
 * @author yarashlee
 *
 */

public class ConnectionUtil {
	
	private static Logger log = Logger.getRootLogger();
	
	private static final String CONNECTION_USERNAME = "postgres";
	private static final String CONNECTION_PASSWORD = "Raccoon69@";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres?";
	
	private static Connection conn; 
	
	public synchronized Connection getConnection() throws SQLException {
		if (conn == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				log.info("Could not register driver!");
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		//If connection was closed then retrieve a new connection
		if (conn.isClosed()){
			log.info("Opening new connection...");
			conn = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		return conn;
	}
	
}
