package app.view;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import resource.utils.*;;

public class Accueil {
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private NavBarre navBarre;
    private Stage primaryStage;

    public Accueil(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_ACCUEIL_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre();
    }

    public Scene creerSceneAccueil() {
        Pane root = creerRootAccueil();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle(Constants.APP_NAME);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        return scene;
    }

    public Pane creerRootAccueil() {
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        configurerComposants(root);
        return root;
    }

    private void configurerComposants(Pane root) {
        root.getChildren().add(this.navBarre);
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
}
