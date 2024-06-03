package app;
import app.controller.*;
import app.model.data.*;
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
        Modele modele = new Modele();
        Connexion vueConnexion = new Connexion(primaryStage);
        Accueil vueAccueil = new Accueil(primaryStage);
        Inscription vueInscription = new Inscription(primaryStage);
        Compte vueCompte = new Compte(primaryStage, "role", "ident", "password");
        CompteAdminScene vueCompteAdminScene = new CompteAdminScene(primaryStage);
        ModifierScene vueModifierScene = new ModifierScene(primaryStage); 
        Donnee vueDonnee = new Donnee(primaryStage);
        new AppController(primaryStage, modele, vueConnexion, vueAccueil, vueInscription, vueCompte, this, vueCompteAdminScene, vueModifierScene, vueDonnee);
        primaryStage.setScene(vueConnexion.creerSceneConnexion());
        primaryStage.show();

    }
}