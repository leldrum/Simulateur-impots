package com.kerware.simulateurreusine;

public class CalculateurAbattement {

    public static double calculer(double revenuReference, double nbParts) {
        // Exemple : abattement de 10% plafonné
        double abattementBrut = revenuReference * 0.10;
        double plafond = ConstantesFiscales2025.PLAFOND_ABATTEMENT_PAR_PART * nbParts;
        return Math.min(abattementBrut, plafond);
    }
}
