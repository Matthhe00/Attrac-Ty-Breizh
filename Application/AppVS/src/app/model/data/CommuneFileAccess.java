package app.model.data;

import java.util.ArrayList;

import app.model.dao.CommuneDAO;

public class CommuneFileAccess {
    public ArrayList<Commune> communes;

    public CommuneFileAccess() {
        communes = new ArrayList<Commune>();
        setList();
    }

    public ArrayList<Commune> getCommunes() {
        return communes;
    }
    
    public void setList() {
        CommuneDAO u =  new CommuneDAO();
        this.communes = u.findAll();
    }
}
