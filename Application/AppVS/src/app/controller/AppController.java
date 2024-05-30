package app.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URI;
import java.util.List;

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
    private boolean role = false;
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

    public AppController(Stage primary, Modele modele, Connexion connexion, Accueil accueil, Inscription inscription, boolean estConnecte, User user,  Compte compte, boolean role) {
        this.primaryStage = primary;
        this.modele = modele;
        this.connexion = connexion;
        this.accueil = accueil;
        this.inscription = inscription;
        this.estConnecte = estConnecte;
        this.user = user;
        this.compte = compte;
        this.userDAO = new UserDAO();
        this.role = role;
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
        this.accueil.getNavBarre().getAccueilButton().setOnAction(this);
        this.accueil.getNotion().setOnAction(this);

        // gestion des événements de la classe Inscription
        this.inscription.getInscriptionButton().setOnAction(this);
        this.inscription.getConnexionButton().setOnAction(this);

        // gestion des événements de la classe Compte
        this.compte.getNavBarre().getcompteButton().setOnAction(this);
        this.compte.getNavBarre().getCarteButton().setOnAction(this);
        this.compte.getNavBarre().getDonneesButton().setOnAction(this);
        this.compte.getNavBarre().getModifieButton().setOnAction(this);
        this.compte.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.compte.getNavBarre().getAccueilButton().setOnAction(this);
        this.compte.getModificationButton().setOnAction(this);
        this.compte.getSupprimerButton().setOnAction(this);
        this.compte.getListeCompteButton().setOnAction(this);
  
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
        } else if ((source == this.accueil.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.compte.getNavBarre().getDeconnexionButton() && this.estConnecte)){
            boutonDeconnexionNavBarreClick();
        } else if (source == this.accueil.getNavBarre().getcompteButton() && this.estConnecte || source == this.compte.getNavBarre().getcompteButton() && this.estConnecte) {
            boutonCompteNavBarreClick();
        } else if (source == this.accueil.getNavBarre().getCarteButton() && this.estConnecte || source == this.compte.getNavBarre().getCarteButton() && this.estConnecte) {
            // boutonCarteNavBarreClick();
            System.out.println("Carte");
        } else if (source == this.accueil.getNavBarre().getDonneesButton() && this.estConnecte || source == this.compte.getNavBarre().getDonneesButton() && this.estConnecte) {
            // boutonDonneesNavBarreClick();
            System.out.println("Données");
        } else if (source == this.accueil.getNavBarre().getModifieButton() && this.estConnecte && this.role || source == this.compte.getNavBarre().getModifieButton() && this.estConnecte && this.role){
            // boutonModifieNavBarreClick();
            System.out.println("Modifie");
        } else if (source == this.accueil.getNotion()) {
            boutonNotionClick();
        } else if (source == this.accueil.getNavBarre().getAccueilButton() && this.estConnecte || source == this.compte.getNavBarre().getAccueilButton() && this.estConnecte){
            boutonAccueilNavBarreClick();
            System.out.println("Accueil");
        } else if (source == this.compte.getModificationButton() && this.estConnecte) {
            modifierUtilisateur();
        } else if (source == this.compte.getSupprimerButton() && this.estConnecte) {
            boutonSupprimerClick();
        } else if (source == this.compte.getListeCompteButton()) {
            boutonListeCompteClick();
        }
    } 

    private void boutonNotionClick() {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://a1-2-sae2.notion.site/Attractivit-des-communes-bretonnes-e554c010050d45e996431ba36e920265"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void boutonConnexionConnexionClick() {
        connecterUtilisateur();
        if (this.estConnecte) {
            Pane root = this.accueil.creerRootAccueil();
            Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
            scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        }
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
        this.user = userDAO.findByLoginPwd(this.user.getLogin(), this.user.getPwd());
        Pane root = this.compte.creerRootCompte(this.user.getRole(), this.user.getLogin(), this.user.getPwd(), this.role);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        new AppController(primaryStage, modele, connexion, accueil, inscription, estConnecte, user, compte, role);
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

    private void boutonAccueilNavBarreClick() {
        Pane root = this.accueil.creerRootAccueil();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }
    
    public void connecterUtilisateur() {
        this.user = utilisateurExiste();
        if (this.user == null) {
            return;
        } else {
            this.user = userDAO.findByLoginPwd(this.user.getLogin(), this.user.getPwd());
            if (this.user.getRole().equals("admin")) {
                this.role = true;
                this.accueil.setNavBarre(this.accueil.getNavBarre().refresh(true));
            } else {
                this.role = false;
                this.accueil.setNavBarre(this.accueil.getNavBarre().refresh(false));
            }
            this.estConnecte = true;
            new AppController(this.primaryStage, this.modele, this.connexion, this.accueil, this.inscription, this.estConnecte, this.user, this.compte, this.role);
        }
    }

    public void deconnecterUtilisateur() {
        this.compte.setNavBarre(this.compte.getNavBarre().refresh(this.user, this.role));
        this.estConnecte = false;
        new AppController(this.primaryStage, this.modele, this.connexion, this.accueil, this.inscription, this.estConnecte, this.user, this.compte, this.role);
    }

    public void inscrireUtilisateur() {
        this.user = new User(this.inscription.getIndentField().getText(), this.inscription.getPasswordField().getText());
        userDAO.create(user);
    }

    public User utilisateurExiste() {
        if (userDAO.findByLoginPwd(this.connexion.getIndentField().getText(), this.connexion.getPasswordField().getText()) == null) {
            return null;
        } else {
            return userDAO.findByLoginPwd(this.connexion.getIndentField().getText(), this.connexion.getPasswordField().getText());
        }
    }

    public void modifierUtilisateur() {
        this.user = new User(this.compte.getidentField().getText(), this.compte.getPasswordField().getText(), this.compte.getRoleLabel().getText());
        if(!this.userDAO.exists(this.compte.getidentField().getText()) && !this.compte.getidentField().getText().isEmpty() && !this.compte.getPasswordField().getText().isEmpty()){
            this.userDAO.update(user, this.compte.getidentLabel().getText(), this.compte.getRoleLabel().getText());
            System.out.println(this.compte.getidentLabel().getText());
            boutonCompteNavBarreClick();
        } else {
            this.compte.getErrorLabel().setText("Identifiant déjà utilisé");
        }
    }

    public void boutonSupprimerClick() {
        this.user = new User(this.compte.getidentField().getText(), this.compte.getPasswordField().getText());
        this.userDAO.delete(user, this.compte.getidentLabel().getText());
        deconnecterUtilisateur();
        boutonConnexionInscriptionClick();
    }

    public void boutonListeCompteClick() {
        List<User> users = userDAO.findAll();
        for (User user : users) {
            System.out.println(user.getId() + " " +user.getLogin() + " " + user.getPwd() + " " + user.getRole());
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Implémentation du PropertyChangeListener si nécessaire

    }
}
