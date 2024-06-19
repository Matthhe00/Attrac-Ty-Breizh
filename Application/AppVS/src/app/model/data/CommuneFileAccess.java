package app.model.data;

import java.util.ArrayList;

import app.model.dao.CommuneDAO;

public class CommuneFileAccess {
    public ArrayList<Commune> communes;
    public ArrayList<Commune> communesV;
    private CommuneDAO u =  new CommuneDAO();


    public CommuneFileAccess() {
        communes = new ArrayList<Commune>();
        setList();
    }

    public ArrayList<Commune> getCommunes() {
        return communes;
    }

    public ArrayList<Commune> getCommuneVoisine(String idCommune) {
        this.communesV = u.findAllVoisine(idCommune);
        return communesV;
    }
    
    public void setList() {
        CommuneDAO u =  new CommuneDAO();
        this.communes = u.findAll();
    }

    public void setList(String idCommune) {
        CommuneDAO u =  new CommuneDAO();
        this.communesV = u.findAllVoisine(idCommune);
    }

    public Commune getCommuneById(String idCommune) {
        for (Commune commune : this.communes) {
            if (commune.getIdCommune().equals(idCommune)) {
                return commune;
            }
        }
        return null;
    }

    public String getNbCommune() {
        return String.valueOf(this.communes.size());
    }

}
