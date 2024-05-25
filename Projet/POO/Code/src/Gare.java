public class Gare {
    private int codeGare;
    private String nomGare;
    private boolean estFret;
    private boolean estVoyageur;
    private Commune laCommune;

    public Gare(int codeGare, String nomGare, boolean estFret, boolean estVoyageur, Commune laCommune) {
        this.codeGare = codeGare;
        this.nomGare = nomGare;
        this.estFret = estFret;
        this.estVoyageur = estVoyageur;
        this.laCommune = laCommune;

    }
    
    public int getCodeGare() {
        return this.codeGare;
    }

    public String getNomGare() {
        return this.nomGare;
    }

    public boolean getEstFret() {
        return this.estFret;
    }

    public boolean getEstVoyageur() {
        return this.estVoyageur;
    }

    public Commune getLaCommune() {
        return this.laCommune;
    }

    public void setEstFret(boolean estFret) {
        this.estFret = estFret;
    }

    public void setEstVoyageur(boolean estVoyageur) {
        this.estVoyageur = estVoyageur;
    }

    public void setNomGare(String nomGare) {
        this.nomGare = nomGare;
    }

    public void setLaCommune(Commune laCommune) {
        this.laCommune = laCommune;
    }

}
