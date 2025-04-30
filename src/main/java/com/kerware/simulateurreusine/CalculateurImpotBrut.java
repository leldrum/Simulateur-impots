package com.kerware.simulateurreusine;

public class CalculateurImpotBrut {

    public static double calculer(double revenuImposable, double nbParts) {
        double revenuParPart = revenuImposable / nbParts;
        double impotParPart = 0;

        for (int i = 0; i < ConstantesFiscales2025.TAUXS.length; i++) {
            double seuilBas = ConstantesFiscales2025.TRANCHES[i];
            double seuilHaut = (i == ConstantesFiscales2025.TRANCHES.length - 1)
                    ? Double.MAX_VALUE
                    : ConstantesFiscales2025.TRANCHES[i + 1];

            if (revenuParPart > seuilBas) {
                double taxable = Math.min(revenuParPart, seuilHaut) - seuilBas;
                impotParPart += taxable * ConstantesFiscales2025.TAUXS[i];
            } else {
                break;
            }
        }

        return impotParPart * nbParts;
    }
}
