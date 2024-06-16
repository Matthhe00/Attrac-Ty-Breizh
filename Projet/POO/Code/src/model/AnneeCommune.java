package model;

/**
 * Classe AnneeCommune
 * Cette class a pour but de mettre en relation une année et une commune
 * Et selon l'année les données de la commune change
 * @author Schell Yanis, Jules-Vachet Mattheo, Gauffeny Paul
 */
public class AnneeCommune {

    /**
     * Attributs annee un objet de type Annee qui représente l'année
     */
    private Annee annee;

    /**
     * Attributs laCommune un objet de type Commune qui représente la commune
     */
    private Commune laCommune;

    /**
     * Attributs nbMaison un entier qui représente le nombre de maison vendus
     */
    private int nbMaison;

    /**
     * Attributs nbAppart un entier qui représente le nombre d'appartements vendus
     */
    private int nbAppart;

    /**
     * Attributs prixMoyen un float qui représente le prix moyen
     */
    private float prixMoyen;

    /**
     * Attributs prixM2Moyen un float qui représente le prix moyen au m2
     */
    private float prixM2Moyen;

    /**
     * Attributs surfaceMoy un float qui représente la surface moyenne
     */
    private float surfaceMoy;

    /**
     * Attributs depCulturellesTotal un float qui représente les dépenses culturelles totales
     */
    private float depCulturellesTotal;

    /**
     * Attributs budgetTotal un float qui représente le budget total
     */
    private float budgetTotal;

    /**
     * Attributs population un float qui représente la population
     */
    private float population;

    /**
     * Constructeur de la classe AnneeCommune
     * @param annee un objet de type Annee qui représente l'année
     * @param laCommune un objet de type Commune qui représente la commune
     * @param nbMaison un entier qui représente le nombre de maison vendus
     * @param nbAppart un entier qui représente le nombre d'appartements vendus
     * @param prixMoyen un float qui représente le prix moyen
     * @param prixM2Moyen un float qui représente le prix moyen au m2
     * @param surfaceMoy un float qui représente la surface moyenne
     * @param depCulturellesTotal un float qui représente les dépenses culturelles totales
     * @param budgetTotal un float qui représente le budget total
     * @param population un float qui représente la population
     */
    public AnneeCommune(Annee annee, Commune laCommune, int nbMaison, int nbAppart, float prixMoyen, float prixM2Moyen, float surfaceMoy, float depCulturellesTotal, float budgetTotal, float population) {
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
     * Méthode getAnnee qui retourne l'année
     * @return l'année
     */
    public Annee getAnnee() {
        return this.annee;
    }

    /**
     * Méthode setAnnee qui modifie l'année
     * @param annee la nouvelle valeur de l'année
     */
    public void setAnnee(Annee annee) {
        this.annee = annee;
    }

    /**
     * Méthode getLaCommune qui retourne la commune
     * @return la commune
     */
    public Commune getLaCommune() {
        return this.laCommune;
    }

    /**
     * Méthode setLaCommune qui modifie la commune
     * @param laCommune la nouvelle valeur de la commune
     */
    public void setLaCommune(Commune laCommune) {
        this.laCommune = laCommune;
    }

    /**
     * Méthode getNbMaison qui retourne le nombre de maison vendus
     * @return le nombre de maison vendus
     */
    public int getNbMaison() {
        return this.nbMaison;
    }

    /**
     * Méthode setNbMaison qui modifie le nombre de maison vendus
     * @param nbMaison la nouvelle valeur du nombre de maison vendus
     */
    public void setNbMaison(int nbMaison) {
        this.nbMaison = nbMaison;
    }

    /**
     * Méthode getNbAppart qui retourne le nombre d'appartements vendus
     * @return le nombre d'appartements vendus
     */
    public int getNbAppart() {
        return this.nbAppart;
    }

    /**
     * Méthode setNbAppart qui modifie le nombre d'appartements vendus
     * @param nbAppart la nouvelle valeur du nombre d'appartements vendus
     */
    public void setNbAppart(int nbAppart) {
        this.nbAppart = nbAppart;
    }

    /**
     * Méthode getPrixMoyen qui retourne le prix moyen
     * @return le prix moyen
     */
    public float getPrixMoyen() {
        return this.prixMoyen;
    }

    /**
     * Méthode setPrixMoyen qui modifie le prix moyen
     * @param prixMoyen la nouvelle valeur du prix moyen
     */
    public void setPrixMoyen(float prixMoyen) {
        this.prixMoyen = prixMoyen;
    }

    /**
     * Méthode getPrixM2Moyen qui retourne le prix moyen au m2
     * @return le prix moyen au m2
     */
    public float getPrixM2Moyen() {
        return this.prixM2Moyen;
    }

    /**
     * Méthode setPrixM2Moyen qui modifie le prix moyen au m2
     * @param prixM2Moyen la nouvelle valeur du prix moyen au m2
     */
    public void setPrixM2Moyen(float prixM2Moyen) {
        this.prixM2Moyen = prixM2Moyen;
    }

    /**
     * Méthode getSurfaceMoy qui retourne la surface moyenne
     * @return la surface moyenne
     */
    public float getSurfaceMoy() {
        return this.surfaceMoy;
    }

    /**
     * Méthode setSurfaceMoy qui modifie la surface moyenne
     * @param surfaceMoy la nouvelle valeur de la surface moyenne
     */
    public void setSurfaceMoy(float surfaceMoy) {
        this.surfaceMoy = surfaceMoy;
    }

    /**
     * Méthode getDepCulturellesTotal qui retourne les dépenses culturelles totales
     * @return les dépenses culturelles totales
     */
    public float getDepCulturellesTotal() {
        return this.depCulturellesTotal;
    }

    /**
     * Méthode setDepCulturellesTotal qui modifie les dépenses culturelles totales
     * @param depCulturellesTotal la nouvelle valeur des dépenses culturelles totales
     */
    public void setDepCulturellesTotal(float depCulturellesTotal) {
        this.depCulturellesTotal = depCulturellesTotal;
    }

    /**
     * Méthode getBudgetTotal qui retourne le budget total
     * @return le budget total
     */
    public float getBudgetTotal() {
        return this.budgetTotal;
    }

    /**
     * Méthode setBudgetTotal qui modifie le budget total
     * @param budgetTotal la nouvelle valeur du budget total
     */
    public void setBudgetTotal(float budgetTotal) {
        this.budgetTotal = budgetTotal;
    }

    /**
     * Méthode getPopulation qui retourne la population
     * @return la population
     */
    public float getPopulation() {
        return this.population;
    }

    /**
     * Méthode setPopulation qui modifie la population
     * @param population la nouvelle valeur de la population
     */
    public void setPopulation(float population) {
        this.population = population;
    }

    /**
     * Méthode toString qui retourne une chaine de caractère représentant l'année et la commune
     * @return une chaine de caractère représentant l'année et la commune
     */
    public String toString() {
        return "AnneeCommune [annee=" + getAnnee() + ", budgetTotal=" + getBudgetTotal() + ", depCulturellesTotal="
                + getDepCulturellesTotal() + ", laCommune=" + getLaCommune() + ", nbAppart=" + getNbAppart() + ", nbMaison=" + getNbMaison()
                + ", population=" + getPopulation() + ", prixM2Moyen=" + getPrixM2Moyen() + ", prixMoyen=" + getPrixMoyen()
                + ", surfaceMoy=" + getSurfaceMoy() + "]";
    }

    /**
     * Méthode afficherCompareTo qui affiche la comparaison des données de deux communes
     * @param commune1 la première commune
     * @param commune2 la deuxième commune
     * @param tab un tableau d'entiers qui représente la comparaison des données
     * @param nomVal un tableau de chaines de caractères qui représente les noms des valeurs
     */
    public void afficherCompareTo(String commune1, String commune2, int[] tab, String[] nomVal){
        System.out.println("Comparaison des données de " + commune1 + " et " + commune2 + " :");
        for(int i = 0; i < nomVal.length; i++){
                if(tab[i] == 0){
                    System.out.print("Les deux communes ont la même valeur");
                    System.out.println(" pour " + nomVal[i]);
                }
                else if(tab[i] == 1){
                    System.out.print(commune1 + " a une valeur supérieure à " + commune2);
                    System.out.println(" pour " + nomVal[i]);
                }
                else{
                    System.out.print(commune1 + " a une valeur inférieure à " + commune2);
                    System.out.println(" pour " + nomVal[i]);
                }
        }
    }
    
    /**
     * Méthode compareTo qui compare les données de deux communes
     * @param otherAnneeCommune un objet de type AnneeCommune qui représente l'autre commune
     * @return un tableau d'entiers qui représente la comparaison des données avec les valeurs suivantes : 0 si les valeurs sont égales, 1 si la valeur de la commune est supérieure, -1 si la valeur de la commune est inférieure
     */
    public int[] compareTo(AnneeCommune otherAnneeCommune) {
    
        int[] result = new int[8];
        String[] nomValeurs = {"le nombre de maison vendus", "le nombre d'appartements vendus", "le prix moyen", "le prix moyen au m2",
        "la surface moyenne", "les dépenses culturelles totales", "le budget total", "la population"};

        if(this.getNbMaison() < otherAnneeCommune.getNbMaison()){
            result[0] = -1;
        }
        else if(this.getNbMaison() > otherAnneeCommune.getNbMaison()){
            result[0] = 1;
        }
        else{
            result[0] = 0;
        }

        if(this.getNbAppart() < otherAnneeCommune.getNbAppart()){
            result[1] = -1;
        }
        else if(this.getNbAppart() > otherAnneeCommune.getNbAppart()){
            result[1] = 1;
        }
        else{
            result[1] = 0;
        }

        if(this.getPrixMoyen() < otherAnneeCommune.getPrixMoyen()){
            result[2] = -1;
        }
        else if(this.getPrixMoyen() > otherAnneeCommune.getPrixMoyen()){
            result[2] = 1;
        }
        else{
            result[2] = 0;
        }

        if(this.getPrixM2Moyen() < otherAnneeCommune.getPrixM2Moyen()){
            result[3] = -1;
        }
        else if(this.getPrixM2Moyen() > otherAnneeCommune.getPrixM2Moyen()){
            result[3] = 1;
        }
        else{
            result[3] = 0;
        }

        if(this.getSurfaceMoy() < otherAnneeCommune.getSurfaceMoy()){
            result[4] = -1;
        }
        else if(this.getSurfaceMoy() > otherAnneeCommune.getSurfaceMoy()){
            result[4] = 1;
        }
        else{
            result[4] = 0;
        }

        if(this.getDepCulturellesTotal() < otherAnneeCommune.getDepCulturellesTotal()){
            result[5] = -1;
        }
        else if(this.getDepCulturellesTotal() > otherAnneeCommune.getDepCulturellesTotal()){
            result[5] = 1;
        }
        else{
            result[5] = 0;
        }

        if(this.getBudgetTotal() < otherAnneeCommune.getBudgetTotal()){
            result[6] = -1;
        }
        else if(this.getBudgetTotal() > otherAnneeCommune.getBudgetTotal()){
            result[6] = 1;
        }
        else{
            result[6] = 0;
        }

        if(this.getPopulation() < otherAnneeCommune.getPopulation()){
            result[7] = -1;
        }
        else if(this.getPopulation() > otherAnneeCommune.getPopulation()){
            result[7] = 1;
        }
        else{
            result[7] = 0;
        }

        afficherCompareTo(this.getLaCommune().getNomCommune(), otherAnneeCommune.getLaCommune().getNomCommune(), result, nomValeurs);
        return result;
    }
    
}
