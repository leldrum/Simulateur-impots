package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculateurCEHR {
    public static double calculer(double revenuFiscalReference, double nbParts, SituationFamiliale situation) {
        double rfrParPart = revenuFiscalReference / nbParts;

        double[] seuils = new double[]{250_000, 500_000, 1_000_000};
        double[] taux = new double[]{0.03, 0.04, 0.045};

        double ceParPart = 0;
        for (int i = seuils.length - 1; i >= 0; i--) {
            if (rfrParPart > seuils[i]) {
                double montant = (rfrParPart - seuils[i]) * taux[i];
                ceParPart += montant; // ❗️Ne pas arrondir ici
                rfrParPart = seuils[i];
            }
        }

        double totalCE = ceParPart * nbParts;
        return Math.round(totalCE); // ✅ Arrondi final uniquement
    }

}
