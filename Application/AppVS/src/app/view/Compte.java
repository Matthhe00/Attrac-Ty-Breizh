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
    private Button modificationButton, supprimerButton;
    private Label roleLabel, identLabel, passwordLabel, errorLabel;
    private TextField identField;
    private PasswordField passwordField;
    private NavBarre navBarre;

    public Compte(Stage primaryStage, String role, String ident, String password) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_COMPTE_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        this.navBarre = new NavBarre(false);

        initUIComponents(role, ident, password);
    }

    private void initUIComponents(String role, String ident, String password) {
        this.modificationButton = new Button("Modifier");
        this.supprimerButton = new Button("Supprimer");
        this.errorLabel = new Label();
        this.roleLabel = new Label(role);
        this.identLabel = new Label(ident);
        this.passwordLabel = new Label(password);
        this.identField = new TextField();
        this.passwordField = new PasswordField();
    }

    public Scene creerSceneCompte() {
        this.identField.clear();
        this.passwordField.clear();
        Pane root = creerRootCompte("role", "ident", "password", false);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle(Constants.APP_NAME);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        return scene;
    }

    public Pane creerRootCompte(String role, String ident, String password, boolean estConnecte) {
        this.identField.clear();
        this.passwordField.clear();
        this.navBarre = this.navBarre.refresh(estConnecte);
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        initUIComponents(role, ident, password);
        configurerComposants(root);
        return root;
    }

    private void configurerComposants(Pane root) {
        root.getChildren().add(this.navBarre);
        configurerBouton(this.supprimerButton, 800, 500, 260, 50, "my-button-nav-barre-deco", root);
        configurerLabel(this.errorLabel, 520, 330, 260, 45, "my-label-error", root);
        configurerBouton(this.modificationButton, 500, 500, 260, 50, "my-button", root);
        configurerLabel(this.roleLabel, 220, 555, 260, 45, "my-label", root);
        configurerLabel(this.identLabel, 220, 425, 260, 45, "my-label", root);
        configurerLabel(this.passwordLabel, 220, 490, 260, 45, "my-label", root);
        configurerTextField(this.identField, 730, 290, 260, 45, "Identifiant", "my-field-user-con", root);
        configurerTextField(this.passwordField, 730, 390, 260, 45, "Mot de passe", "my-field-user-con", root);
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
        return this.modificationButton;
    }

    public TextField getidentField() {
        return this.identField;
    }

    public PasswordField getPasswordField() {
        return this.passwordField;
    }

    public void updateNavBarre(boolean estConnecte) {
        this.navBarre.initNavBarre(estConnecte);
    }

    public NavBarre getNavBarre() {
        return this.navBarre;
    }

    public void setNavBarre(NavBarre navBarre) {
        this.navBarre = navBarre;
    }

    public void setErrorLabel(String error) {
        this.errorLabel.setText(error);
    }

    public Label getErrorLabel() {
        return this.errorLabel;
    }

    public void setRoleLabel(String role) {
        this.roleLabel.setText(role);
    }

    public void setIdentLabel(String ident) {
        this.identLabel.setText(ident);
    }

    public void setPasswordLabel(String password) {
        this.passwordLabel.setText(password);
    }

    public Button getSupprimerButton() {
        return this.supprimerButton;
    }

}
