package app.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import app.model.*;
import app.model.data.*;
import app.view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AppController implements EventHandler<ActionEvent>, PropertyChangeListener {
    private Stage primaryStage;
    private Modele modele;
    private Connexion connexion;
    private Accueil accueil;
    private Inscription inscription;

    private boolean estConnecte = false;

    public AppController(Stage primary, Modele modele, Connexion connexion, Accueil accueil, Inscription inscription) {
        this.primaryStage = primary;
        this.modele = modele;
        this.connexion = connexion;
        this.accueil = accueil;
        this.inscription = inscription;

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
        if (source == this.connexion.getConnexionButton()) {
            boutonConnexionConnexionClick();
        } else if (source == this.accueil.getNavBarre().getcompteButton() && !this.estConnecte) {
            boutonCompteNavBarreClick();
        } else if (source == this.connexion.getInscriptionButton()) {
            boutonInscriptionConnexionClick();
        } else if (source == this.inscription.getInscriptionButton()) {
            boutonInscriptionInscriptionClick();
        } else if (source == this.inscription.getConnexionButton()) {
            boutonConnexionInscriptionClick();
        } else if (source == this.accueil.getNavBarre().getDeconnexionButton() && this.estConnecte) {
            boutonDeconnexionNavBarreClick();
        } else if (source == this.accueil.getNavBarre().getcompteButton() && this.estConnecte) {
            System.out.println("Compte");
        }
    } 

    private void boutonConnexionConnexionClick() {
        connecterUtilisateur();
        Pane root = this.accueil.creerRootAccueil();
        Scene scene = new Scene(root, 1260, 700);
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private void boutonDeconnexionNavBarreClick() {
        Pane root = this.accueil.creerRootAccueil();
        Scene scene = new Scene(root, 1260, 700);
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        System.out.println("Déconnexion");
        deconnecterUtilisateur();
    }

    private void boutonInscriptionConnexionClick() {
        Pane root = this.inscription.creerRootInscription();
        Scene scene = new Scene(root, 1260, 700);
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private void boutonCompteNavBarreClick() {
        Pane root = this.connexion.creerRootConnexion();
        Scene scene = new Scene(root, 1260, 700);
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private void boutonInscriptionInscriptionClick() {
        Pane root = this.connexion.creerRootConnexion();
        Scene scene = new Scene(root, 1260, 700);
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private void boutonConnexionInscriptionClick() {
        Pane root = this.connexion.creerRootConnexion();
        Scene scene = new Scene(root, 1260, 700);
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }
    
    public void connecterUtilisateur() {
        this.estConnecte = true;
        this.accueil.setNavBarre(this.accueil.getNavBarre().refresh(this.estConnecte));
    }

    public void deconnecterUtilisateur() {
        this.estConnecte = false;
        this.accueil.setNavBarre(this.accueil.getNavBarre().refresh(this.estConnecte));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Implémentation du PropertyChangeListener si nécessaire
    }
}
