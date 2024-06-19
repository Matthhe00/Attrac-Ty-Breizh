package app.model.data;

/**
 * Classe Aeroport
 */
public class Aeroport {

    /**
     * Département de l'aéroport
     */
    private String leDepartement;

    /**
     * Nom de l'aéroport
     */
    private String nom;

    /**
     * Adresse de l'aéroport
     */
    private String adresse;

    /**
     * Constructeur de la classe Aeroport
     * @param leDepartement Département de l'aéroport
     * @param nom Nom de l'aéroport
     * @param adresse Adresse de l'aéroport
     */
    public Aeroport(String leDepartement, String nom, String adresse) {
        this.leDepartement = leDepartement;
        this.nom = nom;
        this.adresse = adresse;
    }

    /**
     * Retourne le département de l'aéroport
     * @return leDepartement
     */
    public String getLeDepartement() {
        return this.leDepartement;
    }

    /**
     * Retourne le nom de l'aéroport
     * @return nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retourne l'adresse de l'aéroport
     * @return adresse
     */
    public String getAdresse() {
        return this.adresse;
    }

    /**
     * Modifie le département de l'aéroport
     * @param leDepartement Nouveau département
     */
    public void setLeDepartement(String leDepartement) {
        this.leDepartement = leDepartement;
    }

    /**
     * Modifie le nom de l'aéroport
     * @param nom Nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Modifie l'adresse de l'aéroport
     * @param adresse Nouvelle adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Retourne une représentation textuelle de l'aéroport
     * @return String
     */
    public String toString() {
        return "Aeroport [adresse=" + getAdresse() + ", leDepartement=" + getLeDepartement() + ", nom=" + getNom() + "]";
    }
}
