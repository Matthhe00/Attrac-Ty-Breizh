package app.model.data;

import java.util.ArrayList;

import app.model.dao.AeroportDAO;

/**
 * Classe AeroportFileAccess
 */
public class AeroportFileAccess {

    /**
     * Liste des aéroports
     */
    public ArrayList<Aeroport> Aeroports;

    /**
     * Constructeur de la classe AeroportFileAccess
     */
    public AeroportFileAccess() {
        Aeroports = new ArrayList<Aeroport>();
        setList();
    }

    /**
     * Retourne la liste des aéroports
     * @return Liste des aéroports
     */
    public ArrayList<Aeroport> getAeroports() {
        return Aeroports;
    }

    /**
     * Retourne la liste des aéroports d'un département
     * @param departement Département des aéroports
     * @return Liste des aéroports
     */
    public ArrayList<Aeroport> getAeroports(String departement) {
        ArrayList<Aeroport> Aeroports = new ArrayList<Aeroport>();
        for (Aeroport Aeroport : this.Aeroports) {
            if (Aeroport.getLeDepartement().equals(departement)) {
                Aeroports.add(Aeroport);
            }
        }
        return Aeroports;
    }
    
    /**
     * initialise la liste des aéroports
     */
    public void setList() {
        AeroportDAO u =  new AeroportDAO();
        this.Aeroports = u.findAll();
    }

    /**
     * Retourne la liste des aéroports d'un département celon son département
     * @param departement  Département a rechercher
     * @return Liste des aéroports
     */
    public ArrayList<Aeroport> getAeroportByDepartement(String departement) {
        ArrayList<Aeroport> Aeroports = new ArrayList<Aeroport>();
        for (Aeroport Aeroport : this.Aeroports) {
            if (Aeroport.getLeDepartement().equals(departement)) {
                Aeroports.add(Aeroport);
            }
        }
        return Aeroports;
    }

    /**
     * Retourne un aéroport celon son nom
     * @param nom Nom de l'aéroport
     * @return Aeroport
     */
    public Aeroport getAeroportByNom(String nom) {
        for (Aeroport Aeroport : this.Aeroports) {
            if (Aeroport.getNom().equals(nom)) {
                return Aeroport;
            }
        }
        return null;
    }

    /**
     * Retourne le nombre d'aéroports
     * @return Nombre d'aéroports
     */
    public String getNbAeroport() {
        return String.valueOf(this.Aeroports.size());
    }
}
