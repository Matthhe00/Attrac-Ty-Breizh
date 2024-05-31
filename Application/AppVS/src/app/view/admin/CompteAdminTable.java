package app.view.admin;

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

import app.model.data.UserFileAccess;


public class CompteAdminTable extends TableView<User> {
    private UserFileAccess UserFileAccess; // Access to User file operations
    private AppController controller; // Reference to the controller for event handling

    /**
     * Constructor to initialize the UserTable with data and event handling.
     * @param UserFileAccess The access object for User file operations.
     * @param controller The controller object for event handling.
     */
    public CompteAdminTable(UserFileAccess UserFileAccess, AppController controller) {
        this.controller = controller;
        ObservableList<User> data = FXCollections.observableArrayList(UserFileAccess.getUsers());
        this.setEditable(true);
        this.getSelectionModel().setCellSelectionEnabled(true);
        this.getStylesheets().add(getClass().getResource("../../../resource/app.css").toExternalForm());


        // Creating columns
        TableColumn<User, String> loginCol = new TableColumn<>("Login");
        loginCol.setCellValueFactory(new PropertyValueFactory<>("login"));
        loginCol.setCellFactory(TextFieldTableCell.forTableColumn());
        loginCol.setOnEditCommit((CellEditEvent<User, String> t) -> {
            if (!t.getNewValue().equals(""))
                controller.updateLogin(t.getOldValue(), t.getNewValue());
        });
        loginCol.setMinWidth(150);

        TableColumn<User, String> pwdCol = new TableColumn<>("Mot de passe");
        pwdCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        pwdCol.setCellFactory(TextFieldTableCell.forTableColumn());
        pwdCol.setOnEditCommit((CellEditEvent<User, String> t) -> {
            if (!t.getNewValue().equals(""))
                controller.updatePwd(t.getRowValue(), t.getNewValue());
        });
        pwdCol.setMinWidth(150);

        TableColumn<User, String> otherCol = new TableColumn<>("Actions");
        otherCol.setCellFactory(i -> new TableCell<User, String>() {
            Button deleteButton = new Button("Supprimer");
            FlowPane pane = new FlowPane(1, 0, deleteButton);

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    pane.setAlignment(Pos.CENTER);
                    deleteButton.setId("delUser_" + getIndex());
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
        otherCol.setMinWidth(150);

        // Adding data to the table
        this.setItems(data);
        this.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.getColumns().add(loginCol);
        this.getColumns().add(pwdCol);
        this.getColumns().add(otherCol);

        // Ajouter des classes CSS aux colonnes


        // Setting the size of the table
        this.setMaxSize(600, 800);
    }
}
