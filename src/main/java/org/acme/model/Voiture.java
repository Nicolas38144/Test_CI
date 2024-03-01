package org.acme.model;

public class Voiture {

    private int niveauEssence;

    public Voiture(int niveauEssence) {
        this.niveauEssence = niveauEssence;
    }

    public int getNiveauEssence() {
        return niveauEssence;
    }

    public void setNiveauEssence(int niveauEssence) {
        if (niveauEssence > 60) { this.niveauEssence = 60; }
        else if (niveauEssence < 0) { this.niveauEssence = 0; }
        else { this.niveauEssence = niveauEssence; }
    }
}
