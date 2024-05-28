package app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util .*;
import app.model.data.User;

public class UserDAO extends DAO <User > {

    @Override
    public int create(User user) {
        String query = "INSERT INTO USER(LOGIN , PWD) VALUES ('" + user.getLogin () + "','" + user.getPwd() + "')";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }
    
    @Override
    public int update(User user) {
        String query = "UPDATE USER SET LOGIN='" + user.getLogin () + "', PWD='" + user.getPwd() + "' WHERE LOGIN='" + user.getLogin () + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    @Override
    public int delete(User user) {
        String query = "DELETE FROM USER WHERE LOGIN='" + user.getLogin () + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public List <User > findAll () {
        List <User > users = new LinkedList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM USER");
            while (rs.next()) {
                String nom = rs.getString("LOGIN");
                String pwd = rs.getString("PWD");
                users.add(new User(nom , pwd));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByID(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }
        


}