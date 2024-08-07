package app.view.admin;

import java.util.ArrayList;

import app.controller.AppController;
import app.model.data.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;

public class CompteAdminTable extends TableView<User> {
    private AppController controller; // Reference to the controller for event handling

    /**
     * Constructor to initialize the UserTable with data and event handling.
     * @param UserFileAccess The access object for User file operations.
     * @param controller The controller object for event handling.
     */
    public CompteAdminTable(ArrayList<User> u, AppController controller) {
        this.controller = controller;
        ObservableList<User> data = FXCollections.observableArrayList(u);
        this.setEditable(true);
        this.getSelectionModel().setCellSelectionEnabled(true);
        this.getStylesheets().add(getClass().getResource("../../../resource/app.css").toExternalForm());



        // Creating columns
        TableColumn<User, String> loginCol = new TableColumn<>("Identifiant");
        loginCol.setCellValueFactory(new PropertyValueFactory<>("login"));
        loginCol.setCellFactory(TextFieldTableCell.forTableColumn());
        loginCol.setOnEditCommit((CellEditEvent<User, String> t) -> {
            if (!t.getNewValue().equals("")) {
                controller.updateLogin(t.getOldValue(), t.getNewValue());
            }
        });
        loginCol.setMinWidth(130);

        TableColumn<User, String> pwdCol = new TableColumn<>("Mot de passe");
        pwdCol.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        pwdCol.setCellFactory(TextFieldTableCell.forTableColumn());
        pwdCol.setOnEditCommit((CellEditEvent<User, String> t) -> {
            if (!t.getNewValue().equals("")) {
                controller.updatePwd(t.getRowValue(), t.getNewValue());
            }
        });
        pwdCol.setMinWidth(130);

        
        TableColumn<User, String> roleCol = new TableColumn<>("Role");
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        roleCol.setCellFactory(TextFieldTableCell.forTableColumn());
        roleCol.setOnEditCommit((CellEditEvent<User, String> t) -> {
            if (!t.getNewValue().equals("")) {
                controller.updateRole(t.getRowValue(), t.getNewValue());
            }
        });
        roleCol.setMinWidth(130);

        TableColumn<User, String> otherCol = new TableColumn<>("Actions");
        otherCol.setCellFactory(i -> new TableCell<User, String>() {
            Button deleteButton = new Button("Supprimer");
            FlowPane pane = new FlowPane(deleteButton);
            
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                deleteButton.getStyleClass().add("my-button-sup");
                if (!empty) {
                    User user = getTableView().getItems().get(getIndex());
                    pane.setAlignment(Pos.CENTER);
                    deleteButton.setId(user.getLogin()); 
                    deleteButton.setOnAction(controller);
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
        this.getColumns().add(loginCol);
        this.getColumns().add(pwdCol);
        this.getColumns().add(roleCol);
        this.getColumns().add(otherCol);

        // Ajouter des classes CSS aux colonnes

        loginCol.getStyleClass().add("my-table-col");
        pwdCol.getStyleClass().add("my-table-col");
        roleCol.getStyleClass().add("my-table-col");
        otherCol.getStyleClass().add("my-table-col");

        // Setting the size of the table
        this.setMaxSize(600, 800);
    }
    
}
