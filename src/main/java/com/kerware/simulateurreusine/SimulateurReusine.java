package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class SimulateurReusine {

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

    // --- SETTERS pour les données d'entrée ---
    public void setRevenusNetDecl1(int revenusNetDecl1) {
        this.revenusNetDecl1 = revenusNetDecl1;
    }

    public void setRevenusNetDecl2(int revenusNetDecl2) {
        this.revenusNetDecl2 = revenusNetDecl2;
    }

    public void setSituationFamiliale(SituationFamiliale situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public void setNbEnfantsACharge(int nbEnfantsACharge) {
        this.nbEnfantsACharge = nbEnfantsACharge;
    }

    public void setNbEnfantsSituationHandicap(int nbEnfantsSituationHandicap) {
        this.nbEnfantsSituationHandicap = nbEnfantsSituationHandicap;
    }

    public void setParentIsole(boolean parentIsole) {
        this.parentIsole = parentIsole;
    }

    // --- Méthode principale de calcul ---
    public void calculer() {
        calculImpot(revenusNetDecl1, revenusNetDecl2, situationFamiliale,
                nbEnfantsACharge, nbEnfantsSituationHandicap, parentIsole);
    }

    // --- Méthode de calcul déjà existante ---
    public void calculImpot(
            int revenu1, int revenu2,
            SituationFamiliale situation,
            int nbEnfants, int nbEnfantsHandicapes,
            boolean parentIsole
    ) {
        revenuReference = revenu1 + revenu2;

        nbParts = CalculateurParts.calculer(situation, nbEnfants, nbEnfantsHandicapes, parentIsole);
        abattement = CalculateurAbattement.calculer(revenuReference, nbParts);
        double revenuImposable = revenuReference - abattement;

        impotAvantDecote = CalculateurImpotBrut.calculer(revenuImposable, nbParts);
        decote = CalculateurDecote.calculer(impotAvantDecote, situation);
        impotNet = Math.max(0, impotAvantDecote - decote);

        contributionExceptionnelle = impotNet > ConstantesFiscales2025.SEVUIL_CONTRIBUTION ?
                impotNet * ConstantesFiscales2025.TAUX_CONTRIBUTION_EXCEPTIONNELLE : 0;
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
