package app.view.table;

import java.util.ArrayList;

import app.controller.AppController;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import app.model.data.*;


public class AeroportTable extends TableView<Aeroport> {
    
    public AeroportTable(ArrayList<Aeroport> aeroports, AppController controller, Boolean isAdmin) {
        ObservableList<Aeroport> data = FXCollections.observableArrayList(aeroports);
        this.setEditable(true);
        this.getSelectionModel().setCellSelectionEnabled(true);
        this.getStylesheets().add(getClass().getResource("../../../resource/app.css").toExternalForm());


        // Creating columns
        TableColumn<Aeroport, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nomCol.setEditable(false);
        nomCol.setMinWidth(180);

        TableColumn<Aeroport, String> adresseCol = new TableColumn<>("Adresse");
        adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        adresseCol.setCellFactory(TextFieldTableCell.forTableColumn());
        adresseCol.setEditable(false);
        adresseCol.setMinWidth(300);
        
        TableColumn<Aeroport, String> departCol = new TableColumn<>("Code Departement");
        departCol.setCellValueFactory(new PropertyValueFactory<>("leDepartement"));
        departCol.setCellFactory(TextFieldTableCell.forTableColumn());
        departCol.setEditable(true);
        departCol.setMinWidth(140);

        // Adding data to the table
        this.setItems(data);
        this.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        this.getColumns().add(nomCol);
        this.getColumns().add(adresseCol);

        if (isAdmin) {
            this.getColumns().add(departCol);
        }

        // Ajouter des classes CSS aux colonnes

        nomCol.getStyleClass().add("my-table-col");
        adresseCol.getStyleClass().add("my-table-col");
        departCol.getStyleClass().add("my-table-col");

        // Setting the size of the table
        this.setMaxSize(600, 800);
    }   
}
