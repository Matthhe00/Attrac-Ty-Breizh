package app.controller;

import app.model.data.*;
import app.Main;
import app.model.dao.*;
import app.view.*;
import app.view.admin.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import resource.utils.Constants;

public class AppController implements EventHandler<ActionEvent> {
    private Stage primaryStage;
    private Connexion connexion;
    private Accueil accueil;
    private Inscription inscription;
    private Compte compte;
    private UserDAO userDAO;
    private CommuneDAO communeDAO;
    private User user;
    private boolean role = false;
    private boolean estConnecte = false;
    private Main main;
    private UserFileAccess userFileAccess;
    private AeroportFileAccess aeroportFileAccess;
    private CommuneFileAccess communeFileAccess;
    private CompteAdminScene CompteAdminScene;
    private ModifierScene modifierScene;
    private Donnee donnee;
    private DonneeDetailVue donneeDetailVue;


    public AppController(Stage primary, Connexion connexion, Accueil accueil, Inscription inscription, Compte compte, Main main, CompteAdminScene CompteAdminScene, ModifierScene modifierScene, Donnee donnee, DonneeDetailVue donneeDetailVue) {
        this.primaryStage = primary;
        this.connexion = connexion;
        this.accueil = accueil;
        this.inscription = inscription;
        this.compte = compte;
        this.main = main;
        this.userDAO = new UserDAO();
        this.CompteAdminScene = CompteAdminScene;
        this.userFileAccess = new UserFileAccess();
        this.CompteAdminScene.init(this, userFileAccess);
        this.modifierScene = modifierScene;

        this.communeFileAccess = new CommuneFileAccess();
        this.donnee = donnee;
        this.donnee.init(this, communeFileAccess, this.role);

        this.aeroportFileAccess = new AeroportFileAccess();
        this.donneeDetailVue = donneeDetailVue;
        this.donneeDetailVue.init(this, aeroportFileAccess, this.role);
        initEventHandlers();
    }

    public AppController(Stage primary, Connexion connexion, Accueil accueil, Inscription inscription, boolean estConnecte, User user,  Compte compte, boolean role, Main main, CompteAdminScene CompteAdminScene, ModifierScene modifierScene, Donnee donnee, DonneeDetailVue donneeDetailVue) {
        this.primaryStage = primary;
        this.connexion = connexion;
        this.accueil = accueil;
        this.inscription = inscription;
        this.estConnecte = estConnecte;
        this.user = user;
        this.compte = compte;

        this.userDAO = new UserDAO();
        this.communeDAO = new CommuneDAO();

        this.role = role;
        this.main = main;
        this.CompteAdminScene = CompteAdminScene;
        this.userFileAccess = new UserFileAccess();
        this.CompteAdminScene.init(this, userFileAccess);
        this.modifierScene = modifierScene;
        
        this.communeFileAccess = new CommuneFileAccess();
        this.donnee = donnee;
        this.donnee.init(this, communeFileAccess, this.role);

        this.aeroportFileAccess = new AeroportFileAccess();
        this.donneeDetailVue = donneeDetailVue;
        this.donneeDetailVue.init(this, aeroportFileAccess, this.role);
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

        // gestion des événements de la classe CompteAdminScene
        this.CompteAdminScene.getNavBarre().getcompteButton().setOnAction(this);
        this.CompteAdminScene.getNavBarre().getCarteButton().setOnAction(this);
        this.CompteAdminScene.getNavBarre().getDonneesButton().setOnAction(this);
        this.CompteAdminScene.getNavBarre().getModifieButton().setOnAction(this);
        this.CompteAdminScene.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.CompteAdminScene.getNavBarre().getAccueilButton().setOnAction(this);
        this.CompteAdminScene.getAjouterButton().setOnAction(this);
        
        // gestion des événements de la classe ModifierScene
        this.modifierScene.getNavBarre().getcompteButton().setOnAction(this);
        this.modifierScene.getNavBarre().getCarteButton().setOnAction(this);
        this.modifierScene.getNavBarre().getDonneesButton().setOnAction(this);
        this.modifierScene.getNavBarre().getModifieButton().setOnAction(this);
        this.modifierScene.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.modifierScene.getNavBarre().getAccueilButton().setOnAction(this);

        // gestion des événements de la classe Donnee
        this.donnee.getNavBarre().getcompteButton().setOnAction(this);
        this.donnee.getNavBarre().getCarteButton().setOnAction(this);
        this.donnee.getNavBarre().getDonneesButton().setOnAction(this);
        this.donnee.getNavBarre().getModifieButton().setOnAction(this);
        this.donnee.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.donnee.getNavBarre().getAccueilButton().setOnAction(this);

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
        } else if ((source == this.accueil.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.compte.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.CompteAdminScene.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.modifierScene.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.donnee.getNavBarre().getDeconnexionButton() && this.estConnecte)){
            boutonDeconnexionNavBarreClick();
        } else if (source == this.accueil.getNavBarre().getcompteButton() && this.estConnecte || source == this.compte.getNavBarre().getcompteButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getcompteButton() && this.estConnecte || source == this.modifierScene.getNavBarre().getcompteButton() && this.estConnecte || source == this.donnee.getNavBarre().getcompteButton() && this.estConnecte) {
            boutonCompteNavBarreClick();
        } else if (source == this.accueil.getNavBarre().getCarteButton() && this.estConnecte || source == this.compte.getNavBarre().getCarteButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getCarteButton() && this.estConnecte || source == this.modifierScene.getNavBarre().getCarteButton() && this.estConnecte || source == this.donnee.getNavBarre().getCarteButton() && this.estConnecte) {
            // boutonCarteNavBarreClick();
            System.out.println("Carte");
        } else if (source == this.accueil.getNavBarre().getDonneesButton() && this.estConnecte || source == this.compte.getNavBarre().getDonneesButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getDonneesButton() && this.estConnecte || source == this.donnee.getNavBarre().getDonneesButton() && this.estConnecte ){
            boutonDonneesNavBarreClick();
        } else if (source == this.donnee.getNavBarre().getModifieButton() && this.estConnecte && this.role) {
            // boutonModifieNavBarreClick();
            System.out.println("Modifie");
        } else if (source == this.accueil.getNotion()) {
            boutonNotionClick();
        } else if (source == this.accueil.getNavBarre().getAccueilButton() && this.estConnecte || source == this.compte.getNavBarre().getAccueilButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getAccueilButton() && this.estConnecte || source == this.modifierScene.getNavBarre().getAccueilButton() && this.estConnecte || source == this.donnee.getNavBarre().getAccueilButton() && this.estConnecte) {
            boutonAccueilNavBarreClick();
        } else if (source == this.compte.getModificationButton() && this.estConnecte) {
            modifierUtilisateur();
        } else if (source == this.compte.getSupprimerButton() && this.estConnecte) {
            boutonSupprimerClick();
        } else if (source == this.compte.getListeCompteButton()) {
            boutonListeCompteClick();
        } else if (source == this.CompteAdminScene.getAjouterButton()){
            inscrireUtilisateurAdmin();
        } else {
            Button sources = (Button) event.getSource();
            String sourceId = sources.getId();

            if (this.userDAO.exists(sourceId)) {
                boutonSupprimerClickAdmin(sourceId);
                boutonListeCompteClick();
                boutonListeCompteClick();
            } else if (this.communeDAO.exists(sourceId)) {
                this.donneeDetailVue.setCommune(this.communeDAO.findByCodePostal(sourceId));
                System.out.println(sourceId);
            }
        }
    } 

    // private void boutonCarteNavBarreClick() {
    // }

    private void boutonNotionClick() {
        try {
            this.main.getHostServices().showDocument("https://a1-2-sae2.notion.site/Attractivit-des-communes-bretonnes-e554c010050d45e996431ba36e920265");
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
        new AppController(primaryStage, connexion, accueil, inscription, estConnecte, user, compte, role, main, CompteAdminScene, modifierScene, donnee, donneeDetailVue);
    }

    private void boutonInscriptionInscriptionClick() {
        if (!this.userDAO.exists(this.inscription.getIndentField().getText()) && !this.inscription.getIndentField().getText().isEmpty() && !this.inscription.getPasswordField().getText().isEmpty()){
            Pane root = this.connexion.creerRootConnexion();
            Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
            scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
            inscrireUtilisateur();
        } else if (this.userDAO.exists(this.inscription.getIndentField().getText())){
            this.inscription.getErrorLabel().setText("Identifiant déjà utilisé");
        } else {
            this.inscription.getErrorLabel().setText("Champs vides");
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
            new AppController(this.primaryStage, this.connexion, this.accueil, this.inscription, this.estConnecte, this.user, this.compte, this.role, main, CompteAdminScene, modifierScene, donnee, donneeDetailVue);
        }
    }

    public void deconnecterUtilisateur() {
        this.compte.setNavBarre(this.compte.getNavBarre().refresh(this.user, this.role));
        this.estConnecte = false;
        new AppController(this.primaryStage, this.connexion, this.accueil, this.inscription, this.estConnecte, this.user, this.compte, this.role, main, CompteAdminScene, modifierScene, donnee, donneeDetailVue);
    }

    public void inscrireUtilisateur() {
        user = new User(this.inscription.getIndentField().getText(), this.inscription.getPasswordField().getText());
        userDAO.create(user);
    }

    public void inscrireUtilisateurAdmin() {
        if (!this.userDAO.exists(this.CompteAdminScene.getLoginField().getText()) && !this.CompteAdminScene.getLoginField().getText().isEmpty() && !this.CompteAdminScene.getPasswordField().getText().isEmpty()){
            user = new User(this.CompteAdminScene.getLoginField().getText(), this.CompteAdminScene.getPasswordField().getText());
            userDAO.create(user);
            boutonListeCompteClick();
            boutonListeCompteClick();
        }

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

    public void boutonSupprimerClickAdmin(String user) {
        this.userFileAccess.deleteUser(this.userFileAccess.getUser(user));
    }

    public void boutonListeCompteClick() {
        // this.user = userDAO.findByLoginPwd(this.user.getLogin(), this.user.getPwd());
        Pane root = this.CompteAdminScene.creerRootCompte();
        this.CompteAdminScene.init(this, userFileAccess);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        new AppController(primaryStage, connexion, accueil, inscription, estConnecte, user, compte, role, main, CompteAdminScene, modifierScene, donnee, donneeDetailVue);
    }

    public void updateLogin(String initLogin, String newLogin) {
        this.userDAO.updateLogin(initLogin, newLogin);
        this.userFileAccess.setList();
        boutonListeCompteClick();
        boutonListeCompteClick();
    }

    public void updatePwd(User user, String newPwd) {
        String login = user.getLogin();
        this.userDAO.updatePwd(login, newPwd);
        this.userFileAccess.setList();
        boutonListeCompteClick();
        boutonListeCompteClick();
    }

    public void updateRole(User user, String newRole) {
        String login = user.getLogin();
        this.userDAO.updateRole(login, newRole);
        this.userFileAccess.setList();
        boutonListeCompteClick();
        boutonListeCompteClick();
    }

    private void boutonDonneesNavBarreClick() {
        Pane root = this.donnee.creerRootDonnee(estConnecte, role);
        Pane root2 = this.donneeDetailVue.creerRootDonnee(estConnecte, role);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        new AppController(this.primaryStage, this.connexion, this.accueil, this.inscription, this.estConnecte, this.user, this.compte, this.role, main, CompteAdminScene, modifierScene, donnee, donneeDetailVue);
    }
    
}
