package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public final class SimulateurReusine {

    private int revenusNetDecl1;
    private int revenusNetDecl2;
    private SituationFamiliale situationFamiliale;
    private int nbEnfantsACharge;
    private int nbEnfantsSituationHandicap;
    private boolean parentIsole;

    private double revenuReference;
    private double nbParts;
    private double abattement;
    private double impotAvantDecote;
    private double decote;
    private double impotNet;
    private double contributionExceptionnelle;

    private static final int MAX_ENFANTS = 7;

    // --- SETTERS pour les données d'entrée ---
    public void setRevenusNetDecl1(final int newRevenusNetDecl1) {
        this.revenusNetDecl1 = newRevenusNetDecl1;
    }

    public void setRevenusNetDecl2(final int newRevenusNetDecl2) {
        this.revenusNetDecl2 = newRevenusNetDecl2;
    }

    public void setSituationFamiliale(final SituationFamiliale newSituationFamiliale) {
        this.situationFamiliale = newSituationFamiliale;
    }

    public void setNbEnfantsACharge(final int newNbEnfantsACharge) {
        this.nbEnfantsACharge = newNbEnfantsACharge;
    }

    public void setNbEnfantsSituationHandicap(final int newNbEnfantsSituationHandicap) {
        this.nbEnfantsSituationHandicap = newNbEnfantsSituationHandicap;
    }

    public void setParentIsole(final boolean newParentIsole) {
        this.parentIsole = newParentIsole;
    }

    // --- Méthode principale de calcul ---
    public void calculer() {
        calculImpot(revenusNetDecl1, revenusNetDecl2, situationFamiliale,
                nbEnfantsACharge, nbEnfantsSituationHandicap, parentIsole);
    }

    public void calculImpot(
            final int revenuDecl1,
            final int revenuDecl2,
            final SituationFamiliale situation,
            final int nbEnfants,
            final int nbEnfantsHandicapes,
            final boolean isParentIsole
    ) {
        if (revenuDecl1 < 0 || revenuDecl2 < 0) {
            throw new IllegalArgumentException("Revenu négatif interdit");
        }
        if (nbEnfants < 0) {
            throw new IllegalArgumentException("Nombre d'enfants négatif interdit");
        }
        if (nbEnfantsHandicapes < 0) {
            throw new IllegalArgumentException("Nombre d'enfants handicapés négatif interdit");
        }
        if (situation == null) {
            throw new IllegalArgumentException("Situation familiale null interdite");
        }
        if (nbEnfantsHandicapes > nbEnfants) {
            throw new IllegalArgumentException("Plus d'enfants handicapés que d'enfants au total");
        }
        if (nbEnfants > MAX_ENFANTS) {
            throw new IllegalArgumentException("Nombre d'enfants > 7 interdit");
        }
        if ((situation == SituationFamiliale.MARIE || situation == SituationFamiliale.PACSE)
                && isParentIsole) {
            throw new IllegalArgumentException("Parent isolé ne peut pas être marié ou pacsé");
        }
        if ((situation == SituationFamiliale.CELIBATAIRE
                || situation == SituationFamiliale.VEUF
                || situation == SituationFamiliale.DIVORCE)
                && revenuDecl2 > 0) {
            throw new IllegalArgumentException(
                    "Déclarant 2 ne peut pas avoir de revenu " +
                            "si le foyer est célibataire/divorcé/veuf");
        }

        nbParts = CalculateurParts.calculer(
                situation, nbEnfants, nbEnfantsHandicapes, isParentIsole);
        abattement = CalculateurAbattement.calculer(
                revenusNetDecl1, revenusNetDecl2, situationFamiliale);
        revenuReference = revenusNetDecl1 + revenusNetDecl2;
        double revenuImposable = revenuReference - abattement;

        impotAvantDecote = CalculateurImpotBrut.calculer(revenuImposable, nbParts);
        decote = CalculateurDecote.calculer(impotAvantDecote, situation);

        // Calcul final avec arrondi
        impotNet = Math.max(0, impotAvantDecote - decote);

        contributionExceptionnelle = CalculateurCEHR.calculer(
                revenuReference, nbParts, situationFamiliale);
    }


    // --- GETTERS pour les résultats ---
    public int getRevenusNetDecl1() {
        return revenusNetDecl1;
    }

    public int getRevenusNetDecl2() {
        return revenusNetDecl2;
    }

    public double getRevenuFiscalReference() {
        return revenuReference;
    }

    public double getNbParts() {
        return nbParts;
    }

    public double getAbattement() {
        return abattement;
    }

    public double getImpotAvantDecote() {
        return impotAvantDecote;
    }

    public double getDecote() {
        return decote;
    }

    public double getImpotNet() {
        return impotNet;
    }

    public double getContributionExceptionnelle() {
        return contributionExceptionnelle;
    }


}