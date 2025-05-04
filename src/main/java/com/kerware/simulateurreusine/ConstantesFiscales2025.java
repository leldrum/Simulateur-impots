package com.kerware.simulateurreusine;

public class ConstantesFiscales2025 {


    // Abattement (par déclarant, fixe)
    public static final double TAUX_ABATTEMENT = 0.10;
    public static final int ABATTEMENT_MIN = 495;
    public static final int ABATTEMENT_MAX = 14171;

    public static final double SEUIL_DECOTE_CELIBATAIRE = 888;
    public static final double SEUIL_DECOTE_COUPLE = 1467;

    public static final double SEUIL_CONTRIBUTION_EXCEPTIONNELLE = 250000;
    public static final double TAUX_CONTRIBUTION_EXCEPTIONNELLE = 0.03;
    public static final int[] TRANCHES_IMPOSITION = {
            0,
            11294,
            28797,
            82341,
            177106,
            Integer.MAX_VALUE
    };
    public static final double[] TAUX_IMPOSITION = { 0.0, 0.11, 0.3, 0.41, 0.45 };
}
