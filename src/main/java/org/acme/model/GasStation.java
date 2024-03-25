package org.acme.model;

public class GasStation {
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;
    private int fuelPrice;

    public GasStation(int id, int x, int y, int fuelPrice) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.fuelPrice = fuelPrice;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getFuelPrice() {
        return fuelPrice;
    }

    public void refuel(Player player, Vehicle vehicle) {
        double fuelCost = vehicle.getFuelCapacity() * fuelPrice;
        if (player.getMoney() >= fuelCost) {
            player.spendMoney((int) fuelCost);
            vehicle.refuel();
        }
    }

    public boolean contains(int x, int y) {
        return (x >= this.x && x < this.x + 2 && y >= this.y && y < this.y + 2);
    }
}

