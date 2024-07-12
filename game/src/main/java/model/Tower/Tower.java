package model.Tower;

import controller.raider.RaiderController;
import model.map.Coordinate;

import java.util.ArrayList;

public abstract class Tower {
    private double DPS;
    private int cost;
    private double radius;
    private int level;
    private final int updateCost;
    private ArrayList<RaiderController> raiders;
    private Coordinate coordinate;

    public Tower(double DPS, int cost, double radius, int level, int updateCost, Coordinate coordinate) {
        this.DPS = DPS;
        this.cost = cost;
        this.radius = radius;
        this.level = level;
        this.updateCost = updateCost;
        this.coordinate = coordinate;
    }

    public double getDPS() {
        return DPS;
    }

    public double getCost() {
        return cost;
    }

    public double getRadius() {
        return radius;
    }

    public int getLevel() {
        return level;
    }

    public int getUpdateCost() {
        return updateCost * (level + 1) + cost;
    }

    public ArrayList<RaiderController> getRaiders() {
        return raiders;
    }

    public void setRaiders(ArrayList<RaiderController> raiders) {
        this.raiders = raiders;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setDPS(double DPS) {
        this.DPS = DPS;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
