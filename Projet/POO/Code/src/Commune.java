import java.util.ArrayList;

public class Commune {
    private int idCommune;
    private String nomCommune;
    private Departement leDepartement;
    private ArrayList<Commune> communeVoisine;

    public Commune(int idCommune, String nomCommune, Departement leDepartement) {
        this.idCommune = idCommune;
        this.nomCommune = nomCommune;
        this.leDepartement = leDepartement;
        this.communeVoisine = new ArrayList<Commune>();

    }

    public void addCommuneVoisine(Commune commune) {
        this.communeVoisine.add(commune);
    }

    public void removeCommuneVoisine(Commune commune) {
        this.communeVoisine.remove(commune);
    }

    public int getIdCommune() {
        return this.idCommune;
    }

    public void setIdCommune(int idCommune) {
        this.idCommune = idCommune;
    }

    public String getNomCommune() {
        return this.nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public Departement getLeDepartement() {
        return this.leDepartement;
    }

    public void setLeDepartement(Departement leDepartement) {
        this.leDepartement = leDepartement;
    }

    public ArrayList<Commune> getCommuneVoisine() {
        return this.communeVoisine;
    }

    public void setCommuneVoisine(ArrayList<Commune> communeVoisine) {
        this.communeVoisine = communeVoisine;
    }

    public String toString() {
        return "Commune [idCommune=" + idCommune + ", leDepartement=" + getLeDepartement() + ", nomCommune=" + nomCommune + "]";
    }
}
