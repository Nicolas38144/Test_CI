package org.acme;

import org.junit.jupiter.api.Test;

class GameGameServiceTest {

    @Test
    void run() throws Exception {
        GameService gameService = new GameService();
        assertEquals(0, gameService.run());
    }

    @Test
    void title() {
        GameService gameService = new GameService();
        assertEquals("#####carmageddo", gameService.title());
    }
}