package org.acme.svcTests;


import org.acme.model.*;
import org.acme.svc.impl.Game;
import org.acme.svc.impl.Map;
import org.acme.svc.impl.Simulator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testGame() {
        Game game = new Game();
        assertNotNull(game);
    }

    @Test
    void testGetInstance() {
        Game game = Game.getInstance();
        assertNotNull(game);
    }

    @Test
    void testGetAvailableCars() {
        Game game = new Game();
        List<Vehicle> availableCars = game.getAvailableCars();
        assertNotNull(availableCars);
        assertEquals(2, availableCars.size());
    }

    @Test
    void testToJSON() {
        Game game = new Game();
        String json = game.toJSON();
        assertNotNull(json);
    }
}
