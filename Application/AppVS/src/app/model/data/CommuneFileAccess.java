package app.model.data;

import java.util.ArrayList;

import app.model.dao.CommuneDAO;

/**
 * Classe CommuneFileAccess
 */
public class CommuneFileAccess {

    /**
     * Liste des communes
     */
    public ArrayList<Commune> communes;

    /**
     * Liste des communes voisines
     */
    public ArrayList<Commune> communesV;

    /**
     * Accès aux fichiers de communes
     */
    private CommuneDAO u =  new CommuneDAO();

    /**
     * Constructeur de la classe CommuneFileAccess
     */
    public CommuneFileAccess() {
        communes = new ArrayList<Commune>();
        setList();
    }

    /**
     * Retourne la liste des communes
     * @return Liste des communes
     */
    public ArrayList<Commune> getCommunes() {
        return communes;
    }

    /**
     * Retourne la liste des communes voisines
     * @return Liste des communes voisines
     */
    public ArrayList<Commune> getCommuneVoisine(String idCommune) {
        this.communesV = u.findAllVoisine(idCommune);
        return communesV;
    }
    
    /**
     * initialise la liste des communes
     */
    public void setList() {
        CommuneDAO u =  new CommuneDAO();
        this.communes = u.findAll();
    }

    /**
     * initialise la liste des communes voisines
     */
    public void setList(String idCommune) {
        CommuneDAO u =  new CommuneDAO();
        this.communesV = u.findAllVoisine(idCommune);
    }

    /**
     * Retourne une commune par son id
     * @param idCommune Id de la commune
     * @return Commune
     */
    public Commune getCommuneById(String idCommune) {
        for (Commune commune : this.communes) {
            if (commune.getIdCommune().equals(idCommune)) {
                return commune;
            }
        }
        return null;
    }

    /**
     * Retourne le nombre de communes
     * @return Nombre de communes
     */
    public String getNbCommune() {
        return String.valueOf(this.communes.size());
    }

}
