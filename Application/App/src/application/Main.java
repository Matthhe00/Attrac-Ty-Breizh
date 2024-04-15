package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    
        Image icon = new Image("Logo_SAE.png");
        Image backgroundImage = new Image("Accueil_BG.png");
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true));
        
        Pane root = new Pane();
        root.setBackground(new Background(background));

        // inscription
        Button inscriptionButton = new Button("Inscription");
        inscriptionButton.setLayoutX(830); // Position X
        inscriptionButton.setLayoutY(390); // Position Y
        inscriptionButton.setPrefWidth(260); // Largeur
        inscriptionButton.setPrefHeight(70); // Hauteur
        inscriptionButton.getStyleClass().add("my-button"); // Ajouter une classe CSS
        root.getChildren().add(inscriptionButton);

        Label inscriptionLabel = new Label("Vous n'avez pas de compte ?");
        inscriptionLabel.setLayoutX(800); // Position X
        inscriptionLabel.setLayoutY(320); // Position Y
        inscriptionLabel.getStyleClass().add("my-label-ins"); // Ajouter une classe CSS
        root.getChildren().add(inscriptionLabel);

        // connexion
        Button connexionButton = new Button("Connexion");
        connexionButton.setLayoutX(260); // Position X
        connexionButton.setLayoutY(520); // Position Y
        connexionButton.setPrefWidth(260); // Largeur
        connexionButton.setPrefHeight(40); // Hauteur
        connexionButton.getStyleClass().add("my-button"); // Ajouter une classe CSS
        root.getChildren().add(connexionButton);

        Label connexionLabel = new Label("Connectez-vous !");
        connexionLabel.setLayoutX(290); // Position X
        connexionLabel.setLayoutY(225); // Position Y
        connexionLabel.getStyleClass().add("my-label-con"); // Ajouter une classe CSS
        root.getChildren().add(connexionLabel);

                
        TextField usernameField = new TextField();
        usernameField.setLayoutX(260); // Position X
        usernameField.setLayoutY(300); // Position Y
        usernameField.setPrefWidth(260); // Largeur
        usernameField.setPrefHeight(40); // Hauteur
        usernameField.getStyleClass().add("my-field-user-con"); // Ajouter une classe CSS
        usernameField.setPromptText("Jean.Dubois@gmail.com"); // Texte de l'invite de commande
        root.getChildren().add(usernameField);
        
        Scene scene = new Scene(root, 1260, 700);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); // Ajouter le fichier CSS
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Attrac'Ty Breizh");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}