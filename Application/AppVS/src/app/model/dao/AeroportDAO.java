package app.model.dao;

import java.sql.*;
import java.util .*;
import app.model.data.Aeroport;
import app.model.data.Gare;

public class AeroportDAO extends DAO <Aeroport> {
    
    @Override
    public ArrayList <Aeroport> findAll() {
        ArrayList <Aeroport> Aeroports = new ArrayList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Aeroport");
            while (rs.next()) {
                String nom = rs.getString("NOM");
                String adresse = rs.getString("ADRESSE");
                String departement = rs.getString("LEDEPARTEMENT");
                Aeroports.add(new Aeroport(departement, nom, adresse));      
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Aeroports;
    }

    @Override
    public int update(Aeroport element, String login, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Aeroport element, String login) {
        String query = "DELETE FROM Aeroport WHERE NOM = '" + element.getNom() + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int create(Aeroport element) {
        System.out.println(element.getNom() + " " + element.getAdresse() + " " + element.getLeDepartement());
        String query = "INSERT INTO Aeroport (NOM, ADRESSE, leDepartement) VALUES ('" + element.getNom() + "', '" + element.getAdresse() + "', '" + element.getLeDepartement() + "')";
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public Aeroport findByLoginPwd(String login, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLoginPwd'");
    }

    public ArrayList<Aeroport> findWithQuerry(String query) {
        ArrayList<Aeroport> Aeroports = new ArrayList<>();
        try (Connection con = getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                String nom = rs.getString("NOM");
                String adresse = rs.getString("ADRESSE");
                String departement = rs.getString("LEDEPARTEMENT");
                Aeroports.add(new Aeroport(departement, nom, adresse));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Aeroports;
    }

    public boolean exist(String nom) {
        String query = "SELECT * FROM Aeroport WHERE NOM = '" + nom + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement (); ResultSet rs = st.executeQuery(query)) {
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return false;
        }
    }

    public void updateNom(String nomAeroport, String newValue) {
        if (exist(newValue)) return;
        else {        
            String query = "UPDATE Aeroport SET NOM = '" + newValue + "' WHERE NOM = '" + nomAeroport + "'";
            try (Connection con = getConnection(); Statement st = con.createStatement ()) {
                st.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace ();
            }
        }
    }

    public void updateAdresse(String nomAeroport, String newValue) {
        String query = "UPDATE Aeroport SET ADRESSE = '" + newValue + "' WHERE NOM = '" + nomAeroport + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement ()) {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }    
}
