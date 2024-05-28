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

    public NavBarre(boolean estConnecte, User user) {
        this.compteButton = new Button("Compte");
        this.carteButton = new Button("Carte");
        this.donneesButton = new Button("Données");
        this.modifie = new Button("Modifier");
        this.deconnexion = new Button("Déconnexion");
        this.role = user.getRole();
        initNavBarre(estConnecte);
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
        this.add(deconnexion, 3, 0);


        if (estConnecte && this.role == "admin") {
            this.add(modifie, 19, 0);
        }

        this.getStyleClass().add("nav-barre"); // Ajouter une classe CSS
        this.carteButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.compteButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.donneesButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.modifie.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.deconnexion.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS

        this.getStylesheets().add(getClass().getResource("../../resource/app.css").toExternalForm()); // Ajouter le fichier CSS
    }

    public NavBarre refresh(boolean estConnecte) {
        NavBarre newNavBarre = new NavBarre(estConnecte, new User());
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