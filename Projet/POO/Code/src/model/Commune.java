package model;
import java.util.ArrayList;

/**
 * Classe Commune
 * Pour chaque commune, on a un identifiant, un nom, un département, une liste de communes voisines et une liste de gares
 * @author Schell Yanis, Jules-Vachet Mattheo, Gauffeny Paul
 */
public class Commune {

    /**
     * Attributs idCommune un entier qui représente le code postal de la commune
     */
    private int idCommune;

    /**
     * Attributs nomCommune une chaine de caractère qui représente le nom de la commune
     */
    private String nomCommune;

    /**
     * Attributs leDepartement un objet de type Departement qui représente le département de la commune
     */
    private Departement leDepartement;

    /**
     * Attributs communeVoisine une liste de communes qui représente les communes voisines à la commune
     */
    private ArrayList<Commune> communeVoisine;

    /**
     * Attributs listeGares une liste de gares qui représente les gares de la commune
     */
    private ArrayList<Gare> listeGares;

    /**
     * Constructeur de la classe Commune
     * @param idCommune un entier qui représente le code postal de la commune
     * @param nomCommune une chaine de caractère qui représente le nom de la commune
     * @param leDepartement un objet de type Departement qui représente le département de la commune
     */
    public Commune(int idCommune, String nomCommune, Departement leDepartement) {
        this.idCommune = idCommune;
        this.nomCommune = nomCommune;
        this.leDepartement = leDepartement;
        this.communeVoisine = new ArrayList<Commune>();
        this.listeGares = new ArrayList<Gare>();

    }

    /**
     * Méthode addCommuneVoisine qui ajoute une commune voisine à la liste des communes voisines
     * @param commune une commune qui représente la commune voisine à ajouter
     */
    public void addCommuneVoisine(Commune commune) {
        this.communeVoisine.add(commune);
    }

    /**
     * Méthode removeCommuneVoisine qui supprime une commune voisine de la liste des communes voisines
     * @param commune une commune qui représente la commune voisine à supprimer
     */
    public void removeCommuneVoisine(Commune commune) {
        this.communeVoisine.remove(commune);
    }

    /**
     * Méthode getIdCommune qui retourne le code postal de la commune
     * @return le code postal de la commune
     */
    public int getIdCommune() {
        return this.idCommune;
    }

    /**
     * Méthode setIdCommune qui modifie le code postal de la commune
     * @param idCommune la nouvelle valeur du code postal de la commune
     */
    public void setIdCommune(int idCommune) {
        this.idCommune = idCommune;
    }

    /**
     * Méthode getNomCommune qui retourne le nom de la commune
     * @return le nom de la commune
     */
    public String getNomCommune() {
        return this.nomCommune;
    }

    /**
     * Méthode setNomCommune qui modifie le nom de la commune
     * @param nomCommune la nouvelle valeur du nom de la commune
     */
    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    /**
     * Méthode getLeDepartement qui retourne le département de la commune
     * @return le département de la commune
     */
    public Departement getLeDepartement() {
        return this.leDepartement;
    }

    /**
     * Méthode setLeDepartement qui modifie le département de la commune
     * @param leDepartement la nouvelle valeur du département de la commune
     */
    public void setLeDepartement(Departement leDepartement) {
        this.leDepartement = leDepartement;
    }

    /**
     * Méthode getCommuneVoisine qui retourne la liste des communes voisines
     * @return la liste des communes voisines
     */
    public ArrayList<Commune> getCommuneVoisine() {
        return this.communeVoisine;
    }

    /**
     * Méthode setCommuneVoisine qui modifie la liste des communes voisines
     * @param communeVoisine la nouvelle valeur de la liste des communes voisines
     */
    public void setCommuneVoisine(ArrayList<Commune> communeVoisine) {
        this.communeVoisine = communeVoisine;
    }

    /**
     * Méthode getListeGares qui retourne la liste des gares
     * @return la liste des gares
     */
    public ArrayList<Gare> getListeGares() {
        return this.listeGares;
    }

    /**
     * Méthode setListeGares qui modifie la liste des gares
     * @param listeGares la nouvelle valeur de la liste des gares
     */
    public void setListeGares(ArrayList<Gare> listeGares) {
        this.listeGares = listeGares;
    }

    /**
     * Méthode addGare qui ajoute une gare à la liste des gares
     * @param gare une gare qui représente la gare à ajouter
     */
    public void addGare(Gare gare) {
        if(gare != null){
            this.listeGares.add(gare);
        }
    }

    /**
     * Méthode removeGare qui supprime une gare de la liste des gares
     * @param gare une gare qui représente la gare à supprimer
     */
    public void removeGare(Gare gare) {
        this.listeGares.remove(gare);
    }

    /**
     * Méthode toString qui retourne une chaine de caractère qui représente la commune
     * @return une chaine de caractère qui représente la commune
     */
    public String toString() {
        return "Commune [idCommune=" + idCommune + ", leDepartement=" + getLeDepartement() + ", nomCommune=" + nomCommune + "]";
    }

    /**
     * Méthode communeMaxCommuneVoisine qui retourne la commune ayant le plus de communes voisines
     * @param communeVoisines un tableau de communes qui représente les communes voisines
     * @return la commune ayant le plus de communes voisines
     */
    public Commune communeMaxCommuneVoisine(Commune[] communeVoisines){
        Commune communeMax;
        if(communeVoisines == null){
            communeMax = null;
        }else{
            communeMax = this;
            for (int i = 1; i < communeVoisines.length; i++) {
                if(communeVoisines[i].getCommuneVoisine().size() > communeMax.getCommuneVoisine().size()){
                    communeMax = communeVoisines[i];
                }
            }
        }
        return communeMax;
    }
    
}
