package org.acme;

public class Vehicle {
    private int id;
    private int x;
    private int y;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", height=" + height +
                ", width=" + width +
                ", price=" + price +
                ", fuel=" + fuel +
                ", fuelCapacity=" + fuelCapacity +
                '}';
    }

    public void refuel() {
        fuel = fuelCapacity;
    }

    public boolean collidesWith(PoliceVehicle policeVehicle) {
        return (x < policeVehicle.getX() + policeVehicle.getWidth() &&
                x + width > policeVehicle.getX() &&
                y < policeVehicle.getY() + policeVehicle.getHeight() &&
                y + height > policeVehicle.getY());
    }
}
