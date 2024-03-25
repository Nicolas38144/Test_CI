package org.acme.modelTests;

import org.acme.model.Garage;
import org.acme.model.Player;
import org.acme.model.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {

    @Test
    void testGetID() {
        Garage garage = new Garage(1, 2, 3);
        assertEquals(1, garage.getID());
    }

    @Test
    void testGetX() {
        Garage garage = new Garage(1, 2, 3);
        assertEquals(2, garage.getX());
    }

    @Test
    void testGetY() {
        Garage garage = new Garage(1, 2, 3);
        assertEquals(3, garage.getY());
    }

    @Test
    void testGetWidth() {
        Garage garage = new Garage(1, 2, 3);
        garage.setWidth(4);
        assertEquals(4, garage.getWidth());
    }

    @Test
    void testGetHeight() {
        Garage garage = new Garage(1, 2, 3);
        garage.setHeight(5);
        assertEquals(5, garage.getHeight());
    }

    @Test
    void testGetVehicles() {
        Garage garage = new Garage(1, 2, 3);
        Vehicle vehicle = new Vehicle(1, 0, 0, 10, 10, 100);
        garage.addVehicle(vehicle);
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        assertEquals(vehicles, garage.getVehicles());
    }

    @Test
    void testAddVehicle() {
        Garage garage = new Garage(1, 2, 3);
        Vehicle vehicle = new Vehicle(1, 0, 0, 10, 10, 100);
        garage.addVehicle(vehicle);
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        assertEquals(vehicles, garage.getVehicles());
    }

    @Test
    void testBuyVehicleNotEnoughMoney() {
        Garage garage = new Garage(1, 2, 3);
        Vehicle vehicle = new Vehicle(1, 0, 0, 10, 10, 100);
        Player player = new Player();
        player.addMoney(50);
        garage.addVehicle(vehicle);
        assertFalse(player.getGarage().contains(vehicle));
        assertEquals(50, player.getMoney());
        assertEquals(1, garage.getVehicles().size());
    }

    @Test
    void testBuyVehicleNotInGarage() {
        Garage garage = new Garage(1, 2, 3);
        Vehicle vehicle = new Vehicle(1, 0, 0, 10, 10, 100);
        Player player = new Player();
        player.addMoney(100);
        garage.addVehicle(vehicle);
        assertFalse(player.getGarage().contains(vehicle));
        assertEquals(100, player.getMoney());
        assertEquals(1, garage.getVehicles().size());
    }

    @Test
    void testContains() {
        Garage garage = new Garage(1, 2, 3);
        assertTrue(garage.contains(2, 3));
        assertFalse(garage.contains(3, 2));
    }
}
