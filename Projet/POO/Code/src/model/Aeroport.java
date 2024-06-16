package model;

import java.util.ArrayList;

/**
 * Classe Aeroport
 * Pour chaque aéroport, on a un département, un nom, une adresse et une liste d'aéroports de destination
 * @author Schell Yanis, Jules-Vachet Mattheo, Gauffeny Paul
 */
public class Aeroport {

    /**
     * Attributs leDepartement un objet de type Departement qui représente le département de l'aéroport
     */
    private Departement leDepartement;

    /**
     * Attributs nom une chaine de caractère qui représente le nom de l'aéroport
     */
    private String nom;

    /**
     * Attributs adresse une chaine de caractère qui représente l'adresse de l'aéroport
     */
    private String adresse;

    /**
     * Attributs aeroportsDestination une liste d'aéroports qui représente les aéroports de destination de l'aéroport
     */
    private ArrayList<Aeroport> aeroportsDestination;

    /**
     * Constructeur de la classe Aeroport
     * @param leDepartement un objet de type Departement qui représente le département de l'aéroport
     * @param nom une chaine de caractère qui représente le nom de l'aéroport
     * @param adresse une chaine de caractère qui représente l'adresse de l'aéroport
     */
    public Aeroport(Departement leDepartement, String nom, String adresse) {
        this.leDepartement = leDepartement;
        this.nom = nom;
        this.adresse = adresse;
        this.aeroportsDestination = new ArrayList<Aeroport>();
    }

    /**
     * Méthode getLeDepartement qui retourne le département de l'aéroport
     * @return le département de l'aéroport
     */
    public Departement getLeDepartement() {
        return this.leDepartement;
    }
 
    /**
     * Méthode getNom qui retourne le nom de l'aéroport
     * @return le nom de l'aéroport
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Méthode getAdresse qui retourne l'adresse de l'aéroport
     * @return l'adresse de l'aéroport
     */
    public String getAdresse() {
        return this.adresse;
    }

    /**
     * Méthode setLeDepartement qui modifie le département de l'aéroport
     * @param leDepartement le nouveau département de l'aéroport
     */
    public void setLeDepartement(Departement leDepartement) {
        this.leDepartement = leDepartement;
    }

    /**
     * Méthode setNom qui modifie le nom de l'aéroport
     * @param nom le nouveau nom de l'aéroport
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode setAdresse qui modifie l'adresse de l'aéroport
     * @param adresse la nouvelle adresse de l'aéroport
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Méthode toString qui retourne une chaine de caractère représentant l'aéroport
     * @return une chaine de caractère représentant l'aéroport
     */
    public String toString() {
        return "Aeroport [adresse=" + getAdresse() + ", leDepartement=" + getLeDepartement() + ", nom=" + getNom() + "]";
    }

    /**
     * Méthode addDestinationAeroport qui ajoute un aéroport de destination à la liste des aéroports de destination
     * @param aeroport l'aéroport de destination à ajouter
     */
    public void addDestinationAeroport(Aeroport aeroport){
        if(aeroport != null){
            this.aeroportsDestination.add(aeroport);
        }
    }

    /**
     * Méthode removeDestinationAeroport qui supprime un aéroport de destination de la liste des aéroports de destination
     * @param aeroport l'aéroport de destination à supprimer
     */
    public void removeDestinationAeroport(Aeroport aeroport){
        if(aeroport != null){
            this.aeroportsDestination.remove(aeroport);
        }
    }

    /**
     * Méthode getDestinationAeroport qui retourne la liste des aéroports de destination
     * @return la liste des aéroports de destination
     */
    public ArrayList<Aeroport> getDestinationAeroport() {
        return this.aeroportsDestination;
    }

    /**
     * Méthode setDestinationAeroport qui modifie la liste des aéroports de destination
     * @param aeroportsDestination la nouvelle liste des aéroports de destination
     */
    public void setDestinationAeroport(ArrayList<Aeroport> aeroportsDestination) {
        this.aeroportsDestination = aeroportsDestination;
    }

    /**
     * Méthode rechercheDestinationAeroport qui retourne une liste d'aéroports de destination
     * @return une liste d'aéroports de destination
     */
    public ArrayList<Aeroport> rechercheDestinationAeroport(){
        ArrayList<Aeroport> ret = new ArrayList<>(); 
        for(Aeroport aeroport : this.aeroportsDestination){
            ret.add(aeroport);
        }
        return ret;
    }

}
