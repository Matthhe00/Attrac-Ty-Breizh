package application.model;

import java.util.ArrayList;

public class Commune {
    private int idCommune;
    private String nomCommune;
    private Departement leDepartement;
    private ArrayList<Commune> communeVoisine;

    public Commune() {

    }

    public int getIdCommune() {
        return this.idCommune;
    }

    public String getNomCommune() {
        return this.nomCommune;
    }

    public void nomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }
}
