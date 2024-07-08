package model.Tower;

import controller.raider.RaiderController;
import model.map.Coordinate;

import java.util.ArrayList;

public abstract class Tower {
    private double DPS;
    private int cost;
    private double radius;
    private int level;
    private int updateCost;
    private boolean run;
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

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
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

    public void updateLevel(){
        this.level++;
        radius += 20;
    }

    public void run(boolean run, ArrayList<RaiderController> raiders) {}

    public void action(){}
}
