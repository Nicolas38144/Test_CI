package org.acme.modelTests;

import org.acme.model.PoliceVehicle;
import org.junit.jupiter.api.Test;

import org.acme.model.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testVehicle() {
        Vehicle vehicle = new Vehicle(1, 0, 0, 10, 10, 100);
        assertEquals(1, vehicle.getId());
        assertEquals(0, vehicle.getX());
        assertEquals(0, vehicle.getY());
        assertEquals(10, vehicle.getHeight());
        assertEquals(10, vehicle.getWidth());
        assertEquals(100, vehicle.getFuelCapacity());
        assertEquals(100, vehicle.getFuel());
        vehicle.setFuel(50);
        assertEquals(50, vehicle.getFuel());
        vehicle.refuel();
        assertEquals(100, vehicle.getFuel());
        assertEquals("Vehicle{id=1, x=0, y=0, height=10, width=10, price=0, fuel=100, fuelCapacity=100}", vehicle.toString());
    }

    @Test
    void testCollidesWith() {
        Vehicle vehicle = new Vehicle(1, 0, 0, 10, 10, 100);
        PoliceVehicle policeVehicle = new PoliceVehicle(1, 0, 0, 10);
        assertTrue(vehicle.collidesWith(policeVehicle));
        policeVehicle = new PoliceVehicle(1, 20, 20, 10);
        assertFalse(vehicle.collidesWith(policeVehicle));
    }

    @Test
    void testSettersAndGetters() {
        Vehicle vehicle = new Vehicle(1, 0, 0, 10, 10, 100);
        vehicle.setId(2);
        vehicle.setX(10);
        vehicle.setY(10);
        vehicle.setHeight(20);
        vehicle.setWidth(20);
        vehicle.setPrice(10);
        vehicle.setFuel(50);
        vehicle.setFuelCapacity(200);
        assertEquals(2, vehicle.getId());
        assertEquals(10, vehicle.getX());
        assertEquals(10, vehicle.getY());
        assertEquals(20, vehicle.getHeight());
        assertEquals(20, vehicle.getWidth());
        assertEquals(10, vehicle.getPrice());
        assertEquals(50, vehicle.getFuel());
        assertEquals(200, vehicle.getFuelCapacity());
    }
}
