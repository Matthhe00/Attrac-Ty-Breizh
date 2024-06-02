package app.view.admin;

import app.controller.AppController;
import app.model.data.*;
import app.view.NavBarre;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resource.utils.Constants;

public class CompteAdminScene extends Pane {

    private Stage primaryStage;
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private NavBarre navBarre;
    private CompteAdminTable compteAdminTable;
    private Button ajouterButton;
    private TextField loginField, passwordField;

    public void init(Stage primaryStage, AppController appController, UserFileAccess userFileAccess) {

        this.compteAdminTable = new CompteAdminTable(userFileAccess, appController);
    }

    public void initUIComponents() {
        this.ajouterButton = new Button("Ajouter");
        this.loginField = new TextField();
        this.passwordField = new TextField();
    }

    public CompteAdminScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_COMPTE_ADMIN_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        this.navBarre = new NavBarre(true);
        initUIComponents();
    }

    public Scene creerSceneCompte() {
        Pane root = creerRootCompte();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../../resource/app.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle(Constants.APP_NAME);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        return scene;
    }

    public Pane creerRootCompte() {
        this.loginField.clear();
        this.passwordField.clear();
        this.navBarre = this.navBarre.refresh(true);
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        configurerComposants(root);
        return root;
    }

    private void configurerComposants(Pane root) {
        root.getChildren().add(this.navBarre);
        configurerTable(compteAdminTable, 650, 195, "table-view", root);
        configurerBouton(ajouterButton, 250, 450, 100, 30, "my-button", root);
        configurerTextField(loginField, 175, 305, 260, 45, "Identifiant", "my-field-user-con", root);
        configurerTextField(passwordField, 175, 380, 260, 45, "Mot de passe", "my-field-user-con", root);
    }

    private void configurerTable(CompteAdminTable t, int x, int y, String style, Pane root) {
        t.setLayoutX(x);
        t.setLayoutY(y);
        t.getStyleClass().add(style);
        root.getChildren().add(t);
    }

    private void configurerBouton(Button button, int x, int y, int width, int height, String styleClass, Pane root) {
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefWidth(width);
        button.setPrefHeight(height);
        button.getStyleClass().add(styleClass);
        root.getChildren().add(button);
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

    public NavBarre getNavBarre() {
        return this.navBarre;
    }

    public void setNavBarre(NavBarre navBarre) {
        this.navBarre = navBarre;
    }

    public Button getAjouterButton() {
        return this.ajouterButton;
    }

    public TextField getLoginField() {
        return this.loginField;
    }

    public TextField getPasswordField() {
        return this.passwordField;
    }
}
