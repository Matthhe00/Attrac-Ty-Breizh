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
}
