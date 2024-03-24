package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int largeurEntite;
    private int hauteurEntite;
    private List<int[]> buildingPositions = new ArrayList<>();
    private List<int[]> coinPositions = new ArrayList<>();
    private List<int[]> stationPositions = new ArrayList<>();
    private int[] garagePosition;

    public Map() {

        buildingPositions.add(new int[] { 400, 90 });
        buildingPositions.add(new int[] { 100, 100 });
        buildingPositions.add(new int[] { 450, 150 });
        buildingPositions.add(new int[] { 200, 190 });
        buildingPositions.add(new int[] { 200, 100 });
        buildingPositions.add(new int[] { 450, 250 });

        coinPositions.add(new int[] { 300, 120 });
        coinPositions.add(new int[] { 150, 200 });
        coinPositions.add(new int[] { 500, 220 });

        stationPositions.add(new int[] { 200, 250 });
        stationPositions.add(new int[] { 100, 200 });

        garagePosition = new int[] { 0, 0 }; // Définissez la position du garage ici
    }

    public List<int[]> getBuildingPositions() {
        return buildingPositions;
    }

    public List<int[]> getCoinPositions() {
        return coinPositions;
    }

    public List<int[]> getStationPositions() {
        return stationPositions;
    }

    public int[] getGaragePosition() {
        return garagePosition;
    }

    public Object getRandomPosition() {
        return new int[] { 0, 0 }; // Retourne une position aléatoire
    }
}