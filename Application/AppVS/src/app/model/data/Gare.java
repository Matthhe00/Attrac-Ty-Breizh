package app.model.data;
import java.util.Random;

import app.model.dao.GareDAO;

public class Gare {
    private String codeGare;
    private String nomGare;
    private String estFret;
    private String estVoyageur;
    private String laCommune;

    public Gare(String codeGare, String nomGare, String estFret, String estVoyageur, String laCommune) {
        this.codeGare = codeGare;
        this.nomGare = nomGare;
        this.estFret = estFret;
        this.estVoyageur = estVoyageur;
        this.laCommune = laCommune;
    }


    public Gare(String nomGare, String estFret, String estVoyageur, String laCommune) {
        Random random = new Random();
        String code = "" + random.nextInt(10001);
        GareDAO gareDAO = new GareDAO();
        while (gareDAO.exist(code)) {
            code = "" + code;
        }
        this.codeGare = code; // Génère un nombre aléatoire entre 0 et 10000
        this.nomGare = nomGare;
        this.estFret = estFret;
        this.estVoyageur = estVoyageur;
        this.laCommune = laCommune;
    }
    
    public String getCodeGare() {
        return this.codeGare;
    }

    public String getNomGare() {
        return this.nomGare;
    }

    public String getEstFret() {
        return this.estFret;
    }

    public String getEstVoyageur() {
        return this.estVoyageur;
    }

    public String getLaCommune() {
        return this.laCommune;
    }

    public void setEstFret(String estFret) {
        this.estFret = estFret;
    }

    public void setEstVoyageur(String estVoyageur) {
        this.estVoyageur = estVoyageur;
    }

    public void setNomGare(String nomGare) {
        this.nomGare = nomGare;
    }

    public void setLaCommune(String laCommune) {
        this.laCommune = laCommune;
    }

    public void setCodeGare(String codeGare) {
        this.codeGare = codeGare;
    }

    public String toString() {
        return "Gare [codeGare=" + getCodeGare() + ", estFret=" + getEstFret() + ", estVoyageur=" + getEstVoyageur() + ", laCommune="
                + getLaCommune() + ", nomGare=" + getNomGare() + "]";
    }

}
