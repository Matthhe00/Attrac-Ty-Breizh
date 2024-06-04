package app.view;

import app.controller.AppController;
import app.model.data.User;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import app.model.data.*;


public class DonneTable extends TableView<User> {
    private AppController controller; // Reference to the controller for event handling
    private UserFileAccess UserFileAccess; // Access to User file operations
    private AeroportFileAccess AeroportFileAccess;

    /**
     * Constructor to initialize the UserTable with data and event handling.
     * @param UserFileAccess The access object for User file operations.
     * @param controller The controller object for event handling.
     */
    public DonneTable(UserFileAccess UserFileAccess, AppController controller, Boolean isAdmin) {
        this.controller = controller;
        this.UserFileAccess = UserFileAccess;
        ObservableList<User> data = FXCollections.observableArrayList(UserFileAccess.getUsers());
        this.setEditable(true);
        this.getSelectionModel().setCellSelectionEnabled(true);
        this.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());


        // Creating columns
        TableColumn<User, String> loginCol = new TableColumn<>("Identifiant");
        loginCol.setCellValueFactory(new PropertyValueFactory<>("login"));
        loginCol.setCellFactory(TextFieldTableCell.forTableColumn());
        if (isAdmin) {
            loginCol.setOnEditCommit((CellEditEvent<User, String> t) -> {
                if (!t.getNewValue().equals("")) {
                    controller.updateLogin(t.getOldValue(), t.getNewValue());
                    System.out.println("Login changed");
                }
            });
        } else {
            loginCol.setEditable(false);
        }
        loginCol.setMinWidth(130);

        TableColumn<User, String> pwdCol = new TableColumn<>("Mot de passe");
        pwdCol.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        pwdCol.setCellFactory(TextFieldTableCell.forTableColumn());
        if (isAdmin) {
            pwdCol.setOnEditCommit((CellEditEvent<User, String> t) -> {
                if (!t.getNewValue().equals("")) {
                    controller.updatePwd(t.getRowValue(), t.getNewValue());
                }
            });
        } else {
            pwdCol.setEditable(false);
        }

        pwdCol.setMinWidth(130);
        
        TableColumn<User, String> roleCol = new TableColumn<>("Role");
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        roleCol.setCellFactory(TextFieldTableCell.forTableColumn());
        if (isAdmin) {
            roleCol.setOnEditCommit((CellEditEvent<User, String> t) -> {
                if (!t.getNewValue().equals("")) {
                    controller.updateRole(t.getRowValue(), t.getNewValue());
                }
            });
        } else {
            roleCol.setEditable(false);
        }
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

        if (isAdmin) {
            this.getColumns().add(otherCol);
        }

        // Ajouter des classes CSS aux colonnes

        loginCol.getStyleClass().add("my-table-col");
        pwdCol.getStyleClass().add("my-table-col");
        roleCol.getStyleClass().add("my-table-col");
        otherCol.getStyleClass().add("my-table-col");

        // Setting the size of the table
        this.setMaxSize(600, 800);
    }
    
    public DonneTable(AeroportFileAccess AeroportFileAccess, AppController controller, Boolean isAdmin) {
        
    }
}
