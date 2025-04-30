package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculateurParts {

    public static double calculer(SituationFamiliale situation, int enfants, int enfantsHandicapes, boolean parentIsole) {
        double parts = switch (situation) {
            case MARIE, PACSE -> 2.0;
            case CELIBATAIRE, DIVORCE, VEUF -> 1.0;
        };

        if (parentIsole && situation == SituationFamiliale.CELIBATAIRE) {
            parts += 0.5;
        }

        parts += Math.min(enfants, 2) * 0.5 + Math.max(0, enfants - 2);
        parts += enfantsHandicapes * 0.5;

        return parts;
    }
}
