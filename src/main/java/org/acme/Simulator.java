package org.acme;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Instance;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private Map map;
    private Player player;
    private boolean running;
    private List<PoliceVehicle> policeVehicles;

    public Simulator(Map map, Player player, Instance<PoliceVehicle> policeVehicles) {
        this.map = map;
        this.player = player;
        this.running = false;
        this.policeVehicles = new ArrayList<>();
        policeVehicles.forEach(this::addPoliceVehicle);
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

        // Mettre à jour l'interface utilisateur pour refléter l'état actuel du jeu
        // ...
    }

    private void checkCollisions() {
        // Vérifier les collisions avec les bâtiments
        Building building = map.getBuildingAt(player.getVehicle().getX(), player.getVehicle().getY());
        if (building != null) {
            // Gérer la collision avec le bâtiment
        }

        // Vérifier les collisions avec les stations-service
        GasStation gasStation = map.getGasStationAt(player.getVehicle().getX(), player.getVehicle().getY());
        if (gasStation != null) {
            // Gérer la collision avec la station-service
        }

        // Vérifier les collisions avec les garages
        Garage garage = map.getGarageAt(player.getVehicle().getX(), player.getVehicle().getY());
        if (garage != null) {
            // Gérer la collision avec le garage
        }

        // Vérifier les collisions avec les pièces
        Coin coin = map.getCoinAt(player.getVehicle().getX(), player.getVehicle().getY());
        if (coin != null) {
            // Gérer la collision avec la pièce
        }

        // Vérifier les collisions avec les véhicules de police
        for (PoliceVehicle policeVehicle : policeVehicles) {
            if (player.getVehicle().collidesWith(policeVehicle)) {
                // Gérer la collision avec le véhicule de police
            }
        }
    }
}