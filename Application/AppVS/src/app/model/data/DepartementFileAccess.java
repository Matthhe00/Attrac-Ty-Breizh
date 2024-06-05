package app.model.data;

import java.util.ArrayList;

import app.model.dao.DepartementDAO;

public class DepartementFileAccess {
    public ArrayList<Departement> departements;

    public DepartementFileAccess() {
        departements = new ArrayList<Departement>();
        setList();
    }

    public ArrayList<Departement> getDepartements() {
        return departements;
    }
    
    public void setList() {
        DepartementDAO u =  new DepartementDAO();
        this.departements = u.findAll();
    }

    public Departement getDepartementById(String idDepartement) {
        for (Departement departement : this.departements) {
            if (departement.getIdDep().equals(idDepartement)) {
                return departement;
            }
        }
        return null;
    }
}
