package app.view; 
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resource.utils.Constants;


 public class DonneeDepartement {
    private Image icon, backgroundImage, finistereImage, morbihanImage, illeEtVilaineImage, coteDArmorImage, finistereImageHover, morbihanImageHover, illeEtVilaineImageHover, coteDArmorImageHover;
    private ImageView finistereImageView, morbihanImageView, illeEtVilainImageView, coteDArmorImageView, finistereImageHoverView, morbihanImageHoverView, illeEtVilaineImageHoverView, coteDArmorImageHoverView;
    private BackgroundImage background;
    private NavBarre navBarre;
    private Stage primaryStage;
    private Button finistere, morbihan, illeEtVilaine, coteDArmor;

    public DonneeDepartement(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_DONNEE_DEPARTEMENT_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre(true, true);
        initUIComponents();
    }

    public void initUIComponents() {
        this.finistereImage = new Image(Constants.FINISTERE_PATH);
        this.morbihanImage = new Image(Constants.MORBIHAN_PATH);
        this.illeEtVilaineImage = new Image(Constants.ILLE_ET_VILAINE_PATH);
        this.coteDArmorImage = new Image(Constants.COTE_D_ARMOR_PATH);
    
        this.finistereImageView = new ImageView(finistereImage);
        this.morbihanImageView = new ImageView(morbihanImage);
        this.illeEtVilainImageView = new ImageView(illeEtVilaineImage);
        this.coteDArmorImageView = new ImageView(coteDArmorImage);

        this.finistereImageHoverView = new ImageView(finistereImageHover);
        this.morbihanImageHoverView = new ImageView(morbihanImageHover);
        this.illeEtVilaineImageHoverView = new ImageView(illeEtVilaineImageHover);
        this.coteDArmorImageHoverView = new ImageView(coteDArmorImageHover);
    
        // Réduire la taille des images
        final double newWidth = 300; // Nouvelle largeur
        final double newHeight = 300; // Nouvelle hauteur
    
        this.finistereImageView.setFitWidth(newWidth);
        this.finistereImageView.setFitHeight(newHeight);
    
        this.morbihanImageView.setFitWidth(newWidth);
        this.morbihanImageView.setFitHeight(newHeight);
    
        this.illeEtVilainImageView.setFitWidth(newWidth);
        this.illeEtVilainImageView.setFitHeight(newHeight);
    
        this.coteDArmorImageView.setFitWidth(newWidth);
        this.coteDArmorImageView.setFitHeight(newHeight);

        this.finistereImageHoverView.setFitHeight(newHeight);
        this.finistereImageHoverView.setFitWidth(newWidth);

        this.morbihanImageHoverView.setFitHeight(newHeight);
        this.morbihanImageHoverView.setFitWidth(newWidth);
        
        this.illeEtVilaineImageHoverView.setFitHeight(newHeight);
        this.illeEtVilaineImageHoverView.setFitWidth(newWidth);

        this.coteDArmorImageHoverView.setFitHeight(newHeight);
        this.coteDArmorImageHoverView.setFitWidth(newWidth);
    
        this.finistere = new Button("");
        this.morbihan = new Button("");
        this.illeEtVilaine = new Button("");
        this.coteDArmor = new Button("");
    
        this.finistere.setGraphic(finistereImageView);
        this.illeEtVilaine.setGraphic(illeEtVilainImageView);
        this.morbihan.setGraphic(morbihanImageView);
        this.coteDArmor.setGraphic(coteDArmorImageView);
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
        configurerComposants(root);
        return root;
    }

    public void configurerComposants(Pane root) {
        root.getChildren().add(this.navBarre);
        configurerBouton(this.finistere, 15, 180 + 80, 60, 60, "my-button-dep-fini", root);
        // Côtes-d'Armor au nord
        configurerBouton(this.coteDArmor, 290, 80 + 80, 60, 60, "my-button-dep-cote", root);
        // Ille-et-Vilaine à l'est
        configurerBouton(this.illeEtVilaine, 540, 180 + 80, 60, 60, "my-button-dep-ille", root);
        // Morbihan au sud
        configurerBouton(this.morbihan, 290, 290 + 80, 60, 60, "my-button-dep-morb", root);
    }

    private void configurerBouton(Button bouton, int x, int y, int l, int h, String styleClass, Pane root) {
        bouton.setLayoutX(x);
        bouton.setLayoutY(y);

        bouton.setPrefHeight(h);
        bouton.getStyleClass().add(styleClass);
        root.getChildren().add(bouton);
    }

    public void updateNavBarre(boolean estConnecte) {
        this.navBarre.initNavBarre(estConnecte, true);
    }

    public NavBarre getNavBarre() {
        return this.navBarre;
    }

    public void setNavBarre(NavBarre navBarre) {
        this.navBarre = navBarre;
    }

    public Button getFinistere() {
        return this.finistere;
    }

    public Button getMorbihan() {
        return this.morbihan;
    }

    public Button getIlleEtVilaine() {
        return this.illeEtVilaine;
    }

    public Button getCoteDArmor() {
        return this.coteDArmor;
    }
}
