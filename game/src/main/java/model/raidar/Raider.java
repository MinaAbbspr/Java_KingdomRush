package model.raidar;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.map.Coordinate;

import java.util.ArrayList;
import java.util.Random;

public abstract class Raider {
    private int health;
    private final int finalHealth;
    private final int speed;
    private final int loot;
    private boolean hero;
    private final ArrayList<Coordinate> pathwayFractures;
    private final Random random;
    private final VBox vBox;
    private Coordinate coordinate;
    private final int DPS;
    private int nextIndex;
    private final ImageView imageView;
    private boolean freeze;

    public Raider(int health, int speed, int loot, int DPS, ArrayList<Coordinate> pathwayFractures, VBox vBox, Coordinate coordinate) {
        this.health = health;
        this.finalHealth = health;
        this.speed = speed;
        this.loot = loot;
        this.DPS = DPS;
        this.pathwayFractures = pathwayFractures;
        this.vBox = vBox;
        this.hero = false;
        this.freeze = false;
        this.random = new Random();
        this.coordinate = coordinate;
        this.nextIndex = 1;
        this.imageView = (ImageView) vBox.getChildren().getLast();
    }

    public VBox getvBox() {
        return vBox;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setHero(boolean hero) {
        this.hero = hero;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFinalHealth() {
        return finalHealth;
    }

    public int getDPS() {
        return DPS;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLoot() {
        return loot;
    }

    public boolean isHero() {
        return hero;
    }

    public ArrayList<Coordinate> getPathwayFractures() {
        return pathwayFractures;
    }

    public Random getRandom() {
        return random;
    }

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex() {
        this.nextIndex++ ;
    }
    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public boolean isFreeze() {
        return freeze;
    }

    public void setFreeze(boolean freeze) {
        this.freeze = freeze;
    }
}
