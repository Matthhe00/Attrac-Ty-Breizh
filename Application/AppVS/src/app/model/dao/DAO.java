package app.model.dao;

/*
 * Creation de la base de donnees et des utilisateurs
 * 
 * CREATE USER communeB_User@localhost IDENTIFIED BY 'communeB_Password';
 * CREATE DATABASE bd_communeb;
 * GRANT ALL ON bd_communeb .* TO 'communeB_User'@'localhost';
 * 
    DROP TABLE IF EXISTS User;
    CREATE TABLE User (
        id INT PRIMARY KEY AUTO_INCREMENT,
        login VARCHAR(255) NOT NULL UNIQUE,
        pwd VARCHAR(255) NOT NULL,
        role VARCHAR(255) NOT NULL
    );
    INSERT INTO User (login, pwd, role) VALUES ('admin', 'admin', 'admin'); 
 */

import resource.utils.Constants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe DAO pour la connexion a la base de donnees
 */
public abstract class DAO <T> {

    /**
     * Constructeur
     */
    public DAO () {
    }
    /**
     * Obtenir la connection
     * @return Connection
     * @throws SQLException Exception SQL
     */
    protected Connection getConnection () throws SQLException {
        // Charger la classe du pilote
    try {
        Class.forName(Constants.DB_DRIVER);
        return DriverManager.getConnection(Constants.DB_URL , Constants.DB_LOGIN , Constants.DB_PASSWORD);
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace ();
        return null;
    }
    // Obtenir la connection
    }

    // Les methodes abstraites pour la class User
    public abstract ArrayList <T> findAll ();
    public abstract int update(T element, String login, String role);
    public abstract int delete(T element, String login);
    public abstract int create(T element);
    public abstract T findByLoginPwd(String login , String pwd);
    

}


