package com.kerware.simulateurreusine;

public class ConstantesFiscales2025 {

    // Barème IR 2025 simplifié
    public static final double[] TRANCHES = {
            0, 10777, 27478, 78570, 168994
    };

    public static final double[] TAUXS = {
            0.0, 0.11, 0.30, 0.41, 0.45
    };

    // Abattement (par déclarant, fixe)
    public static final double TAUX_ABATTEMENT = 0.10;
    public static final int ABATTEMENT_MIN = 495;
    public static final int ABATTEMENT_MAX = 14171;

    public static final double SEUIL_DECOTE_CELIBATAIRE = 888;
    public static final double SEUIL_DECOTE_COUPLE = 1467;

    public static final double SEUIL_CONTRIBUTION_EXCEPTIONNELLE = 250000;
    public static final double TAUX_CONTRIBUTION_EXCEPTIONNELLE = 0.03;
    public static final int[] TRANCHES_IMPOSITION = { 0, 11294, 28797, 82341, 177106, Integer.MAX_VALUE };
    public static final double[] TAUX_IMPOSITION = { 0.0, 0.11, 0.3, 0.41, 0.45 };
}
