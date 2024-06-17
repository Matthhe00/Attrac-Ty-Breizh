package app.view.table;

import java.util.ArrayList;

import app.controller.AppController;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.*;
import app.model.data.*;

public class GareTable extends TableView<Gare> {        
    
    public GareTable(ArrayList<Gare> gares, AppController controller, Boolean isAdmin) {
        ObservableList<Gare> data = FXCollections.observableArrayList(gares);
        System.out.println(isAdmin);

        this.setEditable(true);
        this.getSelectionModel().setCellSelectionEnabled(true);
        this.getStylesheets().add(getClass().getResource("../../../resource/app.css").toExternalForm());


        // Creating columns
        TableColumn<Gare, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nomGare"));
        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nomCol.setOnEditCommit((CellEditEvent<Gare, String> t) -> {
            if (!t.getNewValue().equals("")) {
                controller.updateGareNom(t.getOldValue(), t.getNewValue());
            }
        });
        if (isAdmin) nomCol.setEditable(true);
        else nomCol.setEditable(false);
        nomCol.setMinWidth(200);

        TableColumn<Gare, String> adresseCol = new TableColumn<>("Gare Marchandise");
        adresseCol.setCellValueFactory(new PropertyValueFactory<>("estFret"));
        adresseCol.setCellFactory(TextFieldTableCell.forTableColumn());
        if (isAdmin) adresseCol.setEditable(true);
        else adresseCol.setEditable(false);
        adresseCol.setMinWidth(140);
        
        TableColumn<Gare, String> departCol = new TableColumn<>("Gare Voyageur");
        departCol.setCellValueFactory(new PropertyValueFactory<>("estVoyageur"));
        departCol.setCellFactory(TextFieldTableCell.forTableColumn());
        if (isAdmin) departCol.setEditable(true);
        else departCol.setEditable(false);
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
