package app.model.dao;

import java.sql.*;
import java.util .*;

import app.model.data.Gare;

public class GareDAO extends DAO<Gare> {

    @Override
    public ArrayList<Gare> findAll() {
        ArrayList <Gare> gares = new ArrayList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Gare");
            while (rs.next()) {
                String codeGare = rs.getString("CODEGARE");
                String nomGare = rs.getString("NOMGARE");
                String estFret = rs.getString("ESTFRET");
                String estVoyageur = rs.getString("ESTVOYAGEUR");
                String laCommune = rs.getString("LACOMMUNE");
                if (estFret.equals("1")) {
                    estFret = "Oui";
                } else if (estFret.equals("0")){
                    estFret = "Non";
                } 
                
                if (estVoyageur.equals("1")) {
                    estVoyageur = "Oui";
                } else if (estVoyageur.equals("0")){
                    estVoyageur = "Non";
                }
                
                gares.add(new Gare(codeGare, nomGare, estFret, estVoyageur, laCommune));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return gares;
    }

    @Override
    public int update(Gare element, String login, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Gare element, String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int create(Gare element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Gare findByLoginPwd(String login, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLoginPwd'");
    }
    
}
