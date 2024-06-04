package app.view.table;

import app.controller.AppController;
import app.model.data.Aeroport;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import app.model.data.*;


public class AeroportTable extends TableView<Aeroport> {
    private AppController controller; // Reference to the controller for event handling
    private AeroportFileAccess AeroportFileAccess;
        
    
    public AeroportTable(AeroportFileAccess AeroportFileAccess, AppController controller, Boolean isAdmin) {
        this.controller = controller;
        this.AeroportFileAccess = AeroportFileAccess;
        ObservableList<Aeroport> data = FXCollections.observableArrayList(AeroportFileAccess.getAeroports());
        this.setEditable(true);
        this.getSelectionModel().setCellSelectionEnabled(true);
        this.getStylesheets().add(getClass().getResource("../../../resource/app.css").toExternalForm());


        // Creating columns
        TableColumn<Aeroport, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nomCol.setEditable(false);
        nomCol.setMinWidth(130);

        TableColumn<Aeroport, String> adresseCol = new TableColumn<>("Adresse");
        adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        adresseCol.setCellFactory(TextFieldTableCell.forTableColumn());
        adresseCol.setEditable(false);

        adresseCol.setMinWidth(130);
        
        TableColumn<Aeroport, String> departCol = new TableColumn<>("Code Departement");
        departCol.setCellValueFactory(new PropertyValueFactory<>("leDepartement"));
        departCol.setCellFactory(TextFieldTableCell.forTableColumn());
        departCol.setEditable(false);
        departCol.setMinWidth(130);

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
