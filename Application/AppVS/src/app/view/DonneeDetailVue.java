package app.view;

import app.controller.AppController;
import app.model.data.*;
import app.view.table.*;
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
    private Label nomCommune, nomDepartementLabel, numeroLabel, prixm2Label, prixMoyenLabel, surfaceMoyenneLabel, nbMaisonLabel, nbAppartLabel, inflationLabel;
    private AeroportTable aeroportTable;
    private GareTable gareTable;
    private VoisineTable voisineTable;
    private Commune commune;
    private Departement departement;
    private AnneeCommune anneeCommune;
    private Annee annee;

    public DonneeDetailVue(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_DONNEE_DETAIL_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre(true, true);
        initUIComponents();
    }

    public void init(AppController appController, Boolean isAdmin, String idCommune) {
        this.gareTable = new GareTable(this.commune.getListeGares(), appController, isAdmin);
        this.aeroportTable = new AeroportTable(this.departement.getListeAeroports(), appController, isAdmin);
        this.voisineTable = new VoisineTable(this.commune.getCommuneVoisine(), appController, idCommune);
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
        this.inflationLabel = new Label("Données");

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
        configurerLabel(this.nomCommune, 110, 430, "my-label-commune", root);
        configurerLabel(this.nomDepartementLabel, 110, 530, "my-label-commune", root);
        configurerLabel(this.numeroLabel, 110, 480, "my-label-commune", root);
        configurerLabel(this.prixm2Label, 570, 397, "my-label-commune-b", root);
        configurerLabel(this.prixMoyenLabel, 570, 462, "my-label-commune-b", root);
        configurerLabel(this.surfaceMoyenneLabel, 830, 462, "my-label-commune-b", root);
        configurerLabel(this.inflationLabel, 800, 397, "my-label-commune-b", root);
        configurerLabel(this.nbMaisonLabel, 1110, 462, "my-label-commune-b", root);
        configurerLabel(this.nbAppartLabel, 1110, 397, "my-label-commune-b", root);
        
        configurerTable(this.aeroportTable, 650, 250, "my-table", root, 482, 105);
        configurerTable(this.gareTable, 650, 120, "my-table", root, 482, 105);
        configurerTable(this.voisineTable, 680,533, "my-table", root, 492, 150);

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

    private void configurerTable(VoisineTable t, int x, int y, String style, Pane root, int width, int height) {
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

    public String getComboBoxValue() {
        return this.anneeBox.getValue().toString();
    }

    public ComboBox<String> getComboBox() {
        return this.anneeBox;
    }

    public void setAnnee(String annee) {
        this.anneeBox.setValue(annee);
        
        this.inflationLabel.setText(this.anneeCommune.getAnnee().getTauxInflation());
    }

    public void setLaCommune(String idCommune, CommuneFileAccess communeFileAccess, DepartementFileAccess departementFileAccess) {
        //initialisation des variables de donnees
        this.commune = communeFileAccess.getCommuneById(idCommune);
        this.commune.setCommuneVoisine(communeFileAccess.getCommuneVoisine(idCommune));
        this.departement = departementFileAccess.getDepartementById(this.commune.getLeDepartement());
        this.aeroportTable = new AeroportTable(this.departement.getListeAeroports(), null, false);
        this.gareTable = new GareTable(this.commune.getListeGares(), null, false);
        this.voisineTable = new VoisineTable(this.commune.getCommuneVoisine(), null, idCommune);
        

        //mise a jour des donnees affichees
        this.nomCommune.setText(this.commune.getNomCommune());
        this.numeroLabel.setText(idCommune);
        this.nomDepartementLabel.setText(this.departement.getNomDep());
    }

    public void setLaCommune(String idCommune, CommuneFileAccess communeFileAccess, DepartementFileAccess departementFileAccess, String a, AnneeCommuneFileAccess anneeCommuneFileAccess, AnneeFileAccess anneeFileAccess) {
        //initialisation des variables de donnees
        if (a != null) {
            this.commune = communeFileAccess.getCommuneById(idCommune);
            this.commune.setCommuneVoisine(communeFileAccess.getCommuneVoisine(idCommune));
            this.departement = departementFileAccess.getDepartementById(this.commune.getLeDepartement());
            this.aeroportTable = new AeroportTable(this.departement.getListeAeroports(), null, false);
            this.gareTable = new GareTable(this.commune.getListeGares(), null, false);
            this.voisineTable = new VoisineTable(this.commune.getCommuneVoisine(), null, idCommune);
            this.annee = anneeFileAccess.getAnneeById(a);
            this.anneeCommune = anneeCommuneFileAccess.getAnneeCommuneById(a,idCommune);        
    
            //mise a jour des donnees affichees
            this.nomCommune.setText(this.commune.getNomCommune());
            this.numeroLabel.setText(idCommune);
            this.nomDepartementLabel.setText(this.departement.getNomDep());
            this.prixm2Label.setText(this.anneeCommune.getPrixM2Moyen());
            this.prixMoyenLabel.setText(this.anneeCommune.getPrixMoyen());
            this.surfaceMoyenneLabel.setText(this.anneeCommune.getSurfaceMoy());
            this.nbMaisonLabel.setText(this.anneeCommune.getNbMaison());
            this.nbAppartLabel.setText(this.anneeCommune.getNbAppart());
            this.inflationLabel.setText(this.anneeCommune.getAnnee().getTauxInflation());
            this.anneeBox.setValue(a);
        } else {
            this.commune = communeFileAccess.getCommuneById(idCommune);
            this.commune.setCommuneVoisine(communeFileAccess.getCommuneVoisine(idCommune));
            this.departement = departementFileAccess.getDepartementById(this.commune.getLeDepartement());
            this.aeroportTable = new AeroportTable(this.departement.getListeAeroports(), null, false);
            this.gareTable = new GareTable(this.commune.getListeGares(), null, false);
            this.voisineTable = new VoisineTable(this.commune.getCommuneVoisine(), null, idCommune);
            this.annee = anneeFileAccess.getAnneeById(a);
            this.anneeCommune = anneeCommuneFileAccess.getAnneeCommuneById(a,idCommune);        
    
            //mise a jour des donnees affichees
            this.nomCommune.setText(this.commune.getNomCommune());
            this.numeroLabel.setText(idCommune);
            this.nomDepartementLabel.setText(this.departement.getNomDep());
            this.anneeBox.setValue(a);
        }
    }

    public void resetValues() {
        this.nomCommune.setText("Données");
        this.numeroLabel.setText("Données");
        this.nomDepartementLabel.setText("Données");
        this.prixm2Label.setText("Données");
        this.prixMoyenLabel.setText("Données");
        this.surfaceMoyenneLabel.setText("Données");
        this.nbMaisonLabel.setText("Données");
        this.nbAppartLabel.setText("Données");
        this.inflationLabel.setText("Données");
    }

}
