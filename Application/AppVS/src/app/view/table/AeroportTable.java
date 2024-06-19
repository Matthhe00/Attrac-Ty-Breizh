package app.view.table;

import java.util.ArrayList;

import app.controller.AppController;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TableColumn.CellEditEvent;
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
        nomCol.setOnEditCommit((CellEditEvent<Aeroport, String> t) -> {
            if (!t.getNewValue().equals("")) {
                controller.updateAeroportNom(t.getRowValue(), t.getNewValue());
            }
        });
        if (isAdmin) nomCol.setEditable(true);
        else nomCol.setEditable(false);
        nomCol.setMinWidth(180);

        TableColumn<Aeroport, String> adresseCol = new TableColumn<>("Adresse");
        adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        adresseCol.setCellFactory(TextFieldTableCell.forTableColumn());
        adresseCol.setOnEditCommit((CellEditEvent<Aeroport, String> t) -> {
            if (!t.getNewValue().equals("")) {
                controller.updateAeroportAdresse(t.getRowValue(), t.getNewValue());
            }
        });
        if (isAdmin) adresseCol.setEditable(true);
        else adresseCol.setEditable(false);
        adresseCol.setMinWidth(300);

        TableColumn<Aeroport, String> otherCol = new TableColumn<>("Actions");
        if(isAdmin) {
                otherCol.setCellFactory(i -> new TableCell<Aeroport, String>() {
                Button deleteButton = new Button("Supprimer");
                FlowPane pane = new FlowPane(deleteButton);
                
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    deleteButton.getStyleClass().add("my-button-sup");
                    if (!empty) {
                        Aeroport aeroport = getTableView().getItems().get(getIndex());
                        pane.setAlignment(Pos.CENTER);
                        // Supposant que Gare a une propriété identifiant unique, par exemple `codeGare`
                        deleteButton.setId(aeroport.getNom()); 
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
        if(isAdmin) this.getColumns().add(otherCol);

        // Ajouter des classes CSS aux colonnes

        nomCol.getStyleClass().add("my-table-col");
        adresseCol.getStyleClass().add("my-table-col");
        otherCol.getStyleClass().add("my-table-col");

        // Setting the size of the table
        this.setMaxSize(600, 800);
    }

    public void setAeroports(ArrayList<Aeroport> aeroports) {
        ObservableList<Aeroport> data = FXCollections.observableArrayList(aeroports);
        this.setItems(data);
    }

}
