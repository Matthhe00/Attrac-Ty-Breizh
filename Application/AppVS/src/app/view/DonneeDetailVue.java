package app.view;

import app.controller.AppController;
import app.model.data.*;
import app.view.table.AeroportTable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resource.utils.Constants;

public class DonneeDetailVue {
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private NavBarre navBarre;
    private Stage primaryStage;
    private ComboBox<String> anneeBox;
    private Label nomCommune, nomDepartementLabel, numeroLabel, prixm2Label, prixMoyenLabel, surfaceMoyenneLabel, nbMaisonLabel, nbAppartLabel;
    private AeroportTable gareTable, aeroporTable, voisineTable;
    private Commune commune;
    private Departement departement;

    public DonneeDetailVue(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_DONNEE_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre(true, true);
        initUIComponents();
    }

    public void init(AppController appController, AeroportFileAccess AeroportFileAccess, Boolean isAdmin) {
        // this.gareTable = new DonneTable(gareFileAccess, appController, isAdmin);
        this.aeroporTable = new AeroportTable(AeroportFileAccess, appController, isAdmin);
    }

    public void initUIComponents() {
        this.anneeBox = new ComboBox<>();
        this.anneeBox.getItems().addAll("2018", "2019", "2020", "2021");
        this.nomCommune = new Label("Données");
        
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
        this.navBarre = this.navBarre.refresh(estConnecte, estAdmin);
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        configurerComposants(root);
        return root;
    }

    private void configurerComposants(Pane root) {
        root.getChildren().add(this.navBarre);
        configurerLabel(this.nomCommune, 790, 135, 200, 50, "my-label-titre", root);
        configurerTable(this.aeroporTable, 575, 195, "my-table", root);
        configurerComboBox(this.anneeBox, 135, 250, 135, 45, "my-combo-box", root);
    }
    
    private void configurerComboBox(ComboBox<String> anneeBox, int x, int y, int width, int height, String styleClass, Pane root) {
        anneeBox.setLayoutX(x);
        anneeBox.setLayoutY(y);
        anneeBox.setPrefWidth(width);
        anneeBox.setPrefHeight(height);
        anneeBox.getStyleClass().add(styleClass);
        root.getChildren().add(anneeBox);
    }

    private void configurerLabel(Label label, int x, int y, int width, int height, String style, Pane root) {
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setPrefSize(width, height);
        label.getStyleClass().add(style);
        root.getChildren().add(label);
    }

    private void configurerTable(AeroportTable t, int x, int y, String style, Pane root) {
        t.setLayoutX(x);
        t.setLayoutY(y);
        t.getStyleClass().add(style);
        root.getChildren().add(t);
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
}
