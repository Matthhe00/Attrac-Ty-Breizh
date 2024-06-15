package model;
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

    public void afficherCompareTo(String commune1, String commune2, int[] tab, String[] nomVal){
        System.out.println("Comparaison des données de " + commune1 + " et " + commune2 + " :");
        for(int i = 0; i < nomVal.length; i++){
                if(tab[i] == 0){
                    System.out.print("Les deux communes ont la même valeur");
                    System.out.println(" pour " + nomVal[i]);
                }
                else if(tab[i] == 1){
                    System.out.print(commune1 + " a une valeur supérieure à " + commune2);
                    System.out.println(" pour " + nomVal[i]);
                }
                else{
                    System.out.print(commune1 + " a une valeur inférieure à " + commune2);
                    System.out.println(" pour " + nomVal[i]);
                }
        }
    }
    
    public int[] compareTo(AnneeCommune otherAnneeCommune) {
    
        int[] result = new int[8];
        String[] nomValeurs = {"le nombre de maison vendus", "le nombre d'appartements vendus", "le prix moyen", "le prix moyen au m2",
        "la surface moyenne", "les dépenses culturelles totales", "le budget total", "la population"};

        if(this.getNbMaison() < otherAnneeCommune.getNbMaison()){
            result[0] = -1;
        }
        else if(this.getNbMaison() > otherAnneeCommune.getNbMaison()){
            result[0] = 1;
        }
        else{
            result[0] = 0;
        }

        if(this.getNbAppart() < otherAnneeCommune.getNbAppart()){
            result[1] = -1;
        }
        else if(this.getNbAppart() > otherAnneeCommune.getNbAppart()){
            result[1] = 1;
        }
        else{
            result[1] = 0;
        }

        if(this.getPrixMoyen() < otherAnneeCommune.getPrixMoyen()){
            result[2] = -1;
        }
        else if(this.getPrixMoyen() > otherAnneeCommune.getPrixMoyen()){
            result[2] = 1;
        }
        else{
            result[2] = 0;
        }

        if(this.getPrixM2Moyen() < otherAnneeCommune.getPrixM2Moyen()){
            result[3] = -1;
        }
        else if(this.getPrixM2Moyen() > otherAnneeCommune.getPrixM2Moyen()){
            result[3] = 1;
        }
        else{
            result[3] = 0;
        }

        if(this.getSurfaceMoy() < otherAnneeCommune.getSurfaceMoy()){
            result[4] = -1;
        }
        else if(this.getSurfaceMoy() > otherAnneeCommune.getSurfaceMoy()){
            result[4] = 1;
        }
        else{
            result[4] = 0;
        }

        if(this.getDepCulturellesTotal() < otherAnneeCommune.getDepCulturellesTotal()){
            result[5] = -1;
        }
        else if(this.getDepCulturellesTotal() > otherAnneeCommune.getDepCulturellesTotal()){
            result[5] = 1;
        }
        else{
            result[5] = 0;
        }

        if(this.getBudgetTotal() < otherAnneeCommune.getBudgetTotal()){
            result[6] = -1;
        }
        else if(this.getBudgetTotal() > otherAnneeCommune.getBudgetTotal()){
            result[6] = 1;
        }
        else{
            result[6] = 0;
        }

        if(this.getPopulation() < otherAnneeCommune.getPopulation()){
            result[7] = -1;
        }
        else if(this.getPopulation() > otherAnneeCommune.getPopulation()){
            result[7] = 1;
        }
        else{
            result[7] = 0;
        }

        afficherCompareTo(this.getLaCommune().getNomCommune(), otherAnneeCommune.getLaCommune().getNomCommune(), result, nomValeurs);
        return result;
    }
    
}
