package app.model.data;
import java.util.ArrayList;

public class Commune {
    private String idCommune;
    private String nomCommune;
    private String leDepartement;
    private ArrayList<Commune> communeVoisine;
    private ArrayList<Gare> listeGares;

    public Commune(String idCommune, String nomCommune, String leDepartement) {
        this.idCommune = idCommune;
        this.nomCommune = nomCommune;
        this.leDepartement = leDepartement;
        this.communeVoisine = new ArrayList<Commune>();
        this.listeGares = new ArrayList<Gare>();
    }

    public void addCommuneVoisine(Commune commune) {
        this.communeVoisine.add(commune);
    }

    public void removeCommuneVoisine(Commune commune) {
        this.communeVoisine.remove(commune);
    }

    public String getIdCommune() {
        return this.idCommune;
    }

    public void setIdCommune(String idCommune) {
        this.idCommune = idCommune;
    }

    public String getNomCommune() {
        return this.nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public String getLeDepartement() {
        return this.leDepartement;
    }

    public void setLeDepartement(String leDepartement) {
        this.leDepartement = leDepartement;
    }

    public ArrayList<Commune> getCommuneVoisine() {
        return this.communeVoisine;
    }

    public void setCommuneVoisine(ArrayList<Commune> communeVoisine) {
        this.communeVoisine = communeVoisine;
    }

    public ArrayList<Gare> getListeGares() {
        return this.listeGares;
    }

    public void setListeGares(ArrayList<Gare> listeGares) {
        this.listeGares = listeGares;
    }

    public void addGare(Gare gare) {
        if(gare != null){
            this.listeGares.add(gare);
        }
    }

    public void removeGare(Gare gare) {
        this.listeGares.remove(gare);
    }

    public String toString() {
        return "Commune [idCommune=" + idCommune + ", leDepartement=" + getLeDepartement() + ", nomCommune=" + nomCommune + "]";
    }
}
