package model;

import java.util.ArrayList;

/**
 * Classe Departement
 * Pour chaque département, on a un identifiant, un nom, un investissement culturel en 2019 et une liste d'aéroports
 * @author Schell Yanis, Jules-Vachet Mattheo, Gauffeny Paul
 */
public class Departement {
    
    /**
     * Attributs idDep un entier qui représente l'identifiant du département (Code du département)
     */
    private int idDep;

    /**
     * Attributs nomDep une chaine de caractère qui représente le nom du département
     */
    private String nomDep;

    /**
     * Attributs invesCulturel2019 un float qui représente l'investissement culturel en 2019
     */
    private float invesCulturel2019;

    /**
     * Attributs listeAeroports une liste d'aéroports qui représente les aéroports du département
     */
    private ArrayList<Aeroport> listeAeroports;

    /**
     * Constructeur de la classe Departement
     * @param idDep un entier qui représente l'identifiant du département
     * @param nomDep une chaine de caractère qui représente le nom du département
     * @param inves un float qui représente l'investissement culturel en 2019
     */
    public Departement(int idDep, String nomDep, float inves) {
        this.idDep = idDep;
        this.nomDep = nomDep;
        this.invesCulturel2019 = inves;
        this.listeAeroports = new ArrayList<Aeroport>();
    }

    /**
     * Méthode getIdDep qui retourne l'identifiant du département
     * @return l'identifiant du département
     */
    public int getIdDep() {
        return this.idDep;
    }

    /**
     * Méthode setIdDep qui modifie l'identifiant du département
     * @param idDep le nouvel identifiant du département
     */
    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    /**
     * Méthode getNomDep qui retourne le nom du département
     * @return le nom du département
     */
    public String getNomDep() {
        return this.nomDep;
    }

    /**
     * Méthode setNomDep qui modifie le nom du département
     * @param nomDep le nouveau nom du département
     */
    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    /**
     * Méthode getInvesCulturel2019 qui retourne l'investissement culturel en 2019
     * @return l'investissement culturel en 2019
     */
    public float getInvesCulturel2019() {
        return this.invesCulturel2019;
    }

    /**
     * Méthode setInvesCulturel2019 qui modifie l'investissement culturel en 2019
     * @param invesCulturel2019 le nouvel investissement culturel en 2019
     */
    public void setInvesCulturel2019(float invesCulturel2019) {
        this.invesCulturel2019 = invesCulturel2019;
    }

    /**
     * Méthode getListeAeroports qui retourne la liste des aéroports du département
     * @return la liste des aéroports du département
     */
    public ArrayList<Aeroport> getListeAeroports() {
        return this.listeAeroports;
    }

    /**
     * Méthode setListeAeroports qui modifie la liste des aéroports du département
     * @param listeAeroports la nouvelle liste des aéroports du département
     */
    public void setListeAeroports(ArrayList<Aeroport> listeAeroports) {
        this.listeAeroports = listeAeroports;
    }

    /**
     * Méthode addAeroport qui ajoute un aéroport à la liste des aéroports du département
     * @param aeroport l'aéroport à ajouter à la liste des aéroports du département
     */
    public void addAeroport(Aeroport aeroport) {
        if(aeroport != null){
            this.listeAeroports.add(aeroport);
        }
    }

    /**
     * Méthode removeAeroport qui supprime un aéroport de la liste des aéroports du département
     * @param aeroport l'aéroport à supprimer de la liste des aéroports du département
     */
    public void removeAeroport(Aeroport aeroport){
            this.listeAeroports.remove(aeroport);
    }

    /**
     * Méthode toString qui retourne une chaine de caractère représentant le département
     * @return une chaine de caractère représentant le département
     */
    public String toString() {
        return "Departement [idDep=" + idDep + ", nomDep=" + nomDep + ", invesCulturel2019=" + invesCulturel2019 + "]";
    }

    /**
     * Méthode rechercheAeroport qui retourne la liste des aéroports du département
     * @return la liste des aéroports du département
     */
    public ArrayList<Aeroport> rechercheAeroport(){
        ArrayList<Aeroport> ret = new ArrayList<>();
        for(Aeroport aeroport : this.listeAeroports){
            ret.add(aeroport);
        }
        return ret;
    }
}
