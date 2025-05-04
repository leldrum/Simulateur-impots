package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculateurDecote {
    private static final double SEUIL_CELIB = 1929;
    private static final double SEUIL_COUPLE = 3191;
    private static final double DECOTE_MAX_CELIB = 873;
    private static final double DECOTE_MAX_COUPLE = 1444;
    private static final double TAUX_DECOTE = 0.4525;

    public static double calculer(double impotBrut, SituationFamiliale situation) {
        boolean isCouple = situation == SituationFamiliale.MARIE ||
                situation == SituationFamiliale.PACSE;

        double seuil = isCouple ? SEUIL_COUPLE : SEUIL_CELIB;
        double maxDecote = isCouple ? DECOTE_MAX_COUPLE : DECOTE_MAX_CELIB;

        if (impotBrut < seuil) {
            double decote = maxDecote - (impotBrut * TAUX_DECOTE);
            return Math.max(0, Math.round(decote));
        }
        return 0;
    }
}
