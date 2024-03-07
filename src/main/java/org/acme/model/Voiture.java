public class Voiture {

    private static final int MIN_ESSENCE = 0;

    private int niveauEssence;
    private String marque;
    private String modele;
    private int volumeReservoir;
    private int vitesseMax;
    private int resistance;

    public Voiture(int niveauEssence, String marque, String modele, int volumeReservoir, int vitesseMax, int resistance) {
        setNiveauEssence(niveauEssence);
        setMarque(marque);
        setModele(modele);
        setVolumeReservoir(volumeReservoir);
        setVitesseMax(vitesseMax);
        setResistance(resistance);
    }

    public int getNiveauEssence() {
        return niveauEssence;
    }

    public void setNiveauEssence(int niveauEssence) {
        this.niveauEssence = Math.max(MIN_ESSENCE, Math.min(getVolumeReservoir(), niveauEssence));
    }

    public int getVolumeReservoir() {
        return volumeReservoir;
    }

    public void setVolumeReservoir(int volumeReservoir) {
        this.volumeReservoir = Math.max(0, volumeReservoir);
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

}