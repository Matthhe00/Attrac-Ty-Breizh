package app.model.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import app.model.dao.*;

public class AnneeCommuneFileAccess {
    public ArrayList<AnneeCommune> annees;

    public AnneeCommuneFileAccess() {
        annees = new ArrayList<AnneeCommune>();
        setList();
    }

    public ArrayList<AnneeCommune> getAnnees() {
        return annees;
    }
    
    public void setList() {
        AnneeCommuneDAO u =  new AnneeCommuneDAO();
        this.annees = u.findAll();
    }

    public AnneeCommune getAnneeCommuneById(String annee, String idCommune) {
        for (AnneeCommune an : this.annees) {
            if (an.getAnnee().getAnnee().equals(annee) && an.getLaCommune().getIdCommune().equals(idCommune)) {
                return an;
            }
        }
        return null;
    }

    
    public void writeToTextFile(String fileName, String idCommune) {
        AnneeCommuneDAO u =  new AnneeCommuneDAO();
        CommuneDAO c = new CommuneDAO();
        GareDAO g = new GareDAO();
    
        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            //ajout nom commune et nombre de gare
            String communeName = c.findByCodePostal(idCommune).getNomCommune() + " - " + idCommune + " - ";
            if (g.findByCommune(idCommune).size() > 0) {
                communeName += "Gare(s) : " + g.findByCommune(idCommune).size();
            } else {
                communeName += "Pas de gare";
            }
            bw.write(communeName);
            bw.newLine();
            bw.newLine();

            //ajout données annuelles
            for(int i = 2018; i <= 2021; i++) {
                AnneeCommune anneeCommune = u.findAnneeCommune(String.valueOf(i), idCommune);
                String anneeCommuneData = i + " - Prix m2 moyen : " + anneeCommune.getPrixM2Moyen() + " - Prix moyen : " + anneeCommune.getPrixMoyen() + " - Surface moyenne : " + anneeCommune.getSurfaceMoy() + " - Nombre de maison vendu : " +anneeCommune.getNbMaison() + " - Nombre d'appartement vendu : " + anneeCommune.getNbAppart();
                
                bw.write(anneeCommuneData.trim());
                bw.newLine();
            }
            bw.newLine();

            //ajout commune voisine
            ArrayList<Commune> communesVoisines = c.findAllVoisine(idCommune);
            if (communesVoisines.size() > 0) {
                bw.write("Communes voisines : ");
                bw.newLine();

                for (Commune commune : communesVoisines) {
                    bw.write(commune.getNomCommune() + " - " + commune.getIdCommune() + " ");
                    bw.newLine();
                }
            } else {
                bw.write("Pas de commune voisine");
            }

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
