package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;
import com.kerware.simulateurreusine.ConstantesFiscales2025;

public class CalculateurAbattement {

    public static double calculer(int revenu1, int revenu2, SituationFamiliale situation) {
        // Validation des entrées
        if (revenu1 < 0 || revenu2 < 0) {
            throw new IllegalArgumentException("Les revenus ne peuvent pas être négatifs");
        }

        // Calcul abattement premier déclarant
        double abattement1 = calculAbattementIndividuel(revenu1);

        // Calcul abattement deuxième déclarant si couple
        double abattement2 = (situation == SituationFamiliale.MARIE || situation == SituationFamiliale.PACSE)
                ? calculAbattementIndividuel(revenu2)
                : 0;

        return abattement1 + abattement2;
    }

    private static double calculAbattementIndividuel(int revenu) {
        double abattementCalculé = revenu * ConstantesFiscales2025.TAUX_ABATTEMENT;

        // Application des plafonds
        return Math.max(ConstantesFiscales2025.ABATTEMENT_MIN,
                Math.min(ConstantesFiscales2025.ABATTEMENT_MAX, abattementCalculé));
    }
}