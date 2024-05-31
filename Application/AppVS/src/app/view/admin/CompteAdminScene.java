package app.view.admin;

import app.controller.AppController;
import app.model.data.UserFileAccess;
import app.view.NavBarre;
import javafx.geometry.Insets;
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
    private BorderPane borderPane;

    public CompteAdminScene(Stage primaryStage, AppController appController, UserFileAccess userFileAccess) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        this.navBarre = new NavBarre(false);
        this.compteAdminTable = new CompteAdminTable(userFileAccess, appController);
        this.borderPane = new BorderPane();

        initUIComponents();
    }

    private void initUIComponents() {
        BorderPane.setMargin(compteAdminTable, new Insets(50, 50, 50, 50));
        this.borderPane.setCenter(compteAdminTable);

    }


    public Scene creerSceneCompte() {
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
        Pane root = new Pane();
        root.getChildren().add(this.navBarre);
        root.setBackground(new Background(this.background));
        configurerComposants(root);
        return root;
    }

    private void configurerComposants(Pane root) {
        root.getChildren().add(this.compteAdminTable);
    }
    
}
