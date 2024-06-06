package app.model.data;

import java.util.ArrayList;

import app.model.dao.AnneeCommuneDAO;

public class AnneeCommuneFileAccess {
    public ArrayList<AnneeCommune> annees;

    public AnneeCommuneFileAccess() {
        annees = new ArrayList<AnneeCommune>();
        setList();
    }

    public ArrayList<AnneeCommune> getAnnees() {
        return annees;
    }
    
    public void setList() {
        AnneeCommuneDAO u =  new AnneeCommuneDAO();
        this.annees = u.findAll();
    }

    public AnneeCommune getAnneeCommuneById(String annee, String idCommune) {
        for (AnneeCommune an : this.annees) {
            if (an.getAnnee().getAnnee().equals(annee) && an.getLaCommune().getIdCommune().equals(idCommune)) {
                return an;
            }
        }
        return null;
    }
}
