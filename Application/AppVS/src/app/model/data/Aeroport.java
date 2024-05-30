package app.model.data;
public class Aeroport {
    private Departement leDepartement;
    private String nom;
    private String adresse;

    public Aeroport(Departement leDepartement, String nom, String adresse) {
        this.leDepartement = leDepartement;
        this.nom = nom;
        this.adresse = adresse;
    }

    public Departement getLeDepartement() {
        return this.leDepartement;
    }

    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setLeDepartement(Departement leDepartement) {
        this.leDepartement = leDepartement;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String toString() {
        return "Aeroport [adresse=" + getAdresse() + ", leDepartement=" + getLeDepartement() + ", nom=" + getNom() + "]";
    }
}
