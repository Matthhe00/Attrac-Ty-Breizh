package app.view.table;

import java.util.ArrayList;

import app.controller.AppController;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import app.model.data.*;

public class CommuneTable extends TableView<Commune> {
    private AppController controller; // Reference to the controller for event handling
    private CommuneFileAccess CommuneFileAccess;

    public CommuneTable(CommuneFileAccess communeFileAccess, AppController controller) {
        this.controller = controller;
        this.CommuneFileAccess = communeFileAccess;
        ObservableList<Commune> data = FXCollections.observableArrayList(CommuneFileAccess.getCommunes());
        this.setEditable(true);
        this.getSelectionModel().setCellSelectionEnabled(true);
        this.getStylesheets().add(getClass().getResource("../../../resource/app.css").toExternalForm());



        // Creating columns
        TableColumn<Commune, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nomCommune"));
        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nomCol.setEditable(false);
        nomCol.setMinWidth(130);

        TableColumn<Commune, String> departCol = new TableColumn<>("Departement");
        departCol.setCellValueFactory(new PropertyValueFactory<>("leDepartement"));
        departCol.setCellFactory(TextFieldTableCell.forTableColumn());
        departCol.setEditable(false);
        departCol.setMinWidth(130);

        
        TableColumn<Commune, String> idCol = new TableColumn<>("Code Postal");
        idCol.setCellValueFactory(new PropertyValueFactory<>("idCommune"));
        idCol.setCellFactory(TextFieldTableCell.forTableColumn());
        idCol.setEditable(false);
        idCol.setMinWidth(130);

        TableColumn<Commune, String> otherCol = new TableColumn<>("Autre");
        otherCol.setCellFactory(i -> new TableCell<Commune, String>() {
            Button infoButton = new Button("+Informations");
            FlowPane pane = new FlowPane(infoButton);
            
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                infoButton.getStyleClass().add("my-button-info");
                if (!empty) {
                    Commune Commune = getTableView().getItems().get(getIndex());
                    pane.setAlignment(Pos.CENTER);
                    infoButton.setId(Commune.getIdCommune()); 
                    infoButton.setOnAction(controller);
                    setGraphic(pane);
                    setText(null);
                    setAlignment(Pos.CENTER);
                } else {
                    setGraphic(null);
                    setText(null);
                }
                
            }
        });
        otherCol.setMinWidth(130);

        // Adding data to the table
        this.setItems(data);
        this.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.getColumns().add(nomCol);
        this.getColumns().add(departCol);
        this.getColumns().add(idCol);
        this.getColumns().add(otherCol);

        // Ajouter des classes CSS aux colonnes

        nomCol.getStyleClass().add("my-table-col");
        departCol.getStyleClass().add("my-table-col");
        idCol.getStyleClass().add("my-table-col");
        otherCol.getStyleClass().add("my-table-col");

        // Setting the size of the table
        this.setMaxSize(600, 800);
    }

    public void setCommunes(ArrayList<Commune> communes) {
        ObservableList<Commune> data = FXCollections.observableArrayList(communes);
        this.setItems(data);
    }

    

}
