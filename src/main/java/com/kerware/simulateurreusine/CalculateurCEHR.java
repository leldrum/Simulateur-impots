package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculateurCEHR {

    public static double calculer(double revenuFiscalReference,
                                  double nbParts,
                                  SituationFamiliale situation) {
        boolean isCouple = (situation == SituationFamiliale.MARIE ||
                situation == SituationFamiliale.PACSE);

        // Utilisation des constantes du fichier ConstantesFiscales2025
        double seuilBase = ConstantesFiscales2025.SEUIL_CONTRIBUTION_EXCEPTIONNELLE;
        double tauxBase = ConstantesFiscales2025.TAUX_CONTRIBUTION_EXCEPTIONNELLE;

        // Définition des seuils et taux en fonction de la situation
        double[] seuils = isCouple ?
                new double[]{0, seuilBase*2, seuilBase*4, seuilBase*8, Double.MAX_VALUE} :
                new double[]{0, seuilBase, seuilBase*2, seuilBase*4, Double.MAX_VALUE};

        double[] taux = {0, tauxBase, tauxBase + 0.01, tauxBase + 0.015};

        double contribExceptionnelle = 0;
        double revenuRestant = revenuFiscalReference;

        // Calcul progressif par tranche
        for (int i = seuils.length - 2; i >= 0; i--) {
            if (revenuRestant > seuils[i]) {
                double montant = Math.min(revenuRestant, seuils[i+1]) - seuils[i];
                contribExceptionnelle += montant * taux[i];
                revenuRestant = seuils[i];
            }
        }

        // Arrondi à l'euro inférieur
        return Math.floor(contribExceptionnelle);
    }
}