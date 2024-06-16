import java.util.ArrayList;

import model.*;

/**
 * Classe ScenarioModel
 * Pour tester les classes du package model
 */
public class ScenarioModel {

    /**
     * Constructeur de la classe ScenarioModel
     */
    public ScenarioModel() {
    }
//--------------------------------------------------------------------------------------------------------------------------------

    /**
     * Méthode main pour lancer les tests
     * @param args les arguments de la ligne de commande
     */
    public static void main (String[] args) {
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
        System.out.println("\n/---------------------------------------------/\n");
        testAnneeMaxInflation();
        System.out.println("\n/---------------------------------------------/\n");
        testCommuneMaxCommuneVoisine();
        System.out.println("\n/---------------------------------------------/\n");
        testRechercheAeroport();
        System.out.println("\n/---------------------------------------------/\n");
        testDestinationAeroport();
        System.out.println("\n/---------------------------------------------/\n");
        testDestinationGare();
        
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

            int[] ret  = anneeCommune.compareTo(anneeCommune2);

            if (ret[0] == -1 && ret[1] == -1 && ret[2] == 1 && ret[3] == 0 && ret[4] == 1 && ret[5] == 1 && ret[6] == 1 && ret[7] == 1) {
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
     * Test de la méthode anneeMaxInflation de la classe Annee
     */
    public static void testAnneeMaxInflation() {
        System.out.println("Test anneeMaxInflation Annee :");
        System.out.println("Cas normal :");
        try {
            Annee annee1 = new Annee(2020, 1.5f);
            Annee annee2 = new Annee(2021, 1.6f);
            Annee annee3 = new Annee(2022, 1.7f);
            Annee annee4 = new Annee(2023, 1.1f);

            Annee[] annees = {annee1, annee2, annee3, annee4};
            Annee anneeMax = annee1.anneeMaxInflation(annees);

            if (anneeMax == annee3) {
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
     * Test de la méthode communeMaxCommuneVoisine de la classe Commune
     */
    public static void testCommuneMaxCommuneVoisine() {
        System.out.println("Test communeMaxCommuneVoisine Commune :");
        System.out.println("Cas normal :");
        try {
            Departement departement35 = new Departement(35, "Ille-et-Vilaine", 1000000);
            Departement departement56 = new Departement(56, "Morbihan", 102300);

            Commune commune1 = new Commune(1, "Rennes", departement35);
            Commune commune2 = new Commune(2, "Cesson-Sévigné", departement35);
            Commune commune3 = new Commune(3, "Saint-Grégoire", departement35);
            Commune commune4 = new Commune(4, "Betton", departement35);
            Commune commune5 = new Commune(5, "Chantepie", departement35);
            Commune commune6 = new Commune(6, "Noyal-Chatillon-sur-seiche", departement35);
            Commune commune7 = new Commune(4, "Vannes", departement56);
            Commune commune8 = new Commune(5, "Séné", departement56);
            Commune commune9 = new Commune(6, "Saint-Avé", departement56);
            Commune commune10 = new Commune(7, "Saint-Nolf", departement56);


            commune1.addCommuneVoisine(commune2);
            commune1.addCommuneVoisine(commune3);
            commune1.addCommuneVoisine(commune4);
            commune1.addCommuneVoisine(commune5);
            commune1.addCommuneVoisine(commune6);
            commune1.addCommuneVoisine(commune7);
            commune7.addCommuneVoisine(commune8);
            commune7.addCommuneVoisine(commune9);
            commune7.addCommuneVoisine(commune10);


            Commune[] communesVoisinesRennes = {commune2, commune3, commune4, commune5, commune6, commune7};
            Commune communeMax = commune1.communeMaxCommuneVoisine(communesVoisinesRennes);
            System.out.println(communeMax);

            if (communeMax == commune1) {
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
     * Test pour la méthode rechercheAeroport dans la classe Departement
     */
    public static void testRechercheAeroport(){
        System.out.println("Test rechercheAerport Departement :");
        System.out.println("Cas normal :");
        try {
            Departement departement35 = new Departement(35, "Ille-et-Vilaine", 1000000);

            Aeroport aeroport1 = new Aeroport(departement35, "Rennes Aeroport", "Rennes Saint-Jacques");
            Aeroport aeroport2 = new Aeroport(departement35, "Rennes Aeroport 2", "Rennes Saint-Jacques 2");
            Aeroport aeroport3 = new Aeroport(departement35, "Rennes Aeroport 3", "Rennes Saint-Jacques 3");

            departement35.addAeroport(aeroport1);
            departement35.addAeroport(aeroport2);
            departement35.addAeroport(aeroport3);

            ArrayList<Aeroport> res = departement35.rechercheAeroport();

            System.out.println("Les aeroports du département de " + departement35.getNomDep() + " sont : ");
            for(Aeroport a : res){
                System.out.println("\t- " + a.getNom());
            }

            System.out.println(" : Test réussi");
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------


    /**
     * Test pour la méthode destinationAeroport dans la classe Aeroport
     */
    public static void testDestinationAeroport(){
        System.out.println("Test destinationAeroport Aeroport :");
        System.out.println("Cas normal :");
        try {
            Departement departement35 = new Departement(35, "Ille-et-Vilaine", 1000000);
            Departement departement56 = new Departement(56, "Morbihan", 1000000);
            Departement departement29 = new Departement(29, "Finistère", 1000000);
            Aeroport aeroport1 = new Aeroport(departement35, "Rennes Aeroport", "Rennes Saint-Jacques");
            Aeroport aeroport2 = new Aeroport(departement56, "Lorient Aeroport", "Lorient");
            Aeroport aeroport3 = new Aeroport(departement29, "Brest Aeroport", "Brest");
            aeroport1.addDestinationAeroport(aeroport2);
            aeroport1.addDestinationAeroport(aeroport3);
            ArrayList<Aeroport> res = aeroport1.rechercheDestinationAeroport();
            System.out.println("L'aeroport de " + aeroport1.getNom() + " dessert à : ");
            for(Aeroport a : res){
                System.out.println("\t- " + a.getNom());
            }


            System.out.println(" : Test réussi");
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------


    /**
     * Test pour la méthode destinationGare dans la classe Gare
     */
    public static void testDestinationGare(){
        System.out.println("Test destinationGare Gare :");
        System.out.println("Cas normal :");
        try {
            Departement departement35 = new Departement(35, "Ille-et-Vilaine", 1000000);

            Commune commune1 = new Commune(1, "Rennes", departement35);
            Commune commune2 = new Commune(2, "Cesson-Sévigné", departement35);
            Commune commune3 = new Commune(3, "Saint-Grégoire", departement35);
            Commune commune4 = new Commune(4, "Betton", departement35);
            Commune commune5 = new Commune(5, "Chantepie", departement35);

            Gare gare1 = new Gare(1, "Rennes Gare", false, true, commune1);
            Gare gare2 = new Gare(2, "Cesson-Sévigné Gare", false, true, commune2);
            Gare gare3 = new Gare(3, "Saint-Grégoire Gare", false, true, commune3);
            Gare gare4 = new Gare(4, "Betton Gare", false, true, commune4);
            Gare gare5 = new Gare(5, "Chantepie Gare", false, true, commune5);
            
            gare1.addDestinationGare(gare2);
            gare1.addDestinationGare(gare3);
            gare1.addDestinationGare(gare4);
            gare1.addDestinationGare(gare5);
            
            ArrayList<Gare> dest = gare1.rechercheDestinationGare();

            System.out.println("La gare de " + gare1.getNomGare() + " dessert à : ");
            for(Gare g : dest){
                System.out.println("\t- " + g.getNomGare());
            }

            System.out.println(" : Test réussi");   
        } catch (Exception e) {
            System.out.println(" : Test échoué");
        }
    }

}