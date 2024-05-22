-- Active: 1716314718184@@127.0.0.1@3306@sae

/* Question 1 : jointure */
-- Quels est le departement de chaque aeroport ?
SELECT Aeroport.nom, Departement.nomDep
FROM Departement
JOIN Aeroport ON Departement.idDep = Aeroport.leDepartement
ORDER BY Departement.idDep;

/*
LANNION	COTES-D'ARMOR
SAINT-BRIEUC-ARMOR	COTES-D'ARMOR
BREST-BRETAGNE	FINISTERE
MORLAIX-PLOUJEAN	FINISTERE
QUIMPER-PLUGUFFAN	FINISTERE

8 tuples retournés
*/

--------------------------------------------------------------

/* Question 2 : auto-jointure */
-- Quels sont les villes possédant plus d'une gares ?
SELECT C1.nomCommune, COUNT(DISTINCT G1.codeGare) AS nombreDeGares
FROM Commune C1
JOIN Gare G1 ON C1.idCommune = G1.laCommune
JOIN Gare G2 ON C1.idCommune = G2.laCommune AND G1.codeGare < G2.codeGare
GROUP BY C1.nomCommune
HAVING COUNT(DISTINCT G1.codeGare) >= 2
ORDER BY nombreDeGares DESC;

/*
SAINT-PIERRE-QUIBERON	3
PLOURIVO	2
RENNES	2

3 tuples retournés
*/

--------------------------------------------------------------

/* Question 3 : jointure externe */
-- Quels sont les communes n'ayant pas de gare ?
SELECT Commune.idCommune, Commune.nomCommune
FROM Commune
LEFT JOIN Gare ON Commune.idCommune = Gare.laCommune
WHERE Gare.codeGare IS NULL
ORDER BY Commune.idCommune;

/*
22001 ALLINEUC
22002 ANDEL
22003 AUCALEUC
22004 BEGARD
22005 BELLE-ISLE-EN-TERRE

1087 tuples retournés
*/

--------------------------------------------------------------

/* Question 4 : jointure externe */
-- Quels sont les communes ayant un nombre de maisons vendu supérieur à 50 en 2020 ?
SELECT c.nomCommune, d.nbMaison
FROM Commune c
LEFT JOIN DonneesAnnuelles d
ON c.idCommune = d.laCommune
WHERE d.lAnnee = 2020
AND d.nbMaison > 50;

/*
BEGARD 81
CALLAC 52
LE MENE 113
DINAN 150
ERQUY 80

221 tuples retournés
*/

--------------------------------------------------------------

/* Question 5 : sous-requête (avec IN) */
-- Quels sont les aeroports dont le département est le 35 ?
SELECT nom, leDepartement
FROM Aeroport
WHERE leDepartement IN (
    SELECT idDep 
    FROM Departement
    WHERE UPPER(nomDep) = 'ILLE-ET-VILAINE'
    );

/*
DINARD-PLEURTUIT-ST-MALO 35
RENNES-ST-JACQUES 35

2 tuples retournés
*/

--------------------------------------------------------------

/* Question 6 : sous-requête (avec NOT IN) */
-- Quels sont les gares qui ne sont pas dans le département 56 ?
SELECT nomGare, laCommune
FROM Gare
WHERE laCommune NOT IN (
    SELECT idCommune
    FROM Commune
    WHERE leDepartement = 56
    )
ORDER BY codeGare;

/*
KER-LANN 35047
TRAOU-NEZ 22233
CESSON-SEVIGNE 35051
LA POTERIE 35238
RENNES 35238

116 tuples retournés
*/

--------------------------------------------------------------

/* Question 7 : sous-requête (avec EXISTS) */
-- Quels sont les communes ayant au moins 2 gares ?
SELECT nomCommune, leDepartement
FROM Commune c1
WHERE EXISTS (
    SELECT *
    FROM Gare g1, Gare g2
    WHERE g1.laCommune = c1.idCommune
    AND g2.laCommune = c1.idCommune
    AND g1.codeGare < g2.codeGare
    )
ORDER BY c1.idCommune;

/*
CALLAC 22
GUINGAMP 22
PLOURIVO 22
PONT-MELVEZ 22
PONTRIEUX 22

13 tuples retournés
*/

--------------------------------------------------------------

/* Question 8 : sous-requête (avec NOT EXISTS) */
-- Quels sont les communes n'ayant pas de gare ?
SELECT *
FROM Commune c1
WHERE NOT EXISTS (
    SELECT *
    FROM Gare g1
    WHERE g1.laCommune = c1.idCommune
    )
ORDER BY c1.idCommune;

/*
22001 ALLINEUC 22
22002 ANDEL 22
22003 AUCALEUC 22
22004 BEGARD 22
22005 BELLE-ISLE-EN-TERRE 22

1087 tuples retournés
*/

--------------------------------------------------------------

/* Question 9 : fonction de groupe sans regroupement */
-- Quel est l'investissement culturel moyen par département ?
SELECT nomDep, AVG(investissementCulturel2019) AS investissementCulturelMoyen
FROM Departement
GROUP BY nomDep;

/*
COTES-D'ARMOR 6196596.0000
FINISTERE 13672777.0000
ILLE-ET-VILAINE 26901579.0000
MORBIHAN 7107993.0000

4 tuples retournés
*/

--------------------------------------------------------------

/* Question 10 : fonction de groupe sans regroupement */
-- Nombre de gares par commune, incluant les communes sans gares.
SELECT C.nomCommune, COUNT(G.codeGare) AS nombreDeGares
FROM Commune C
LEFT JOIN Gare G ON C.idCommune = G.laCommune
GROUP BY C.nomCommune;

/*
ALLINEUC 0
ANDEL 0
AUCALEUC 0
BEGARD 0
BELLE-ISLE-EN-TERRE 0

1201 tuples retournés
*/

--------------------------------------------------------------

/* Question 11 : regroupement avec fonction de groupe */
-- Quel est le nombre de communes par département ?
SELECT D.nomDep, COUNT(C.idCommune) AS nombreDeCommunes
FROM Departement D
JOIN Commune C ON D.idDep = C.leDepartement
GROUP BY D.nomDep;

/*
COTES-D'ARMOR 348
FINISTERE 277
ILLE-ET-VILAINE 333
MORBIHAN 249

4 tuples retournés
*/

--------------------------------------------------------------

/* Question 12 :regroupement avec fonction de groupe */
-- Quel est le nombre de commune voisine trié par ordre décroissant ?
SELECT Commune.nomCommune, COUNT(Voisinage.communeVoisine) AS nbVoisins
FROM Voisinage
JOIN Commune ON Voisinage.commune = Commune.idCommune
LEFT JOIN Commune voisine ON Voisinage.communeVoisine = voisine.idCommune
GROUP BY Commune.nomCommune
ORDER BY nbVoisins DESC;

/*
IFFENDIC 14
LAMBALLE-ARMOR 13
TREMEVEN 13
LA CHAPELLE-NEUVE 12
LE FAOUET 12

1189 tuples retournés
*/

--------------------------------------------------------------

/* Question 13 : regroupement et restriction (avec HAVING) */
-- Quel est le nombre de gares par departement ?
SELECT D.nomDep, COUNT(G.codeGare) AS nombreDeGares
FROM Gare G
LEFT JOIN Commune C ON G.laCommune = C.idCommune
LEFT JOIN Departement D ON C.leDepartement = D.idDep
GROUP BY D.nomDep
HAVING COUNT(G.codeGare) > 0;

/*
COTES-D'ARMOR 43
FINISTERE 24 
ILLE-ET-VILAINE 49
MORBIHAN 21

4 tuples retournés
*/

--------------------------------------------------------------

/* Question 14 : regroupement et restriction (avec HAVING) */
-- Quel est l'investissement total par département pour les départements ayant plus de 300 communes ?
SELECT D.nomDep, SUM(D.investissementCulturel2019) AS investissementTotal
FROM Departement D
JOIN Commune C ON D.idDep = C.leDepartement
GROUP BY D.nomDep
HAVING COUNT(C.idCommune) > 300;

/* Question 15 : division normale */


/* Question 16 : division exacte */


/* Question 17 : vue (pour gérer des contraintes à proposer)  */
-- Vue pour obtenir les départements avec moins de 300 communes
CREATE OR REPLACE VIEW DepartementsPlusDeCentCommunes AS
SELECT D.nomDep, COUNT(C.idCommune) AS nombreDeCommunes
FROM Departement D
JOIN Commune C ON D.idDep = C.leDepartement
GROUP BY D.nomDep
HAVING COUNT(C.idCommune) < 300;

SELECT * FROM DepartementsPlusDeCentCommunes;


/* Question 18 : vue (pour gérer des contraintes à proposer) */
-- Vue pour obtenir les communes ont les 2 types de gares
CREATE OR REPLACE VIEW CommunesAvecDeuxTypesDeGares AS
SELECT C.nomCommune
FROM Commune C
JOIN Gare G ON C.idCommune = G.laCommune
WHERE G.estFret = TRUE
AND G.estVoyageur = TRUE
GROUP BY C.nomCommune;

SELECT * FROM CommunesAvecDeuxTypesDeGares;

/* Question 19 : vue (pour gérer des informations dérivables à proposer) */
-- Vue pour obtenir le nombre de maisons vendues par département
CREATE OR REPLACE VIEW vue_nombre_maisons_par_departement AS
SELECT d.nomDep AS Departement, SUM(da.nbMaison) AS NombreMaisonsVendues
FROM Departement d
JOIN Commune c ON d.idDep = c.leDepartement
JOIN DonneesAnnuelles da ON c.idCommune = da.laCommune
GROUP BY d.nomDep;

SELECT * FROM vue_nombre_maisons_par_departement;

/* Question 20 : vue (pour gérer des informations dérivables à proposer) */
-- Vue pour obtenir le prix moyens des logements des communes
CREATE OR REPLACE VIEW vue_prix_moyen_logements_communes AS
SELECT c.nomCommune AS Commune, AVG(da.nbMaison) AS PrixMoyenLogements
FROM Commune c
JOIN DonneesAnnuelles da ON c.idCommune = da.laCommune
GROUP BY c.nomCommune;

SELECT * FROM vue_prix_moyen_logements_communes;