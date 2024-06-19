package app.model.data;
import java.util.ArrayList;

/**
 * Classe Commune
 */
public class Commune {

    /**
     * Identifiant de la commune
     */
    private String idCommune;

    /**
     * Nom de la commune
     */
    private String nomCommune;

    /**
     * Département de la commune
     */
    private String leDepartement;

    /**
     * Liste des communes voisines
     */
    private ArrayList<Commune> communeVoisine;

    /**
     * Liste des gares
     */
    private ArrayList<Gare> listeGares;

    /**
     * Accès aux fichiers de gares
     */
    private GareFileAccess gareFileAccess;

    /**
     * Constructeur de la classe Commune
     * @param idCommune Identifiant de la commune
     * @param nomCommune Nom de la commune
     * @param leDepartement Département de la commune
     */
    public Commune(String idCommune, String nomCommune, String leDepartement) {
        this.idCommune = idCommune;
        this.nomCommune = nomCommune;
        this.leDepartement = leDepartement;
        this.communeVoisine = new ArrayList<Commune>();
        this.listeGares = new ArrayList<Gare>();
        this.gareFileAccess = new GareFileAccess();
        initGares();
    }

    /**
     * Initialise la liste des gares
     */
    private void initGares() {
        this.listeGares = this.gareFileAccess.getGares(this.idCommune);
    }

    /**
     * Ajoute une commune voisine
     * @param commune Commune voisine
     */
    public void addCommuneVoisine(Commune commune) {
        this.communeVoisine.add(commune);
    }

    /**
     * Retire une commune voisine
     * @param commune Commune voisine
     */
    public void removeCommuneVoisine(Commune commune) {
        this.communeVoisine.remove(commune);
    }

    /**
     * Retourne l'identifiant de la commune
     * @return idCommune
     */
    public String getIdCommune() {
        return this.idCommune;
    }

    /**
     * Modifie l'identifiant de la commune
     * @param idCommune
     */
    public void setIdCommune(String idCommune) {
        this.idCommune = idCommune;
    }

    /**
     * Retourne le nom de la commune
     * @return nomCommune
     */
    public String getNomCommune() {
        return this.nomCommune;
    }

    /**
     * Modifie le nom de la commune
     * @param nomCommune
     */
    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    /**
     * Retourne le département de la commune
     * @return leDepartement
     */
    public String getLeDepartement() {
        return this.leDepartement;
    }

    /**
     * Modifie le département de la commune
     * @param leDepartement
     */
    public void setLeDepartement(String leDepartement) {
        this.leDepartement = leDepartement;
    }

    /**
     * Retourne la liste des communes voisines
     * @return communeVoisine
     */
    public ArrayList<Commune> getCommuneVoisine() {
        return this.communeVoisine;
    }

    /**
     * Modifie la liste des communes voisines
     * @param communeVoisine
     */
    public void setCommuneVoisine(ArrayList<Commune> communeVoisine) {
        this.communeVoisine = communeVoisine;
    }

    /**
     * Retourne la liste des gares
     * @return listeGares
     */
    public ArrayList<Gare> getListeGares() {
        return this.listeGares;
    }

    /**
     * Modifie la liste des gares
     * @param listeGares
     */
    public void setListeGares(ArrayList<Gare> listeGares) {
        this.listeGares = listeGares;
    }

    /**
     * Ajoute une gare
     * @param gare Gare
     */
    public void addGare(Gare gare) {
        if(gare != null){
            this.listeGares.add(gare);
        }
    }

    /**
     * Retire une gare
     * @param gare Gare
     */
    public void removeGare(Gare gare) {
        this.listeGares.remove(gare);
    }

    /**
     * Retourne une gare par son nom
     * @param nom Nom de la gare
     * @return Gare
     */
    public String toString() {
        return "Commune [idCommune=" + idCommune + ", leDepartement=" + getLeDepartement() + ", nomCommune=" + nomCommune + "]";
    }
}
