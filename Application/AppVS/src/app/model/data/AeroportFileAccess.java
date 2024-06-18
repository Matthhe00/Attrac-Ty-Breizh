package app.model.data;

import java.util.ArrayList;

import app.model.dao.AeroportDAO;

public class AeroportFileAccess {
    public ArrayList<Aeroport> Aeroports;

    public AeroportFileAccess() {
        Aeroports = new ArrayList<Aeroport>();
        setList();
    }

    public ArrayList<Aeroport> getAeroports() {
        return Aeroports;
    }

    // public void addAeroport(Aeroport Aeroport) {
    //     AeroportDAO u =  new AeroportDAO();
    //     this.Aeroports.add(Aeroport);
    //     u.create(Aeroport);
    // }

    // public void deleteAeroport(Aeroport Aeroport) {
    //     AeroportDAO u =  new AeroportDAO();
    //     this.Aeroports.remove(Aeroport);
    //     u.delete(Aeroport, Aeroport.getLogin());
    // }

    // public void updateAeroport(Aeroport Aeroport, String login, String role) {
    //     AeroportDAO u =  new AeroportDAO();
    //     u.update(Aeroport, login, role);
    // }

    // public void loadAeroports() {
    //     AeroportDAO u =  new AeroportDAO();
    //     this.Aeroports = u.findAll();
    // }


    public ArrayList<Aeroport> getAeroports(String departement) {
        ArrayList<Aeroport> Aeroports = new ArrayList<Aeroport>();
        for (Aeroport Aeroport : this.Aeroports) {
            if (Aeroport.getLeDepartement().equals(departement)) {
                Aeroports.add(Aeroport);
            }
        }
        return Aeroports;
    }
    
    public void setList() {
        AeroportDAO u =  new AeroportDAO();
        this.Aeroports = u.findAll();
    }

    public ArrayList<Aeroport> getAeroportByDepartement(String departement) {
        ArrayList<Aeroport> Aeroports = new ArrayList<Aeroport>();
        for (Aeroport Aeroport : this.Aeroports) {
            if (Aeroport.getLeDepartement().equals(departement)) {
                Aeroports.add(Aeroport);
            }
        }
        return Aeroports;
    }
}
