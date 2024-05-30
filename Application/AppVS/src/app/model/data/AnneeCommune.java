package app.model.data;
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

    String compareValues(String nomDonnee, double valeur1, double valeur2, String nomCommune1, String nomCommune2) {
        if (valeur1 > valeur2) {
            return nomDonnee + " de " + nomCommune1 + " est superieur à " + nomCommune2 + "\n";
        } else if (valeur1 < valeur2) {
            return nomDonnee + " de " + nomCommune1 + " est inferieur à " + nomCommune2 + "\n";
        } else if (valeur1 == valeur2) {
            return nomDonnee + " de " + nomCommune1 + " est egal à " + nomCommune2 + "\n";
        } else {
            return "";
        }
    }
    
    public String compareTo(AnneeCommune otherAnneeCommune) {
        String result = "";
    
        String nomCommune1 = this.getLaCommune().getNomCommune();
        String nomCommune2 = otherAnneeCommune.getLaCommune().getNomCommune();
    
        result += compareValues("\tLe budget total", this.getBudgetTotal(), otherAnneeCommune.getBudgetTotal(), nomCommune1, nomCommune2);
        result += compareValues("\tLes dépenses culturelles totales", this.getDepCulturellesTotal(), otherAnneeCommune.getDepCulturellesTotal(), nomCommune1, nomCommune2);
        result += compareValues("\tLe nombre d'appartements vendu", this.getNbAppart(), otherAnneeCommune.getNbAppart(), nomCommune1, nomCommune2);
        result += compareValues("\tLe nombre de maisons vendu", this.getNbMaison(), otherAnneeCommune.getNbMaison(), nomCommune1, nomCommune2);
        result += compareValues("\tLe prix moyen du m2", this.getPrixM2Moyen(), otherAnneeCommune.getPrixM2Moyen(), nomCommune1, nomCommune2);
        result += compareValues("\tLe prix moyen des logements", this.getPrixMoyen(), otherAnneeCommune.getPrixMoyen(), nomCommune1, nomCommune2);
        result += compareValues("\tLa surface moyenne des logements", this.getSurfaceMoy(), otherAnneeCommune.getSurfaceMoy(), nomCommune1, nomCommune2);
    
        return result;
    }
    
}
