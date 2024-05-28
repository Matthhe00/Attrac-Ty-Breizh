package app.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resource.utils.Constants;

public class Compte {
    
    private Stage primaryStage;
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private Button modificationButton, deconnexionButton;
    private Label roleLabel, identLabel, passwordLabel;
    private TextField mailField;
    private PasswordField passwordField;
    private NavBarre navBarre;

    public Compte(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_COMPTE_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        this.navBarre = new NavBarre(true);

        initUIComponents();
    }

    private void initUIComponents() {
        this.modificationButton = new Button("Modifier");
        this.deconnexionButton = new Button("Deconnexion");
        this.roleLabel = new Label("Role : ");
        this.identLabel = new Label("Identifiant : ");
        this.passwordLabel = new Label("Mot de passe : ");
        this.mailField = new TextField();
        this.passwordField = new PasswordField();
    }

    public Scene creerSceneCompte() {
        this.mailField.clear();
        this.passwordField.clear();
        Pane root = creerRootCompte();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle(Constants.APP_NAME);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        return scene;
    }

    public Pane creerRootCompte() {
        this.mailField.clear();
        this.passwordField.clear();
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        configurerComposants(root);
        return root;
    }

    private void configurerComposants(Pane root) {
        root.getChildren().add(this.navBarre);
        configurerBouton(modificationButton, 490, 480, 260, 50, "my-button", root);
        configurerBouton(deconnexionButton, 490, 225, 260, 10, "my-button-label", root);
        configurerLabel(roleLabel, 490, 100, 260, 45, "my-label", root);
        configurerLabel(identLabel, 490, 300, 260, 45, "my-label", root);
        configurerLabel(passwordLabel, 490, 395, 260, 45, "my-label", root);
        configurerTextField(mailField, 490, 300, 260, 45, "Identifiant", "my-field-user-con", root);
        configurerTextField(passwordField, 490, 395, 260, 45, "Mot de passe", "my-field-user-con", root);
    }

    private void configurerBouton(Button button, int x, int y, int width, int height, String style, Pane root) {
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefSize(width, height);
        button.getStyleClass().add(style);
        root.getChildren().add(button);
    }

    private void configurerLabel(Label label, int x, int y, int width, int height, String style, Pane root) {
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setPrefSize(width, height);
        label.getStyleClass().add(style);
        root.getChildren().add(label);
    }

    private void configurerTextField(TextField field, int x, int y, int width, int height, String prompt, String style, Pane root) {
        field.setLayoutX(x);
        field.setLayoutY(y);
        field.setPrefSize(width, height);
        field.setPromptText(prompt);
        field.getStyleClass().add(style);
        root.getChildren().add(field);
    }

    public Button getModificationButton() {
        return modificationButton;
    }

    public Button getDeconnexionButton() {
        return deconnexionButton;
    }

    public TextField getMailField() {
        return mailField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

}
