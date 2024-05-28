import model.*;

public class ScenarioModel {

    private Annee annee2020;
    private Annee annee2021;
    private Annee annee2022;

    private Departement departement;
    private Commune commune1;
    private Commune commune2;
    private Commune commune3;
    private Commune commune4;
    private Commune commune5;

    private Aeroport aeroport;
    private Gare gare;
    private Gare gare2;
    private Gare gare3;
    
    private AnneeCommune anneeCommune10;
    private AnneeCommune anneeCommune11;
    private AnneeCommune anneeCommune12;
    
    private AnneeCommune anneeCommune20;
    private AnneeCommune anneeCommune21;
    private AnneeCommune anneeCommune22;

    private AnneeCommune anneeCommune30;
    private AnneeCommune anneeCommune31;
    private AnneeCommune anneeCommune32;

    private AnneeCommune anneeCommune40;
    private AnneeCommune anneeCommune41;
    private AnneeCommune anneeCommune42;

    private AnneeCommune anneeCommune50;
    private AnneeCommune anneeCommune51;
    private AnneeCommune anneeCommune52;

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
        testConstruteur();
        System.out.println("\n/---------------------------------------------/\n");
        testGetters();
        System.out.println("\n/---------------------------------------------/\n");
        testSetters();
        System.out.println("\n/---------------------------------------------/\n");
        testCommuneVoisine();
        System.out.println("\n/---------------------------------------------/\n");
        testCompareToAnneeCommune();
    }
//--------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test des setters du package model
     */
    public static void testConstruteur() {
        System.out.println("Test constructeur :");
        System.out.println("Cas normal :");
        System.out.print("\tTest Annee");
        try {
            Annee annee = new Annee(2020, 1.5f);
            System.out.println(" : Test réussi");
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Departement");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            System.out.println(" : Test réussi");
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Commune");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Commune commune = new Commune(1, "Rennes", departement);
            System.out.println(" : Test réussi");
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Aeroport");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Aeroport aeroport = new Aeroport(departement, "Rennes Aeroport", "Rennes Saint-Jacques");
            System.out.println(" : Test réussi");
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Gare");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Commune commune = new Commune(1, "Rennes", departement);
            Gare gare = new Gare(1, "Rennes Gare", false, true, commune);
            System.out.println(" : Test réussi");
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest AnneeCommune");
        try {
            Annee annee = new Annee(2020, 1.5f);
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Commune commune = new Commune(1, "Rennes", departement);
            AnneeCommune anneeCommune = new AnneeCommune(annee, commune, 1, 1, 100000, 1000, 100, 100000, 1000000, 10000);
            System.out.println(" : Test réussi");
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test des setters du package model
     */
    public static void testGetters() {
        System.out.println("Test getters :");
        System.out.println("Cas normal :");
        System.out.print("\tTest Annee");
        try {
            Annee annee = new Annee(2020, 1.5f);
            if (annee.getAnnee() == 2020 && annee.getTauxInflation() == 1.5f) {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Departement");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            if (departement.getIdDep() == 35 && departement.getNomDep() == "Ille-et-Vilaine" && departement.getInvesCulturel2019() == 1000000) {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Commune");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Commune commune = new Commune(1, "Rennes", departement);
            if (commune.getIdCommune() == 1 && commune.getNomCommune() == "Rennes" && commune.getLeDepartement() == departement) {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Aeroport");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Aeroport aeroport = new Aeroport(departement, "Rennes Aeroport", "Rennes Saint-Jacques");
            if (aeroport.getLeDepartement() == departement && aeroport.getNom() == "Rennes Aeroport" && aeroport.getAdresse() == "Rennes Saint-Jacques") {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Gare");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Commune commune = new Commune(1, "Rennes", departement);
            Gare gare = new Gare(1, "Rennes Gare", false, true, commune);
            if (gare.getCodeGare() == 1 && gare.getNomGare() == "Rennes Gare" && gare.getEstFret() == false && gare.getEstVoyageur() == true && gare.getLaCommune() == commune) {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest AnneeCommune");
        try {
            Annee annee = new Annee(2020, 1.5f);
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Commune commune = new Commune(1, "Rennes", departement);
            AnneeCommune anneeCommune = new AnneeCommune(annee, commune, 1, 1, 100000, 1000, 100, 100000, 1000000, 10000);
            if (anneeCommune.getAnnee() == annee && anneeCommune.getLaCommune() == commune && anneeCommune.getNbMaison() == 1 && anneeCommune.getNbAppart() == 1 && anneeCommune.getPrixMoyen() == 100000 && anneeCommune.getPrixM2Moyen() == 1000 && anneeCommune.getSurfaceMoy() == 100 && anneeCommune.getDepCulturellesTotal() == 100000 && anneeCommune.getBudgetTotal() == 1000000 && anneeCommune.getPopulation() == 10000) {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test des setters du package model
     */
    public static void testSetters() {
        System.out.println("Test setters :");
        System.out.println("Cas normal :");
        System.out.print("\tTest Annee");
        try {
            Annee annee = new Annee(2020, 1.5f);
            annee.setAnnee(2021);
            annee.setTauxInflation(1.6f);
            if (annee.getAnnee() == 2021 && annee.getTauxInflation() == 1.6f) {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Departement");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            departement.setIdDep(36);
            departement.setNomDep("Ille-et-Vilaine 2");
            departement.setInvesCulturel2019(2000000);
            if (departement.getIdDep() == 36 && departement.getNomDep() == "Ille-et-Vilaine 2" && departement.getInvesCulturel2019() == 2000000) {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Commune");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Commune commune = new Commune(1, "Rennes", departement);
            commune.setIdCommune(2);
            commune.setNomCommune("Rennes 2");
            commune.setLeDepartement(departement);
            if (commune.getIdCommune() == 2 && commune.getNomCommune() == "Rennes 2" && commune.getLeDepartement() == departement) {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Aeroport");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Aeroport aeroport = new Aeroport(departement, "Rennes Aeroport", "Rennes Saint-Jacques");
            aeroport.setLeDepartement(departement);
            aeroport.setNom("Rennes Aeroport 2");
            aeroport.setAdresse("Rennes Saint-Jacques 2");
            if (aeroport.getLeDepartement() == departement && aeroport.getNom() == "Rennes Aeroport 2" && aeroport.getAdresse() == "Rennes Saint-Jacques 2") {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest Gare");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Commune commune = new Commune(1, "Rennes", departement);
            Gare gare = new Gare(1, "Rennes Gare", false, true, commune);
            gare.setCodeGare(2);
            gare.setNomGare("Rennes Gare 2");
            gare.setEstFret(true);
            gare.setEstVoyageur(false);
            gare.setLaCommune(commune);
            if (gare.getCodeGare() == 2 && gare.getNomGare() == "Rennes Gare 2" && gare.getEstFret() == true && gare.getEstVoyageur() == false && gare.getLaCommune() == commune) {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }

        System.out.print("\tTest AnneeCommune");
        try {
            Annee annee = new Annee(2020, 1.5f);
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Commune commune = new Commune(1, "Rennes", departement);
            AnneeCommune anneeCommune = new AnneeCommune(annee, commune, 1, 1, 100000, 1000, 100, 100000, 1000000, 10000);
            anneeCommune.setAnnee(annee);
            anneeCommune.setLaCommune(commune);
            anneeCommune.setNbMaison(2);
            anneeCommune.setNbAppart(2);
            anneeCommune.setPrixMoyen(200000);
            anneeCommune.setPrixM2Moyen(2000);
            anneeCommune.setSurfaceMoy(200);
            anneeCommune.setDepCulturellesTotal(200000);
            anneeCommune.setBudgetTotal(2000000);
            anneeCommune.setPopulation(20000);
            if (anneeCommune.getAnnee() == annee && anneeCommune.getLaCommune() == commune && anneeCommune.getNbMaison() == 2 && anneeCommune.getNbAppart() == 2 && anneeCommune.getPrixMoyen() == 200000 && anneeCommune.getPrixM2Moyen() == 2000 && anneeCommune.getSurfaceMoy() == 200 && anneeCommune.getDepCulturellesTotal() == 200000 && anneeCommune.getBudgetTotal() == 2000000 && anneeCommune.getPopulation() == 20000) {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }
            
    }

//--------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test de la méthode compareTo de la classe AnneeCommune
     */
    public static void testCompareToAnneeCommune() {
        System.out.println("Test compareTo AnneeCommune :");
        System.out.println("Cas normal :");
        try {
            Annee annee = new Annee(2020, 1.5f);
            Departement departement35 = new Departement(35, "Ille-et-Vilaine", 1000000);
            Departement departement56 = new Departement(56, "Morbihan", 102300);
            Commune commune = new Commune(1, "Rennes", departement35);
            Commune commune2 = new Commune(2, "Vannes",departement56);
            AnneeCommune anneeCommune = new AnneeCommune(annee, commune, 1, 1, 100000, 1000, 100, 100000, 1000000, 10000);
            AnneeCommune anneeCommune2 = new AnneeCommune(annee, commune2, 2, 2,12410, 1000, 1, 1, 1, 1);
            String ret  = anneeCommune.compareTo(anneeCommune2);
            System.out.println(ret);

        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------

    /**
     * Test des setters du package model
     */
    public static void testCommuneVoisine() {
        System.out.println("Test CommuneVoisine :");
        System.out.println("Cas normal :");
        System.out.print("\tTest CommuneVoisine");
        try {
            Departement departement = new Departement(35, "Ille-et-Vilaine", 1000000);
            Commune commune1 = new Commune(1, "Rennes", departement);
            Commune commune2 = new Commune(2, "Cesson-Sévigné", departement);
            Commune commune3 = new Commune(3, "Saint-Grégoire", departement);

            commune1.addCommuneVoisine(commune2);
            commune1.addCommuneVoisine(commune3);

            commune2.addCommuneVoisine(commune1);
            commune2.addCommuneVoisine(commune3);

            commune3.addCommuneVoisine(commune1);
            commune3.addCommuneVoisine(commune2);

            if (commune1.getCommuneVoisine().contains(commune2) && commune1.getCommuneVoisine().contains(commune3) && commune2.getCommuneVoisine().contains(commune1) && commune2.getCommuneVoisine().contains(commune3)) {
                System.out.println(" : Test réussi");
            } else {
                System.out.println(" : Test échoué");
            }
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }
    }

}
