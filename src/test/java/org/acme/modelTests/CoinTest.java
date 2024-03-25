package org.acme.modelTests;

import org.acme.model.Coin;
import org.acme.model.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

    @Test
    void testCoin() {
        Coin coin = new Coin(1, 50, 50, 50);
        assertEquals(1, coin.getID());
        assertEquals(50, coin.getX());
        assertEquals(50, coin.getY());
        assertEquals(50, coin.getValue());
        assertFalse(coin.isCollected());
    }

    @Test
    void testCollect() {
        Coin coin = new Coin(1, 50, 50, 50);
        Player player = new Player();
        coin.collect(player);
        assertTrue(coin.isCollected());
        assertEquals(50, player.getMoney());
    }

    @Test
    void testContains() {
        Coin coin = new Coin(1, 50, 50, 50);
        assertTrue(coin.contains(50, 50));
        assertTrue(coin.contains(51, 51));
        assertFalse(coin.contains(49, 49));
        assertFalse(coin.contains(52, 52));
    }
}
