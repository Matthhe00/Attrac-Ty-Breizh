package app.model.dao;

import java.sql.*;
import java.util .*;
import app.model.data.User;

/**
 * Classe UserDAO
 */
public class UserDAO extends DAO <User> {

    /**
     * Constructeur
     */
    public UserDAO() {
    }

    /**
     * Crée un utilisateur
     * @param user Utilisateur à créer
     * @return Nombre de lignes créées
     */
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
    
    /**
     * Met à jour un utilisateur
     * @param user Utilisateur à mettre à jour
     * @param login Login de l'utilisateur
     * @param role Role de l'utilisateur
     * @return Nombre de lignes mises à jour
     */
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

    /**
     * Supprime un utilisateur
     * @param user Utilisateur à supprimer
     * @param login Login de l'utilisateur
     * @return Nombre de lignes supprimées
     */
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

    /**
     * retourne la liste des utilisateurs
     * @return Liste des utilisateurs
     */
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

    /**
     * retourne un utilisateur
     * @param login Login de l'utilisateur
     * @param pwd Mot de passe de l'utilisateur
     * @return Utilisateur
     */
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

    /**
     * retourne un utilisateur
     * @param login Login de l'utilisateur
     * @return Utilisateur
     */
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

    /**
     * Vérifie si un utilisateur existe
     * @param login Login de l'utilisateur
     * @return true si l'utilisateur existe, false sinon
     */
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

    /**
     * Met à jour le login d'un utilisateur
     * @param oldLogin Ancien login
     * @param newLogin Nouveau login
     * @return Nombre de lignes mises à jour
     */
    public int updateLogin(String oldLogin, String newLogin) {
        String query = "UPDATE User SET login ='" + newLogin + "' WHERE login ='" + oldLogin + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    /**
     * Met à jour le mot de passe d'un utilisateur
     * @param login Login de l'utilisateur
     * @param pwd Nouveau mot de passe
     * @return  Nombre de lignes mises à jour
     */
    public int updatePwd(String login, String pwd) {
        String query = "UPDATE User SET pwd ='" + pwd + "' WHERE login ='" + login + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    /**
     * Met à jour le role d'un utilisateur
     * @param login Login de l'utilisateur
     * @param role Nouveau role
     * @return Nombre de lignes mises à jour
     */
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