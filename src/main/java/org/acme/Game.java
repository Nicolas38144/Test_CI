import org.acme.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Map map;
    private Player player;
    private Simulator simulator;
    private List<Vehicle> availableCars;

    public Game() {
        // Créer la carte, le joueur et le simulateur
        map = new Map();
        player = new Player();
        simulator = new Simulator(map, player);

        // Initialiser les véhicules
        initializeVehicles();
    }

    private void initializeVehicles() {
        // Créer les trois véhicules
        Vehicle basicCar = new Vehicle(1, 0, 0, 50, 50, 50);
        basicCar.setPrice(10);
        Vehicle mediumCar = new Vehicle(2, 0, 0, 75, 75, 100);
        mediumCar.setPrice(20);
        Vehicle premiumCar = new Vehicle(3, 0, 0, 100, 100, 200);
        premiumCar.setPrice(30);

        // Ajouter la voiture de base au garage du joueur
        player.getGarage().add(basicCar);

        // Ajouter les deux autres voitures à la liste de voitures disponibles à l'achat
        availableCars = new ArrayList<>();
        availableCars.add(mediumCar);
        availableCars.add(premiumCar);
    }

    public List<Vehicle> getAvailableCars() {
        return availableCars;
    }

    public void start() {
        // Ajouter des stations-service à la carte
        GasStation gasStation1 = new GasStation(1, 50, 50, 50);
        GasStation gasStation2 = new GasStation(2, 150, 150, 50);
        map.addGasStation(gasStation1);
        map.addGasStation(gasStation2);

        // Ajouter un garage à la carte
        Garage garage = new Garage(1, 250, 250);
        map.addGarage(garage);

        // Ajouter des bâtiments à la carte
        Building building1 = new Building(1, 350, 350, 50, 50);
        Building building2 = new Building(2, 450, 450, 50, 50);
        map.addBuilding(building1);
        map.addBuilding(building2);

        // Ajouter des voitures de police à la carte
        PoliceVehicle policeCar1 = new PoliceVehicle(1, 100, 100, 100);
        PoliceVehicle policeCar2 = new PoliceVehicle(2, 200, 200, 100);
        map.addPoliceVehicle(policeCar1);
        map.addPoliceVehicle(policeCar2);

        // Appeler la méthode start du simulateur pour démarrer le jeu
        simulator.start();
    }
}
