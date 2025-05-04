# Simulateur d'Impôts - Projet R4.02

## Description du projet
Réusinage complet du simulateur d'impôts initial avec :
- Modularisation du code en composants spécialisés
- Amélioration de la lisibilité et de la maintenabilité
- Conservation de la compatibilité avec les tests existants via un adaptateur
- Respect strict des standards de qualité logicielle

## Exigences satisfaites

### Qualité du code
- **Couverture de tests** : > 90% (vérifié via JaCoCo)
- **CheckStyle** : 0 erreur/warning pour le nouveau code réusine
- **Tests unitaires** : 100% passants avec l'adaptateur (Les 4 derniers tests du csv ne marchent pas)

### Traçabilité
Les commentaires dans le code relient explicitement :
- Les exigences fiscales aux implémentations
- Les formules de calcul aux articles de loi correspondants
- Les règles métier aux constantes configurables

## Fonctionnalités implémentées
- Calcul de l'impôt brut par tranches
- Calcul des abattements et décotes
- Gestion des situations familiales complexes
- Contribution exceptionnelle sur hauts revenus
- Validation robuste des entrées

## Outils utilisés
- Java 17
- Maven
- JUnit 5
- JaCoCo (couverture de code)
- CheckStyle (vérification de qualité)

## Membres du projet
- **Ravida Lélyan** 
- **Surcouf Clément**
- **Delaunay Alix** 



## Commandes utiles

```bash
# Lancer les tests avec couverture
mvn clean test

# Générer le rapport JaCoCo
mvn jacoco:report

# Vérifier la qualité du code
mvn checkstyle:check

# Générer la documentation du projet
mvn site