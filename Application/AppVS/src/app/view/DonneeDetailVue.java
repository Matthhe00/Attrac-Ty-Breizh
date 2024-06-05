package app.view;

import app.controller.AppController;
import app.model.data.*;
import app.view.table.AeroportTable;
import app.view.table.GareTable;
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
    private AeroportTable aeroportTable, voisineTable;
    private GareTable gareTable;
    private Commune commune;
    private Departement departement;

    public DonneeDetailVue(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_DONNEE_DETAIL_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre(true, true);
        initUIComponents();
    }

    public void init(AppController appController, AeroportFileAccess AeroportFileAccess, Boolean isAdmin, String idCommune) {
        this.gareTable = new GareTable(this.commune.getListeGares(), appController, isAdmin);
        this.aeroportTable = new AeroportTable(this.departement.getListeAeroports(), appController, isAdmin);
    }

    public void initUIComponents() {
        this.anneeBox = new ComboBox<>();
        this.anneeBox.getItems().addAll("2018", "2019", "2020", "2021");
        this.nomCommune = new Label("Données");
        this.nomDepartementLabel = new Label("Données");
        this.numeroLabel = new Label("Données");
        this.prixm2Label = new Label("Données");
        this.prixMoyenLabel = new Label("Données");
        this.surfaceMoyenneLabel = new Label("Données");
        this.nbMaisonLabel = new Label("Données");
        this.nbAppartLabel = new Label("Données");

        this.commune = new Commune("idCommune", "nomCommune", "leDepartement");
        this.departement = new Departement("idDepartement", "nomDepartement", "100");
        
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
        configurerLabel(this.nomCommune, 150, 430, "my-label-commune", root);
        configurerLabel(this.nomDepartementLabel, 150, 530, "my-label-commune", root);
        configurerLabel(this.numeroLabel, 150, 480, "my-label-commune", root);
        configurerTable(this.aeroportTable, 650, 270, "my-table", root, 482, 105);
        configurerTable(this.gareTable, 650, 400, "my-table", root, 482, 105);
        configurerComboBox(this.anneeBox, 365, 140, 135, 45, "my-combo-box", root);
    }
    
    private void configurerComboBox(ComboBox<String> anneeBox, int x, int y, int width, int height, String styleClass, Pane root) {
        anneeBox.setLayoutX(x);
        anneeBox.setLayoutY(y);
        anneeBox.setPrefWidth(width);
        anneeBox.setPrefHeight(height);
        anneeBox.getStyleClass().add(styleClass);
        root.getChildren().add(anneeBox);
    }

    private void configurerLabel(Label label, int x, int y, String style, Pane root) {
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.getStyleClass().add(style);
        root.getChildren().add(label);
    }

    private void configurerTable(AeroportTable t, int x, int y, String style, Pane root, int width, int height) {
        t.setLayoutX(x);
        t.setLayoutY(y);
        t.setPrefWidth(width);
        t.setPrefHeight(height);
        t.getStyleClass().add(style);
        root.getChildren().add(t);
    }

    private void configurerTable(GareTable t, int x, int y, String style, Pane root, int width, int height) {
        t.setLayoutX(x);
        t.setLayoutY(y);
        t.setPrefWidth(width);
        t.setPrefHeight(height);
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

    public void setLeDepartement(Departement departement) {
        this.departement = departement;
    }

    public void setLaCommune(String idCommune, CommuneFileAccess communeFileAccess, DepartementFileAccess departementFileAccess) {
        //initialisation des variables de donnees
        this.commune = communeFileAccess.getCommuneById(idCommune);
        this.departement = departementFileAccess.getDepartementById(this.commune.getLeDepartement());
        this.aeroportTable = new AeroportTable(this.departement.getListeAeroports(), null, false);
        this.gareTable = new GareTable(this.commune.getListeGares(), null, false);

        //mise a jour des donnees affichees
        this.nomCommune.setText(this.commune.getNomCommune());
        this.numeroLabel.setText(idCommune);
        this.nomDepartementLabel.setText(this.departement.getNomDep());
    }
}
