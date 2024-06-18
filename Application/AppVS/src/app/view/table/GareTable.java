package app.view.table;

import java.util.ArrayList;

import app.controller.AppController;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.*;
import javafx.scene.layout.FlowPane;
import app.model.data.*;

public class GareTable extends TableView<Gare> {        
    
    public GareTable(ArrayList<Gare> gares, AppController controller, Boolean isAdmin) {
        ObservableList<Gare> data = FXCollections.observableArrayList(gares);
        this.setEditable(true);
        this.getSelectionModel().setCellSelectionEnabled(true);
        this.getStylesheets().add(getClass().getResource("../../../resource/app.css").toExternalForm());


        // Creating columns
        TableColumn<Gare, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nomGare"));
        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nomCol.setOnEditCommit((CellEditEvent<Gare, String> t) -> {
            if (!t.getNewValue().equals("")) {
                controller.updateGareNom(t.getRowValue(), t.getNewValue());
            }
        });
        if (isAdmin) nomCol.setEditable(true);
        else nomCol.setEditable(false);
        nomCol.setMinWidth(200);

        TableColumn<Gare, String> adresseCol = new TableColumn<>("Gare Marchandise");
        adresseCol.setCellValueFactory(new PropertyValueFactory<>("estFret"));
        adresseCol.setCellFactory(TextFieldTableCell.forTableColumn());
        adresseCol.setOnEditCommit((CellEditEvent<Gare, String> t) -> {
            if (!t.getNewValue().equals("")) {
                controller.updateGareFret(t.getRowValue(), t.getNewValue());
            }
        });
        if (isAdmin) adresseCol.setEditable(true);
        else adresseCol.setEditable(false);
        adresseCol.setMinWidth(140);
        
        TableColumn<Gare, String> departCol = new TableColumn<>("Gare Voyageur");
        departCol.setCellValueFactory(new PropertyValueFactory<>("estVoyageur"));
        departCol.setCellFactory(TextFieldTableCell.forTableColumn());
        departCol.setOnEditCommit((CellEditEvent<Gare, String> t) -> {
            if (!t.getNewValue().equals("")) {
                controller.updateGareVoyageur(t.getRowValue(), t.getNewValue());
            }
        });
        if (isAdmin) departCol.setEditable(true);
        else departCol.setEditable(false);
        departCol.setMinWidth(140);
        TableColumn<Gare, String> otherCol = new TableColumn<>("Actions");
        if(isAdmin) {
                otherCol.setCellFactory(i -> new TableCell<Gare, String>() {
                Button deleteButton = new Button("Supprimer");
                FlowPane pane = new FlowPane(deleteButton);
                
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    deleteButton.getStyleClass().add("my-button-sup");
                    if (!empty) {
                        Gare gare = getTableView().getItems().get(getIndex());
                        pane.setAlignment(Pos.CENTER);
                        // Supposant que Gare a une propriété identifiant unique, par exemple `codeGare`
                        deleteButton.setId(String.valueOf(gare.getCodeGare())); 
                        deleteButton.setOnAction(controller); // Assurez-vous que `controller` est correctement défini pour gérer l'action
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
        }
        

        // Adding data to the table
        this.setItems(data);
        this.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.getColumns().add(nomCol);
        this.getColumns().add(adresseCol);
        this.getColumns().add(departCol);
        if(isAdmin) this.getColumns().add(otherCol);

        // Ajouter des classes CSS aux colonnes
        nomCol.getStyleClass().add("my-table-col");
        adresseCol.getStyleClass().add("my-table-col");
        departCol.getStyleClass().add("my-table-col");
        otherCol.getStyleClass().add("my-table-col");

        // Setting the size of the table
        this.setMaxSize(600, 800);
    }

    public void setGares(ArrayList<Gare> gares) {
        ObservableList<Gare> data = FXCollections.observableArrayList(gares);
        this.setItems(data);
    }

}
