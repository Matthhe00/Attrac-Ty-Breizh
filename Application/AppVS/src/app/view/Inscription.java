package app.view;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resource.utils.Constants;

public class Inscription {
    private Stage primaryStage;
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private Button inscriptionButton, connexionButton;
    private TextField indentField, passwordField;
    private Label errorLabel;

    public Inscription(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_INSCRIPTION_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        initUIComponents();
    }

    private void initUIComponents() {
        this.inscriptionButton = new Button("S'inscrire");
        this.connexionButton = new Button("Deja inscrit ? Connecte toi !");
        this.indentField = new TextField();
        this.passwordField = new PasswordField();
        this.errorLabel = new Label();
    }

    public Scene creerSceneInscription() {
        this.indentField.clear();
        this.passwordField.clear();
        Pane root = creerRootInscription();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle(Constants.APP_NAME);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        return scene;
    }

    public Pane creerRootInscription() {
        this.indentField.clear();
        this.passwordField.clear();
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        configurerComposants(root);
        return root;
    }

    private void configurerComposants(Pane root) {
        configurerBouton(inscriptionButton, 490, 480, 260, 50, "my-button", root);
        configurerBouton(connexionButton, 490, 225, 260, 10, "my-button-label", root);
        configurerLabel(errorLabel, 545, 437, 260, 45, "my-label-error", root);
        configurerTextField(indentField, 490, 300, 260, 45, "Identifiant", "my-field-user-con", root);
        configurerTextField(passwordField, 490, 395, 260, 45, "Mot de passe", "my-field-user-con", root);
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

    private void configurerLabel(Label label, int x, int y, int width, int height, String style, Pane root) {
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setPrefSize(width, height);
        label.getStyleClass().add(style);
        root.getChildren().add(label);
    }

    public Button getInscriptionButton() {
        return inscriptionButton;
    }

    public Button getConnexionButton() {
        return connexionButton;
    }

    public TextField getIndentField() {
        return indentField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(String error) {
        this.errorLabel.setText(error);
    }
}
