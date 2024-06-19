package app;
import app.controller.*;
import app.view.*;
import app.view.admin.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Méthode principale
     * @param args Arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /** 
     * Méthode de démarrage
     * @param primaryStage Scène principale
     * @throws Exception Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Connexion vueConnexion = new Connexion(primaryStage);
            Accueil vueAccueil = new Accueil(primaryStage);
            Inscription vueInscription = new Inscription(primaryStage);
            Compte vueCompte = new Compte(primaryStage, "role", "ident", "password");
            CompteAdminScene vueCompteAdminScene = new CompteAdminScene(primaryStage);
            DonneeCommune vueDonnee = new DonneeCommune(primaryStage);
            DonneeCommuneDetail vueDonneeDetailVue = new DonneeCommuneDetail(primaryStage);
            DonneeDepartement vuDonneeDepartement = new DonneeDepartement(primaryStage);
            DonneeDepartementDetail vueDonneeDepartementDetail = new DonneeDepartementDetail(primaryStage);
            Statistique vueStatistique = new Statistique(primaryStage);
            new AppController(primaryStage, vueConnexion, vueAccueil, vueInscription, vueCompte, this, vueCompteAdminScene, vueDonnee, vueDonneeDetailVue, vuDonneeDepartement, vueDonneeDepartementDetail, vueStatistique);
            primaryStage.setScene(vueConnexion.creerSceneConnexion());
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}