-- Active: 1716314718184@@127.0.0.1@3306@sae

/* Question 1 : jointure */
-- Quels est le departement de chaque aeroport ?
SELECT Aeroport.nom, Departement.nomDep
FROM Departement
JOIN Aeroport ON Departement.idDep = Aeroport.leDepartement
ORDER BY Departement.idDep;

/* Question 2 : auto-jointure */
-- Quels sont les villes possédant plus d'une gares ?
SELECT C1.nomCommune, COUNT(DISTINCT G1.codeGare) AS nombreDeGares
FROM Commune C1
JOIN Gare G1 ON C1.idCommune = G1.laCommune
JOIN Gare G2 ON C1.idCommune = G2.laCommune AND G1.codeGare < G2.codeGare
GROUP BY C1.nomCommune
HAVING COUNT(DISTINCT G1.codeGare) >= 2
ORDER BY nombreDeGares DESC;

/* Question 3 : jointure externe */
-- Quels sont les 10 premières communes n'ayant pas de gare ?
SELECT Commune.idCommune, Commune.nomCommune
FROM Commune
LEFT JOIN Gare ON Commune.idCommune = Gare.laCommune
WHERE Gare.codeGare IS NULL
ORDER BY Commune.idCommune
LIMIT 10;

/* Question 4 : jointure externe */
-- Quels sont les communes ayant un nombre de maisons vendu supérieur à 50 en 2020 ?
SELECT c.nomCommune, d.nbMaison
FROM Commune c
LEFT JOIN DonneesAnnuelles d
ON c.idCommune = d.laCommune
WHERE d.lAnnee = 2020
AND d.nbMaison > 50;


/* Question 5 : sous-requête (avec IN) */
-- Quels sont les aeroports dont le département est le 35 ?
SELECT nom, leDepartement
FROM Aeroport
WHERE leDepartement IN (
    SELECT idDep 
    FROM Departement
    WHERE UPPER(nomDep) = 'ILLE-ET-VILAINE'
    );

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

/* Question 9 : fonction de groupe sans regroupement */
-- Quel est l'investissement culturel moyen par département ?
SELECT nomDep, AVG(investissementCulturel2019) AS investissementCulturelMoyen
FROM Departement
GROUP BY nomDep;

/* Question 10 : fonction de groupe sans regroupement */
-- Nombre de gares par commune, incluant les communes sans gares.
SELECT C.nomCommune, COUNT(G.codeGare) AS nombreDeGares
FROM Commune C
LEFT JOIN Gare G ON C.idCommune = G.laCommune
GROUP BY C.nomCommune;

/* Question 11 : regroupement avec fonction de groupe */
-- Quel est le nombre de communes par département ?
SELECT D.nomDep, COUNT(C.idCommune) AS nombreDeCommunes
FROM Departement D
JOIN Commune C ON D.idDep = C.leDepartement
GROUP BY D.nomDep;

/* Question 12 :regroupement avec fonction de groupe */
-- Quel est le nombre de commune voisine trié par ordre décroissant ?
SELECT Commune.nomCommune, COUNT(Voisinage.communeVoisine) AS nbVoisins
FROM Voisinage
JOIN Commune ON Voisinage.commune = Commune.idCommune
LEFT JOIN Commune voisine ON Voisinage.communeVoisine = voisine.idCommune
GROUP BY Commune.nomCommune
ORDER BY nbVoisins DESC;

/* Question 13 : regroupement et restriction (avec HAVING) */
-- Quel est le nombre de gares par departement ?
SELECT D.nomDep, COUNT(G.codeGare) AS nombreDeGares
FROM Gare G
LEFT JOIN Commune C ON G.laCommune = C.idCommune
LEFT JOIN Departement D ON C.leDepartement = D.idDep
GROUP BY D.nomDep
HAVING COUNT(G.codeGare) > 0;

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
-- 


/* Question 19 : vue (pour gérer des informations d´erivables à proposer) */


/* Question 20 : vue (pour gérer des informations d´erivables à proposer) */

