package model;

/**
 * Classe Annee 
 * Pour chaque année, on a un taux d'inflation
 * @author Schell Yanis, Jules-Vachet Mattheo, Gauffeny Paul
 */
public class Annee {

    /**
     * Attributs annee un entier qui représente l'année
     */
    private int annee;

    /**
     * Attributs tauxInflation un float qui représente le taux d'inflation d'une année
     */
    private float tauxInflation;

    /**
     * Constructeur de la classe Annee
     * @param annee un entier qui représente l'année
     * @param tauxInflation un float qui représente le taux d'inflation d'une année
     */
    public Annee(int annee, float tauxInflation) {
        this.annee = annee;
        this.tauxInflation = tauxInflation;
    }

    /**
     * Méthode getAnnee qui retourne l'année
     * @return l'année
     */
    public int getAnnee() {
        return this.annee;
    }

    /**
     * Méthode getTauxInflation qui retourne le taux d'inflation
     * @return le taux d'inflation
     */
    public float getTauxInflation() {
        return this.tauxInflation;
    }

    /**
     * Méthode setAnnee qui modifie l'année
     * @param annee la nouvelle valeur de l'année
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     * Méthode setTauxInflation qui modifie le taux d'inflation
     * @param tauxInflation la nouvelle valeur du taux d'inflation
     */
    public void setTauxInflation(float tauxInflation) {
        this.tauxInflation = tauxInflation;
    }

    /**
     * Méthode toString qui retourne une chaine de caractère représentant l'année
     * @return une chaine de caractère représentant l'année
     */
    public String toString() {
        return "Annee [annee=" + getAnnee() + ", tauxInflation=" + getTauxInflation() + "]";
    }

    /**
     * Méthode anneeMaxInflation qui retourne l'année avec le taux d'inflation le plus élevé
     * @param annee un tableau d'année
     * @return l'année avec le taux d'inflation le plus élevé
     */
    public Annee anneeMaxInflation(Annee[] annee){
        Annee anneeMax;
        if(annee == null){
            anneeMax = null;
        }else{
            anneeMax = annee[0];
            for (int i = 1; i < annee.length; i++) {
                if(annee[i].getTauxInflation() > anneeMax.getTauxInflation()){
                    anneeMax = annee[i];
                }
            }
        }
        return anneeMax;
    }
    
}
