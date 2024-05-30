package app.view;
import app.model.data.User;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class NavBarre extends GridPane{
    private Button compteButton;
    private Button carteButton;
    private Button donneesButton;
    private Button modifie;
    private Button deconnexion;
    private String role;

    public NavBarre() {
        this.compteButton = new Button("Compte");
        this.carteButton = new Button("Carte");
        this.donneesButton = new Button("Données");
        initNavBarre(false);
    }

    public NavBarre(User user, boolean role) {
        this.compteButton = new Button("Compte");
        this.carteButton = new Button("Carte");
        this.donneesButton = new Button("Données");
        this.modifie = new Button("Modifier");
        this.deconnexion = new Button("Déconnexion");
        this.role = user.getRole();
        if (role) {
            initNavBarre(true);
            System.out.println("Role : " + this.role);
        } else {
            initNavBarre(false);
            System.out.println("Role : " + this.role);
        }
    }

    public NavBarre(boolean estConnecte) {
        this.compteButton = new Button("Compte");
        this.carteButton = new Button("Carte");
        this.donneesButton = new Button("Données");
        this.modifie = new Button("Modifier");
        this.deconnexion = new Button("Déconnexion");
        initNavBarre(estConnecte);
    }

    public void initNavBarre(boolean estConnecte) {
        this.setHgap(30);

        this.compteButton = new Button("Compte");
        this.carteButton = new Button("Carte");
        this.donneesButton = new Button("Données");
        this.modifie = new Button("Modifier");
        this.deconnexion = new Button("Déconnexion");

        this.add(compteButton, 0, 0);
        this.add(carteButton, 1, 0);
        this.add(donneesButton, 2, 0);
        this.add(deconnexion, 19, 0);


        if (estConnecte) {
            this.add(modifie, 3, 0);
        }

        this.getStyleClass().add("nav-barre"); // Ajouter une classe CSS
        this.carteButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.compteButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.donneesButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.modifie.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.deconnexion.getStyleClass().add("my-button-nav-barre-deco"); // Ajouter une classe CSS

        this.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm()); // Ajouter le fichier CSS
    }

    public NavBarre refresh(User user, boolean role) {
        NavBarre newNavBarre = new NavBarre(user, role);
        return newNavBarre;
    }

    public NavBarre refresh(boolean role) {
        NavBarre newNavBarre = new NavBarre(role);
        return newNavBarre;
    }

    public Button getcompteButton() {
        return this.compteButton;
    }

    public Button getCarteButton() {
        return this.carteButton;
    }

    public Button getDonneesButton() {
        return this.donneesButton;
    }

    public Button getModifieButton() {
        return this.modifie;
    }

    public Button getDeconnexionButton() {
        return this.deconnexion;
    }
    
}