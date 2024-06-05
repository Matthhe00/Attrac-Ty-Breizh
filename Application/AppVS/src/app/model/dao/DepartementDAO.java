package app.model.dao;

import java.sql.*;
import java.util .*;
import app.model.data.Departement;

public class DepartementDAO extends DAO<Departement> {

    @Override
    public ArrayList<Departement> findAll() {
        ArrayList <Departement> departements = new ArrayList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Departement");
            while (rs.next()) {
                String idDepartement = rs.getString("idDep");
                String nomDepartement = rs.getString("nomDep");
                String inves2019 = rs.getString("investissementCulturel2019");
                departements.add(new Departement(idDepartement, nomDepartement, inves2019));      
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return departements;
    }

    @Override
    public int update(Departement element, String login, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Departement element, String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int create(Departement element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Departement findByLoginPwd(String login, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLoginPwd'");
    }
    
}
