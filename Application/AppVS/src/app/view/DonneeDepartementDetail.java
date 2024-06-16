package app.view;

import java.util.ArrayList;

import app.controller.AppController;
import app.model.data.*;
import app.view.table.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resource.utils.Constants;

public class DonneeDepartementDetail {

    private Stage primaryStage;
    private Image icon, backgroundImage, imageDep, image35, image22, image29, image56;
    private BackgroundImage background;
    private NavBarre navBarre;
    private Label nomDep, invesCulturel, nbCommune, nbGare, nbAeroport;
    private CommuneTable donneTable;
    private AeroportTable aeroportTable;
    private Departement departement;
    

    public DonneeDepartementDetail(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_DONNEE_DEPARTEMENT_DETAIL_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        this.image35 = new Image(Constants.ILLE_ET_VILAINE_PATH);
        this.image22 = new Image(Constants.COTE_D_ARMOR_PATH);
        this.image29 = new Image(Constants.FINISTERE_PATH);
        this.image56 = new Image(Constants.MORBIHAN_PATH);
        this.imageDep = new Image(Constants.FINISTERE_PATH);


        this.navBarre = new NavBarre(true, true);
        initUIComponents();
    }

    public void init(Departement dep, AeroportFileAccess aeroportFileAccess, AppController appController, Boolean isAdmin) {
        this.nomDep.setText(dep.getNomDep());
        this.invesCulturel.setText(dep.getInvesCulturel2019());
        this.aeroportTable = new AeroportTable(aeroportFileAccess.getAeroports(dep.getIdDep()), appController, isAdmin);
        if (dep.getIdDep().equals("35")) {
            this.imageDep = this.image35;
        } else if (dep.getIdDep().equals("22")) {
            this.imageDep = this.image22;
        } else if (dep.getIdDep().equals("29")) {
            this.imageDep = this.image29;;
        } else if (dep.getIdDep().equals("56")) {
            this.imageDep = this.image56;
        }
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
        configurerTable(this.donneTable, 630, 205, "my-table", root, 522, 180);
        configurerLabel(this.nomDep, 200, 150, "my-label-titre", root);
        configurerLabel(this.invesCulturel, 360, 505, "my-label-commune-bt", root);
        configurerLabel(this.nbCommune, 360, 575, "my-label-commune-bt", root);
        configurerTable(this.aeroportTable, 650, 485, "my-table", root, 482, 105);
        configurerImage(this.imageDep, 178, 205, 250, 250, root);

    }

    private void configurerImage(Image image, int x, int y, int width, int height, Pane root) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.getStyleClass().add("my-image");
        root.getChildren().add(imageView);
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
