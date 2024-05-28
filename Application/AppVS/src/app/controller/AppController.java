package app.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import app.model.data.*;
import app.model.dao.*;
import app.view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import resource.utils.Constants;

public class AppController implements EventHandler<ActionEvent>, PropertyChangeListener {
    private Stage primaryStage;
    private Modele modele;
    private Connexion connexion;
    private Accueil accueil;
    private Inscription inscription;
    private Compte compte;
    private UserDAO userDAO;
    private User user;

    private boolean estConnecte = false;

    public AppController(Stage primary, Modele modele, Connexion connexion, Accueil accueil, Inscription inscription, Compte compte) {
        this.primaryStage = primary;
        this.modele = modele;
        this.connexion = connexion;
        this.accueil = accueil;
        this.inscription = inscription;
        this.compte = compte;
        this.userDAO = new UserDAO();
        initEventHandlers();
    }

    public AppController(Stage primary, Modele modele, Connexion connexion, Accueil accueil, Inscription inscription, boolean estConnecte, User user,  Compte compte) {
        this.primaryStage = primary;
        this.modele = modele;
        this.connexion = connexion;
        this.accueil = accueil;
        this.inscription = inscription;
        this.estConnecte = estConnecte;
        this.user = user;
        this.compte = compte;
        initEventHandlers();
    }

    private void initEventHandlers() {
        // gestion des événements de la classe Connexion
        this.connexion.getConnexionButton().setOnAction(this);
        this.connexion.getInscriptionButton().setOnAction(this);
        this.connexion.getMotDePasseOublieButton().setOnAction(this);

        // gestion des événements de la classe Accueil
        this.accueil.getNavBarre().getcompteButton().setOnAction(this);
        this.accueil.getNavBarre().getCarteButton().setOnAction(this);
        this.accueil.getNavBarre().getDonneesButton().setOnAction(this);
        this.accueil.getNavBarre().getModifieButton().setOnAction(this);
        this.accueil.getNavBarre().getDeconnexionButton().setOnAction(this);

        // gestion des événements de la classe Inscription
        this.inscription.getInscriptionButton().setOnAction(this);
        this.inscription.getConnexionButton().setOnAction(this);
  
    }

    @Override
    public void handle(ActionEvent event) {
        Object source = event.getSource();
        if (source == this.connexion.getConnexionButton() && !this.estConnecte && !this.connexion.getIndentField().getText().isEmpty() && !this.connexion.getPasswordField().getText().isEmpty()) {
            boutonConnexionConnexionClick();
        } else if (source == this.connexion.getInscriptionButton()) {
            boutonInscriptionConnexionClick();
        } else if (source == this.inscription.getInscriptionButton()) {
            boutonInscriptionInscriptionClick();
        } else if (source == this.inscription.getConnexionButton()) {
            boutonConnexionInscriptionClick();
        } else if (source == this.accueil.getNavBarre().getDeconnexionButton() && this.estConnecte) {
            boutonDeconnexionNavBarreClick();
        } else if (source == this.accueil.getNavBarre().getcompteButton() && this.estConnecte) {
            boutonCompteNavBarreClick();
        }
    } 

    private void boutonConnexionConnexionClick() {
        connecterUtilisateur();
        Pane root = this.accueil.creerRootAccueil();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        this.estConnecte = false;
    }

    private void boutonDeconnexionNavBarreClick() {
        deconnecterUtilisateur();
        Pane root = this.connexion.creerRootConnexion();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private void boutonInscriptionConnexionClick() {
        Pane root = this.inscription.creerRootInscription();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private void boutonCompteNavBarreClick() {
        Pane root = this.compte.creerRootCompte(this.user.getRole(), this.user.getLogin(), this.user.getPwd());
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private void boutonInscriptionInscriptionClick() {
        if (!this.userDAO.exists(this.inscription.getIndentField().getText())) {
            Pane root = this.connexion.creerRootConnexion();
            Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
            scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
            inscrireUtilisateur();
        } else {
            this.inscription.getErrorLabel().setText("Identifiant déjà utilisé");
        }

    }

    private void boutonConnexionInscriptionClick() {
        Pane root = this.connexion.creerRootConnexion();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }
    
    public void connecterUtilisateur() {
        this.user = new User(this.connexion.getIndentField().getText(), this.connexion.getPasswordField().getText());
        System.out.println(userDAO.findByLoginPwd("admin", "admin"));
        this.estConnecte = true;
        this.accueil.setNavBarre(this.accueil.getNavBarre().refresh(this.estConnecte));
        new AppController(this.primaryStage, this.modele, this.connexion, this.accueil, this.inscription, this.estConnecte, this.user, this.compte);
    }

    public void deconnecterUtilisateur() {
        this.estConnecte = false;
        this.accueil.setNavBarre(this.accueil.getNavBarre().refresh(this.estConnecte));
        new AppController(this.primaryStage, this.modele, this.connexion, this.accueil, this.inscription, this.estConnecte, this.user, this.compte);
    }

    public void inscrireUtilisateur() {
        this.user = new User(this.inscription.getIndentField().getText(), this.inscription.getPasswordField().getText());
        userDAO.create(user);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Implémentation du PropertyChangeListener si nécessaire

    }
}
