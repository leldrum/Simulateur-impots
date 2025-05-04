package com.kerware.simulateurreusine;

public class CalculateurImpotBrut {
    private static final int[] TRANCHES = ConstantesFiscales2025.TRANCHES_IMPOSITION;
    private static final double[] TAUX = ConstantesFiscales2025.TAUX_IMPOSITION;

    public static double calculer(double revenuFiscalReference, double nbParts) {
        double revenuParPart = revenuFiscalReference / nbParts;
        double impot = 0.0;

        for (int i = 0; i < TAUX.length; i++) {
            if (revenuParPart > TRANCHES[i]) {
                double limiteSup = i < TRANCHES.length - 1 ? TRANCHES[i+1] : Double.MAX_VALUE;
                double base = Math.min(revenuParPart, limiteSup) - TRANCHES[i];
                impot += base * TAUX[i];
            }
        }

        // Arrondi spécifique à l'impôt sur le revenu (à l'euro le plus proche)
        double impotTotal = impot * nbParts;
        return Math.round(impotTotal);
    }
}
