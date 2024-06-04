package app.model.dao;

import java.sql.*;
import java.util .*;
import app.model.data.Aeroport;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int create(Aeroport element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Aeroport findByLoginPwd(String login, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLoginPwd'");
    }

    
}
