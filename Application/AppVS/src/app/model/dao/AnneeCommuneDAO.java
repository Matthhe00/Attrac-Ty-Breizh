package app.model.dao;

import java.sql.*;
import java.util .*;

import app.model.data.Annee;
import app.model.data.AnneeCommune;
import app.model.data.Commune;

public class AnneeCommuneDAO extends DAO<AnneeCommune> {

    @Override
    public ArrayList<AnneeCommune> findAll() {
        ArrayList <AnneeCommune> Annees = new ArrayList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM donneesannuelles");
            while (rs.next()) {
                String idAnnee = rs.getString("lAnnee");
                String idCommune = rs.getString("laCommune");
                String nbMaison = rs.getString("nbMaison");
                String nbAppart = rs.getString("nbAppart");
                String prixMoyen = rs.getString("prixMoyen");
                String prixM2Moyen = rs.getString("prixM2Moyen");
                String surfaceMoy = rs.getString("SurfaceMoy");
                String depCulturellesTotal = rs.getString("depensesCulturellesTotales");
                String budgetTotal = rs.getString("budgetTotal");
                String population = rs.getString("population");

                Annee a = new AnneeDAO().findAnnee(idAnnee);
                Commune c = new CommuneDAO().findByCodePostal(idCommune);
                Annees.add(new AnneeCommune(a, c, nbMaison, nbAppart, prixMoyen, prixM2Moyen, surfaceMoy, depCulturellesTotal, budgetTotal, population));      
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Annees;
    }

    @Override
    public int update(AnneeCommune element, String login, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(AnneeCommune element, String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int create(AnneeCommune element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public AnneeCommune findByLoginPwd(String login, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLoginPwd'");
    }

    public AnneeCommune findAnneeCommune(String annee, String commune) {
        AnneeCommune an = null;
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM donneesannuelles WHERE lAnnee = '" + annee + "' AND laCommune = '" + commune + "'");
            if (rs.next()) {
                String idAnnee = rs.getString("lAnnee");
                String idCommune = rs.getString("laCommune");
                String nbMaison = rs.getString("nbMaison");
                String nbAppart = rs.getString("nbAppart");
                String prixMoyen = rs.getString("prixMoyen");
                String prixM2Moyen = rs.getString("prixM2Moyen");
                String surfaceMoy = rs.getString("SurfaceMoy");
                String depCulturellesTotal = rs.getString("depensesCulturellesTotales");
                String budgetTotal = rs.getString("budgetTotal");
                String population = rs.getString("population");

                Annee a = new AnneeDAO().findAnnee(idAnnee);
                Commune c = new CommuneDAO().findByCodePostal(idCommune);
                an = new AnneeCommune(a, c, nbMaison, nbAppart, prixMoyen, prixM2Moyen, surfaceMoy, depCulturellesTotal, budgetTotal, population);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return an;
    }
    
}
