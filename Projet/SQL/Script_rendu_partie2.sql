-- Active: 1710626043643@@127.0.0.1@3306@bd_r206

/* Question 1 : jointure */
-- Quels sont les aéroports et leur département ?
SELECT Aeroport.nom, Departement.nomDep
FROM Departement
JOIN Aeroport ON Departement.idDep = Aeroport.leDepartement
ORDER BY Departement.idDep;

/* Question 2 : auto-jointure */
-- Quels sont les 10 premières villes possédant au moins deux gares ?
SELECT C.nomCommune, COUNT(G.codeGare) AS nombreDeGares
FROM Commune C
JOIN Gare G ON C.idCommune = G.laCommune
GROUP BY C.nomCommune
HAVING COUNT(G.codeGare) >= 2
ORDER BY nombreDeGares DESC
LIMIT 10;


/* Question 3 : jointure externe */
-- Quels sont les 10 premières communes n'ayant pas de gare ?
SELECT Commune.idCommune, Commune.nomCommune
FROM Commune
LEFT JOIN Gare ON Commune.idCommune = Gare.laCommune
WHERE Gare.codeGare IS NULL
ORDER BY Commune.idCommune
LIMIT 10;


/* Question 4 : jointure externe */


/* Question 5 : sous-requête (avec IN) */
-- Quels sont les aeroports dont le département est le 35 ?
SELECT nom, leDepartement
FROM Aeroport
WHERE leDepartement IN (
    SELECT idDep 
    FROM Departement
    WHERE UPPER(nomDep) = 'ILLE-ET-VILAINE'
    );

-- /* Question 6 : sous-requête (avec NOT IN) */
-- Quels sont les gares qui ne sont pas dans le département 56 ?
SELECT nomGare, laCommune
FROM Gare
WHERE laCommune NOT IN (
    SELECT idCommune
    FROM Commune
    WHERE leDepartement = 56
    )
ORDER BY codeGare;

-- /* Question 7 : sous-requête (avec EXISTS) */
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

-- /* Question 8 : sous-requête (avec NOT EXISTS) */
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
-- Calculer l'investissement culturel moyen par département.
SELECT nomDep, AVG(investissementCulturel2019) AS investissementCulturelMoyen
FROM Departement
GROUP BY nomDep;

/* Question 10 : fonction de groupe sans regroupement */
-- Trouver le département avec le maximum d'investissement culturel.
SELECT nomDep, investissementCulturel2019
FROM Departement
WHERE investissementCulturel2019 = (SELECT MAX(investissementCulturel2019) FROM Departement);

/* Question 11 : jointure et fonction de groupe */
-- Nombre de communes par département.
SELECT D.nomDep, COUNT(C.idCommune) AS nombreDeCommunes
FROM Departement D
JOIN Commune C ON D.idDep = C.leDepartement
GROUP BY D.nomDep;

-- /* Question 12 : jointure avec condition */


-- /* Question 13 : jointure externe et fonction de groupe */


/* Question 14 : sous-requête corrélée */
-- Liste des communes ayant plus de 2 gares.
SELECT nomCommune
FROM Commune C
WHERE (SELECT COUNT(*) FROM Gare G WHERE G.laCommune = C.idCommune) > 2;

/* Question 15 : jointure et fonction de groupe avec condition */
-- Nombre total d'investissement culturel pour les départements ayant plus de 300 communes.
SELECT D.nomDep, SUM(D.investissementCulturel2019) AS investissementTotal
FROM Departement D
JOIN Commune C ON D.idDep = C.leDepartement
GROUP BY D.nomDep
HAVING COUNT(C.idCommune) > 300;

-- /* Question 16 : sous-requête imbriquée */


-- /* Question 17 : jointure avec agrégation et condition */


/* Question 18 : jointure externe avec fonction de groupe */
-- Nombre de gares par commune, incluant les communes sans gares.
SELECT C.nomCommune, COUNT(G.codeGare) AS nombreDeGares
FROM Commune C
LEFT JOIN Gare G ON C.idCommune = G.laCommune
GROUP BY C.nomCommune;

-- /* Question 19 : jointure multiple */


-- /* Question 20 : sous-requête avec agrégation */


