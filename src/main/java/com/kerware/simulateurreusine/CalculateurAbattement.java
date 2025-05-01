package com.kerware.simulateurreusine;

public class CalculateurAbattement {

    public static double calculer(double revenuReference, double nombreDeclarants) {
        double abattementTotal = 0.0;

        for (int i = 0; i < nombreDeclarants; i++) {
            double abattement = revenuReference * ConstantesFiscales2025.TAUX_ABATTEMENT;
            abattement = Math.max(ConstantesFiscales2025.ABATTEMENT_MIN, abattement);
            abattement = Math.min(ConstantesFiscales2025.ABATTEMENT_MAX, abattement);
            abattementTotal += abattement;
        }

        return abattementTotal;
    }
}


