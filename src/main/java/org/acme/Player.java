package org.acme.model;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Game;
import org.acme.Vehicle;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class Player {
    private final Game game;

    private int id;
    private String name;
    private int money;
    private List<Vehicle> garage;
    private Vehicle currentVehicle;

    public Player(Game game, int id, String name, int money, List<Vehicle> garage, Vehicle currentVehicle) {
        this.game = game;
        this.id = id;
        this.name = name;
        this.money = money;
        this.garage = garage;
        this.currentVehicle = currentVehicle;
    }

    public Player(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return game.getPlayer();
    }

    public void updateMoney(int amount) {
        // Mettre à jour l'argent du joueur en ajoutant ou en soustrayant le montant spécifié
        this.money += amount;
    }

    public void updateFuel(int amount) {
        // Mettre à jour le carburant du véhicule du joueur en ajoutant ou en soustrayant le montant spécifié
        this.currentVehicle.setCurrentFuel(this.currentVehicle.getCurrentFuel() + amount);
    }

    public void updateLives(int amount) {
        // Mettre à jour les vies du joueur en ajoutant ou en soustrayant le montant spécifié
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int setMoney(int money) {
        this.money = money;
        return money;
    }

    public List<Vehicle> getGarage() {
        return garage;
    }

    public List<Vehicle> setGarage(List<Vehicle> garage) {
        this.garage = garage;
        return garage;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public Vehicle setCurrentVehicle(Vehicle currentVehicle) {
        this.currentVehicle = currentVehicle;
        return currentVehicle;
    }

    public void addVehicle(Vehicle vehicle) {
        this.garage.add(vehicle);
    }
}
