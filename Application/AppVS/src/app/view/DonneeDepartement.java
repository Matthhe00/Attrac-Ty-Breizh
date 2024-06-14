package app.view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import resource.utils.Constants;

public class DonneeDepartement {
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private NavBarre navBarre;
    private Stage primaryStage;

    public DonneeDepartement(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_DONNEE_DEPARTEMENT_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre(true, true);
        // initUIComponents();
    }
    

    public Scene creerSceneDonnee() {
        Pane root = creerRootDonnee(false, false);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle(Constants.APP_NAME);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        return scene;
    }

    public Pane creerRootDonnee(boolean estConnecte, boolean estAdmin) {
        this.navBarre = this.navBarre.refresh(estConnecte, false);
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        // configurerComposants(root);
        return root;
    }

}
