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
        Connexion vueConnexion = new Connexion(primaryStage);
        Accueil vueAccueil = new Accueil(primaryStage);
        Inscription vueInscription = new Inscription(primaryStage);
        Compte vueCompte = new Compte(primaryStage, "role", "ident", "password");
        CompteAdminScene vueCompteAdminScene = new CompteAdminScene(primaryStage);
        ModifierScene vueModifierScene = new ModifierScene(primaryStage); 
        DonneeCommune vueDonnee = new DonneeCommune(primaryStage);
        DonneeCommuneDetail vueDonneeDetailVue = new DonneeCommuneDetail(primaryStage);
        DonneeDepartement vuDonneeDepartement = new DonneeDepartement(primaryStage);
        DonneeDepartementDetail vueDonneeDepartementDetail = new DonneeDepartementDetail(primaryStage);
        new AppController(primaryStage, vueConnexion, vueAccueil, vueInscription, vueCompte, this, vueCompteAdminScene, vueModifierScene, vueDonnee, vueDonneeDetailVue, vuDonneeDepartement, vueDonneeDepartementDetail);
        primaryStage.setScene(vueConnexion.creerSceneConnexion());
        primaryStage.show();

    }
}

// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.web.WebEngine;
// import javafx.scene.web.WebView;
// import javafx.stage.Stage;

// import java.nio.file.Paths;

// public class Main extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         WebView webView = new WebView();
//         WebEngine webEngine = webView.getEngine();

//         // Assurez-vous de fournir le chemin correct vers votre fichier HTML
//         String localUrl = Paths.get("src/app/test.html").toUri().toString();
//         System.out.println("Loading URL: " + localUrl); // Affichez le chemin d'accès
//         webEngine.load(localUrl);

//         BorderPane root = new BorderPane();
//         root.setCenter(webView);

//         Scene scene = new Scene(root, 800, 600);
//         primaryStage.setTitle("Google Maps in JavaFX");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }