package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import jakarta.inject.Inject;

@ApplicationScoped
public class Coin {
    private int id;
    private int x;
    private int y;
    private int value;
    private boolean collected;

    public Coin(int id, int x, int y, int value) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.value = value;
        this.collected = false;
    }

    public int getID() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public boolean isCollected() {
        return collected;
    }

    public void collect(Player player) {
        if (!collected) {
            collected = true;
            player.addMoney(value);
        }
    }

    public boolean contains(int x, int y) {
        return (x >= this.x && x < this.x + 2 && y >= this.y && y < this.y + 2);
    }
}


