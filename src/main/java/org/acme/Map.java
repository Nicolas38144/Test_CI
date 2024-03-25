package org.acme;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Building> buildings;
    private List<GasStation> gasStations;
    private List<Garage> garages;
    private List<Coin> coins;
    private List<PoliceVehicle> policeVehicles;

    public Map() {
        buildings = new ArrayList<>();
        gasStations = new ArrayList<>();
        garages = new ArrayList<>();
        coins = new ArrayList<>();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public void addGasStation(GasStation gasStation) {
        gasStations.add(gasStation);
    }

    public void addGarage(Garage garage) {
        garages.add(garage);
    }

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    //TO DO: Add a method to init the coins on the map
    public void initCoins() {
        addCoin(new Coin(1, 50, 50, 10));
        addCoin(new Coin(2, 150, 150, 10));
        addCoin(new Coin(3, 250, 250, 10));
        addCoin(new Coin(4, 350, 350, 10));
        addCoin(new Coin(5, 450, 450, 10));
    }



    public Building getBuildingAt(int x, int y) {
        for (Building building : buildings) {
            if (building.contains(x, y)) {
                return building;
            }
        }
        return null;
    }

    public GasStation getGasStationAt(int x, int y) {
        for (GasStation gasStation : gasStations) {
            if (gasStation.contains(x, y)) {
                return gasStation;
            }
        }
        return null;
    }

    public Garage getGarageAt(int x, int y) {
        for (Garage garage : garages) {
            if (garage.contains(x, y)) {
                return garage;
            }
        }
        return null;
    }

    public Coin getCoinAt(int x, int y) {
        for (Coin coin : coins) {
            if (coin.contains(x, y)) {
                return coin;
            }
        }
        return null;
    }

    public void addPoliceVehicle(PoliceVehicle policeVehicle) {
        policeVehicles.add(policeVehicle);
    }

    public void removeCoin(Coin coin) {
        coins.remove(coin);
    }
}
