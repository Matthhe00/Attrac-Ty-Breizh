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

public class AppController implements EventHandler<ActionEvent> {
    private Stage primaryStage;
    private Connexion connexion;
    private Accueil accueil;
    private Inscription inscription;
    private Compte compte;
    private UserDAO userDAO;
    private CommuneDAO communeDAO;
    private AeroportDAO aeroportDAO;
    private GareDAO gareDAO;
    private DepartementDAO departementDAO;
    private AnneeDAO anneeDAO;
    private AnneeCommuneDAO anneeCommuneDAO;
    private User user;
    private boolean estConnecte = false, role = false, estdepartement = false;
    private String annee, idCommune, querry;
    private Main main;
    private UserFileAccess userFileAccess;
    private AeroportFileAccess aeroportFileAccess;
    private GareFileAccess gareFileAccess;
    private AnneeFileAccess anneeFileAccess;
    private AnneeCommuneFileAccess anneeCommuneFileAccess;
    private CommuneFileAccess communeFileAccess;
    private CompteAdminScene CompteAdminScene;
    private DonneeCommune donnee;
    private DonneeCommuneDetail donneeDetailVue;
    private DepartementFileAccess departementFileAccess;
    private ArrayList<Commune> communes;
    private DonneeDepartement donneeDepartement;
    private DonneeDepartementDetail donneeDepartementDetail;
    private Statistique statistique;
    

    // private AnneeFileAccess anneeFileAccess;

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

    public void updateAppController() {
        initEventHandlers();
    }
 
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
        this.accueil.getNotion().setOnAction(this);

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
        } else if ((source == this.accueil.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.compte.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.CompteAdminScene.getNavBarre().getDeconnexionButton() && this.estConnecte) ||  (source == this.donnee.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.donneeDetailVue.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.donneeDepartement.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.donneeDepartementDetail.getNavBarre().getDeconnexionButton() && this.estConnecte) || (source == this.statistique.getNavBarre().getDeconnexionButton() && this.estConnecte)){
            boutonDeconnexionNavBarreClick();
        } else if (source == this.accueil.getNavBarre().getcompteButton() && this.estConnecte || source == this.compte.getNavBarre().getcompteButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getcompteButton() && this.estConnecte  || source == this.donnee.getNavBarre().getcompteButton() && this.estConnecte || source == this.donneeDetailVue.getNavBarre().getcompteButton() && this.estConnecte || source == this.donneeDepartement.getNavBarre().getcompteButton() && this.estConnecte || source == this.donneeDepartementDetail.getNavBarre().getcompteButton() && this.estConnecte || source == this.statistique.getNavBarre().getcompteButton() && this.estConnecte) {
            boutonCompteNavBarreClick();
        } else if (source == this.accueil.getNavBarre().getdepartementButton() && this.estConnecte || source == this.compte.getNavBarre().getdepartementButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getdepartementButton() && this.estConnecte ||  source == this.donnee.getNavBarre().getdepartementButton() && this.estConnecte || source == this.donneeDetailVue.getNavBarre().getdepartementButton() && this.estConnecte || source == this.donneeDepartement.getNavBarre().getdepartementButton() && this.estConnecte || source == this.donneeDepartementDetail.getNavBarre().getdepartementButton() && this.estConnecte || source == this.statistique.getNavBarre().getdepartementButton() && this.estConnecte) {
            boutonDepartementNavBarreClick();
            this.estdepartement = true;
        } else if (source == this.accueil.getNavBarre().getDonneesButton() && this.estConnecte || source == this.compte.getNavBarre().getDonneesButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getDonneesButton() && this.estConnecte || source == this.donnee.getNavBarre().getDonneesButton() && this.estConnecte || source == this.donneeDetailVue.getNavBarre().getDonneesButton() && this.estConnecte || source == this.donneeDepartement.getNavBarre().getDonneesButton() && this.estConnecte || source == this.donneeDepartementDetail.getNavBarre().getDonneesButton() && this.estConnecte || source == this.statistique.getNavBarre().getDonneesButton() && this.estConnecte){
            boutonDonneesNavBarreClick();
            this.estdepartement = false;
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
            if (source == this.donneeDetailVue.getAjouterAeroport()) ajouterAeroport(this.donneeDetailVue.getCodeCommune().getText(), false);
            else if (source == this.donneeDepartementDetail.getAjouterAeroport()) ajouterAeroport(this.donneeDepartementDetail.getDepartement().getIdDep(), true);
        } else if (source == this.donneeDepartement.getCoteDArmor()) {
            boutonDepartementClick("22");
        } else if (source == this.donneeDepartement.getIlleEtVilaine()) {
            boutonDepartementClick("35");
        } else if (source == this.donneeDepartement.getMorbihan()) {
            boutonDepartementClick("56");
        } else if (source == this.accueil.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.compte.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.CompteAdminScene.getNavBarre().getStatistiqueButton() && this.estConnecte ||  source == this.donnee.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.donneeDetailVue.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.donneeDepartement.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.donneeDepartementDetail.getNavBarre().getStatistiqueButton() && this.estConnecte || source == this.statistique.getNavBarre().getStatistiqueButton() && this.estConnecte){
            boutonStatistiqueNavBarreClick();
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
                    boutonSupprimerGareClick(sourceId);
                    boutonInfoClick(codeCommune);
                    boutonInfoClick(codeCommune);
                    this.estdepartement = false;
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

    private void boutonStatistiqueNavBarreClick() {
        Pane root = this.statistique.creerRootStatistique(1);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
    }

    public void boutonSupprimerAeroportClick(String sourceId) {
        this.aeroportDAO.delete(this.aeroportFileAccess.getAeroportByNom(sourceId), "");
        this.aeroportFileAccess.setList();
        // this.donneeDetailVue.setAeroportTable(this.aeroportDAO.findWithQuerry("SELECT * FROM Aeroport WHERE leDepartement = '" + this.aeroportFileAccess.getAeroportByNom(sourceId).getLeDepartement() + "'"));
        // updateAppController();
    }

    public void ajouterGare(String codeCommune) {
        Gare gare = new Gare("a","0","0", codeCommune);
        this.gareDAO.create(gare);
        this.gareFileAccess.setList();
        this.donneeDetailVue.setGareTable(this.gareDAO.findWithQuerry("SELECT * FROM Gare WHERE laCommune = '" + codeCommune + "'"));
        updateAppController();
    }

    public void ajouterAeroport(String codeCommune, boolean isDepartement) {
        if (isDepartement) {
            Aeroport aeroport = new Aeroport(codeCommune, "nom","adresse" );
            this.aeroportDAO.create(aeroport);
            this.aeroportFileAccess.setList();
            ArrayList<Aeroport> aeroports = this.aeroportDAO.findWithQuerry("SELECT * FROM Aeroport WHERE leDepartement = '" + codeCommune + "'");
            this.donneeDepartementDetail.setAeroportTable(aeroports);
            updateAppController();

        } else {
            Aeroport aeroport = new Aeroport(this.communeFileAccess.getCommuneById(codeCommune).getLeDepartement(), "nom","adresse" );
            this.aeroportDAO.create(aeroport);
            this.aeroportFileAccess.setList();
            ArrayList<Aeroport> aeroports = this.aeroportDAO.findWithQuerry("SELECT * FROM Aeroport WHERE leDepartement = '" + this.communeFileAccess.getCommuneById(codeCommune).getLeDepartement() + "'");
            this.donneeDetailVue.setAeroportTable(aeroports);
            updateAppController();
        }
    }

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

    public void boutonDepartementNavBarreClick() {
        Pane root = this.donneeDepartement.creerRootDonnee(estConnecte, role,  this.aeroportFileAccess, this.gareFileAccess, this.communeFileAccess);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
    }

    public void exportDataDepartement() {
        this.departementFileAccess.writeDepartementToCSVFile("Departement");
    }

    public void exportDataCommune() {
        this.anneeCommuneFileAccess.writeCommuneToCSVFile("Commune", this.idCommune);
    }
    
    public void exportDataBase() {
        this.anneeCommuneFileAccess.writeDonneeToCSVFile("BaseDeDonnee");
    }

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

    public void boutonNotionClick() {
        try {
            this.main.getHostServices().showDocument("https://a1-2-sae2.notion.site/Attractivit-des-communes-bretonnes-e554c010050d45e996431ba36e920265");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public void boutonDeconnexionNavBarreClick() {
        deconnecterUtilisateur();
        Pane root = this.connexion.creerRootConnexion();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();

    }

    public void boutonInscriptionConnexionClick() {
        Pane root = this.inscription.creerRootInscription();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();

    }

    public void boutonCompteNavBarreClick() {
        this.user = userDAO.findByLoginPwd(this.user.getLogin(), this.user.getPwd());
        Pane root = this.compte.creerRootCompte(this.user.getRole(), this.user.getLogin(), this.user.getPwd(), this.role);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
    }

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

    public void boutonConnexionInscriptionClick() {
        Pane root = this.connexion.creerRootConnexion();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();

    }

    private void boutonAccueilNavBarreClick() {
        Pane root = this.accueil.creerRootAccueil();
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();

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
            updateAppController();
        }
    }

    public void deconnecterUtilisateur() {
        this.compte.setNavBarre(this.compte.getNavBarre().refresh(this.user, this.role));
        this.estConnecte = false;
        updateAppController();
    }

    public void inscrireUtilisateur() {
        user = new User(this.inscription.getIndentField().getText(), this.inscription.getPasswordField().getText());
        userDAO.create(user);
    }

    public void inscrireUtilisateurAdmin() {
        if (!this.userDAO.exists(this.CompteAdminScene.getLoginField().getText()) && !this.CompteAdminScene.getLoginField().getText().isEmpty() && !this.CompteAdminScene.getPasswordField().getText().isEmpty()){
            user = new User(this.CompteAdminScene.getLoginField().getText(), this.CompteAdminScene.getPasswordField().getText());
            this.userDAO.create(user);
            this.userFileAccess.setList();
            boutonListeCompteClick();
            boutonListeCompteClick();
        } else {
            this.CompteAdminScene.getErrorLabel().setText("Identifiant déjà utilisé");
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

    public void boutonSupprimerGareClick(String sourceId) {
        this.gareDAO.delete(this.gareFileAccess.getGare(sourceId), "");
        this.gareFileAccess.setList();
    }

    public void updateGareNom(Gare gare, String newValue) {
        this.gareDAO.updateNom(gare.getCodeGare(), newValue);
        this.gareFileAccess.setList();
        this.donneeDetailVue.setLaCommune(gare.getLaCommune(), this.communeFileAccess, this.departementFileAccess, this.annee, this.anneeCommuneFileAccess, this.anneeFileAccess, this, this.role, this.gareDAO);
        boutonInfoClick(gare.getLaCommune());
    }

    public void boutonListeCompteClick() {
        // this.user = userDAO.findByLoginPwd(this.user.getLogin(), this.user.getPwd());
        Pane root = this.CompteAdminScene.creerRootCompte();
        this.CompteAdminScene.init(this, userFileAccess);
        Scene scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); 
        scene.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm());
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        updateAppController();
    }

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

    public void resetCommuneTable() {
        this.donnee.setCommuneTable(communes);
    }

    public void updateGareFret(Gare gare, String newValue) {
        this.gareDAO.updateFret(gare.getCodeGare(), newValue);
        this.gareFileAccess.setList();
        this.donneeDetailVue.setLaCommune(gare.getLaCommune(), this.communeFileAccess, this.departementFileAccess, this.annee, this.anneeCommuneFileAccess, this.anneeFileAccess, this, this.role, this.gareDAO);
        boutonInfoClick(gare.getLaCommune());
    }

    public void updateGareVoyageur(Gare gare, String newValue) {
        this.gareDAO.updateVoyageur(gare.getCodeGare(), newValue);
        this.gareFileAccess.setList();
        this.donneeDetailVue.setLaCommune(gare.getLaCommune(), this.communeFileAccess, this.departementFileAccess, this.annee, this.anneeCommuneFileAccess, this.anneeFileAccess, this, this.role, this.gareDAO);
        boutonInfoClick(gare.getLaCommune());
    }

    public void updateAeroportNom(Aeroport rowValue, String newValue) {
        this.aeroportDAO.updateNom(rowValue.getNom(), newValue);
        this.aeroportFileAccess.setList();
        this.donneeDetailVue.setLaCommune(this.donneeDetailVue.getCodeCommune().getText(), this.communeFileAccess, this.departementFileAccess, this.annee, this.anneeCommuneFileAccess, this.anneeFileAccess, this, this.role, this.gareDAO);
        boutonInfoClick(this.donneeDetailVue.getCodeCommune().getText());
    }

    public void updateAeroportAdresse(Aeroport rowValue, String newValue) {
        this.aeroportDAO.updateAdresse(rowValue.getNom(), newValue);
        this.aeroportFileAccess.setList();
        this.donneeDetailVue.setLaCommune(this.donneeDetailVue.getCodeCommune().getText(), this.communeFileAccess, this.departementFileAccess, this.annee, this.anneeCommuneFileAccess, this.anneeFileAccess, this, this.role, this.gareDAO);
        boutonInfoClick(this.donneeDetailVue.getCodeCommune().getText());
    }
    
}
