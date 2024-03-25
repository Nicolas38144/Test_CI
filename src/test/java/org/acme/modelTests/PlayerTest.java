package org.acme.modelTests;

import org.acme.model.Player;
import org.acme.model.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayer() {
        Vehicle vehicle = new Vehicle(1, 0, 0, 10, 10, 100);
        Player player = new Player(1, vehicle, 100);
        assertEquals(1, player.getID());
        assertEquals(vehicle, player.getVehicle());
        assertEquals(100, player.getMoney());
        assertEquals(new ArrayList<Vehicle>(), player.getGarage());
    }

    @Test
    void testSettersAndGetters() {
        Vehicle vehicle = new Vehicle(1, 0, 0, 10, 10, 100);
        Player player = new Player(1, vehicle, 100);
        player.setVehicle(new Vehicle(2, 10, 10, 20, 20, 200));
        assertEquals(2, player.getVehicle().getId());
        assertEquals(10, player.getVehicle().getX());
        assertEquals(10, player.getVehicle().getY());
        assertEquals(20, player.getVehicle().getHeight());
        assertEquals(20, player.getVehicle().getWidth());
        assertEquals(200, player.getVehicle().getFuelCapacity());
        assertEquals(200, player.getVehicle().getFuel());
        player.addMoney(50);
        assertEquals(150, player.getMoney());
        player.spendMoney(50);
        assertEquals(100, player.getMoney());
        player.addVehicleToGarage(new Vehicle(3, 20, 20, 30, 30, 300));
        assertEquals(1, player.getGarage().size());
        player.removeVehicleFromGarage(player.getGarage().get(0));
        assertEquals(0, player.getGarage().size());
        player.addMoney(1000);
        player.buyVehicle(new Vehicle(5, 30, 30, 40, 40, 400));
        assertEquals(1, player.getGarage().size());
    }

    @Test
    void testMoveVehicle() {
        Vehicle vehicle = new Vehicle(1, 0, 0, 10, 10, 100);
        Player player = new Player(1, vehicle, 100);
        player.moveVehicle();
        assertEquals(0, player.getVehicle().getX());
        assertEquals(0, player.getVehicle().getY());
    }
}
