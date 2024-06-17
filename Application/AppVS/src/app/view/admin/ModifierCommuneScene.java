package app.view.admin;

import app.view.NavBarre;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resource.utils.Constants;

public class ModifierCommuneScene {
    private Stage primaryStage;
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private NavBarre navBarre;
    // private Bouton newGare, newAnnee, 
    
    public ModifierCommuneScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_CONNEXION_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre();
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
        this.navBarre = this.navBarre.refresh(true, true);
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        // configurerComposants(root);
        return root;
    }

    public void updateNavBarre(boolean estConnecte) {
        this.navBarre.initNavBarre(estConnecte, false);
    }

    public NavBarre getNavBarre() {
        return this.navBarre;
    }

    public void setNavBarre(NavBarre navBarre) {
        this.navBarre = navBarre;
    }
}
