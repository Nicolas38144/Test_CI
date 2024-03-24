package org.acme;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;

import javax.inject.Inject;

@ApplicationScoped
public class Vehicle {
    private final Game game;

    private int id;
    private String brand;
    private String model;
    private int fuelTankCapacity;
    private int resistance;
    private int currentFuel;
    private int money;

    @Inject
    public Vehicle(Game game) {
        this.game = game;
    }

    public Vehicle(Game game, int id, String brand, String model, int fuelTankCapacity, int resistance, int currentFuel, int money) {
        this.game = game;
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.fuelTankCapacity = fuelTankCapacity;
        this.resistance = resistance;
        this.currentFuel = currentFuel;
        this.money = money;
    }

    public List<Vehicle> getVehicles() {
        return game.getPlayer().getGarage();
    }

    public Vehicle getVehicleById(int vehicleId) {
        return game.getPlayer().getGarage().stream().filter(vehicle -> vehicle.getId() == vehicleId).findFirst().orElse(null);
    }

    public void buyVehicle(int vehicleId) {
        Vehicle vehicleToBuy = getVehicleById(vehicleId);

        if (vehicleToBuy != null && game.getPlayer().getMoney() >= vehicleToBuy.getPrice()) {
            game.getPlayer().setMoney(game.getPlayer().getMoney() - vehicleToBuy.getPrice());
            game.getPlayer().getGarage().add(vehicleToBuy);
        }
    }

    public void setCurrentVehicle(int vehicleId) {
        Vehicle currentVehicle = getVehicleById(vehicleId);

        if (currentVehicle != null) {
            game.getPlayer().setCurrentVehicle(currentVehicle);
        }
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public String setBrand(String brand) {
        this.brand = brand;
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String setModel(String model) {
        this.model = model;
        return model;
    }

    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public int setFuelTankCapacity(int fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
        return fuelTankCapacity;
    }

    public int getResistance() {
        return resistance;
    }

    public int setResistance(int resistance) {
        this.resistance = resistance;
        return resistance;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public int setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
        return currentFuel;
    }

    public int getMoney() {
        return money;
    }

    public int setMoney(int money) {
        this.money = money;
        return money;
    }

    public int getPrice() {
        return money;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fuelTankCapacity=" + fuelTankCapacity +
                ", resistance=" + resistance +
                ", currentFuel=" + currentFuel +
                ", money=" + money +
                '}';
    }
}
