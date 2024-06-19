package app.model.dao;

import java.sql.*;
import java.util .*;

import app.model.data.Gare;

/**
 * Classe GareDAO
 */
public class GareDAO extends DAO<Gare> {

    /**
     * Constructeur
     */
    public GareDAO() {
    }

    /**
     * retourne la liste des gares
     * @return Liste des gares
     */
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

    /**
     * 
     * @param element
     * @param login
     * @param role
     * @return
     */
    @Override
    public int update(Gare element, String login, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    /**
     * Supprime une gare de la base de donnée
     * @param element Gare à supprimer
     * @param login Login de l'utilisateur
     * @return Nombre de lignes supprimées
     */
    @Override
    public int delete(Gare element, String login) {
        String query = "DELETE FROM Gare WHERE CODEGARE = '" + element.getCodeGare() + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    /**
     * Crée une gare dans la base de donnée
     * @param element Gare à créer
     * @return Identifiant de la gare créée
     */
    @Override
    public int create(Gare element) {
        String query = "INSERT INTO GARE (CODEGARE, NOMGARE, ESTFRET, ESTVOYAGEUR, LACOMMUNE) VALUES ('" + element.getCodeGare() + "','" + element.getNomGare() + "','" + element.getEstFret() + "','" + element.getEstVoyageur() + "','" + element.getLaCommune() + "')";
        try (Connection con = getConnection(); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    /**
     * 
     * @param login 
     * @param pwd 
     * @return Gare trouvée
     */
    @Override
    public Gare findByLoginPwd(String login, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLoginPwd'");
    }

    /**
     * recupérer la liste des gares par commune
     * @param idCommune Identifiant de la commune
     * @return Liste des gares
     */
    public ArrayList<Gare> findByCommune(String idCommune) {
        ArrayList <Gare> gares = new ArrayList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Gare WHERE LACOMMUNE = '" + idCommune + "'");
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
    
    /**
     * verifier si une gare existe
     * @param codeGare Code de la gare
     * @return Vrai si la gare existe, faux sinon
     */
    public boolean exist(String codeGare) {
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Gare WHERE CODEGARE = '" + codeGare + "'");
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Recherche une liste de gares avec une requête
     * @param query Requête SQL à exécuter
     * @return  Liste de gares
     */
    public ArrayList<Gare> findWithQuerry(String query) {
        ArrayList <Gare> gares = new ArrayList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery(query);
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

    /**
     * Met à jour le nom d'une gare
     * @param codeGare Code de la gare
     * @param newNom Nouveau nom
     * @return Nombre de lignes modifiées
     */
    public int updateNom(String codeGare, String newNom) {
        String query = "UPDATE Gare SET NOMGARE = '" + newNom + "' WHERE CODEGARE = '" + codeGare + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    /**
     * Met à jour le statut fret d'une gare
     * @param codeGare Code de la gare
     * @param newFret Nouveau statut fret
     * @return Nombre de lignes modifiées
     */
    public int updateFret(String codeGare, String newFret) {
        String query = "UPDATE Gare SET ESTFRET = '" + newFret + "' WHERE  CODEGARE = '" + codeGare + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    /**
     * Met à jour le statut voyageur d'une gare
     * @param codeGare Code de la gare
     * @param newVoyageur Nouveau statut voyageur
     * @return Nombre de lignes modifiées
     */
    public int updateVoyageur(String codeGare, String newVoyageur) {
        String query = "UPDATE Gare SET ESTVOYAGEUR = '" + newVoyageur + "' WHERE  CODEGARE = '" + codeGare + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

}
