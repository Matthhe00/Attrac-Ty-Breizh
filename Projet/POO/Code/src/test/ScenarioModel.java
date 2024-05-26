package test;
import model.*;

public class ScenarioModel {

    public static void main (String[] args) {

        // Creation des objets et initialisation des relations
        Annee annee2020 = new Annee(2020, 1.5f);
        Annee annee2021 = new Annee(2021, 1.6f);
        Annee annee2022 = new Annee(2022, 1.7f);

        Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
        Commune commune1 = new Commune(1, "Rennes", departement);
        Commune commune2 = new Commune(2, "Cesson-Sévigné", departement);
        Commune commune3 = new Commune(3, "Saint-Grégoire", departement);
        Commune commune4 = new Commune(4, "Pacé", departement);
        Commune commune5 = new Commune(5, "Betton", departement);

        commune1.addCommuneVoisine(commune2);
        commune1.addCommuneVoisine(commune3);

        commune2.addCommuneVoisine(commune1);
        commune2.addCommuneVoisine(commune3);
        commune2.addCommuneVoisine(commune4);

        commune3.addCommuneVoisine(commune1);
        commune3.addCommuneVoisine(commune2);

        commune4.addCommuneVoisine(commune2);
        commune4.addCommuneVoisine(commune5);

        commune5.addCommuneVoisine(commune4);

        Aeroport aeroport = new Aeroport(departement, "Rennes Aeroport", "Rennes Saint-Jacques");
        Gare gare = new Gare(1, "Rennes Gare", false, true, commune1);
        Gare gare2 = new Gare(2, "Cesson-Sévigné Gare", false, true, commune2);
        Gare gare3 = new Gare(3, "Saint-Grégoire Gare", true, true, commune3);
    
        AnneeCommune anneeCommune10 = new AnneeCommune(annee2020, commune1, 1, 1, 100000, 1000, 100, 100000, 1000000, 10000);
        AnneeCommune anneeCommune11 = new AnneeCommune(annee2021, commune1, 2, 2, 200000, 2000, 200, 200000, 2000000, 20000);
        AnneeCommune anneeCommune12 = new AnneeCommune(annee2022, commune1, 3, 3, 300000, 3000, 300, 300000, 3000000, 30000);

        AnneeCommune anneeCommune20 = new AnneeCommune(annee2020, commune2, 1, 1, 100000, 1000, 100, 100000, 1000000, 10000);
        AnneeCommune anneeCommune21 = new AnneeCommune(annee2021, commune2, 2, 2, 200000, 2000, 200, 200000, 2000000, 20000);
        AnneeCommune anneeCommune22 = new AnneeCommune(annee2022, commune2, 3, 3, 300000, 3000, 300, 300000, 3000000, 30000);

        AnneeCommune anneeCommune30 = new AnneeCommune(annee2020, commune3, 1, 1, 100000, 1000, 100, 100000, 1000000, 10000);
        AnneeCommune anneeCommune31 = new AnneeCommune(annee2021, commune3, 2, 2, 200000, 2000, 200, 200000, 2000000, 20000);
        AnneeCommune anneeCommune32 = new AnneeCommune(annee2022, commune3, 3, 3, 300000, 3000, 300, 300000, 3000000, 30000);

        AnneeCommune anneeCommune40 = new AnneeCommune(annee2020, commune4, 1, 1, 100000, 1000, 100, 100000, 1000000, 10000);
        AnneeCommune anneeCommune41 = new AnneeCommune(annee2021, commune4, 2, 2, 200000, 2000, 200, 200000, 2000000, 20000);
        AnneeCommune anneeCommune42 = new AnneeCommune(annee2022, commune4, 3, 3, 300000, 3000, 300, 300000, 3000000, 30000);

        AnneeCommune anneeCommune50 = new AnneeCommune(annee2020, commune5, 1, 1, 100000, 1000, 100, 100000, 1000000, 10000);
        AnneeCommune anneeCommune51 = new AnneeCommune(annee2021, commune5, 2, 2, 200000, 2000, 200, 200000, 2000000, 20000);
        AnneeCommune anneeCommune52 = new AnneeCommune(annee2022, commune5, 3, 3, 300000, 3000, 300, 300000, 3000000, 30000);

        // Scenario 
        
    }
}
