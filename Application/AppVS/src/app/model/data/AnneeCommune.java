package app.model.data;

/**
 * Classe AnneeCommune
 */
public class AnneeCommune {

    /**
     * Année
     */
    private Annee annee;

    /**
     * Commune
     */
    private Commune laCommune;

    /**
     * Nombre de maisons vendues
     */
    private String nbMaison;

    /**
     * Nombre d'appartements vendus
     */
    private String nbAppart;

    /**
     * Prix moyen d'un logement
     */
    private String prixMoyen;

    /**
     * Prix moyen du m2
     */
    private String prixM2Moyen;

    /**
     * Surface moyenne
     */
    private String surfaceMoy;

    /**
     * Dépenses culturelles totales
     */
    private String depCulturellesTotal;

    /**
     * Budget total
     */
    private String budgetTotal;

    /**
     * Population
     */
    private String population;

    /**
     * Constructeur de la classe AnneeCommune
     * @param annee Année
     * @param laCommune Commune
     * @param nbMaison Nombre de maisons vendues
     * @param nbAppart Nombre d'appartements vendus
     * @param prixMoyen Prix moyen d'un logement
     * @param prixM2Moyen Prix moyen du m2
     * @param surfaceMoy Surface moyenne
     * @param depCulturellesTotal Dépenses culturelles totales
     * @param budgetTotal Budget total
     * @param population Population
     */
    public AnneeCommune(Annee annee, Commune laCommune, String nbMaison, String nbAppart, String prixMoyen, String prixM2Moyen, String surfaceMoy, String depCulturellesTotal, String budgetTotal, String population) {
        this.annee = annee;
        this.laCommune = laCommune;
        this.nbMaison = nbMaison;
        this.nbAppart = nbAppart;
        this.prixMoyen = prixMoyen;
        this.prixM2Moyen = prixM2Moyen;
        this.surfaceMoy = surfaceMoy;
        this.depCulturellesTotal = depCulturellesTotal;
        this.budgetTotal = budgetTotal;
        this.population = population;
    }

    /**
     * Retourne l'année
     * @return annee
     */
    public Annee getAnnee() {
        return this.annee;
    }

    /**
     * Modifie l'année
     * @param annee Année
     */
    public void setAnnee(Annee annee) {
        this.annee = annee;
    }

    /**
     * Retourne la commune
     * @return laCommune
     */
    public Commune getLaCommune() {
        return this.laCommune;
    }

    /**
     * Modifie la commune
     * @param laCommune Commune
     */
    public void setLaCommune(Commune laCommune) {
        this.laCommune = laCommune;
    }

    /**
     * Retourne le nombre de maisons vendues
     * @return nbMaison
     */
    public String getNbMaison() {
        return this.nbMaison;
    }

    /**
     * Modifie le nombre de maisons vendues
     * @param nbMaison Nombre de maisons vendues
     */
    public void setNbMaison(String nbMaison) {
        this.nbMaison = nbMaison;
    }

    /**
     * Retourne le nombre d'appartements vendus
     * @return nbAppart
     */
    public String getNbAppart() {
        return this.nbAppart;
    }

    /**
     * Modifie le nombre d'appartements vendus
     * @param nbAppart Nombre d'appartements vendus
     */
    public void setNbAppart(String nbAppart) {
        this.nbAppart = nbAppart;
    }

    /**
     * Retourne le prix moyen d'un logement
     * @return prixMoyen
     */
    public String getPrixMoyen() {
        return this.prixMoyen;
    }

    /**
     * Modifie le prix moyen d'un logement
     * @param prixMoyen Prix moyen d'un logement
     */
    public void setPrixMoyen(String prixMoyen) {
        this.prixMoyen = prixMoyen;
    }

    /**
     * Retourne le prix moyen du m2
     * @return prixM2Moyen
     */
    public String getPrixM2Moyen() {
        return this.prixM2Moyen;
    }

    /**
     * Modifie le prix moyen du m2
     * @param prixM2Moyen Prix moyen du m2
     */
    public void setPrixM2Moyen(String prixM2Moyen) {
        this.prixM2Moyen = prixM2Moyen;
    }

    /**
     * Retourne la surface moyenne
     * @return surfaceMoy
     */
    public String getSurfaceMoy() {
        return this.surfaceMoy;
    }

    /**
     * Modifie la surface moyenne
     * @param surfaceMoy Surface moyenne
     */
    public void setSurfaceMoy(String surfaceMoy) {
        this.surfaceMoy = surfaceMoy;
    }

    /**
     * Retourne les dépenses culturelles totales
     * @return depCulturellesTotal
     */
    public String getDepCulturellesTotal() {
        return this.depCulturellesTotal;
    }

    /**
     * Modifie les dépenses culturelles totales
     * @param depCulturellesTotal Dépenses culturelles totales
     */
    public void setDepCulturellesTotal(String depCulturellesTotal) {
        this.depCulturellesTotal = depCulturellesTotal;
    }

    /**
     * Retourne le budget total
     * @return budgetTotal
     */
    public String getBudgetTotal() {
        return this.budgetTotal;
    }

    /**
     * Modifie le budget total
     * @param budgetTotal Budget total
     */
    public void setBudgetTotal(String budgetTotal) {
        this.budgetTotal = budgetTotal;
    }

    /**
     * Retourne la population
     * @return population
     */
    public String getPopulation() {
        return this.population;
    }

    /**
     * Modifie la population
     * @param population Population
     */
    public void setPopulation(String population) {
        this.population = population;
    }

    /**
     * Retourne la chaine de caractères
     * @return String Chaine de caractères
     */
    public String toString() {
        return "AnneeCommune [annee=" + getAnnee() + ", budgetTotal=" + getBudgetTotal() + ", depCulturellesTotal="
                + getDepCulturellesTotal() + ", laCommune=" + getLaCommune() + ", nbAppart=" + getNbAppart() + ", nbMaison=" + getNbMaison()
                + ", population=" + getPopulation() + ", prixM2Moyen=" + getPrixM2Moyen() + ", prixMoyen=" + getPrixMoyen()
                + ", surfaceMoy=" + getSurfaceMoy() + "]";
    }    
}
