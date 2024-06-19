package app.model.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import app.model.dao.*;

/**
 * Classe AnneeCommuneFileAccess
 */
public class AnneeCommuneFileAccess {

    /**
     * Liste des années
     */
    public ArrayList<AnneeCommune> annees;

    /**
     * Constructeur de la classe AnneeCommuneFileAccess
     */
    public AnneeCommuneFileAccess() {
        annees = new ArrayList<AnneeCommune>();
        setList();
    }

    /**
     * Retourne la liste des années
     * @return Liste des années
     */
    public ArrayList<AnneeCommune> getAnnees() {
        return annees;
    }
    
    /**
     * initialise la liste des années
     */
    public void setList() {
        AnneeCommuneDAO u =  new AnneeCommuneDAO();
        this.annees = u.findAll();
    }

    /**
     * Retourne une année commune par son année et son id de commune
     * @param annee Année
     * @param idCommune Id de la commune
     * @return Année commune
     */
    public AnneeCommune getAnneeCommuneById(String annee, String idCommune) {
        for (AnneeCommune an : this.annees) {
            if (an.getAnnee().getAnnee().equals(annee) && an.getLaCommune().getIdCommune().equals(idCommune)) {
                return an;
            }
        }
        return null;
    }

    /**
     * Ecrit les données d'une commune dans un fichier CSV
     * @param fileName Nom du fichier
     * @param idCommune Id de la commune
     */
    public void writeCommuneToCSVFile(String fileName, String idCommune) {
        AnneeCommuneDAO u = new AnneeCommuneDAO();
        CommuneDAO c = new CommuneDAO();
        GareDAO g = new GareDAO();

        StringBuilder stringBuilder = new StringBuilder();

        // Header row
        stringBuilder.append("Nom Commune;Code Postale\n");

        // Commune information
        String communeName = c.findByCodePostal(idCommune).getNomCommune();
        String communeCode = idCommune;

        // Append commune data
        stringBuilder.append(communeName).append(";").append(communeCode).append("\n");

        // Annual data header
        stringBuilder.append("\nAnnee;Prixm2moyen;prixMoyen;Surface moy;nbMaisonVe;nbAppartVend\n");

        // AnneeCommune data
        for (int i = 2018; i <= 2021; i++) {
            AnneeCommune anneeCommune = u.findAnneeCommune(String.valueOf(i), idCommune);
            stringBuilder.append(i).append(";")
                          .append(anneeCommune.getPrixM2Moyen()).append(";")
                          .append(anneeCommune.getPrixMoyen()).append(";")
                          .append(anneeCommune.getSurfaceMoy()).append(";")
                          .append(anneeCommune.getNbMaison()).append(";")
                          .append(anneeCommune.getNbAppart()).append("\n");
        }

        // Adding neighboring communes
        ArrayList<Commune> communesVoisines = c.findAllVoisine(idCommune);
        if (communesVoisines.size() > 0) {
            stringBuilder.append("\nCommune Voisine;Code Postale\n");

            for (Commune commune : communesVoisines) {
                stringBuilder.append(commune.getNomCommune()).append(";")
                             .append(commune.getIdCommune()).append("\n");
            }
        }

        // Adding gare list after neighboring communes
        ArrayList<Gare> gares = g.findByCommune(idCommune);
        if (!gares.isEmpty()) {
            stringBuilder.append("\nGare;Marchandise;Voyageur\n");
            for (Gare gare : gares) {
                stringBuilder.append(gare.getNomGare()).append(";")
                             .append(gare.getEstFret()).append(";")
                             .append(gare.getEstVoyageur()).append("\n"); // Assuming 1 as a placeholder for gare count
            }
        }

        if (!fileName.endsWith(".csv")) {
            fileName += "_" + communeName + ".csv";
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ecrit les données d'une année dans un fichier CSV
     * @param fileName Nom du fichier
     * @param annee Année
     */
    public void writeDonneeToCSVFile(String fileName) {
        CommuneDAO c = new CommuneDAO();

        StringBuilder stringBuilder = new StringBuilder();

        // Header row
        stringBuilder.append("Nom Commune;Code Postale;Département\n");

        // Commune information
        for (Commune commune : c.findAll()) {
            String communeName = commune.getNomCommune();
            String communeCode = commune.getIdCommune();

            // Append commune data
            stringBuilder.append(communeName).append(";").append(communeCode).append(";").append(commune.getLeDepartement()).append("\n");
        }

        if (!fileName.endsWith(".csv")) {
            fileName += ".csv";
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
