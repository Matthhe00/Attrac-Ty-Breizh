package model;
public class Annee {
    private int annee;
    private float tauxInflation;

    public Annee(int annee, float tauxInflation) {
        this.annee = annee;
        this.tauxInflation = tauxInflation;
    }

    public int getAnnee() {
        return this.annee;
    }

    public float getTauxInflation() {
        return this.tauxInflation;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setTauxInflation(float tauxInflation) {
        this.tauxInflation = tauxInflation;
    }

    public String toString() {
        return "Annee [annee=" + getAnnee() + ", tauxInflation=" + getTauxInflation() + "]";
    }

    public Annee anneeMaxInflation(Annee[] annee){
        Annee anneeMax;
        if(annee == null){
            anneeMax = null;
        }else{
            anneeMax = annee[0];
            for (int i = 1; i < annee.length; i++) {
                if(annee[i].getTauxInflation() > anneeMax.getTauxInflation()){
                    anneeMax = annee[i];
                }
            }
        }
        return anneeMax;
    }
    
}
