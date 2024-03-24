package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Simulator;
import org.acme.model.Player;
import org.acme.PoliceVehicle;
import org.acme.Coin;

import java.util.List;
import javax.inject.Inject;

@ApplicationScoped
public class Game {
    private Player player;
    private Map map;
    private List<PoliceVehicle> policeVehicles;
    private List<Coin> coins;
    private boolean isRunning;
    private final Simulator simulator;
    private final PlayerService playerService;
    private final VehicleService vehicleService;
    private final CoinService coinService;

    @Inject
    public Game(Simulator simulator, PlayerService playerService, VehicleService vehicleService, CoinService coinService) {
        this.simulator = simulator;
        this.playerService = playerService;
        this.vehicleService = vehicleService;
        this.coinService = coinService;
    }

    public Game(Player player, Map map, Simulator simulator, PlayerService playerService, VehicleService vehicleService, CoinService coinService) {
        this.player = player;
        this.map = map;
        this.simulator = simulator;
        this.playerService = playerService;
        this.vehicleService = vehicleService;
        this.coinService = coinService;
        this.isRunning = true;
        this.policeVehicles = initializePoliceVehicles();
        this.coins = initializeCoins();
    }

    public Player getPlayer() {
        return player;
    }

    public Map getMap() {
        return map;
    }

    public List<PoliceVehicle> getPoliceVehicles() {
        return policeVehicles;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    private List<PoliceVehicle> initializePoliceVehicles() {
        // Initialiser la liste des véhicules de police et les placer sur la carte
    }

    private List<Coin> initializeCoins() {
        // Initialiser la liste des pièces et les placer sur la carte
    }

    // Autres méthodes pour gérer l'état du jeu (par exemple, mettre à jour l'état du joueur, vérifier les conditions de victoire/défaite, etc.)

    public void startGame(int difficulty, String playerName) {
        // Initialiser le jeu avec le niveau de difficulté et le nom du joueur
        // Créer une nouvelle instance de Game et la passer au simulateur
        // Démarrer le simulateur
    }

    public void stopGame() {
        // Arrêter le simulateur
    }

    public void movePlayer(String direction) {
        // Mettre à jour la position du joueur en fonction de la direction
        // Vérifier et gérer les collisions avec les bâtiments, les véhicules de police, les pièces, etc.
    }

    public void refuelAtGasStation() {
        // Recharger le carburant du véhicule du joueur à une station-service
        // Déduire le coût du carburant de l'argent du joueur
    }

    public void buyVehicleAtGarage(int vehicleId) {
        // Acheter un nouveau véhicule au garage
        // Déduire le coût du véhicule de l'argent du joueur
        // Ajouter le véhicule au garage du joueur
    }

    public void collectCoin(int coinId) {
        // Ramasser une pièce de monnaie dans le jeu
        // Ajouter la valeur de la pièce à l'argent du joueur
        // Supprimer la pièce du jeu
    }
}
