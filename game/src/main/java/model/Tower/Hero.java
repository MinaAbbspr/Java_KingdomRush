package model.Tower;

import javafx.scene.layout.VBox;
import model.map.Coordinate;

import java.util.ArrayList;
import java.util.Random;

public class Hero {
    private int health;
    private final int finalHealth;
    private final int speed;
    private boolean raider;
    private final ArrayList<Coordinate> pathwayFractures;
    private final Random random;
    private VBox vBox;
    private final Barracks barracks;
    private Coordinate coordinate;
    private int DPS;

    public Hero(ArrayList<Coordinate> pathwayFractures, Barracks barracks) {
        this.pathwayFractures = pathwayFractures;
        this.barracks = barracks;
        this.random = new Random();
        this.raider = false;
        this.health = 100;
        this.speed = 200;
        this.DPS = 20;
        this.finalHealth = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isRaider() {
        return raider;
    }

    public void setRaider(boolean raider) {
        this.raider = raider;
    }

    public ArrayList<Coordinate> getPathwayFractures() {
        return pathwayFractures;
    }

    public Random getRandom() {
        return random;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public Barracks getBarracks() {
        return barracks;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getDPS() {
        return DPS;
    }

    public void setDPS(int DPS) {
        this.DPS = DPS;
    }

    public int getFinalHealth() {
        return finalHealth;
    }
}
