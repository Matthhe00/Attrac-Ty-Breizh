package app.model.data;

import java.util.ArrayList;

import app.model.dao.AnneeDAO;

/**
 * Classe AnneeFileAccess
 */
public class AnneeFileAccess {

    /**
     * Liste des années
     */
    public ArrayList<Annee> annees;

    /**
     * Constructeur de la classe AnneeFileAccess
     */
    public AnneeFileAccess() {
        annees = new ArrayList<Annee>();
        setList();
    }

    /**
     * Retourne la liste des années
     * @return Liste des années
     */
    public ArrayList<Annee> getAnnees() {
        return annees;
    }
    
    /**
     * initialise la liste des années
     */
    public void setList() {
        AnneeDAO u =  new AnneeDAO();
        this.annees = u.findAll();
    }

    /**
     * Retourne une année par son année
     * @param annee Année
     * @return Année
     */
    public Annee getAnneeById(String annee) {
        for (Annee an : this.annees) {
            if (an.getAnnee().equals(annee)) {
                return an;
            }
        }
        return null;
    }

}
