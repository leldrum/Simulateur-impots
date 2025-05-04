package com.kerware.simulateurreusine;

public class CalculateurImpotBrut {

    public static double calculer(double revenuFiscalReference, double nbParts) {
        double revenuParPart = revenuFiscalReference / nbParts;
        double impot = 0.0;

        int[] tranches = ConstantesFiscales2025.TRANCHES_IMPOSITION;
        double[] taux = ConstantesFiscales2025.TAUX_IMPOSITION;

        for (int i = 0; i < taux.length; i++) {
            if (revenuParPart > tranches[i]) {
                double base = Math.min(revenuParPart, tranches[i+1]) - tranches[i];
                impot += base * taux[i];
            } else {
                break;
            }
        }

        return Math.round(impot * nbParts); // Impôt total du foyer
    }
}
