package app.view;

import java.util.ArrayList;

import app.controller.AppController;
import app.model.data.*;
import app.view.table.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resource.utils.Constants;

public class DonneeDepartementDetail {

    private Stage primaryStage;
    private Image icon, backgroundImage, depImage;
    private BackgroundImage background;
    private NavBarre navBarre;
    private Label nomDep, invesCulturel;
    private CommuneTable donneTable;
    

    public DonneeDepartementDetail(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre(true, true);
        initUIComponents();
    }

    public void init(Departement dep) {
        this.nomDep.setText(dep.getNomDep());
        this.invesCulturel.setText(dep.getInvesCulturel2019());

    }

    public void setCommuneTable(ArrayList<Commune> communes) {
        this.donneTable.setCommunes(communes);
    }

    public void initUIComponents() {
        this.nomDep = new Label();
        this.invesCulturel = new Label();
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

    public void init(AppController appController, CommuneFileAccess communeFileAccess, Boolean isAdmin) {
        this.donneTable = new CommuneTable(communeFileAccess, appController);
    }

    public void configurerComposants(Pane root) {
        root.getChildren().add(this.navBarre);
        configurerTable(this.donneTable, 595, 195, "my-table", root, 522, 430);

    }

    private void configurerTable(CommuneTable t, int x, int y, String style, Pane root, int width, int height) {
        t.setLayoutX(x);
        t.setLayoutY(y);
        t.setPrefWidth(width);
        t.setPrefHeight(height);
        t.getStyleClass().add(style);
        root.getChildren().add(t);
    }

    public NavBarre getNavBarre() {
        return this.navBarre;
    }

    public Label getNomDep() {
        return this.nomDep;
    }

    public Label getInvesCulturel() {
        return this.invesCulturel;
    }
}
