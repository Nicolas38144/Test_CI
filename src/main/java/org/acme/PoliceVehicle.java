package org.acme;

import java.util.Random;

import java.util.Random;

public class PoliceVehicle {

    static final int WIDTH = 5;
    static final int HEIGHT = 5;
    private int id;
    private int x;
    private int y;
    private int speed;
    private Random random;

    public PoliceVehicle(int id, int x, int y, int speed) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.random = new Random();
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

    public int getSpeed() {
        return speed;
    }

    public void move() {
        int dx = random.nextInt(speed * 2 + 1) - speed;
        int dy = random.nextInt(speed * 2 + 1) - speed;
        x += dx;
        y += dy;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void updatePosition() {
        move();
    }
}

