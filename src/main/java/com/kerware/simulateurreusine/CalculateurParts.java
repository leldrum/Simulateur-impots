package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculateurParts {

    public static final double MAJORATION_PARENT_ISOLE = 0.5;

    public static double calculer(SituationFamiliale situation,
                                  int enfants, int enfantsHandicapes, boolean parentIsole) {

        double parts = switch (situation) {
            case MARIE, PACSE -> 2.0;
            case CELIBATAIRE, DIVORCE, VEUF -> 1.0;
        };

        if (enfants > 0 && parentIsole) {
            parts += MAJORATION_PARENT_ISOLE;
        }

        if (situation == SituationFamiliale.VEUF && enfants > 0) {
            parts += 1.0;
        }

        if (enfants == 1) {
            parts += MAJORATION_PARENT_ISOLE;
        } else if (enfants == 2) {
            parts += 1.0;
        } else if (enfants > 2) {
            parts += 1.0 + (enfants - 2) * 1.0;
        }

        parts += enfantsHandicapes * MAJORATION_PARENT_ISOLE;

        return parts;
    }
}
