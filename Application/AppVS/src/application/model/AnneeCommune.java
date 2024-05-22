package application.model;


public class AnneeCommune {
    private Annee annee;
    private Commune laCommune;

    public AnneeCommune(Annee annee, Commune laCommune) {
        this.annee = annee;
        this.laCommune = laCommune;
    }

    public Annee getAnnee() {
        return this.annee;
    }

    public Commune getLaCommune() {
        return this.laCommune;
    }

    public void setAnnee(Annee annee) {
        this.annee = annee;
    }

    public void setLaCommune(Commune laCommune) {
        this.laCommune = laCommune;
    }
}
