package app.model.data;
public class AnneeCommune {
    private Annee annee;
    private Commune laCommune;
    private String nbMaison;
    private String nbAppart;
    private String prixMoyen;
    private String prixM2Moyen;
    private String surfaceMoy;
    private String depCulturellesTotal;
    private String budgetTotal;
    private String population;

    public AnneeCommune(Annee annee, Commune laCommune, String nbMaison, String nbAppart, String prixMoyen, String prixM2Moyen, String surfaceMoy, String depCulturellesTotal, String budgetTotal, String population) {
        this.annee = annee;
        this.laCommune = laCommune;
        this.nbMaison = nbMaison;
        this.nbAppart = nbAppart;
        this.prixMoyen = prixMoyen;
        this.prixM2Moyen = prixM2Moyen;
        this.surfaceMoy = surfaceMoy;
        this.depCulturellesTotal = depCulturellesTotal;
        this.budgetTotal = budgetTotal;
        this.population = population;
    }

    public Annee getAnnee() {
        return this.annee;
    }

    public void setAnnee(Annee annee) {
        this.annee = annee;
    }

    public Commune getLaCommune() {
        return this.laCommune;
    }

    public void setLaCommune(Commune laCommune) {
        this.laCommune = laCommune;
    }

    public String getNbMaison() {
        return this.nbMaison;
    }

    public void setNbMaison(String nbMaison) {
        this.nbMaison = nbMaison;
    }

    public String getNbAppart() {
        return this.nbAppart;
    }

    public void setNbAppart(String nbAppart) {
        this.nbAppart = nbAppart;
    }

    public String getPrixMoyen() {
        return this.prixMoyen;
    }

    public void setPrixMoyen(String prixMoyen) {
        this.prixMoyen = prixMoyen;
    }

    public String getPrixM2Moyen() {
        return this.prixM2Moyen;
    }

    public void setPrixM2Moyen(String prixM2Moyen) {
        this.prixM2Moyen = prixM2Moyen;
    }

    public String getSurfaceMoy() {
        return this.surfaceMoy;
    }

    public void setSurfaceMoy(String surfaceMoy) {
        this.surfaceMoy = surfaceMoy;
    }

    public String getDepCulturellesTotal() {
        return this.depCulturellesTotal;
    }

    public void setDepCulturellesTotal(String depCulturellesTotal) {
        this.depCulturellesTotal = depCulturellesTotal;
    }

    public String getBudgetTotal() {
        return this.budgetTotal;
    }

    public void setBudgetTotal(String budgetTotal) {
        this.budgetTotal = budgetTotal;
    }

    public String getPopulation() {
        return this.population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String toString() {
        return "AnneeCommune [annee=" + getAnnee() + ", budgetTotal=" + getBudgetTotal() + ", depCulturellesTotal="
                + getDepCulturellesTotal() + ", laCommune=" + getLaCommune() + ", nbAppart=" + getNbAppart() + ", nbMaison=" + getNbMaison()
                + ", population=" + getPopulation() + ", prixM2Moyen=" + getPrixM2Moyen() + ", prixMoyen=" + getPrixMoyen()
                + ", surfaceMoy=" + getSurfaceMoy() + "]";
    }    
}
