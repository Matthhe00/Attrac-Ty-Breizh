public class AnneeCommune {
    private Annee annee;
    private Commune laCommune;
    private int nbMaison;
    private int nbAppart;
    private float prixMoyen;
    private float prixM2Moyen;
    private float surfaceMoy;
    private float depCulturellesTotal;
    private float budgetTotal;
    private float population;

    public AnneeCommune(Annee annee, Commune laCommune, int nbMaison, int nbAppart, float prixMoyen, float prixM2Moyen, float surfaceMoy, float depCulturellesTotal, float budgetTotal, float population) {
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

    public int getNbMaison() {
        return this.nbMaison;
    }

    public void setNbMaison(int nbMaison) {
        this.nbMaison = nbMaison;
    }

    public int getNbAppart() {
        return this.nbAppart;
    }

    public void setNbAppart(int nbAppart) {
        this.nbAppart = nbAppart;
    }

    public float getPrixMoyen() {
        return this.prixMoyen;
    }

    public void setPrixMoyen(float prixMoyen) {
        this.prixMoyen = prixMoyen;
    }

    public float getPrixM2Moyen() {
        return this.prixM2Moyen;
    }

    public void setPrixM2Moyen(float prixM2Moyen) {
        this.prixM2Moyen = prixM2Moyen;
    }

    public float getSurfaceMoy() {
        return this.surfaceMoy;
    }

    public void setSurfaceMoy(float surfaceMoy) {
        this.surfaceMoy = surfaceMoy;
    }

    public float getDepCulturellesTotal() {
        return this.depCulturellesTotal;
    }

    public void setDepCulturellesTotal(float depCulturellesTotal) {
        this.depCulturellesTotal = depCulturellesTotal;
    }

    public float getBudgetTotal() {
        return this.budgetTotal;
    }

    public void setBudgetTotal(float budgetTotal) {
        this.budgetTotal = budgetTotal;
    }

    public float getPopulation() {
        return this.population;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public String toString() {
        return "AnneeCommune [annee=" + getAnnee() + ", budgetTotal=" + getBudgetTotal() + ", depCulturellesTotal="
                + getDepCulturellesTotal() + ", laCommune=" + getLaCommune() + ", nbAppart=" + getNbAppart() + ", nbMaison=" + getNbMaison()
                + ", population=" + getPopulation() + ", prixM2Moyen=" + getPrixM2Moyen() + ", prixMoyen=" + getPrixMoyen()
                + ", surfaceMoy=" + getSurfaceMoy() + "]";
    }
}
