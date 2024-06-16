package model;

import java.util.ArrayList;

public class Gare {
    private int codeGare;
    private String nomGare;
    private boolean estFret;
    private boolean estVoyageur;
    private Commune laCommune;
    private ArrayList<Gare> gareDestination;

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

    public void setCodeGare(int codeGare) {
        this.codeGare = codeGare;
    }

    public String toString() {
        return "Gare [codeGare=" + getCodeGare() + ", estFret=" + getEstFret() + ", estVoyageur=" + getEstVoyageur() + ", laCommune="
                + getLaCommune() + ", nomGare=" + getNomGare() + "]";
    }

    public void addDestinationGare(Gare gare){
        if(gare != null){
            this.gareDestination.add(gare);
        }
    }

    public void removeDestinationGare(Gare gare){
        if(gare != null){
            this.gareDestination.remove(gare);
        }
    }

    public ArrayList<Gare> getDestinationGare() {
        return this.gareDestination;
    }

    public void setDestinationGare(ArrayList<Gare> gareDestination) {
        this.gareDestination = gareDestination;
    }

    public void rechercheDestinationGare(String nomGare){
        boolean trouve = false;
        for(Gare gare : this.gareDestination){
            if(gare.getNomGare().equals(nomGare)){
                System.out.println("La gare de " + this.nomGare + " dessert bien à " + nomGare);
                trouve = true;
            }
        }
        if(!trouve){
            System.out.println("La gare de " + this.nomGare + " ne dessert bien à " + nomGare);
        }
    }
}
