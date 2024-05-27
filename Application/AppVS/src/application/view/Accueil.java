package application.view;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Accueil {
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private NavBarre navBarre;
    private Stage primaryStage;

    public Accueil(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image("application/resource/image/Logo_SAE.png");
        this.backgroundImage = new Image("application/resource/image/BackgroundAccueil.png");
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre();
    }

    public Scene creerSceneAccueil() {
        Pane root = creerRootAccueil();
        Scene scene = new Scene(root, 1260, 700);
        scene.getStylesheets().add(getClass().getResource("resource/application.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle("Attrac'Ty Breizh");
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
}
