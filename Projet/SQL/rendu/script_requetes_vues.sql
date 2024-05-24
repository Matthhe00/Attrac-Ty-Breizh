/*

Rendu partie BDD partie 2 : Requêtes et vues MySQL
Groupe A1-2

Membres du groupe :
- Jules-Vachet Mattheo
- Schell Yanis
- Gauffeny Paul

*/

--------------------------------------------------------------

/* Question 1 : jointure interne */
-- Quel est le departement de chaque aeroport ?
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
-- Quelles sont les villes possédant plus d'une gares ?
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
<<<<<<< HEAD
-- Quelles communes n'a pas vendues d'appartement en 2020 ?
SELECT C.nomCommune
FROM Commune C
LEFT JOIN DonneesAnnuelles D ON C.idCommune = D.laCommune
WHERE D.lAnnee = 2020
AND D.nbAppart = 0;

=======
-- Quels sont les communes qui n'ont pas vendu d'apartement en 2020 ?
SELECT c.nomCommune
FROM Commune c
LEFT JOIN DonneesAnnuelles d ON c.idCommune = d.laCommune
WHERE d.lAnnee = 2020
AND d.nbAppart = 0;

ALLINEUC
ANDEL
AUCALEUC
BERHET
BOBITAL

793 tuples retournés
*/
>>>>>>> fd1bf7e88d4eb92005a2043e6b221cac742eb9a2

--------------------------------------------------------------

/* Question 4 : jointure externe */
-- Quelles sont les communes ayant un nombre de maisons vendu supérieur à 50 en 2020 ?
SELECT c.nomCommune, d.nbMaison
FROM Commune c
LEFT JOIN DonneesAnnuelles d ON c.idCommune = d.laCommune
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
-- Quelles sont les gares qui ne sont pas dans le département 56 ?
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
-- Quelles sont les communes ayant au moins 2 gares ?
SELECT nomCommune
FROM Commune c
WHERE EXISTS (
    SELECT g.laCommune
    FROM Gare g
    WHERE g.laCommune = c.idCommune
    GROUP BY g.laCommune
    HAVING COUNT(g.codeGare) >= 2
);

/*
CALLAC
GUINGAMP
PLOURIVO
PONT-MELVEZ
PONTRIEUX

13 tuples retournés
*/

--------------------------------------------------------------

/* Question 8 : sous-requête (avec NOT EXISTS) */
-- Quelles sont les communes n'ayant pas de gare ?
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
-- Quel est le nombre de gares par commune ?
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

/*
COTES-D'ARMOR 2156415408
ILLE-ET-VILAINE 8958225807

2 tuples retournés
*/

--------------------------------------------------------------

/* Question 15 : division normale */
-- Quelles sont les communes ayant les 2 types de gares ?
SELECT C.nomCommune
FROM Commune C
WHERE NOT EXISTS (
    SELECT G1.codeGare
    FROM Gare G1
    WHERE G1.estFret = TRUE
    AND NOT EXISTS (
        SELECT G2.codeGare
        FROM Gare G2
        WHERE G2.laCommune = C.idCommune
        AND G2.estFret = TRUE
    )
) AND NOT EXISTS (
    SELECT G1.codeGare
    FROM Gare G1
    WHERE G1.estVoyageur = TRUE
    AND NOT EXISTS (
        SELECT G2.codeGare
        FROM Gare G2
        WHERE G2.laCommune = C.idCommune
        AND G2.estVoyageur = TRUE
    )
);

/*
GUINGAMP
LAMBALLE-ARMOR
LOCARN
PLENEE-JUGON
PLESTAN

35 tuples retournés
*/

--------------------------------------------------------------

/* Question 16 : division exacte */
-- Quelles sont les communes ayant uniquement des gares voyageurs ?
SELECT C.nomCommune
FROM Commune C
WHERE EXISTS (
    SELECT 1
    FROM Gare G
    WHERE C.idCommune = G.laCommune
    AND G.estVoyageur = TRUE
)
AND NOT EXISTS (
    SELECT 1
    FROM Gare G
    WHERE C.idCommune = G.laCommune
    AND G.estFret = TRUE
);

/*
BRUZ
PLOURIVO
CESSON-SEVIGNE
VERN-SUR-SEICHE
BETTON

74 tuples retournés
*/

--------------------------------------------------------------

/* Question 17 : vue (pour gérer des contraintes à proposer)  */
-- Vue pour obtenir les départements avec moins de 300 communes
CREATE OR REPLACE VIEW DepartementsPlusDeCentCommunes AS
SELECT D.nomDep, COUNT(C.idCommune) AS nombreDeCommunes
FROM Departement D
JOIN Commune C ON D.idDep = C.leDepartement
GROUP BY D.nomDep
HAVING COUNT(C.idCommune) < 300;

SELECT * FROM DepartementsPlusDeCentCommunes;

/*
FINISTERE 277
MORBIHAN 249

2 tuples retournés
*/

--------------------------------------------------------------

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

/*
RENNES
SAINT-JACQUES-DE-LA-LANDE
L'HERMITAGE
MONTAUBAN-DE-BRETAGNE
REDON

35 tuples retournés
*/

--------------------------------------------------------------

/* Question 19 : vue (pour gérer des informations dérivables à proposer) */
-- Vue pour obtenir le nombre de maisons vendues par département
CREATE OR REPLACE VIEW vue_nombre_maisons_par_departement AS
SELECT d.nomDep AS Departement, SUM(da.nbMaison) AS NombreMaisonsVendues
FROM Departement d
JOIN Commune c ON d.idDep = c.leDepartement
JOIN DonneesAnnuelles da ON c.idCommune = da.laCommune
GROUP BY d.nomDep;

SELECT * FROM vue_nombre_maisons_par_departement;

/*
COTES-D'ARMOR 35041
FINISTERE 44094
ILLE-ET-VILAINE 38801
MORBIHAN 38296

4 tuples retournés
*/

--------------------------------------------------------------

/* Question 20 : vue (pour gérer des informations dérivables à proposer) */
-- Vue pour obtenir le prix moyens des logements des communes
CREATE OR REPLACE VIEW vue_prix_moyen_logements_communes AS
SELECT c.nomCommune AS Commune, AVG(da.nbMaison) AS PrixMoyenLogements
FROM Commune c
JOIN DonneesAnnuelles da ON c.idCommune = da.laCommune
GROUP BY c.nomCommune;

SELECT * FROM vue_prix_moyen_logements_communes;

/*
ALLINEUC 5.5000
ANDEL 13.7500
AUCALEUC 10.5000
BEGARD 81.0000
BELLE-ISLE-EN-TERRE 20.7500

1199 tuples retournés
*/

--------------------------------------------------------------