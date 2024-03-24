package org.acme;

import org.acme.Vehicle;

import java.util.List;

public class Garage {
    private int id;
    private int xCoordinate;
    private int yCoordinate;

    private List<Vehicle> availableVehicles;

    // Constructors, getters and setters

    public Garage(int id, int xCoordinate, int yCoordinate, List<Vehicle> availableVehicles) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.availableVehicles = availableVehicles;
    }

    public Garage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public List<Vehicle> getAvailableVehicles() {
        return availableVehicles;
    }

    public void setAvailableVehicles(List<Vehicle> availableVehicles) {
        this.availableVehicles = availableVehicles;
    }
}
