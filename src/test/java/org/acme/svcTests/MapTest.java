package org.acme.svcTests;

import org.acme.model.*;
import org.acme.svc.impl.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void testGetBuildingAt() {
        Map map = new Map();
        Building building = new Building(1, 0, 0, 50, 50);
        map.addBuilding(building);
        assertEquals(building, map.getBuildingAt(25, 25));
        assertNull(map.getBuildingAt(100, 100));
    }
}
