package org.acme.model;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Player {
    private int id;
    private Vehicle vehicle;
    private int money;
    private List<Vehicle> garage;

    public Player(int id, Vehicle vehicle, int money) {
        this.id = id;
        this.vehicle = vehicle;
        this.money = money;
        this.garage = new ArrayList<>();
    }

    public Player() {
        this.garage = new ArrayList<>();
    }

    public int getID() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public void spendMoney(int amount) {
        this.money -= amount;
    }

    public List<Vehicle> getGarage() {
        return garage;
    }

    public void addVehicleToGarage(Vehicle vehicle) {
        garage.add(vehicle);
    }

    public void removeVehicleFromGarage(Vehicle vehicle) {
        garage.remove(vehicle);
    }

    public void buyVehicle(Vehicle vehicle) {
        if (money >= vehicle.getPrice()) {
            money -= vehicle.getPrice();
            garage.add(vehicle);
        }
    }

    public void moveVehicle() {

    }

    public void updatePosition() {
    }
}
