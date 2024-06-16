package app.view.table;

import java.util.ArrayList;

import app.controller.AppController;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import app.model.data.*;

public class VoisineTable extends TableView<Commune> {

    public VoisineTable(ArrayList<Commune> c, AppController controller, String idCommune) {
        ObservableList<Commune> data = FXCollections.observableArrayList(c);
        this.setEditable(true);
        this.getSelectionModel().setCellSelectionEnabled(true);
        this.getStylesheets().add(getClass().getResource("../../../resource/app.css").toExternalForm());

        // Creating columns
        TableColumn<Commune, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nomCommune"));
        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nomCol.setEditable(false);
        nomCol.setMinWidth(230);

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
        this.getColumns().add(idCol);
        this.getColumns().add(otherCol);

        // Ajouter des classes CSS
        nomCol.getStyleClass().add("my-table-col");
        idCol.getStyleClass().add("my-table-col");
        otherCol.getStyleClass().add("my-table-col");
    }
}
