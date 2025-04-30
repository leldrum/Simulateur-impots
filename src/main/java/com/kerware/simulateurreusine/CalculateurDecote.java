package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculateurDecote {

    public static double calculer(double impotBrut, SituationFamiliale situation) {
        double seuil = switch (situation) {
            case MARIE, PACSE -> ConstantesFiscales2025.SEUIL_DECOTE_COUPLE;
            default -> ConstantesFiscales2025.SEUIL_DECOTE_CELIBATAIRE;
        };

        if (impotBrut < seuil) {
            return seuil - impotBrut;
        }

        return 0;
    }
}
