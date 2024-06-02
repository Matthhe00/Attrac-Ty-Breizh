package app;

import app.controller.AppController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {

    /**
     * Méthode principale
     * @param args Arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Méthode de démarrage
     * @param primaryStage Scène principale
     * @throws Exception Exception
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/Inscription.fxml"));
            Parent root = loader.load();
            
            AppController controller = loader.getController();
            controller.setStage(primaryStage);
            
            primaryStage.setTitle("Attrac'Ty Breizh");
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
