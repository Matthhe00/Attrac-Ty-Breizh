package app.model.data;

import java.util.ArrayList;

import app.model.dao.AnneeDAO;

public class AnneeFileAccess {
    public ArrayList<Annee> annees;

    public AnneeFileAccess() {
        annees = new ArrayList<Annee>();
        setList();
    }

    public ArrayList<Annee> getAnnees() {
        return annees;
    }
    
    public void setList() {
        AnneeDAO u =  new AnneeDAO();
        this.annees = u.findAll();
    }

}
