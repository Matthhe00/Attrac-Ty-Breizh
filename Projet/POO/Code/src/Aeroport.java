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
}
