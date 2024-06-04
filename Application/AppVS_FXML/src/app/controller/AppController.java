package app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class AppController {

    private Stage stage;

    // Setter for the stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    private BorderPane mainPane; // Assurez-vous que votre scène actuelle utilise BorderPane comme racine

    @FXML
    public void openConnexionPage(ActionEvent event) {
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resource/Connexion.fxml"));
            Parent root = loader.load();
            scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openInscriptionPage(ActionEvent event) {
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resource/Inscription.fxml"));
            Parent root = loader.load();
            scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openAccueilConnecte(ActionEvent event) {
        
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resource/AccueilConnecte.fxml"));
            Parent root = loader.load();
            scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

