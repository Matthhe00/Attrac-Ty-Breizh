package app.view.table;

import java.util.ArrayList;

import app.controller.AppController;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import app.model.data.*;

public class GareTable extends TableView<Gare> {
    private AppController controller; // Reference to the controller for event handling
    private GareFileAccess gareFileAccess;
        
    
    public GareTable(ArrayList<Gare> gares, AppController controller, Boolean isAdmin) {
        this.controller = controller;
        ObservableList<Gare> data = FXCollections.observableArrayList(gares);
        this.setEditable(true);
        this.getSelectionModel().setCellSelectionEnabled(true);
        this.getStylesheets().add(getClass().getResource("../../../resource/app.css").toExternalForm());


        // Creating columns
        TableColumn<Gare, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nomGare"));
        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nomCol.setEditable(false);
        nomCol.setMinWidth(200);

        TableColumn<Gare, String> adresseCol = new TableColumn<>("Gare Marchandise");
        adresseCol.setCellValueFactory(new PropertyValueFactory<>("estFret"));
        adresseCol.setCellFactory(TextFieldTableCell.forTableColumn());
        adresseCol.setEditable(true);
        adresseCol.setMinWidth(140);
        
        TableColumn<Gare, String> departCol = new TableColumn<>("Gare Voyageur");
        departCol.setCellValueFactory(new PropertyValueFactory<>("estVoyageur"));
        departCol.setCellFactory(TextFieldTableCell.forTableColumn());
        departCol.setEditable(true);
        departCol.setMinWidth(140);

        // Adding data to the table
        this.setItems(data);
        this.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        this.getColumns().add(nomCol);
        this.getColumns().add(adresseCol);
        this.getColumns().add(departCol);


        // Ajouter des classes CSS aux colonnes

        nomCol.getStyleClass().add("my-table-col");
        adresseCol.getStyleClass().add("my-table-col");
        departCol.getStyleClass().add("my-table-col");

        // Setting the size of the table
        this.setMaxSize(600, 800);
    }
}
