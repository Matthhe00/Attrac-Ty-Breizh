package model;

import java.util.ArrayList;

public class Departement {
    
    private int idDep;

    private String nomDep;

    private float invesCulturel2019;

    private ArrayList<Aeroport> listeAeroports;

    public Departement(int idDep, String nomDep, float inves) {
        this.idDep = idDep;
        this.nomDep = nomDep;
        this.invesCulturel2019 = inves;
        this.listeAeroports = new ArrayList<Aeroport>();
    }

    public int getIdDep() {
        return this.idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public String getNomDep() {
        return this.nomDep;
    }

    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    public float getInvesCulturel2019() {
        return this.invesCulturel2019;
    }

    public void setInvesCulturel2019(float invesCulturel2019) {
        this.invesCulturel2019 = invesCulturel2019;
    }

    public ArrayList<Aeroport> getListeAeroports() {
        return this.listeAeroports;
    }

    public void setListeAeroports(ArrayList<Aeroport> listeAeroports) {
        this.listeAeroports = listeAeroports;
    }

    public void addAeroport(Aeroport aeroport) {
        if(aeroport != null){
            this.listeAeroports.add(aeroport);
        }
    }

    public void removeAeroport(Aeroport aeroport){
            this.listeAeroports.remove(aeroport);
    }

    public String toString() {
        return "Departement [idDep=" + idDep + ", nomDep=" + nomDep + ", invesCulturel2019=" + invesCulturel2019 + "]";
    }
}
