package app.model.dao;

import java.sql.*;
import java.util .*;
import app.model.data.User;

public class UserDAO extends DAO <User> {

    @Override
    public int create(User user) {
        String query = "INSERT INTO USER(LOGIN , PWD , ROLE) VALUES ('" + user.getLogin () + "','" + user.getPwd() + "','" + user.getRole() + "')";
        try (Connection con = getConnection(); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }
    
    @Override
    public int update(User user, String login, String role) {
        String query = "UPDATE User SET login ='" + user.getLogin() + "', pwd ='" + user.getPwd() + "', role ='" + user.getRole() + "' WHERE login ='" + login + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    @Override
    public int delete(User user, String login) {
        String query = "DELETE FROM User WHERE LOGIN='" + login + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public ArrayList <User> findAll () {
        ArrayList <User > users = new ArrayList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM USER");
            while (rs.next()) {
                String id = rs.getString("ID");
                String nom = rs.getString("LOGIN");
                String pwd = rs.getString("PWD");
                String role = rs.getString("ROLE");
                users.add(new User(id, nom , pwd, role));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByLoginPwd(String login , String pwd) {
        try (Connection con = getConnection ();
            PreparedStatement st = con.prepareStatement("SELECT * FROM USER WHERE LOGIN= ? AND PWD= ?")) {
            st.setString(1, login); st.setString(2, pwd);
            ResultSet rs = st.executeQuery ();
            while (rs.next()) {
                String l = rs.getString("LOGIN");
                String p = rs.getString("PWD");
                String r = rs.getString("ROLE");
                return new User(l, p, r);
            }
        } catch (SQLException ex) { 
            ex.printStackTrace (); 
        }
        return null;
    }

    public User findByLogin(String login) {
        try (Connection con = getConnection ();
            PreparedStatement st = con.prepareStatement("SELECT * FROM USER WHERE LOGIN= ?")) {
            st.setString(1, login);
            ResultSet rs = st.executeQuery ();
            while (rs.next()) {
                String l = rs.getString("LOGIN");
                String p = rs.getString("PWD");
                String r = rs.getString("ROLE");
                return new User(l, p, r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return null;
    }

    public boolean exists(String login) {
        try (Connection con = getConnection ();
            PreparedStatement st = con.prepareStatement("SELECT * FROM USER WHERE LOGIN= ?")) {
            st.setString(1, login);
            ResultSet rs = st.executeQuery ();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return false;
        }
    }

    public int updateLogin(String oldLogin, String newLogin) {
        String query = "UPDATE User SET login ='" + newLogin + "' WHERE login ='" + oldLogin + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int updatePwd(String login, String pwd) {
        String query = "UPDATE User SET pwd ='" + pwd + "' WHERE login ='" + login + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int updateRole(String login, String role) {
        String query = "UPDATE User SET role ='" + role + "' WHERE login ='" + login + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }


}