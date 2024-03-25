package org.acme;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;

import javax.inject.Inject;

@ApplicationScoped
public class Vehicle {
    private int id;
    private int x;
    private int y;
    private int height;
    private int width;

    private int price;
    private int fuel;
    private int fuelCapacity;

    public Vehicle(int id, int x, int y, int height, int width, int fuelCapacity) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.fuel = fuelCapacity;
        this.fuelCapacity = fuelCapacity;
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

    public int getFuel() {
        return fuel;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void move(int dx, int dy) {
        if (fuel > 0) {
            x += dx;
            y += dy;
            fuel -= Math.abs(dx) + Math.abs(dy);
        }
    }

    public void refuel() {
        fuel = fuelCapacity;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean collidesWith(PoliceVehicle policeVehicle) {

        int policeX = policeVehicle.getX();
        int policeY = policeVehicle.getY();
        int policeWidth = policeVehicle.getWidth();
        int policeHeight = policeVehicle.getHeight();

        return (x < policeX + policeWidth && x + width > policeX && y < policeY + policeHeight && y + height > policeY);
    }
}

