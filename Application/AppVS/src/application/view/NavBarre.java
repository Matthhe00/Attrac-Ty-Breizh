package application.view;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class NavBarre extends GridPane{
    private Button compteButton;
    private Button carteButton;
    private Button donneesButton;
    private Button modifie;
    private Button deconnexion;

    public NavBarre() {
        this.compteButton = new Button("Compte");
        this.carteButton = new Button("Carte");
        this.donneesButton = new Button("Données");
        initNavBarre(false);
    }

    public void initNavBarre(boolean estConnecte) {
        this.getChildren().clear();  // Nettoyer les éléments précédents
        this.setHgap(30);

        this.compteButton = new Button("Compte");
        this.carteButton = new Button("Carte");
        this.donneesButton = new Button("Données");
        this.modifie = new Button("Modifier");
        this.deconnexion = new Button("Déconnexion");

        this.add(compteButton, 0, 0);
        this.add(carteButton, 1, 0);
        this.add(donneesButton, 2, 0);

        if (estConnecte) {
            this.add(modifie, 3, 0);
            this.add(deconnexion, 4, 0);
        }

        this.getStyleClass().add("nav-barre"); // Ajouter une classe CSS
        this.carteButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.compteButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.donneesButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.modifie.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.deconnexion.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS

        this.getStylesheets().add(getClass().getResource("resource/application.css").toExternalForm()); // Ajouter le fichier CSS
    }

    public void refresh(boolean estConnecte) {
        initNavBarre(estConnecte);
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