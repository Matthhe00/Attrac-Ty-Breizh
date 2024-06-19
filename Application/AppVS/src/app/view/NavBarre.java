package app.view;
import app.model.data.User;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class NavBarre extends GridPane{
    private Button compteButton;
    private Button departementButton;
    private Button donneesButton;
    private Button deconnexion;
    private Button accueilButton;
    private Button statistiqueButton;

    public NavBarre() {
        initNavBarre(false, false);
    }

    public NavBarre(User user, boolean role) {
        if (role) {
            initNavBarre(true, true);
        } else {
            initNavBarre(false, false);
        }
    }

    public NavBarre(boolean estConnecte) {
        initNavBarre(estConnecte, false);
    }

    public NavBarre(boolean estConnecte, boolean modifie) {
        initNavBarre(estConnecte, modifie);
    }

    public void initNavBarre(boolean estConnecte, boolean modifie) {
        this.setHgap(30);

        this.compteButton = new Button("Compte");
        this.departementButton = new Button("Départements");
        this.donneesButton = new Button("Communes");
        this.deconnexion = new Button("Déconnexion");
        this.accueilButton = new Button("Accueil");
        this.statistiqueButton = new Button("Statistiques");


        this.add(accueilButton, 0, 0);
        this.add(compteButton, 1, 0);
        this.add(departementButton, 2, 0);
        this.add(donneesButton, 3, 0);
        this.add(statistiqueButton, 4, 0);
        this.add(deconnexion, 14, 0);
        

        this.getStyleClass().add("nav-barre"); // Ajouter une classe CSS
        this.accueilButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.departementButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.compteButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.donneesButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
        this.statistiqueButton.getStyleClass().add("my-button-nav-barre"); // Ajouter une classe CSS
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

    public NavBarre refresh(boolean estConnecte, boolean modifie) {
        NavBarre newNavBarre = new NavBarre(estConnecte, modifie);
        return newNavBarre;
    }

    public Button getcompteButton() {
        return this.compteButton;
    }

    public Button getdepartementButton() {
        return this.departementButton;
    }

    public Button getDonneesButton() {
        return this.donneesButton;
    }

    public Button getDeconnexionButton() {
        return this.deconnexion;
    }

    public Button getAccueilButton() {
        return this.accueilButton;
    }
    
    public Button getStatistiqueButton() {
        return this.statistiqueButton;
    }
}