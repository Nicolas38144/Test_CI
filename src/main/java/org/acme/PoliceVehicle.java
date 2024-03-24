package org.acme;

import java.util.Random;

public class PoliceVehicle {
    private int id;
    private int x;
    private int y;
    private int speed;
    private Random random;

    public PoliceVehicle(int id, int x, int y, int speed) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.random = new Random();
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void move() {
        // Déplacer le véhicule de police aléatoirement dans une direction
        int dx = random.nextInt(3) - 1; // Générer un déplacement horizontal entre -1 et 1
        int dy = random.nextInt(3) - 1; // Générer un déplacement vertical entre -1 et 1

        // Normaliser le vecteur de déplacement (assurer que la vitesse maximale est respectée)
        if (dx != 0 && dy != 0) {
            dx /= Math.sqrt(2);
            dy /= Math.sqrt(2);
        }

        // Appliquer le déplacement
        x += dx * speed;
        y += dy * speed;

        // Vérifier et gérer les collisions avec les bords de la carte et les autres objets du jeu
    }
}
