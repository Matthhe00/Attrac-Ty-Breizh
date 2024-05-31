package app.view.admin;

import app.controller.AppController;
import app.model.data.UserFileAccess;
import app.view.NavBarre;
import javafx.scene.Scene;
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
    

    public void init(Stage primaryStage, AppController appController, UserFileAccess userFileAccess) {
        this.compteAdminTable = new CompteAdminTable(userFileAccess, appController);
    }

    public CompteAdminScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        this.navBarre = new NavBarre(false);
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
        this.navBarre = this.navBarre.refresh(true);
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        configurerComposants(root);
        return root;
    }

    private void configurerComposants(Pane root) {
        root.getChildren().add(this.navBarre);
        configurerTable(compteAdminTable, 650, 175, "table-view", root);
    }

    private void configurerTable(CompteAdminTable t, int x, int y, String style, Pane root) {
        t.setLayoutX(x);
        t.setLayoutY(y);
        t.getStyleClass().add(style);
        root.getChildren().add(t);
    }

    public NavBarre getNavBarre() {
        return this.navBarre;
    }

    public void setNavBarre(NavBarre navBarre) {
        this.navBarre = navBarre;
    }
    
}
