package com.core.dBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbConnectionApplication {

	public static void main(String[] args) {
		System.out.println("Check");
		SpringApplication.run(DbConnectionApplication.class, args);
		
		Connection con = getConnection();
		logger.info(con);
		closeConnection(con);
	}

	static Logger logger = Logger.getLogger(DbConnectionApplication.class);
	static ResourceBundle mybundle = ResourceBundle.getBundle("MyProperties");
	
	
	public static Connection getConnection() {
    	Connection con = null;
    	try {
    		
    		logger.info("Connection Details:::"+mybundle.getString("db.drivername"));
    		logger.info("Connection connection URL:::"+mybundle.getString("db.connectionURL"));
    		logger.info("Connection username:::"+mybundle.getString("db.username"));
    		logger.info("Connection password:::"+mybundle.getString("db.password"));
    		Class.forName(mybundle.getString("db.drivername"));    		  
    		con = DriverManager.getConnection(	mybundle.getString("db.connectionURL"),
    											mybundle.getString("db.username"),
    											mybundle.getString("db.password"));  
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return con;
    }
	
	public static void closeConnection(Connection con) {
    	try {
    		if(con != null ) {
    			con.close();
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
