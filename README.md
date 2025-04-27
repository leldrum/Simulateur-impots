# Lisezmoi

## Projet : Réusinage du Simulateur d'Impôts - R4.02

### Description rapide
Ce projet a pour but de réusiner le simulateur d’impôts fourni, tout en conservant la compatibilité avec les tests existants.
Le code a été rendu plus lisible, plus modulaire, et respecte les standards de qualité imposés par l'IUT.

---

### Détail des modifications
- Refactorisation du code pour améliorer la lisibilité et la maintenance
- Modularisation : découpage du code en plusieurs classes/fichiers clairs
- Mise en place d’un adaptateur pour faire fonctionner les tests existants sans les modifier
- Ajout de commentaires pour assurer la traçabilité entre les exigences et le code
- Correction des erreurs de style selon les règles fournies par l'IUT (CheckStyle)

---

### Qualité logicielle
- Couverture de tests : supérieure à 90%
- CheckStyle : aucune erreur ni warning détecté avec les règles imposées
- Tests unitaires : tous les tests sont passants.

---

### Organisation des fichiers
- src/main/ : code source refactoré
- src/test/ : tests unitaires d’origine
- doc/ : documentation, y compris ce fichier

---

### Commandes utiles
Pour lancer les tests :
    mvn test

Pour vérifier la qualité du code avec CheckStyle :
    mvn checkstyle:check

---

### Trinôme
- Ravida Lélyan 
- Surcouf Clément
- Delaunay Alix 
