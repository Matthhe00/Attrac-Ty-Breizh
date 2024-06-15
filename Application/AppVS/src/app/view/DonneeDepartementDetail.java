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
    private Label nomDep, invesCulturel, nbCommune, nbGare, nbAeroport;
    private CommuneTable donneTable;
    private AeroportTable aeroportTable;
    private Departement departement;
    

    public DonneeDepartementDetail(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre(true, true);
        initUIComponents();
    }

    public void init(Departement dep, AeroportFileAccess aeroportFileAccess, AppController appController, Boolean isAdmin) {
        this.nomDep.setText(dep.getNomDep());
        this.invesCulturel.setText(dep.getInvesCulturel2019());
        this.aeroportTable = new AeroportTable(aeroportFileAccess.getAeroports(dep.getIdDep()), appController, isAdmin);
    }

    public void setCommuneTable(ArrayList<Commune> communes) {
        this.donneTable.setCommunes(communes);
        this.nbCommune.setText(communes.size() + "");
    }

    public void initUIComponents() {
        this.nomDep = new Label();
        this.invesCulturel = new Label();
        this.nbCommune = new Label();
        this.nbGare = new Label();
        this.nbAeroport = new Label();
    }

    public Scene creerSceneDonnee() {
        Pane root = creerRootDonnee(false, false, null, null, null);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.getIcons().add(this.icon);
        this.primaryStage.setTitle(Constants.APP_NAME);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        return scene;
    }

    public Pane creerRootDonnee(boolean estConnecte, boolean estAdmin, Departement dep, AeroportFileAccess aeroportFile, AppController appcontroller) {
        this.navBarre = this.navBarre.refresh(estConnecte, estAdmin);
        this.departement = dep;
        init(dep, aeroportFile, appcontroller, estAdmin);
        Pane root = new Pane();
        root.setBackground(new Background(this.background));
        configurerComposants(root);
        return root;
    }

    public void init(AppController appController, CommuneFileAccess communeFileAccess, Boolean isAdmin, AeroportFileAccess aeroportFileAccess) {
        this.donneTable = new CommuneTable(communeFileAccess, appController);
        this.aeroportTable = new AeroportTable(aeroportFileAccess.getAeroports("35"), appController, isAdmin);

    }

    public void configurerComposants(Pane root) {
        root.getChildren().add(this.navBarre);
        configurerTable(this.donneTable, 630, 225, "my-table", root, 522, 180);
        configurerLabel(this.nomDep, 50, 150, "my-label", root);
        configurerLabel(this.invesCulturel, 50, 200, "my-label", root);
        configurerLabel(this.nbCommune, 50, 250, "my-label", root);
        configurerLabel(this.nbGare, 50, 300, "my-label", root);
        configurerLabel(this.nbAeroport, 50, 350, "my-label", root);
        configurerTable(this.aeroportTable, 650, 500, "my-table", root, 482, 105);

    }

    private void configurerTable(AeroportTable t, int x, int y, String style, Pane root, int width, int height) {
        t.setLayoutX(x);
        t.setLayoutY(y);
        t.setPrefWidth(width);
        t.setPrefHeight(height);
        t.getStyleClass().add(style);
        root.getChildren().add(t);
    }

    private void configurerLabel(Label label, int x, int y, String styleClass, Pane root) {
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.getStyleClass().add(styleClass);
        root.getChildren().add(label);
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
