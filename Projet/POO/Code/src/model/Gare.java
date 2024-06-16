package model;

import java.util.ArrayList;

/**
 * Classe Gare
 * Pour chaque gare, on a un code, un nom, un boolean pour savoir si c'est une gare de fret ou de voyageur, une commune et une liste de gares de destination
 * @author Schell Yanis, Jules-Vachet Mattheo, Gauffeny Paul
 */
public class Gare {

    /**
     * Attributs codeGare un entier qui représente le code de la gare
     */
    private int codeGare;

    /**
     * Attributs nomGare une chaine de caractère qui représente le nom de la gare
     */
    private String nomGare;

    /**
     * Attributs estFret un boolean qui représente si la gare est une gare de fret
     */
    private boolean estFret;

    /**
     * Attributs estVoyageur un boolean qui représente si la gare est une gare de voyageur
     */
    private boolean estVoyageur;

    /**
     * Attributs laCommune un objet de type Commune qui représente la commune de la gare
     */
    private Commune laCommune;

    /**
     * Attributs gareDestination une liste de gares qui représente les gares de destination de la gare
     */
    private ArrayList<Gare> gareDestination;

    /**
     * Constructeur de la classe Gare
     * @param codeGare un entier qui représente le code de la gare
     * @param nomGare une chaine de caractère qui représente le nom de la gare
     * @param estFret un boolean qui représente si la gare est une gare de fret
     * @param estVoyageur un boolean qui représente si la gare est une gare de voyageur
     * @param laCommune un objet de type Commune qui représente la commune de la gare
     */
    public Gare(int codeGare, String nomGare, boolean estFret, boolean estVoyageur, Commune laCommune) {
        this.codeGare = codeGare;
        this.nomGare = nomGare;
        this.estFret = estFret;
        this.estVoyageur = estVoyageur;
        this.laCommune = laCommune;
        this.gareDestination = new ArrayList<Gare>();

    }
    
    /**
     * Méthode getCodeGare qui retourne le code de la gare
     * @return le code de la gare
     */
    public int getCodeGare() {
        return this.codeGare;
    }

    /**
     * Méthode getNomGare qui retourne le nom de la gare
     * @return le nom de la gare
     */
    public String getNomGare() {
        return this.nomGare;
    }

    /**
     * Méthode getEstFret qui retourne si la gare est une gare de fret
     * @return si la gare est une gare de fret
     */
    public boolean getEstFret() {
        return this.estFret;
    }

    /**
     * Méthode getEstVoyageur qui retourne si la gare est une gare de voyageur
     * @return si la gare est une gare de voyageur
     */
    public boolean getEstVoyageur() {
        return this.estVoyageur;
    }

    /**
     * Méthode getLaCommune qui retourne la commune de la gare
     * @return la commune de la gare
     */
    public Commune getLaCommune() {
        return this.laCommune;
    }

    /**
     * Méthode setEstFret qui modifie si la gare est une gare de fret
     * @param estFret la nouvelle valeur de si la gare est une gare de fret
     */
    public void setEstFret(boolean estFret) {
        this.estFret = estFret;
    }

    /**
     * Méthode setEstVoyageur qui modifie si la gare est une gare de voyageur
     * @param estVoyageur la nouvelle valeur de si la gare est une gare de voyageur
     */
    public void setEstVoyageur(boolean estVoyageur) {
        this.estVoyageur = estVoyageur;
    }

    /**
     * Méthode setNomGare qui modifie le nom de la gare
     * @param nomGare la nouvelle valeur du nom de la gare
     */
    public void setNomGare(String nomGare) {
        this.nomGare = nomGare;
    }

    /**
     * Méthode setLaCommune qui modifie la commune de la gare
     * @param laCommune la nouvelle valeur de la commune de la gare
     */
    public void setLaCommune(Commune laCommune) {
        this.laCommune = laCommune;
    }

    /**
     * Méthode setCodeGare qui modifie le code de la gare
     * @param codeGare la nouvelle valeur du code de la gare
     */
    public void setCodeGare(int codeGare) {
        this.codeGare = codeGare;
    }

    /**
     * Méthode toString qui retourne une chaine de caractère représentant la gare
     * @return une chaine de caractère représentant la gare
     */
    public String toString() {
        return "Gare [codeGare=" + getCodeGare() + ", estFret=" + getEstFret() + ", estVoyageur=" + getEstVoyageur() + ", laCommune="
                + getLaCommune() + ", nomGare=" + getNomGare() + "]";
    }

    /**
     * Méthode addDestinationGare qui ajoute une gare de destination à la liste des gares de destination
     * @param gare une gare qui représente la gare de destination à ajouter
     */
    public void addDestinationGare(Gare gare){
        if(gare != null){
            this.gareDestination.add(gare);
        }
    }

    /**
     * Méthode removeDestinationGare qui supprime une gare de destination de la liste des gares de destination
     * @param gare une gare qui représente la gare de destination à supprimer
     */
    public void removeDestinationGare(Gare gare){
        if(gare != null){
            this.gareDestination.remove(gare);
        }
    }

    /**
     * Méthode getDestinationGare qui retourne la liste des gares de destination
     * @return la liste des gares de destination
     */
    public ArrayList<Gare> getDestinationGare() {
        return this.gareDestination;
    }

    /**
     * Méthode setDestinationGare qui modifie la liste des gares de destination
     * @param garesDestination la liste de nouvelle valeur de la liste des gares de destination
     */
    public void setDestinationGare(ArrayList<Gare> garesDestination) {
        this.gareDestination = garesDestination;
    }

    /**
     * Méthode rechercheDestinationGare qui retourne la liste des gares de destination
     * @return la liste des gares de destination
     */
    public ArrayList<Gare> rechercheDestinationGare(){
        ArrayList<Gare> ret = new ArrayList<>(); 
        for(Gare gare : this.gareDestination){
            ret.add(gare);
        }
        return ret;
    }
}
