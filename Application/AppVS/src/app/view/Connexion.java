package app.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resource.utils.Constants;

public class Connexion {
    private Stage primaryStage;
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private Button inscriptionButton, connexionButton, motDePasseOublieButton;
    private Label inscriptionLabel, connexionLabel, emailLabel, passwordLabel;
    private TextField mailField;
    private PasswordField passwordField;

    public Connexion(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_CONNEXION_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        initUIComponents();
    }

    private void initUIComponents() {
        this.inscriptionButton = new Button("Inscription");
        this.connexionButton = new Button("Connexion");
        this.motDePasseOublieButton = new Button("Mot de passe oublié ?");
        this.inscriptionLabel = new Label("Vous n'avez pas de compte ?");
        this.connexionLabel = new Label("Connectez-vous !");
        this.emailLabel = new Label("Email :");
        this.mailField = new TextField();
        this.passwordLabel = new Label("Mot de passe :");
        this.passwordField = new PasswordField();
    }

    public Scene creerSceneConnexion() {
        Pane root = creerRootConnexion();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle(Constants.APP_NAME);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        return scene;
    }

    public Pane creerRootConnexion() {
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        
        configurerComposants(root);
        
        return root;
    }

    private void configurerComposants(Pane root) {
        configurerBouton(inscriptionButton, 830, 390, 260, 70, "my-button", root);
        configurerBouton(connexionButton, 260, 490, 260, 50, "my-button", root);
        configurerBouton(motDePasseOublieButton, 260, 445, 260, 30, "my-button-label", root);
        configurerLabel(inscriptionLabel, 800, 320, "my-label-ins", root);
        configurerLabel(connexionLabel, 290, 225, "my-label-con", root);
        configurerLabel(emailLabel, 260, 274, "my-label-user-con", root);
        configurerLabel(passwordLabel, 260, 364, "my-label-user-con", root);
        configurerTextField(mailField, 260, 300, 260, 45, "Jean.Dubois@gmail.com", "my-field-user-con", root);
        configurerTextField(passwordField, 260, 390, 260, 45, "Mot de passe", "my-field-user-con", root);
    }

    // Méthodes de configuration de composants
    private void configurerBouton(Button bouton, int x, int y, int largeur, int hauteur, String styleClass, Pane root) {
        bouton.setLayoutX(x);
        bouton.setLayoutY(y);
        bouton.setPrefWidth(largeur);
        bouton.setPrefHeight(hauteur);
        bouton.getStyleClass().add(styleClass);
        root.getChildren().add(bouton);
    }

    private void configurerLabel(Label label, int x, int y, String styleClass, Pane root) {
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.getStyleClass().add(styleClass);
        root.getChildren().add(label);
    }

    private void configurerTextField(TextField champ, int x, int y, int largeur, int hauteur, String promptText, String styleClass, Pane root) {
        champ.setLayoutX(x);
        champ.setLayoutY(y);
        champ.setPrefWidth(largeur);
        champ.setPrefHeight(hauteur);
        champ.setPromptText(promptText);
        champ.getStyleClass().add(styleClass);
        root.getChildren().add(champ);
    }

    public Button getConnexionButton() {
        return connexionButton;
    }

    public Button getInscriptionButton() {
        return inscriptionButton;
    }

    public Button getMotDePasseOublieButton() {
        return motDePasseOublieButton;
    }

}
