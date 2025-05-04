package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculateurDecote {

    public static double calculer(double impotBrut, SituationFamiliale situation) {
        double seuil, maxDecote;

        if (situation == SituationFamiliale.MARIE || situation == SituationFamiliale.PACSE) {
            seuil = 3191;
            maxDecote = 1444;
        } else {
            seuil = 1929;
            maxDecote = 873;
        }

        if (impotBrut < seuil) {
            double decote = maxDecote - (impotBrut * 0.4525);
            return Math.round(Math.min(decote, impotBrut)); // On ne dépasse jamais l’impôt brut
        }

        return 0;
    }
}

