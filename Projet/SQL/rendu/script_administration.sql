/*

Rendu partie BDD partie 2 : Administration de la base de donnee
Groupe A1-2

Membres du groupe :
- Jules-Vachet Mattheo
- Schell Yanis
- Gauffeny Paul

*/

------------------------------------------
--        Shell / root@localhost        --
------------------------------------------

-- Creation de la base de donnee
CREATE DATABASE bd_sae204;

-- Creation de l'utilisateur 'schell'
CREATE USER 'schell'@'localhost' IDENTIFIED BY 'mdp_schell';


-- Attribution des droits a l'utilisateur 'schell'
GRANT ALL PRIVILEGES ON *.* TO 'schell'@'localhost' WITH GRANT OPTION;

-- Utilisation de la base de donnee
USE bd_sae204;

-- Execution des scripts de creation et de remplissage
\source "D:\desktop\SAE_communes_bretonnes\SAE_creation.sql"
\source "D:\desktop\SAE_communes_bretonnes\SAE_remplissage.sql"



------------------------------------------
--     Workbench / schell@localhost     --
------------------------------------------

-- Creation des utilisateurs de la base de donnee ('vachet', 'gauffeny', 'user')
CREATE USER 'vachet'@'localhost' IDENTIFIED BY 'mdp_vachet';

CREATE USER 'gauffeny'@'localhost' IDENTIFIED BY 'mdp_gauffeny';

CREATE USER 'user'@'localhost' IDENTIFIED BY 'mdp_user';


-- Creation des roles
CREATE ROLE 'bd_sae204_lecture';
GRANT SELECT ON bd_sae204.* TO 'bd_sae204_lecture';

CREATE ROLE 'bd_sae204_ecriture';
GRANT INSERT, UPDATE, DELETE ON bd_sae204.* TO 'bd_sae204_ecriture';


-- Attribution des roles aux utilisateurs
GRANT bd_sae204_lecture, bd_sae204_ecriture TO 'vachet'@'localhost';
SET DEFAULT ROLE ALL TO 'vachet'@'localhost';

GRANT bd_sae204_ecriture TO 'gauffeny'@'localhost';
SET DEFAULT ROLE ALL TO 'gauffeny'@'localhost';

GRANT bd_sae204_lecture TO 'user'@'localhost';
SET DEFAULT ROLE ALL TO 'user'@'localhost';

-- Verification des droits
SHOW GRANTS FOR 'schell'@'localhost';
SHOW GRANTS FOR 'vachet'@'localhost';
SHOW GRANTS FOR 'gauffeny'@'localhost';
SHOW GRANTS FOR 'user'@'localhost';


------------------------------------------
--      Workbench / script de test      --
------------------------------------------

-- Utilisateur : vachet@localhost
-- Mot de passe : mdp_vachet

USE bd_sae204;

-- Verification des droits de lecture
SELECT * FROM Departement;
SELECT * FROM Commune;
SELECT * FROM Gare;
SELECT * FROM Voisinage;

-- Verification des droits d'ecriture
INSERT INTO Departement VALUES (44, 'Loire Atlantique', 1000);

SELECT * 
FROM Departement
WHERE idDep = 44;

UPDATE Departement 
SET investissementCulturel2019 = 2000
WHERE idDep = 44;

SELECT *
FROM Departement
WHERE idDep = 44;

DELETE FROM Departement
WHERE idDep = 44;

SELECT *
FROM Departement
WHERE idDep = 44;

-- Utilisateur : gauffeny@localhost
-- Mot de passe : mdp_gauffeny

USE bd_sae204;
-- Verification des droits de lecture
SELECT * FROM Departement;
SELECT * FROM Commune;
SELECT * FROM Gare;
SELECT * FROM Voisinage;

-- Verification des droits d'ecriture
INSERT INTO Departement VALUES (78, 'Yvelines', 9999);

SELECT *
FROM Departement
WHERE idDep = 78;

UPDATE Departement
SET investissementCulturel2019 = 10000
WHERE idDep = 78;

SELECT *
FROM Departement
WHERE idDep = 78;

DELETE FROM Departement
WHERE idDep = 78;

SELECT *
FROM Departement
WHERE idDep = 78;

-- Utilisateur : user@localhost

USE bd_sae204;

-- Verification des droits de lecture

SELECT * FROM Departement;
SELECT * FROM Commune;
SELECT * FROM Gare;
SELECT * FROM Voisinage;

-- Verification des droits d'ecriture
INSERT INTO Departement VALUES (68, 'Haut-Rhin', 1111);

SELECT *
FROM Departement
WHERE idDep = 68;

UPDATE Departement
SET investissementCulturel2019 = 2222
WHERE idDep = 68;

SELECT *
FROM Departement
WHERE idDep = 68;

DELETE FROM Departement
WHERE idDep = 68;

SELECT *
FROM Departement
WHERE idDep = 68;

-- Utilisateur : schell@localhost
-- Mot de passe : mdp_schell

USE bd_sae204;

-- Verification des droits de lecture
SELECT * FROM Departement;
SELECT * FROM Commune;
SELECT * FROM Gare;
SELECT * FROM Voisinage;

-- Verification des droits d'ecriture
INSERT INTO Departement VALUES (67, 'Bas-Rhin', 1111);

SELECT *
FROM Departement
WHERE idDep = 67;

UPDATE Departement
SET investissementCulturel2019 = 2222
WHERE idDep = 67;

SELECT *
FROM Departement
WHERE idDep = 67;

DELETE FROM Departement
WHERE idDep = 67;

SELECT *
FROM Departement
WHERE idDep = 67;