package app.model.data;

import java.util.ArrayList;

import app.model.dao.GareDAO;

public class GareFileAccess{
    public ArrayList<Gare> Gares;

    public GareFileAccess() {
        Gares = new ArrayList<Gare>();
        setList();
    }

    public ArrayList<Gare> getGares() {
        return Gares;
    }
    
    public void setList() {
        GareDAO u =  new GareDAO();
        this.Gares = u.findAll();
    }

    public ArrayList<Gare> getGares(String commune) {
        ArrayList<Gare> Gares = new ArrayList<Gare>();
        for (Gare Gare : this.Gares) {
            if (Gare.getLaCommune().equals(commune)) {
                Gares.add(Gare);
            }
        }
        return Gares;
    }

    public ArrayList<Gare> getGareByCommune(String commune) {
        ArrayList<Gare> Gares = new ArrayList<Gare>();
        for (Gare Gare : this.Gares) {
            if (Gare.getLaCommune().equals(commune)) {
                Gares.add(Gare);
            }
        }
        return Gares;
    }

    public Gare getGare(String codeGare) {
        for (Gare Gare : Gares) {
            if (Gare.getCodeGare().equals(codeGare)) {
                return Gare;
            }
        }
        return null;
    }

    public void addGare(Gare Gare) {
        GareDAO u =  new GareDAO();
        this.Gares.add(Gare);
        u.create(Gare);
    }

    public void deleteGare(Gare Gare) {
        GareDAO u =  new GareDAO();
        this.Gares.remove(Gare);
        u.delete(Gare, Gare.getCodeGare());
    }

    public void updateNom(String oldNom , String newNom) {
        GareDAO u =  new GareDAO();
        u.updateNom(oldNom, newNom);
    }

    public void updateFret(String codeGare, String fret) {
        GareDAO u =  new GareDAO();
        u.updateFret(codeGare, fret);
    }

    public void updateVoyageur(String codeGare, String voyageur) {
        GareDAO u =  new GareDAO();
        u.updateVoyageur(codeGare, voyageur);
    }

    public String getNbGare() {
        return String.valueOf(Gares.size());
    }

}
