package app.model.data;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import app.model.dao.DepartementDAO;

public class DepartementFileAccess {
    public ArrayList<Departement> departements;

    public DepartementFileAccess() {
        departements = new ArrayList<Departement>();
        setList();
    }

    public ArrayList<Departement> getDepartements() {
        return departements;
    }
    
    public void setList() {
        DepartementDAO u =  new DepartementDAO();
        this.departements = u.findAll();
    }

    public Departement getDepartementById(String idDepartement) {
        for (Departement departement : this.departements) {
            if (departement.getIdDep().equals(idDepartement)) {
                return departement;
            }
        }
        return null;
    }

    public void writeDepartementToCSVFile(String fileName) {
        DepartementDAO u =  new DepartementDAO();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("code Departement;nom Departement;investissement Culturel en 2019;nombre d'aeroport\n");

        for (Departement departement : u.findAll()) {
            stringBuilder.append(departement.getIdDep());
            stringBuilder.append(";");
            stringBuilder.append(departement.getNomDep());
            stringBuilder.append(";");
            stringBuilder.append(departement.getInvesCulturel2019());
            stringBuilder.append(";");
            stringBuilder.append(departement.getListeAeroports().size());
            stringBuilder.append("\n\n");
            stringBuilder.append("code Aeroport;nom Aeroport;code Departement\n");
            for (Aeroport aeroport : departement.getListeAeroports()) {
                stringBuilder.append(aeroport.getNom());
                stringBuilder.append(";");
                stringBuilder.append(aeroport.getAdresse());
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n\n");
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
