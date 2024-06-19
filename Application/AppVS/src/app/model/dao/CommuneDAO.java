package app.model.dao;

import java.sql.*;
import java.util .*;

import app.model.data.Commune;

/**
 * Classe CommuneDAO
 */
public class CommuneDAO extends DAO<Commune> {

    /**
     * Constructeur
     */
    public CommuneDAO() {
    }

    /**
     * retourne la liste des communes
     * @return Liste des communes
     */
    @Override
    public ArrayList<Commune> findAll() {
        ArrayList <Commune> communes = new ArrayList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Commune");
            while (rs.next()) {
                String idCommune = rs.getString("IDCOMMUNE");
                String nomCommune = rs.getString("NOMCOMMUNE");
                String departement = rs.getString("LEDEPARTEMENT");
                communes.add(new Commune(idCommune, nomCommune, departement));      
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return communes;
    }

    /**
     * retourne la liste des communes voisines
     * @param id Identifiant de la commune
     * @return Liste des communes voisines
     */
    public ArrayList<Commune> findAllVoisine(String id) {
        ArrayList <Commune> communes = new ArrayList<>();
        try (Connection con = getConnection (); 
             PreparedStatement st = con.prepareStatement("SELECT * FROM Voisinage WHERE communeVoisine = ?")) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idCommune = rs.getString("commune");
                communes.add(findByCodePostal(idCommune));      
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return communes;
    }

    /**
     * 
     * @param element
     * @param login
     * @param role
     * @return
     */
    @Override
    public int update(Commune element, String login, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    /**
     * Supprime une commune de la base de donnée
     * @param element Commune à supprimer
     * @param login Login de l'utilisateur
     * @return Nombre de lignes supprimées
     */
    @Override
    public int delete(Commune element, String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    /**
     * Crée une commune dans la base de donnée
     * @param element Commune à créer
     * @return Identifiant de la commune créée
     */
    @Override
    public int create(Commune element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    /**
     * 
     * @param login 
     * @param pwd 
     * @return Commune trouvée
     */
    @Override
    public Commune findByLoginPwd(String login, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLoginPwd'");
    }

    /**
     * verifie si une commune existe
     * @param idCommune Code postal de la commune
     * @return true si la commune existe, false sinon
     */
    public boolean exists(String idCommune) {
        try (Connection con = getConnection ();
            PreparedStatement st = con.prepareStatement("SELECT * FROM COMMUNE WHERE IDCOMMUNE= ?")) {
            st.setString(1, idCommune);
            ResultSet rs = st.executeQuery ();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return false;
        }
    }

    /**
     * Recherche une commune par son code postal
     * @param sourceId Code postal de la commune
     * @return Commune trouvée
     */
    public Commune findByCodePostal(String sourceId) {
        try (Connection con = getConnection ();
            PreparedStatement st = con.prepareStatement("SELECT * FROM COMMUNE WHERE IDCOMMUNE= ?")) {
            st.setString(1, sourceId);
            ResultSet rs = st.executeQuery ();
            if (rs.next()) {
                String idCommune = rs.getString("IDCOMMUNE");
                String nomCommune = rs.getString("NOMCOMMUNE");
                String departement = rs.getString("LEDEPARTEMENT");
                return new Commune(idCommune, nomCommune, departement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return null;
    }

    /**
     * Recherche une commune par son nom
     * @param nomRecherche Nom de la commune
     * @return Liste des communes trouvées
     */
    public ArrayList<Commune> findByNomCommune(String nomRecherche) {
        ArrayList<Commune> communesTrouvees = new ArrayList<>();
        String sql = "SELECT * FROM Commune WHERE NOMCOMMUNE LIKE ?";
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, nomRecherche + "%"); // Modification ici
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idCommune = rs.getString("IDCOMMUNE");
                String nomCommune = rs.getString("NOMCOMMUNE");
                String departement = rs.getString("LEDEPARTEMENT");
                communesTrouvees.add(new Commune(idCommune, nomCommune, departement));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return communesTrouvees;
    }

    /**
     * recherche une commune avec une requête
     * @param sql Requête SQL à exécuter
     * @return Liste des communes
     */
    public ArrayList<Commune> findWithQuerry(String sql) {
        ArrayList<Commune> communes = new ArrayList<>();
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String idCommune = rs.getString("IDCOMMUNE");
                String nomCommune = rs.getString("NOMCOMMUNE");
                String departement = rs.getString("LEDEPARTEMENT");
                communes.add(new Commune(idCommune, nomCommune, departement));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return communes;
    }
    
}
