package app.model.dao;

import java.sql.*;
import java.util .*;
import app.model.data.Annee;

public class AnneeDAO extends DAO<Annee> {

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

    @Override
    public int update(Annee element, String login, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Annee element, String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int create(Annee element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Annee findByLoginPwd(String login, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLoginPwd'");
    }

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
