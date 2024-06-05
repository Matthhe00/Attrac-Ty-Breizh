package app.model.data;
public class Annee {
    private String annee;
    private String tauxInflation;

    public Annee(String annee, String tauxInflation) {
        this.annee = annee;
        this.tauxInflation = tauxInflation;
    }

    public String getAnnee() {
        return this.annee;
    }

    public String getTauxInflation() {
        return this.tauxInflation;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public void setTauxInflation(String tauxInflation) {
        this.tauxInflation = tauxInflation;
    }

    public String toString() {
        return "Annee [annee=" + getAnnee() + ", tauxInflation=" + getTauxInflation() + "]";
    }
    
}
