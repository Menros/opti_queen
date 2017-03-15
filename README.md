# Projet - Problème des n-dames
###### PRIEUR-DREVON Thomas - GONDRAS Pierre-Louis

## Ensemble
- Tout : n<sup>n</sup> solutions
- **1 reine par ligne et par colone : n! solutions**

## Représentation
- Matrice binaire n x n
- Liste de couples (ligne, colone)
- **Liste d'entiers (indice = ligne, valeur = colone)**

## Voisinages
- Reine se déplace de une case sur ligne ou colone
- Reine se déplace de une case sur ligne ou colone ou diagonale
- **2 Reines échangent leurs coordonnées x ou y**

## Fitness
Nombres de conflits (nombre de fois que deux reines entre en conflit)
Conflit si :
- x1 = x2 ou y1 = y2 : ligne ou colones identiques
- **|x1 - x2| = |y1 - y2| : diagonales identiques**

## Initialisation
**Les reines sont sur une diagonale de l'échiquier**

## Méthodes
 1/ Méthode Tabou
 2/ Méthode du recuit simulé
 