package com.kerware.simulateurreusine;

import com.kerware.simulateur.ICalculateurImpot;
import com.kerware.simulateur.SituationFamiliale;

public class AdaptateurSimulateurReusine implements ICalculateurImpot {

    private final SimulateurReusine simulateur = new SimulateurReusine();

    @Override
    public void setRevenusNetDeclarant1(int rn) {
        simulateur.setRevenusNetDecl1(rn);
    }

    @Override
    public void setRevenusNetDeclarant2(int rn) {
        simulateur.setRevenusNetDecl2(rn);
    }

    @Override
    public void setSituationFamiliale(SituationFamiliale sf) {
        simulateur.setSituationFamiliale(sf);
    }

    @Override
    public void setNbEnfantsACharge(int nbe) {
        simulateur.setNbEnfantsACharge(nbe);
    }

    @Override
    public void setNbEnfantsSituationHandicap(int nbesh) {
        simulateur.setNbEnfantsSituationHandicap(nbesh);
    }

    @Override
    public void setParentIsole(boolean pi) {
        simulateur.setParentIsole(pi);
    }

    @Override
    public void calculImpotSurRevenuNet() {
        simulateur.calculer();
    }

    @Override
    public int getRevenuNetDeclatant1() {
        return simulateur.getRevenusNetDecl1();
    }

    @Override
    public int getRevenuNetDeclatant2() {
        return simulateur.getRevenusNetDecl2();
    }

    @Override
    public double getContribExceptionnelle() {
        return simulateur.getContributionExceptionnelle();
    }

    @Override
    public int getRevenuFiscalReference() {
        return (int) simulateur.getRevenuFiscalReference();
    }

    @Override
    public int getAbattement() {
        return (int) simulateur.getAbattement();
    }

    @Override
    public double getNbPartsFoyerFiscal() {
        return simulateur.getNbParts();
    }

    @Override
    public int getImpotAvantDecote() {
        return (int) simulateur.getImpotAvantDecote();
    }

    @Override
    public int getDecote() {
        return (int) simulateur.getDecote();
    }

    @Override
    public int getImpotSurRevenuNet() {
        return (int) Math.round(simulateur.getImpotNet() + simulateur.getContributionExceptionnelle());

    }
}
