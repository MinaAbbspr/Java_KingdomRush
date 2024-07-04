package model.raidar;

import model.map.Coordinate;

import java.util.ArrayList;

public abstract class Raider {
    private int health;
    private int speed;
    private int loot;
    private ArrayList<Coordinate> pathwayFractures;

    public Raider(int health, int speed, int loot) {
        this.health = health;
        this.speed = speed;
        this.loot = loot;
    }

    public void walk(){}
}
