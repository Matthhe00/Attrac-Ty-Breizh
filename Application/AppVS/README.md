# Projet : Attractivité des communes bretonnes

## Description
Développement d’une application de valorisation de données publiques pour analyser et améliorer l'attractivité des communes bretonnes. Ce projet inclut la conception d'une base de données, l'analyse statistique, la création d'une interface graphique et la modélisation du réseau des communes sous forme de graphe.

## Utilisation
Instructions pour utiliser le projet :

1. Lancer l'application :
```bash
# Pour compiler l'application Java il faut utiliser la commande suivante :
javac -d ./classes --module-path C:\Users\User\Documents\Ressources\R2.02\lib\javafx-sdk-22.0.1\lib --add-modules javafx.controls .\src\app\controller\*.java .\src\app\model\dao\*.java .\src\app\model\data\*.java .\src\resource\utils\Constants.java .\src\app\Main.java .\src\app\view\*.java .\src\app\view\admin\*.java .\src\app\view\table\*.java

#Pour exécuter l'application Java il faut utiliser la commande suivante  : 
java --module-path C:\Users\User\Documents\javafx-sdk-21.0.3\lib --add-modules javafx.controls .\src\app\Main

#Autre possibilié simplement lancer "Attract'y Breizh - App" avec le Debug VsCode (si Sur VsCode) en modifiant dans "lauch.json"
Modifié : "vmArgs": "--module-path <Chemin vers la librairie JavaFX - /lib> --add-modules javafx.controls"

```



2. Accéder à l'application via l'interface utilisateur fournie.

## Données
Le projet utilise plusieurs jeux de données disponibles sur [data.gouv.fr](https://www.data.gouv.fr/fr/). Les fichiers de données inclus sont :
- `departement.csv` : Liste des départements en Bretagne.
- `communesBretonnes.csv` : Liste des communes bretonnes.
- `voisinageCommunesBretonnes.csv` : Liste des communes adjacentes.
- `prixParCommune.csv` : Données sur les prix des logements par commune.
- `investissementCulturelParDep.csv` : Montants des allocations culturelles par département.
- `gare.csv` : Présence des gares par commune.
- `depensesCulturellesParCommune.csv` : Dépenses culturelles par commune.
- `aeroport.csv` : Localisation des aéroports bretons.
- `tauxInflationParAn.csv` : Taux d'inflation par an.

## Auteurs et crédits
- Matthéo Jules-Vachet
- Paul Gauffeny
- Yanis Schell

## Technologies utilisées
- Java
- JavaFX
- MySQL

## Liens utiles
- [Documentation](https://moodle.univ-ubs.fr/course/view.php?id=7564)
- [Rapports de bugs](https://www.data.gouv.fr/fr/)
- [Discussions](https://www.data.gouv.fr/fr/)

## Lien Vers la vidéo de démonstration d'application

- [Lien de la vidéo](https://www.youtube.com/watch?v=slz8_Z3xK80)
