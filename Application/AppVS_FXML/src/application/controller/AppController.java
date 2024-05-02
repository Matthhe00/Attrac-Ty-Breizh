package application.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class AppController {

    @FXML
    private BorderPane mainPane; // Assurez-vous que votre scène actuelle utilise BorderPane comme racine

    @FXML
    public void openConnexionPage(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Connexion.fxml"));
            Parent connexionView = (Parent) fxmlLoader.load();

            // Ajouter la vue de connexion à la scène actuelle
            mainPane.setCenter(connexionView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}