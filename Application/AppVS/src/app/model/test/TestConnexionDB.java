package app.model.test;

import app.model.ConnexionDB;
import java.sql.Connection;

public class TestConnexionDB {

    public static void main(String[] args) {
        // Utilisez la méthode getInstance pour obtenir une instance de ConnexionDB
        ConnexionDB ConnexionDB = app.model.ConnexionDB.getInstance();

        // Utilisez la méthode getConnect pour obtenir la connexion à la base de données
        Connection connection = ConnexionDB.getConnect();

        if (connection != null) {
            System.out.println("Connexion à la base de données établie");
        } else {
            System.out.println("Échec de la connexion à la base de données");
        }
    }
}
