package application.view;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Inscription {
    private Stage primaryStage;
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private Button inscriptionButton, connexionButton;
    private TextField mailField, passwordField;

    public Inscription(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image("application/resource/image/Logo_SAE.png");
        this.backgroundImage = new Image("application/resource/image/BackgroundInscription.png");
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        initUIComponents();
    }

    private void initUIComponents() {
        this.inscriptionButton = new Button("S'inscrire");
        this.connexionButton = new Button("Deja inscrit ? Connecte toi !");
        this.mailField = new TextField();
        this.passwordField = new PasswordField();
    }

    public Scene creerSceneInscription() {
        Pane root = creerRootInscription();
        Scene scene = new Scene(root, 1260, 700);
        scene.getStylesheets().add(getClass().getResource("../resource/application.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle("Attrac'Ty Breizh");
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        return scene;
    }

    public Pane creerRootInscription() {
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        
        configurerComposants(root);
        
        return root;
    }

    private void configurerComposants(Pane root) {
        configurerBouton(inscriptionButton, 490, 480, 260, 50, "my-button", root);
        configurerBouton(connexionButton, 490, 225, 260, 10, "my-button-label", root);
        configurerTextField(mailField, 490, 300, 260, 45, "Jean.Dubois@gmail.com", "my-field-user-con", root);
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

    public Button getInscriptionButton() {
        return inscriptionButton;
    }

    public Button getConnexionButton() {
        return connexionButton;
    }

    public TextField getMailField() {
        return mailField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }
}
