package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private Map map;
    private Player player;
    private boolean running;
    private List<PoliceVehicle> policeVehicles;

    public Simulator(Map map, Player player) {
        this.map = map;
        this.player = player;
        this.running = false;
        this.policeVehicles = new ArrayList<>();
    }

    public void start() {
        running = true;
        gameLoop();
    }

    public void stop() {
        running = false;
    }

    private void gameLoop() {
        while (running) {
            update();
            try {
                Thread.sleep(100); // Attendre 100 millisecondes entre chaque mise à jour
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        // Mettre à jour la position du véhicule du joueur en fonction des requêtes API
        player.updatePosition();

        // Mettre à jour la position des véhicules de police en fonction de leur comportement aléatoire
        for (PoliceVehicle policeVehicle : policeVehicles) {
            policeVehicle.updatePosition();
        }

        // Vérifier les collisions entre le véhicule du joueur et les bâtiments, les pièces, les véhicules de police, etc.
        checkCollisions();

        // Si le joueur n'a plus de carburant, arrêter le jeu
        if (player.getVehicle().getFuel() == 0) {
            stop();
        }
    }

    private void checkCollisions() {
        checkBuildingCollision();
        checkGasStationCollision();
        checkGarageCollision();
        checkCoinCollision();
        checkPoliceVehicleCollision();
    }

    private void checkBuildingCollision() {
        Building building = map.getBuildingAt(player.getVehicle().getX(), player.getVehicle().getY());
        if (building != null) {
            stop();
        }
    }

    private void checkGasStationCollision() {
        GasStation gasStation = map.getGasStationAt(player.getVehicle().getX(), player.getVehicle().getY());
        if (gasStation != null && canRefuel(gasStation)) {
            refuel(gasStation);
        }
    }

    private boolean canRefuel(GasStation gasStation) {
        return player.getMoney() >= gasStation.getFuelPrice() && player.getVehicle().getFuel() < player.getVehicle().getFuelCapacity();
    }

    private void refuel(GasStation gasStation) {
        player.spendMoney(gasStation.getFuelPrice());
        player.getVehicle().refuel();
    }

    private void checkGarageCollision() {
        Garage garage = map.getGarageAt(player.getVehicle().getX(), player.getVehicle().getY());
        if (garage != null) {
            buyAvailableVehicles(garage);
        }
    }

    private void buyAvailableVehicles(Garage garage) {
        for (Vehicle vehicle : garage.getVehicles()) {
            if (canBuyVehicle(vehicle)) {
                player.buyVehicle(vehicle);
            }
        }
    }

    private boolean canBuyVehicle(Vehicle vehicle) {
        return !player.getGarage().contains(vehicle) && player.getMoney() >= vehicle.getPrice();
    }

    private void checkCoinCollision() {
        Coin coin = map.getCoinAt(player.getVehicle().getX(), player.getVehicle().getY());
        if (coin != null) {
            collectCoin(coin);
        }
    }

    private void collectCoin(Coin coin) {
        player.addMoney(coin.getValue());
        map.removeCoin(coin);
    }

    private void checkPoliceVehicleCollision() {
        for (PoliceVehicle policeVehicle : policeVehicles) {
            if (player.getVehicle().collidesWith(policeVehicle)) {
                stop();
            }
        }
    }
}