package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculateurAbattement {

    public static double calculer(int revenu1, int revenu2, SituationFamiliale situation) {
        double abattement1 = Math.max(495, Math.min(14171, revenu1 * 0.10));
        double abattement2 = 0;

        if (situation == SituationFamiliale.MARIE || situation == SituationFamiliale.PACSE) {
            abattement2 = Math.max(495, Math.min(14171, revenu2 * 0.10));
        }

        return abattement1 + abattement2;
    }
}



