package org.acme;

public class Building {
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;

    public Building(int id, int x, int y, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getID() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isColliding(Player player) {
        // Vérifie si le joueur est en collision avec le bâtiment
        // Vous devrez remplacer cette logique par votre propre implémentation
        // en fonction de la façon dont vous représentez la position et la taille du joueur et du bâtiment
        int playerX = player.getVehicle().getX();
        int playerY = player.getVehicle().getY();
        int playerWidth = player.getVehicle().getWidth();
        int playerHeight = player.getVehicle().getHeight();

        return (x < playerX + playerWidth && x + width > playerX && y < playerY + playerHeight && y + height > playerY);
    }

    public boolean contains(int x, int y) {
        return (x >= this.x && x < this.x + width && y >= this.y && y < this.y + height);
    }
}

