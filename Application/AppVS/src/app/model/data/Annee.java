package app.model.data;

/**
 * Classe Annee
 */
public class Annee {

    /**
     * Année
     */
    private String annee;

    /**
     * Taux d'inflation
     */
    private String tauxInflation;

    /**
     * Constructeur de la classe Annee
     * @param annee Année
     * @param tauxInflation Taux d'inflation
     */
    public Annee(String annee, String tauxInflation) {
        this.annee = annee;
        this.tauxInflation = tauxInflation;
    }

    /**
     * Retourne l'année
     * @return annee
     */
    public String getAnnee() {
        return this.annee;
    }

    /**
     * Retourne le taux d'inflation
     * @return tauxInflation
     */
    public String getTauxInflation() {
        return this.tauxInflation;
    }

    /**
     * Modifie l'année
     * @param annee Année
     */
    public void setAnnee(String annee) {
        this.annee = annee;
    }

    /**
     * Modifie le taux d'inflation
     * @param tauxInflation Taux d'inflation
     */
    public void setTauxInflation(String tauxInflation) {
        this.tauxInflation = tauxInflation;
    }

    /**
     * Retourne la chaine de caractères
     */
    public String toString() {
        return "Annee [annee=" + getAnnee() + ", tauxInflation=" + getTauxInflation() + "]";
    }
    
}
