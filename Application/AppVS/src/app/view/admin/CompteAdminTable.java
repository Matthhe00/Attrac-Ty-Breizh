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

        // Creating columns
        TableColumn<User, String> nameCol = new TableColumn<>("Login");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("login"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit((CellEditEvent<User, String> t) -> {
            if (!t.getNewValue().equals(""))
                controller.updateLogin(t.getOldValue(), t.getNewValue());
        });
        nameCol.setMinWidth(150);

        TableColumn<User, String> firstNameCol = new TableColumn<>("Mot de passe");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit((CellEditEvent<User, String> t) -> {
            if (!t.getNewValue().equals(""))
                controller.updatePwd(t.getRowValue(), t.getNewValue());
        });
        firstNameCol.setMinWidth(150);

        TableColumn<User, Float> avgCol = new TableColumn<>("Moyenne");
        avgCol.setCellValueFactory(new PropertyValueFactory<>("average"));
        avgCol.setMinWidth(150);

        TableColumn<User, String> otherCol = new TableColumn<>("Actions");
        otherCol.setCellFactory(i -> new TableCell<User, String>() {
            Button evalButton = new Button("Notes");
            Button deleteButton = new Button("Supprimer");
            FlowPane pane = new FlowPane(1, 0, evalButton, deleteButton);

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    pane.setAlignment(Pos.CENTER);
                    deleteButton.setId("delUser_" + getIndex());
                    deleteButton.setOnAction(controller);
                    evalButton.setId("eval_" + getIndex());
                    evalButton.setOnAction(controller);
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
        this.getColumns().add(nameCol);
        this.getColumns().add(firstNameCol);
        this.getColumns().add(avgCol);
        this.getColumns().add(otherCol);

        // Setting the size of the table
        this.setMaxSize(600, 800);
    }
}
