package app.model.dao;

import java.sql.*;
import java.util .*;
import app.model.data.Annee;

/**
 * Classe AnneeDAO
 */
public class AnneeDAO extends DAO<Annee> {

    /**
     * Constructeur
     */
    public AnneeDAO() {
    }

    /**
     * retourne la liste des années
     * @return Liste des années
     */
    @Override
    public ArrayList<Annee> findAll() {
        ArrayList <Annee> Annees = new ArrayList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Annee");
            while (rs.next()) {
                String idAnnee = rs.getString("annee");
                String inflationTaux = rs.getString("tauxInflation");

                Annees.add(new Annee(idAnnee, inflationTaux));      
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Annees;
    }

    /**
     * 
     * @param element
     * @param login
     * @param role
     * @return
     */
    @Override
    public int update(Annee element, String login, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    /**
     * Supprime une année de la base de donnée
     * @param element Année à supprimer
     * @param login Login de l'utilisateur
     * @return Nombre de lignes supprimées
     */
    @Override
    public int delete(Annee element, String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    /**
     * Crée une année dans la base de donnée
     * @param element Année à créer
     * @return Identifiant de l'année créée
     */
    @Override
    public int create(Annee element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    /**
     * Recherche une année par son identifiant
     * @param id Identifiant de l'année
     * @return Année
     */
    @Override
    public Annee findByLoginPwd(String login, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLoginPwd'");
    }

    /**
     * Recherche une année par son année
     * @param annee Année de l'année
     * @return Année
     */
    public Annee findAnnee(String annee) {
        Annee an = null;
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Annee WHERE annee = '" + annee + "'");
            if (rs.next()) {
                String idAnnee = rs.getString("annee");
                String inflationTaux = rs.getString("tauxInflation");
                an = new Annee(idAnnee, inflationTaux);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return an;
    }
}
