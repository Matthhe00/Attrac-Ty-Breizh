package model;

import java.util.ArrayList;

public class Aeroport {
    private Departement leDepartement;
    private String nom;
    private String adresse;

    private ArrayList<Aeroport> aeroportsDestination;

    public Aeroport(Departement leDepartement, String nom, String adresse) {
        this.leDepartement = leDepartement;
        this.nom = nom;
        this.adresse = adresse;
        this.aeroportsDestination = new ArrayList<Aeroport>();
    }

    public Departement getLeDepartement() {
        return this.leDepartement;
    }
 
    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setLeDepartement(Departement leDepartement) {
        this.leDepartement = leDepartement;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String toString() {
        return "Aeroport [adresse=" + getAdresse() + ", leDepartement=" + getLeDepartement() + ", nom=" + getNom() + "]";
    }

    

    public void addDestinationAeroport(Aeroport aeroport){
        if(aeroport != null){
            this.aeroportsDestination.add(aeroport);
        }
    }

    public void removeDestinationAeroport(Aeroport aeroport){
        if(aeroport != null){
            this.aeroportsDestination.remove(aeroport);
        }
    }

    public ArrayList<Aeroport> getDestinationAeroport() {
        return this.aeroportsDestination;
    }

    public void setDestinationAeroport(ArrayList<Aeroport> aeroportsDestination) {
        this.aeroportsDestination = aeroportsDestination;
    }

    public void rechercheDestinationAeroport(String nomAeroport){
        boolean trouve = false;
        for(Aeroport aeroport : this.aeroportsDestination){
            if(aeroport.getNom().equals(nomAeroport)){
                System.out.println("L'aeroport de " + this.nom + " dessert bien à " + nomAeroport);
                trouve = true;
            }
        }

        if(!trouve){
            System.out.println("L'aeroport de " + this.nom + " ne dessert pas à " + nomAeroport);
        }
    }

}
