package com.kerware.simulateurreusine;

public class ConstantesFiscales2025 {

    // Barème IR 2025 simplifié
    public static final double[] TRANCHES = {
            0, 10777, 27478, 78570, 168994
    };

    public static final double[] TAUXS = {
            0.0, 0.11, 0.30, 0.41, 0.45
    };

    public static final double PLAFOND_ABATTEMENT_PAR_PART = 1752;

    public static final double SEUIL_DECOTE_CELIBATAIRE = 888;
    public static final double SEUIL_DECOTE_COUPLE = 1467;

    public static final double SEVUIL_CONTRIBUTION = 50000;
    public static final double TAUX_CONTRIBUTION_EXCEPTIONNELLE = 0.03;
}
