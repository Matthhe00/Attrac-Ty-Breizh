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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import resource.utils.Constants;
import java.util.ArrayList;

/**
 * Classe AppController
 * Gestionnaire des événements de l'application
 */
public class AppController implements EventHandler<ActionEvent> {

    /**
     * Scène principale
     */
    private Stage primaryStage;

    /**
     * Vue connexion de l'application
     */
    private Connexion connexion;

    /**
     * Vue accueil de l'application
     */
    private Accueil accueil;

    /**
     * Vue inscription de l'application
     */
    private Inscription inscription;

    /**
     * Vue compte de l'application
     */
    private Compte compte;

    /**
     * DAO User de l'application 
     */
    private UserDAO userDAO;

    /**
     * DAO Commune de l'application
     */
    private CommuneDAO communeDAO;

    /**
     * DAO Aeroport de l'application
     */
    private AeroportDAO aeroportDAO;

    /**
     * DAO Gare de l'application
     */
    private GareDAO gareDAO;

    /**
     * DAO Departement de l'application
     */
    private DepartementDAO departementDAO;

    /**
     * DAO Annee de l'application
     */
    private AnneeDAO anneeDAO;

    /**
     * DAO AnneeCommune de l'application
     */
    private AnneeCommuneDAO anneeCommuneDAO;

    /**
     * Data User de l'application pour récupérer l'utilisateur connecté
     */
    private User user;

    /**
     * Boolean pour savoir si l'utilisateur est connecté, le rôle de l'utilisateur et si c'est une action du departement
     */
    private boolean estConnecte = false, role = false, estdepartement = false;

    /**
     * String pour l'année, l'id de la commune et la requête
     */
    private String annee, idCommune, querry;

    /**
     * Main de l'application
     */
    private Main main;

    /**
     * userFileAccess de l'application pour accéder aux donnée utilisateurs
     */
    private UserFileAccess userFileAccess;

    /**
     * aeroportFileAccess de l'application pour accéder aux données aéroports
     */
    private AeroportFileAccess aeroportFileAccess;

    /**
     * gareFileAccess de l'application pour accéder aux données gares
     */
    private GareFileAccess gareFileAccess;

    /**
     * anneeFileAccess de l'application pour accéder aux données années
     */
    private AnneeFileAccess anneeFileAccess;

    /**
     * anneeCommuneFileAccess de l'application pour accéder aux données années communes
     */
    private AnneeCommuneFileAccess anneeCommuneFileAccess;

    /**
     * communeFileAccess de l'application pour accéder aux données communes
     */
    private CommuneFileAccess communeFileAccess;

    /**
     * vue CompteAdminScene de l'application
     */
    private CompteAdminScene CompteAdminScene;

    /**
     * vue Donnée commune de l'application
     */
    private DonneeCommune donnee;

    /**
     * vue Donnée commune détail de l'application
     */
    private DonneeCommuneDetail donneeDetailVue;

    /**
     * departementFileAccess de l'application pour accéder aux données départements
     */
    private DepartementFileAccess departementFileAccess;

    /**
     * Liste des communes
     */
    private ArrayList<Commune> communes;

    /**
     * vue Donnée département de l'application
     */
    private DonneeDepartement donneeDepartement;

    /**
     * vue Donnée département détail de l'application
     */
    private DonneeDepartementDetail donneeDepartementDetail;

    /**
     * vue Statistique de l'application
     */
    private Statistique statistique;
    

    /**
     * Constructeur de la classe AppController
     * @param primary Scène principale
     * @param connexion Vue Connexion
     * @param accueil Vue Accueil
     * @param inscription Vue Inscription
     * @param compte Vue Compte
     * @param main Classe Main
     * @param CompteAdminScene Vue CompteAdminScene
     * @param donnee Vue Donnee
     * @param donneeDetailVue Vue DonneeDetailVue
     * @param donneeDepartement Vue DonneeDepartement
     * @param donneeDepartementDetail Vue DonneeDepartementDetail
     * @param statistique Vue Statistique
     * @param userDAO DAO User
     */
    public AppController(Stage primary, Connexion connexion, Accueil accueil, Inscription inscription, Compte compte, Main main, CompteAdminScene CompteAdminScene,  DonneeCommune donnee, DonneeCommuneDetail donneeDetailVue, DonneeDepartement donneeDepartement, DonneeDepartementDetail donneeDepartementDetail, Statistique statistique) {
        this.primaryStage = primary;
        this.connexion = connexion;
        this.accueil = accueil;
        this.inscription = inscription;
        this.compte = compte;
        this.main = main;
        this.donneeDepartement = donneeDepartement;
        this.donneeDepartementDetail = donneeDepartementDetail;
        this.statistique = statistique;

        this.userDAO = new UserDAO();
        this.communeDAO = new CommuneDAO();
        this.aeroportDAO = new AeroportDAO();
        this.gareDAO = new GareDAO();
        this.departementDAO = new DepartementDAO();
        this.anneeDAO = new AnneeDAO();
        this.anneeCommuneDAO = new AnneeCommuneDAO();
    
        long startTime, endTime;

        startTime = System.currentTimeMillis();
        this.departementFileAccess = new DepartementFileAccess();
        endTime = System.currentTimeMillis();
        System.out.println("departementFileAccess - Execution time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        this.userFileAccess = new UserFileAccess();
        endTime = System.currentTimeMillis();
        System.out.println("userFileAccess - Execution time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        this.communeFileAccess = new CommuneFileAccess();
        endTime = System.currentTimeMillis();
        System.out.println("communeFileAccess - Execution time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        this.gareFileAccess = new GareFileAccess();
        endTime = System.currentTimeMillis();
        System.out.println("gareFileAccess - Execution time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        this.aeroportFileAccess = new AeroportFileAccess();
        endTime = System.currentTimeMillis();
        System.out.println("aeroportFileAccess - Execution time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        this.anneeFileAccess = new AnneeFileAccess();
        endTime = System.currentTimeMillis();
        System.out.println("anneeFileAccess - Execution time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        this.anneeCommuneFileAccess = new AnneeCommuneFileAccess();
        endTime = System.currentTimeMillis();
        System.out.println("anneeCommuneFileAccess - Execution time: " + (endTime - startTime) + "ms");
        this.communes = this.communeFileAccess.getCommunes();

        
        this.CompteAdminScene = CompteAdminScene;
        this.CompteAdminScene.init(this, userFileAccess);

        this.donnee = donnee;
        this.donnee.init(this, communeFileAccess, this.role);
        this.donneeDepartementDetail.init(this, communeFileAccess, this.role, aeroportFileAccess);

        this.donneeDetailVue = donneeDetailVue;
        initEventHandlers();
    }

    /**
     * Méthode pour update les gestionnaires d'événements
     */
    public void updateAppController() {
        initEventHandlers();
    }
 
    /**
     * Méthode pour initialiser les gestionnaires d'événements
     */
    private void initEventHandlers() {
        // gestion des événements de la classe Connexion
        this.connexion.getConnexionButton().setOnAction(this);
        this.connexion.getInscriptionButton().setOnAction(this);
        this.connexion.getMotDePasseOublieButton().setOnAction(this);

        // gestion des événements de la classe Accueil
        this.accueil.getNavBarre().getcompteButton().setOnAction(this);
        this.accueil.getNavBarre().getdepartementButton().setOnAction(this);
        this.accueil.getNavBarre().getDonneesButton().setOnAction(this);
        this.accueil.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.accueil.getNavBarre().getAccueilButton().setOnAction(this);
        this.accueil.getNavBarre().getStatistiqueButton().setOnAction(this);
        this.accueil.getNotion().setOnAction(this);
        this.accueil.getNavBarre().getStatistiqueButton().setOnAction(this);

        // gestion des événements de la classe Inscription
        this.inscription.getInscriptionButton().setOnAction(this);
        this.inscription.getConnexionButton().setOnAction(this);

        // gestion des événements de la classe Compte
        this.compte.getNavBarre().getcompteButton().setOnAction(this);
        this.compte.getNavBarre().getdepartementButton().setOnAction(this);
        this.compte.getNavBarre().getDonneesButton().setOnAction(this);
        this.compte.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.compte.getNavBarre().getAccueilButton().setOnAction(this);
        this.compte.getNavBarre().getStatistiqueButton().setOnAction(this);
        this.compte.getModificationButton().setOnAction(this);
        this.compte.getSupprimerButton().setOnAction(this);
        this.compte.getListeCompteButton().setOnAction(this);

        // gestion des événements de la classe CompteAdminScene
        this.CompteAdminScene.getNavBarre().getcompteButton().setOnAction(this);
        this.CompteAdminScene.getNavBarre().getdepartementButton().setOnAction(this);
        this.CompteAdminScene.getNavBarre().getDonneesButton().setOnAction(this);
        this.CompteAdminScene.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.CompteAdminScene.getNavBarre().getAccueilButton().setOnAction(this);
        this.CompteAdminScene.getNavBarre().getStatistiqueButton().setOnAction(this);
        this.CompteAdminScene.getAjouterButton().setOnAction(this);

        // gestion des événements de la classe Donnee
        this.donnee.getNavBarre().getcompteButton().setOnAction(this);
        this.donnee.getNavBarre().getdepartementButton().setOnAction(this);
        this.donnee.getNavBarre().getDonneesButton().setOnAction(this);
        this.donnee.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.donnee.getNavBarre().getAccueilButton().setOnAction(this);
        this.donnee.getNavBarre().getStatistiqueButton().setOnAction(this);
        this.donnee.getExportDataButton().setOnAction(this);
        this.donnee.getSearchField().setOnAction(this);
        this.donnee.getPrixField().setOnAction(this);
        this.donnee.getTri1().setOnAction(this);
        this.donnee.getTri2().setOnAction(this);
        this.donnee.getTri3().setOnAction(this);
        this.donnee.getTri4().setOnAction(this);
        this.donnee.getTri5().setOnAction(this);
        this.donnee.getTri6().setOnAction(this);

        // gestion des événements de la classe DonneeDetailVue
        this.donneeDetailVue.getNavBarre().getcompteButton().setOnAction(this);
        this.donneeDetailVue.getNavBarre().getdepartementButton().setOnAction(this);
        this.donneeDetailVue.getNavBarre().getDonneesButton().setOnAction(this);
        this.donneeDetailVue.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.donneeDetailVue.getNavBarre().getAccueilButton().setOnAction(this);
        this.donneeDetailVue.getNavBarre().getStatistiqueButton().setOnAction(this);
        this.donneeDetailVue.getComboBox().setOnAction(this);
        this.donneeDetailVue.getExportDataButton().setOnAction(this);
        this.donneeDetailVue.getAjouterGare().setOnAction(this);
        this.donneeDetailVue.getAjouterAeroport().setOnAction(this);

        //gestion des événements de la classe DonneeDetailVue
        this.donneeDepartement.getNavBarre().getcompteButton().setOnAction(this);
        this.donneeDepartement.getNavBarre().getdepartementButton().setOnAction(this);
        this.donneeDepartement.getNavBarre().getDonneesButton().setOnAction(this);
        this.donneeDepartement.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.donneeDepartement.getNavBarre().getAccueilButton().setOnAction(this);
        this.donneeDepartement.getNavBarre().getStatistiqueButton().setOnAction(this);
        this.donneeDepartement.getFinistere().setOnAction(this);
        this.donneeDepartement.getIlleEtVilaine().setOnAction(this);
        this.donneeDepartement.getCoteDArmor().setOnAction(this);
        this.donneeDepartement.getMorbihan().setOnAction(this);
        this.donneeDepartement.getExportButton().setOnAction(this);

        // gestion des événements des boutons de la classe DonneeDepartementDetail
        this.donneeDepartementDetail.getNavBarre().getcompteButton().setOnAction(this);
        this.donneeDepartementDetail.getNavBarre().getdepartementButton().setOnAction(this);
        this.donneeDepartementDetail.getNavBarre().getDonneesButton().setOnAction(this);
        this.donneeDepartementDetail.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.donneeDepartementDetail.getNavBarre().getAccueilButton().setOnAction(this);
        this.donneeDepartementDetail.getNavBarre().getStatistiqueButton().setOnAction(this);
        this.donneeDepartementDetail.getAjouterAeroport().setOnAction(this);

        // gestion des événements de la classe Statistique
        this.statistique.getNavBarre().getcompteButton().setOnAction(this);
        this.statistique.getNavBarre().getdepartementButton().setOnAction(this);
        this.statistique.getNavBarre().getDonneesButton().setOnAction(this);
        this.statistique.getNavBarre().getDeconnexionButton().setOnAction(this);
        this.statistique.getNavBarre().getAccueilButton().setOnAction(this);
        this.statistique.getNavBarre().getStatistiqueButton().setOnAction(this);
        this.statistique.getButton1().setOnAction(this);
        this.statistique.getButton2().setOnAction(this);
    }

    /**
     * Méthode pour gérer les évévenement de l'application
     * @param event Evénement de l'application
     */
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
        } else if ((source == this.accueil.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.compte.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.CompteAdminScene.getNavBarre().getDeconnexionButton() && this.estConnecte) ||  (source == this.donnee.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.donneeDetailVue.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.donneeDepartement.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.donneeDepartementDetail.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.statistique.getNavBarre().getDeconnexionButton() && this.estConnecte)){
            boutonDeconnexionNavBarreClick();
        } else if (source == this.accueil.getNavBarre().getcompteButton() && this.estConnecte || source == this.compte.getNavBarre().getcompteButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getcompteButton() && this.estConnecte  || source == this.donnee.getNavBarre().getcompteButton() && this.estConnecte || source == this.donneeDetailVue.getNavBarre().getcompteButton() && this.estConnecte || source == this.donneeDepartement.getNavBarre().getcompteButton() && this.estConnecte || source == this.donneeDepartementDetail.getNavBarre().getcompteButton() && this.estConnecte || source == this.statistique.getNavBarre().getcompteButton() && this.estConnecte) {
            boutonCompteNavBarreClick();
        } else if (source == this.accueil.getNavBarre().getdepartementButton() && this.estConnecte || source == this.compte.getNavBarre().getdepartementButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getdepartementButton() && this.estConnecte ||  source == this.donnee.getNavBarre().getdepartementButton() && this.estConnecte || source == this.donneeDetailVue.getNavBarre().getdepartementButton() && this.estConnecte || source == this.donneeDepartement.getNavBarre().getdepartementButton() && this.estConnecte || source == this.donneeDepartementDetail.getNavBarre().getdepartementButton() && this.estConnecte || source == this.statistique.getNavBarre().getdepartementButton() && this.estConnecte) {
            this.estdepartement = true;
            boutonDepartementNavBarreClick();
        } else if (source == this.accueil.getNavBarre().getDonneesButton() && this.estConnecte || source == this.compte.getNavBarre().getDonneesButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getDonneesButton() && this.estConnecte || source == this.donnee.getNavBarre().getDonneesButton() && this.estConnecte || source == this.donneeDetailVue.getNavBarre().getDonneesButton() && this.estConnecte || source == this.donneeDepartement.getNavBarre().getDonneesButton() && this.estConnecte || source == this.donneeDepartementDetail.getNavBarre().getDonneesButton() && this.estConnecte || source == this.statistique.getNavBarre().getDonneesButton() && this.estConnecte){
            this.estdepartement = false;
            boutonDonneesNavBarreClick();
        } else if (source == this.accueil.getNotion()) {
            boutonNotionClick();
        } else if (source == this.accueil.getNavBarre().getAccueilButton() && this.estConnecte || source == this.compte.getNavBarre().getAccueilButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getAccueilButton() && this.estConnecte ||  source == this.donnee.getNavBarre().getAccueilButton() && this.estConnecte || source == this.donneeDetailVue.getNavBarre().getAccueilButton() && this.estConnecte || source == this.donneeDepartement.getNavBarre().getAccueilButton() && this.estConnecte || source == this.donneeDepartementDetail.getNavBarre().getAccueilButton() && this.estConnecte || source == this.statistique.getNavBarre().getAccueilButton() && this.estConnecte){
            boutonAccueilNavBarreClick();
        } else if (source == this.compte.getModificationButton() && this.estConnecte) {
            modifierUtilisateur();
        } else if (source == this.compte.getSupprimerButton() && this.estConnecte) {
            boutonSupprimerClick();
        } else if (source == this.compte.getListeCompteButton()) {
            boutonListeCompteClick();
        } else if (source == this.CompteAdminScene.getAjouterButton()){
            inscrireUtilisateurAdmin();
        } else if (source == this.donneeDetailVue.getExportDataButton()) {
            exportDataCommune();
        } else if (source == this.donnee.getExportDataButton()) {
            exportDataBase();
        } else if (source == this.donneeDepartement.getExportButton()) {
            exportDataDepartement();
        } else if (source == this.donneeDepartement.getFinistere()) {
            boutonDepartementClick("29");
        } else if (source == this.donneeDetailVue.getAjouterGare()) {
            System.out.println("Ajouter Gare");
            ajouterGare(this.donneeDetailVue.getCodeCommune().getText());
        } else if (source == this.donneeDetailVue.getAjouterAeroport() || source == this.donneeDepartementDetail.getAjouterAeroport()) {
            if (source == this.donneeDetailVue.getAjouterAeroport()) ajouterAeroport(this.donneeDetailVue.getCodeCommune().getText(), this.estdepartement);
            else if (source == this.donneeDepartementDetail.getAjouterAeroport()) ajouterAeroport(this.donneeDepartementDetail.getDepartement().getIdDep(), this.estdepartement);
        } else if (source == this.donneeDepartement.getCoteDArmor()) {
            boutonDepartementClick("22");
        } else if (source == this.donneeDepartement.getIlleEtVilaine()) {
            boutonDepartementClick("35");
        } else if (source == this.donneeDepartement.getMorbihan()) {
            boutonDepartementClick("56");
        } else if (source == this.accueil.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.compte.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getStatistiqueButton() && this.estConnecte ||  source == this.donnee.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.donneeDetailVue.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.donneeDepartement.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.donneeDepartementDetail.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.statistique.getNavBarre().getStatistiqueButton() && this.estConnecte){
            boutonStatistiqueNavBarreClick("0");
            this.statistique.resetToggle();
        } else if (source == this.statistique.getButton1() || source == this.statistique.getButton2()) {
            if (source == this.statistique.getButton1()) {
                boutonStatistiqueNavBarreClick(this.statistique.getButton1().getId());
            } else if (source == this.statistique.getButton2()) {
                boutonStatistiqueNavBarreClick(this.statistique.getButton2().getId());
            }
        } else {
            if (source instanceof Button) {
                Button sources = (Button) event.getSource();
                String sourceId = sources.getId();
                this.idCommune = sourceId;
    
                if (this.userDAO.exists(sourceId)) {
                    boutonSupprimerClickAdmin(sourceId);
                    boutonListeCompteClick();
                    boutonListeCompteClick();
                } else if (this.communeDAO.exists(sourceId)) {
                    boutonInfoClick(sourceId);
                    this.donneeDetailVue.getComboBox().setValue(null);
                    this.donneeDetailVue.resetValues();
                } else if (this.gareDAO.exist(sourceId)) {
                    String codeCommune = this.gareFileAccess.getGare(sourceId).getLaCommune();
                    this.estdepartement = false;
                    boutonSupprimerGareClick(sourceId);
                    boutonInfoClick(codeCommune);
                    boutonInfoClick(codeCommune);
                    updateAppController();
                } else if (this.aeroportDAO.exist(sourceId)) {
                    boutonSupprimerAeroportClick(sourceId);
                    if (this.estdepartement) {
                        boutonDepartementClick(this.donneeDepartementDetail.getDepartement().getIdDep());
                    } else {
                        boutonInfoClick(this.donneeDetailVue.getCodeCommune().getText());
                        boutonInfoClick(this.donneeDetailVue.getCodeCommune().getText());
                    }
                    updateAppController();
                }
            } else if (source instanceof ComboBox) {
                ComboBox sources = (ComboBox) event.getSource();
                if (sources.getValue() == null) {
                    return;
                } else {
                    String selectedAction = sources.getValue().toString();
                    this.annee = selectedAction;
                    updateAnnee(selectedAction);
                }
            } else if (source instanceof TextField) {
                TextField sources = (TextField) event.getSource();
                if (sources.getId().equals("searchField")) {
                    if(sources.getText().isEmpty()){
                        this.donnee.setCommuneTable(communes);
                    } else if (!sources.getText().matches(".*\\d.*")) {
                        this.donnee.getErrorLabel().setText("");
                        if (this.communeDAO.findByNomCommune(sources.getText()).size() > 0) {
                            this.donnee.setCommuneTable(this.communeDAO.findByNomCommune(sources.getText()));
                        } else if (this.communeDAO.findByCodePostal(sources.getText()) != null) {
                            this.donnee.getSearchField().clear();
                            this.donnee.setCommuneTable(communes);
                        } else if (this.communeDAO.findByNomCommune(sources.getText()).size() == 0) {
                            this.donnee.getErrorLabel().setText("Aucun résultat trouvé");
                            this.donnee.getSearchField().clear();
                            this.donnee.setCommuneTable(communes);
                        }
                        
                    } else {
                        // Gérer le cas où le texte contient des chiffres
                        this.donnee.getErrorLabel().setText("Erreur de syntaxe");
                        this.donnee.getSearchField().clear();
                        this.donnee.setCommuneTable(communes);
                    }
                }
            } else if (source instanceof CheckBox) {
                CheckBox sources = (CheckBox) event.getSource();
                if (sources.getId().equals("35") && sources.isSelected() && !this.donnee.getTri2().isSelected() && !this.donnee.getTri3().isSelected() && !this.donnee.getTri4().isSelected() && !this.donnee.getTri5().isSelected() && !this.donnee.getTri6().isSelected() || this.donnee.getTri1().isSelected()) {
                    this.querry = "SELECT * FROM COMMUNE WHERE leDepartement = '35'";
                    this.donnee.setCommuneTable(this.communeDAO.findWithQuerry(this.querry));
                } else if (sources.getId().equals("56") && sources.isSelected() && !this.donnee.getTri1().isSelected() && !this.donnee.getTri3().isSelected() && !this.donnee.getTri4().isSelected() && !this.donnee.getTri5().isSelected() && !this.donnee.getTri6().isSelected() || this.donnee.getTri2().isSelected()){
                    this.querry = "SELECT * FROM COMMUNE WHERE leDepartement = '56'";
                    this.donnee.setCommuneTable(this.communeDAO.findWithQuerry(this.querry));
                } else if (sources.getId().equals("29") && sources.isSelected() && !this.donnee.getTri1().isSelected() && !this.donnee.getTri2().isSelected() && !this.donnee.getTri4().isSelected() && !this.donnee.getTri5().isSelected() && !this.donnee.getTri6().isSelected() || this.donnee.getTri3().isSelected()){
                    this.querry = "SELECT * FROM COMMUNE WHERE leDepartement = '29'";
                    this.donnee.setCommuneTable(this.communeDAO.findWithQuerry(this.querry));
                } else if (sources.getId().equals("22") && sources.isSelected() && !this.donnee.getTri1().isSelected() && !this.donnee.getTri2().isSelected() && !this.donnee.getTri3().isSelected() && !this.donnee.getTri5().isSelected() && !this.donnee.getTri6().isSelected() || this.donnee.getTri4().isSelected()){
                    this.querry = "SELECT DISTINCT * FROM COMMUNE WHERE leDepartement = '22'";
                    this.donnee.setCommuneTable(this.communeDAO.findWithQuerry(this.querry));
                } else if (sources.getId().equals("Gare") && sources.isSelected() && !this.donnee.getTri1().isSelected() && !this.donnee.getTri2().isSelected() && !this.donnee.getTri3().isSelected() && !this.donnee.getTri4().isSelected() && !this.donnee.getTri6().isSelected() || this.donnee.getTri5().isSelected()){
                    this.querry = "SELECT * FROM Commune JOIN Gare ON Commune.idCommune = Gare.laCommune ORDER BY Commune.idCommune";
                    this.donnee.setCommuneTable(this.communeDAO.findWithQuerry(this.querry));
                } else if (sources.getId().equals("prix") && sources.isSelected() && !this.donnee.getTri1().isSelected() && !this.donnee.getTri2().isSelected() && !this.donnee.getTri3().isSelected() && !this.donnee.getTri4().isSelected() && !this.donnee.getTri5().isSelected() || this.donnee.getTri6().isSelected()){
                    if(this.donnee.getPrixField().getText().isEmpty()){
                        this.donnee.getErrorLabel().setText("Champ vide");
                    } else if (this.donnee.getPrixField().getText().matches(".*\\d.*")) {
                        this.querry = "SELECT * FROM Commune JOIN DonneesAnnuelles ON Commune.idCommune = DonneesAnnuelles.laCommune WHERE DonneesAnnuelles.lAnnee = 2021 AND DonneesAnnuelles.prixM2Moyen < " + this.donnee.getPrixField().getText() + " ORDER BY DonneesAnnuelles.prixM2Moyen";
                        this.donnee.setCommuneTable(this.communeDAO.findWithQuerry(this.querry));
                        this.donnee.getErrorLabel().setText("");
                        this.donnee.getPrixField().clear();
                    } else {
                        this.donnee.getErrorLabel().setText("Erreur de syntaxe");
                    }
                } else if (!this.donnee.getTri1().isSelected() && !this.donnee.getTri2().isSelected() && !this.donnee.getTri3().isSelected() && !this.donnee.getTri4().isSelected() && !this.donnee.getTri5().isSelected() && !this.donnee.getTri6().isSelected()) {
                    this.donnee.setCommuneTable(communes);
                    this.donnee.getErrorLabel().setText("");
                }
            }
        }
    } 

    /**
     * Méthode pour afficher la vue de statistique
     * @param id valeur du bouton cliqué pour afficher la donnée souhaitée
     */
    public void boutonStatistiqueNavBarreClick(String id) {
        this.statistique.resetToggle();
        Pane root = this.statistique.creerRootStatistique(id);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
    }

    /**
     * methode pour update l'affichage de la vue de statistique
     * @param source valeur du bouton cliqué pour afficher la donnée souhaitée
     */
    public void changeStatistique(String source) {
        boutonStatistiqueNavBarreClick(source);
    }

    /**
     * methode pour supprier un aerport de la base de donnée et de l'affichage
     * @param sourceId nom de l'aeroport à supprimer
     */
    public void boutonSupprimerAeroportClick(String sourceId) {
        this.aeroportDAO.delete(this.aeroportFileAccess.getAeroportByNom(sourceId), "");
        this.aeroportFileAccess.setList();
    }

    /**
     * methode pour ajouter une gare à la base de donnée et à l'affichage
     * @param codeCommune code de la commune de la gare a ajouter
     */
    public void ajouterGare(String codeCommune) {
        Gare gare = new Gare("a","0","0", codeCommune);
        this.gareDAO.create(gare);
        this.gareFileAccess.setList();
        this.donneeDetailVue.setGareTable(this.gareDAO.findWithQuerry("SELECT * FROM Gare WHERE laCommune = '" + codeCommune + "'"));
        updateAppController();
    }

    /**
     * methode pour ajouté un aeroport à la base de donnée et à l'affichage
     * @param codeDepartement code de la commune de l'aeroport a ajouter
     * @param isDepartement boolean pour savoir si l'action viens de la vue de département ou de commune
     */
    public void ajouterAeroport(String codeDepartement, boolean isDepartement) {
        if (isDepartement) {
            Aeroport aeroport = new Aeroport(codeDepartement, "nom","adresse" );
            this.aeroportDAO.create(aeroport);
            this.aeroportFileAccess.setList();
            ArrayList<Aeroport> aeroports = this.aeroportDAO.findWithQuerry("SELECT * FROM Aeroport WHERE leDepartement = '" + codeDepartement + "'");
            this.donneeDepartementDetail.setAeroportTable(aeroports);
            updateAppController();

        } else {
            Aeroport aeroport = new Aeroport(this.communeFileAccess.getCommuneById(codeDepartement).getLeDepartement(), "nom","adresse" );
            this.aeroportDAO.create(aeroport);
            this.aeroportFileAccess.setList();
            ArrayList<Aeroport> aeroports = this.aeroportDAO.findWithQuerry("SELECT * FROM Aeroport WHERE leDepartement = '" + this.communeFileAccess.getCommuneById(codeDepartement).getLeDepartement() + "'");
            this.donneeDetailVue.setAeroportTable(aeroports);
            updateAppController();
        }
    }

    /**
     * methode pour afficher la vue du détail d'un département
     * @param id le departement a afficher
     */
    public void boutonDepartementClick(String id) {
        this.querry = "SELECT * FROM COMMUNE WHERE leDepartement = '" + id + "'";
        this.donneeDepartementDetail.setCommuneTable(this.communeDAO.findWithQuerry(this.querry));
        Pane root = this.donneeDepartementDetail.creerRootDonnee(estConnecte, role, this.departementFileAccess.getDepartementById(id), this.aeroportFileAccess, this);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
    }

    /**
     * methode pour afficher la vue des donnees du département
     */
    public void boutonDepartementNavBarreClick() {
        Pane root = this.donneeDepartement.creerRootDonnee(estConnecte, role,  this.aeroportFileAccess, this.gareFileAccess, this.communeFileAccess);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
    }

    /**
     * methode pour exporter les données des departements en csv
     */
    public void exportDataDepartement() {
        this.departementFileAccess.writeDepartementToCSVFile("Departement");
    }

    /**
     * methode pour exporter les données de la base de donnée d'une commune en csv
     */
    public void exportDataCommune() {
        this.anneeCommuneFileAccess.writeCommuneToCSVFile("Commune", this.idCommune);
    }
    
    /**
     * methode pour exporter les données de la base de donnée en csv
     */
    public void exportDataBase() {
        this.anneeCommuneFileAccess.writeDonneeToCSVFile("BaseDeDonnee");
    }

    /**
     * methode pour afficher la vue d'une commune en détaille 
     * @param sourceId nom de la commune à afficher
     */
    public void boutonInfoClick(String sourceId) {
        this.aeroportFileAccess.setList();
        this.gareFileAccess.setList();
        this.donneeDetailVue.setLaCommune(sourceId, this.communeFileAccess, this.departementFileAccess, this, this.role);
        this.donneeDetailVue.init(this, this.role, sourceId, this.gareFileAccess, this.aeroportFileAccess, this.communeFileAccess);
        Pane root = this.donneeDetailVue.creerRootDonnee(estConnecte, role);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
    }

    /**
     * methode pour modifier la vue d'une commune selon l'année selectionnée
     * @param annee année selectionnée
     */
    public void updateAnnee(String annee) {
        this.donneeDetailVue.setLaCommune(this.idCommune, this.communeFileAccess, this.departementFileAccess, this.annee, this.anneeCommuneFileAccess, this.anneeFileAccess, this, this.role, this.gareDAO);
        this.donneeDetailVue.init(this, this.role, this.idCommune, this.gareFileAccess, this.aeroportFileAccess, this.communeFileAccess);
        Pane root = this.donneeDetailVue.creerRootDonnee(estConnecte, role);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
    }

    /** 
     * methode pour acceder a la page notion du projet
     */
    public void boutonNotionClick() {
        try {
            this.main.getHostServices().showDocument("https://a1-2-sae2.notion.site/Attractivit-des-communes-bretonnes-e554c010050d45e996431ba36e920265");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode pour afficher la vue de l'accueil
     */
    public void boutonConnexionConnexionClick() {
        connecterUtilisateur();
        if (this.estConnecte) {
            Pane root = this.accueil.creerRootAccueil();
            Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
            scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        }
        updateAppController();

    }

    /**
     * methode pour afficher la vue de connexion après une deconnexion
     */
    public void boutonDeconnexionNavBarreClick() {
        deconnecterUtilisateur();
        Pane root = this.connexion.creerRootConnexion();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();

    }

    /**
     * methode pour afficher la vue d'inscription 
     */
    public void boutonInscriptionConnexionClick() {
        Pane root = this.inscription.creerRootInscription();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();

    }

    /**
     * methode pour afficher la vue du compte de l'utilisateur
     */
    public void boutonCompteNavBarreClick() {
        this.user = userDAO.findByLoginPwd(this.user.getLogin(), this.user.getPwd());
        Pane root = this.compte.creerRootCompte(this.user.getRole(), this.user.getLogin(), this.user.getPwd(), this.role);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
    }

    /**
     * methode pour afficher la vue de connexion après une inscription reussi 
     */
    public void boutonInscriptionInscriptionClick() {
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
        updateAppController();

    }

    /**
     * methode pour afficher la vue de connexion après une inscription reussi 
     */
    public void boutonConnexionInscriptionClick() {
        Pane root = this.connexion.creerRootConnexion();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();

    }

    /**
     * methode pour afficher la vue de l'accueil
     */
    private void boutonAccueilNavBarreClick() {
        Pane root = this.accueil.creerRootAccueil();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();

    }
    
    /**
     * methode pour afficher les donnes et récuperer du compte de l'utilisateur
     */
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
            updateAppController();
        }
    }

    /**
     * methode pour deconnecter l'utilisateur
     */
    public void deconnecterUtilisateur() {
        this.compte.setNavBarre(this.compte.getNavBarre().refresh(this.user, this.role));
        this.estConnecte = false;
        updateAppController();
    }

    /**
     * methode pour l'inscription d'un utilisateur
     */
    public void inscrireUtilisateur() {
        User user = new User(this.inscription.getIndentField().getText(), this.inscription.getPasswordField().getText());
        userDAO.create(user);
    }

    /**
     * methode pour l'inscription d'un utilisateur du côté administateur
     */
    public void inscrireUtilisateurAdmin() {
        if (!this.userDAO.exists(this.CompteAdminScene.getLoginField().getText()) && !this.CompteAdminScene.getLoginField().getText().isEmpty() && !this.CompteAdminScene.getPasswordField().getText().isEmpty()){
            User user = new User(this.CompteAdminScene.getLoginField().getText(), this.CompteAdminScene.getPasswordField().getText());
            this.userDAO.create(user);
            this.userFileAccess.setList();
            boutonListeCompteClick();
            boutonListeCompteClick();
        } else {
            this.CompteAdminScene.getErrorLabel().setText("Identifiant déjà utilisé");
        }
    }

    /**
     * methode pour verifier si un utilisateur existe
     * @return l'utilisateur si il existe sinon null
     */
    public User utilisateurExiste() {
        if (userDAO.findByLoginPwd(this.connexion.getIndentField().getText(), this.connexion.getPasswordField().getText()) == null) {
            return null;
        } else {
            return userDAO.findByLoginPwd(this.connexion.getIndentField().getText(), this.connexion.getPasswordField().getText());
        }
    }

    /**
     * methode pour modifier un utilisateur
     */
    public void modifierUtilisateur() {
        if(!this.userDAO.exists(this.compte.getidentField().getText()) && !this.compte.getidentField().getText().isEmpty() && !this.compte.getPasswordField().getText().isEmpty()){
            User user = new User(this.compte.getidentField().getText(), this.compte.getPasswordField().getText());
            this.userDAO.update(user, this.compte.getidentLabel().getText(), this.compte.getRoleLabel().getText());
            this.userFileAccess.setList();
            boutonCompteNavBarreClick();
        } else {
            this.compte.getErrorLabel().setText("Identifiant déjà utilisé");
        }
    }

    /**
     * methode pour supprimer un utilisateur
     */
    public void boutonSupprimerClick() {
        this.user = new User(this.compte.getidentField().getText(), this.compte.getPasswordField().getText());
        this.userDAO.delete(user, this.compte.getidentLabel().getText());
        deconnecterUtilisateur();
        boutonConnexionInscriptionClick();
    }

    /**
     * methode pour supprimer un utilisateur du côté administrateur
     * @param user nom de l'utilisateur à supprimer
     */
    public void boutonSupprimerClickAdmin(String user) {
        this.userFileAccess.deleteUser(this.userFileAccess.getUser(user));
    }

    /**
     * methode pour supprimer une gare de la base de donnée et de l'affichage
     * @param sourceId cpde de la gare à supprimer
     */
    public void boutonSupprimerGareClick(String sourceId) {
        this.gareDAO.delete(this.gareFileAccess.getGare(sourceId), "");
        this.gareFileAccess.setList();
    }

    /**
     * methode pour mettre à jour le nom d'une gare
     * @param gare gare à modifier
     * @param newValue nouveau nom de la gare
     */
    public void updateGareNom(Gare gare, String newValue) {
        this.gareDAO.updateNom(gare.getCodeGare(), newValue);
        this.gareFileAccess.setList();
        this.donneeDetailVue.setLaCommune(gare.getLaCommune(), this.communeFileAccess, this.departementFileAccess, this.annee, this.anneeCommuneFileAccess, this.anneeFileAccess, this, this.role, this.gareDAO);
        boutonInfoClick(gare.getLaCommune());
    }

    /**
     * methode pour afficher la vue de la liste des comptes coté administrateur
     */
    public void boutonListeCompteClick() {
        // this.user = userDAO.findByLoginPwd(this.user.getLogin(), this.user.getPwd());
        this.userFileAccess.setList();
        Pane root = this.CompteAdminScene.creerRootCompte();
        this.CompteAdminScene.init(this, userFileAccess);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
    }

    /**
     * methode pour mettre à jour le login d'un utilisateur
     * @param initLogin login initial de l'utilisateur
     * @param newLogin nouveau login de l'utilisateur
     */
    public void updateLogin(String initLogin, String newLogin) {
        if (this.userDAO.exists(newLogin)) {
            this.userFileAccess.setList();
            boutonListeCompteClick();
            boutonListeCompteClick();
            return;
        } else {
            this.userDAO.updateLogin(initLogin, newLogin);
            this.userFileAccess.setList();
            boutonListeCompteClick();
            boutonListeCompteClick();
        }

    }

    /**
     * methode pour mettre à jour le mot de passe d'un utilisateur
     * @param user utilisateur à modifier
     * @param newPwd nouveau mot de passe de l'utilisateur
     */
    public void updatePwd(User user, String newPwd) {
        String login = user.getLogin();
        this.userDAO.updatePwd(login, newPwd);
        this.userFileAccess.setList();
        boutonListeCompteClick();
        boutonListeCompteClick();
    }

    /**
     * methode pour mettre à jour le role d'un utilisateur
     * @param user utilisateur à modifier
     * @param newRole nouveau role de l'utilisateur
     */
    public void updateRole(User user, String newRole) {
        String login = user.getLogin();
        this.userDAO.updateRole(login, newRole);
        this.userFileAccess.setList();
        boutonListeCompteClick();
        boutonListeCompteClick();
    }

    /**
     * methode pour afficher la vue des données des communes de la base deonnée
     */
    public void boutonDonneesNavBarreClick() {
        this.donnee.getSearchField().clear();
        resetCommuneTable();
        this.donnee.resetCheckBox();
        Pane root = this.donnee.creerRootDonnee(estConnecte, role);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
        this.donneeDetailVue.getComboBox().setValue(null);
        this.donneeDetailVue.resetValues();
    }

    /**
     * reset la value de la table des communes
     */
    public void resetCommuneTable() {
        this.donnee.setCommuneTable(communes);
    }

    /**
     * methode pour mettre à jour le fret d'une gare
     * @param gare gare à modifier
     * @param newValue nouvelle valeur de fret de la gare
     */
    public void updateGareFret(Gare gare, String newValue) {
        this.gareDAO.updateFret(gare.getCodeGare(), newValue);
        this.gareFileAccess.setList();
        this.donneeDetailVue.setLaCommune(gare.getLaCommune(), this.communeFileAccess, this.departementFileAccess, this.annee, this.anneeCommuneFileAccess, this.anneeFileAccess, this, this.role, this.gareDAO);
        boutonInfoClick(gare.getLaCommune());
    }

    /**
     * methode pour mettre à jour l'état d'une gare voyageur
     * @param gare gare à modifier
     * @param newValue nouvelle valeur de voyageur de la gare
     */
    public void updateGareVoyageur(Gare gare, String newValue) {
        this.gareDAO.updateVoyageur(gare.getCodeGare(), newValue);
        this.gareFileAccess.setList();
        this.donneeDetailVue.setLaCommune(gare.getLaCommune(), this.communeFileAccess, this.departementFileAccess, this.annee, this.anneeCommuneFileAccess, this.anneeFileAccess, this, this.role, this.gareDAO);
        boutonInfoClick(gare.getLaCommune());
    }

    /**
     * methode pour mettre à jour le nom d'un aeroport
     * @param rowValue aeroport à modifier
     * @param newValue nouveau nom de l'aeroport
     */
    public void updateAeroportNom(Aeroport rowValue, String newValue) {
        this.aeroportDAO.updateNom(rowValue.getNom(), newValue);
        this.aeroportFileAccess.setList();
        this.donneeDetailVue.setLaCommune(this.donneeDetailVue.getCodeCommune().getText(), this.communeFileAccess, this.departementFileAccess, this.annee, this.anneeCommuneFileAccess, this.anneeFileAccess, this, this.role, this.gareDAO);
        boutonInfoClick(this.donneeDetailVue.getCodeCommune().getText());
    }

    /**
     * methode pour mettre à jour l'adresse d'un aeroport
     * @param rowValue aeroport à modifier
     * @param newValue nouvelle adresse de l'aeroport
     */
    public void updateAeroportAdresse(Aeroport rowValue, String newValue) {
        this.aeroportDAO.updateAdresse(rowValue.getNom(), newValue);
        this.aeroportFileAccess.setList();
        this.donneeDetailVue.setLaCommune(this.donneeDetailVue.getCodeCommune().getText(), this.communeFileAccess, this.departementFileAccess, this.annee, this.anneeCommuneFileAccess, this.anneeFileAccess, this, this.role, this.gareDAO);
        boutonInfoClick(this.donneeDetailVue.getCodeCommune().getText());
    }
    
}
