package app.model.dao;

import java.sql.*;
import java.util .*;

import app.model.data.Commune;

public class CommuneDAO extends DAO<Commune> {

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

    @Override
    public int update(Commune element, String login, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Commune element, String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int create(Commune element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Commune findByLoginPwd(String login, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLoginPwd'");
    }

    public boolean exists(String login) {
        try (Connection con = getConnection ();
            PreparedStatement st = con.prepareStatement("SELECT * FROM COMMUNE WHERE IDCOMMUNE= ?")) {
            st.setString(1, login);
            ResultSet rs = st.executeQuery ();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return false;
        }
    }

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

    public ArrayList<Commune> findByNomCommune(String nomRecherche) {
        ArrayList<Commune> communesTrouvees = new ArrayList<>();
        String sql = "SELECT * FROM Commune WHERE NOMCOMMUNE LIKE ?";
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, "%" + nomRecherche + "%");
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
