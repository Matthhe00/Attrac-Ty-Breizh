package app.model;

import resource.utils.Constants;
import java.sql.*;

/*
 * Creation de la base de donnees et des utilisateurs
 * 
 * CREATE USER communeB_User@localhost IDENTIFIED BY 'communeB_Password' ;
 * CREATE DATABASE bd_communeb;
 * GRANT ALL ON bd_communeb .* TO 'communeB_User'@'localhost' ;
 */

public class ConnexionDB {

	private Connection conn;

	private static ConnexionDB connDB;

	private ConnexionDB() {
		try {
			this.conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_LOGIN, Constants.DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR : app.model.ConnexionDB.ConnexionDB() => Database access impossible");
			System.out.println(e.getMessage());
		}
	}

	public static ConnexionDB getInstance() {
		if (connDB == null) 
			connDB = new ConnexionDB();
		return connDB;
	}

	public Connection getConnect() {
		return this.conn;
	}

}


