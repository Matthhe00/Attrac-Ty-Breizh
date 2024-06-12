package app.view;
import javafx.stage.Stage;

import java.util.ArrayList;

import app.controller.AppController;
import app.model.data.Commune;
import app.model.data.CommuneFileAccess;
import app.view.table.CommuneTable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import resource.utils.*;;

public class Donnee extends Pane {
    private Image icon, backgroundImage;
    private BackgroundImage background;
    private NavBarre navBarre;
    private Stage primaryStage;
    private CheckBox tri1, tri2, tri3, tri4, tri5, tri6, tri7, tri8;
    private Label donneLabel, errorLabel;
    private TextField searchField, prixField;
    private CommuneTable donneTable;
    private Button exportDataButton;

    public Donnee(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.icon = new Image(Constants.ICON_PATH);
        this.backgroundImage = new Image(Constants.BACKGROUND_DONNEE_PATH);
        this.background = new BackgroundImage(this.backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, false, true));
        
        this.navBarre = new NavBarre(true, true);
        initUIComponents();
    }

    public void init(AppController appController, CommuneFileAccess communeFileAccess, Boolean isAdmin) {
        this.donneTable = new CommuneTable(communeFileAccess, appController);
    }

    public void setCommuneTable(ArrayList<Commune> communes) {
        this.donneTable.setCommunes(communes);
    }

    public void initUIComponents() {
        this.tri1 = new CheckBox("Ile et Vilaine");
        this.tri1.setId("35");

        this.tri2 = new CheckBox("Morbihan");
        this.tri2.setId("56");

        this.tri3 = new CheckBox("Finistère");
        this.tri3.setId("29");

        this.tri4 = new CheckBox("Côtes d'Armor");
        this.tri4.setId("22");

        this.tri5 = new CheckBox("Gare");
        this.tri5.setId("Gare");

        this.tri6 = new CheckBox("prix du m² < ");
        this.tri6.setId("prix");

        this.tri7 = new CheckBox("Tri 7");
        this.tri8 = new CheckBox("Tri 8");
        this.donneLabel = new Label("Communes");
        this.errorLabel = new Label("");
        this.exportDataButton = new Button("Exporter les données");
        this.searchField = new TextField();
        this.prixField = new TextField("0");
        this.searchField.setId("searchField");
        this.prixField.setId("prixField");
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

    private void configurerComposants(Pane root) {
        root.getChildren().add(this.navBarre);
        configurerLabel(this.donneLabel, 790, 135, 200, 50, "my-label-titre", root);
        configurerLabel(this.errorLabel, 150, 220, 200, 50, "my-label-error", root);
        configurerTextField(this.searchField, 135, 180, 350, 50, "Rechercher", "my-field-user-con", root);
        configurerTextField(this.prixField, 390, 395, 80, 20, "Prix", "my-field-user-con", root);
        configurerBouton(this.exportDataButton, 170, 550, "my-button", root);

        configurerTable(this.donneTable, 595, 195, "my-table", root, 522, 430);
        
        ArrayList<CheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(this.tri1);
        checkBoxes.add(this.tri2);
        checkBoxes.add(this.tri3);
        checkBoxes.add(this.tri4);
        checkBoxes.add(this.tri5);
        checkBoxes.add(this.tri6);
        checkBoxes.add(this.tri7);
        checkBoxes.add(this.tri8);
    
        // Groupe 1 : Les 4 premiers CheckBox
        for (CheckBox checkBox : checkBoxes) {
            checkBox.selectedProperty().addListener((obs, wasPreviouslySelected, isNowSelected) -> {
                if (isNowSelected) {
                    for (CheckBox otherCheckBox : checkBoxes) {
                        if (otherCheckBox != checkBox) {
                            otherCheckBox.setSelected(false);
                        }
                    }
                }
            });
        }
        
        int x = 30;
        int y = 300;
        // Positionnement des CheckBox
        for (int i = 0; i < checkBoxes.size(); i++) {
            CheckBox checkBox = checkBoxes.get(i);
            if (i % 2 == 0) {
                x = 90;
            } else {
                x = 260;
            }
            configurerCheckBox(checkBox, x, y, 200, 50, "my-checkbox", root);
            if (i % 2 != 0) {
                y += 50;
            }
        }
    }

    private void configurerCheckBox(CheckBox checkBox, int x, int y, int width, int height, String styleClass, Pane root) {
        checkBox.setLayoutX(x);
        checkBox.setLayoutY(y);
        // checkBox.setPrefWidth(width);
        // checkBox.setPrefHeight(height);
        checkBox.getStyleClass().add(styleClass);
        root.getChildren().add(checkBox);
    }

    private void configurerBouton(Button bouton, int x, int y, String styleClass, Pane root) {
        bouton.setLayoutX(x);
        bouton.setLayoutY(y);
        bouton.getStyleClass().add(styleClass);
        root.getChildren().add(bouton);
    }

    private void configurerLabel(Label label, int x, int y, int width, int height, String style, Pane root) {
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setPrefSize(width, height);
        label.getStyleClass().add(style);
        root.getChildren().add(label);
    }

    private void configurerTextField(TextField champ, int x, int y, int largeur, int hauteur, String promptText, String styleClass, Pane root) {
        champ.setLayoutX(x);
        champ.setLayoutY(y);
        champ.setPrefWidth(largeur);
        champ.setPrefHeight(hauteur);
        champ.setPromptText(promptText);
        champ.getStyleClass().add(styleClass);
        root.getChildren().add(champ);
    }

    private void configurerTable(CommuneTable t, int x, int y, String style, Pane root, int width, int height) {
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

    public CheckBox getTri1() {
        return this.tri1;
    }

    public CheckBox getTri2() {
        return this.tri2;
    }

    public CheckBox getTri3() {
        return this.tri3;
    }

    public CheckBox getTri4() {
        return this.tri4;
    }

    public CheckBox getTri5() {
        return this.tri5;
    }

    public CheckBox getTri6() {
        return this.tri6;
    }

    public CheckBox getTri7() {
        return this.tri7;
    }

    public CheckBox getTri8() {
        return this.tri8;
    }

    public Label getDonneLabel() {
        return this.donneLabel;
    }

    public Label getErrorLabel() {
        return this.errorLabel;
    }

    public TextField getSearchField() {
        return this.searchField;
    }

    public Button getExportDataButton() {
        return this.exportDataButton;
    }

    public TextField getPrixField() {
        return this.prixField;
    }

}
