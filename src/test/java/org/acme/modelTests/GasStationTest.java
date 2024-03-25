package org.acme.modelTests;

import org.acme.model.GasStation;
import org.acme.model.Player;
import org.acme.model.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GasStationTest {

    @Test
    void testGasStation() {
        GasStation gasStation = new GasStation(1, 50, 50, 50);
        assertEquals(1, gasStation.getID());
        assertEquals(50, gasStation.getX());
        assertEquals(50, gasStation.getY());
        assertEquals(0, gasStation.getWidth());
        assertEquals(0, gasStation.getHeight());
        assertEquals(50, gasStation.getFuelPrice());
    }

    @Test
    void testSetWidth() {
        GasStation gasStation = new GasStation(1, 50, 50, 50);
        gasStation.setWidth(100);
        assertEquals(100, gasStation.getWidth());
    }

    @Test
    void testSetHeight() {
        GasStation gasStation = new GasStation(1, 50, 50, 50);
        gasStation.setHeight(100);
        assertEquals(100, gasStation.getHeight());
    }

    @Test
    void testContains() {
        GasStation gasStation = new GasStation(1, 50, 50, 50);
        assertTrue(gasStation.contains(50, 50));
        assertTrue(gasStation.contains(51, 51));
        assertFalse(gasStation.contains(49, 49));
        assertFalse(gasStation.contains(52, 52));
    }

}
