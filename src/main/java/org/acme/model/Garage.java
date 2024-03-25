package org.acme.model;

import java.util.List;

import java.util.ArrayList;

public class Garage {
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;
    private List<Vehicle> vehicles;

    public Garage(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.vehicles = new ArrayList<>();
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public boolean buyVehicle(Player player, int vehicleID) {
        for (Vehicle vehicle : vehicles) {
            if (player.getVehicle().getId() == vehicleID) {
                if (player.getMoney() >= vehicle.getPrice()) {
                    player.buyVehicle(vehicle);
                    vehicles.remove(vehicle);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean contains(int x, int y) {
        return this.x == x && this.y == y;
    }
}

