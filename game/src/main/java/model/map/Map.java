package model.map;

import java.util.ArrayList;

public abstract class Map {
    private ArrayList<Coordinate> towersCoordinate;
    private ArrayList<ArrayList<Coordinate>> way;
    private ArrayList<Wave> waves;
    private final Coordinate endPoint;
    private final int wave;
    private int coin;
    private int health;
    private final int diamondReward;
    private final int level;

    public Map(Coordinate endPoint, int wave, int coin, int diamondReward, int level) {
        this.endPoint = endPoint;
        this.wave = wave;
        this.coin = coin;
        this.waves = new ArrayList<>();
        this.way = new ArrayList<>();
        this.health = 20;
        this.diamondReward = diamondReward;
        this.level = level;
    }

    public ArrayList<Coordinate> getTowersCoordinate() {
        return towersCoordinate;
    }

    public void setTowersCoordinate(ArrayList<Coordinate> towersCoordinate) {
        this.towersCoordinate = towersCoordinate;
    }

    public ArrayList<ArrayList<Coordinate>> getWays() {
        return way;
    }

    public ArrayList<model.map.Wave> getWaves() {
        return waves;
    }

    public int getWave() {
        return wave;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDiamondReward() {
        return diamondReward;
    }

    public int getLevel() {
        return level;
    }

    public Coordinate find (Coordinate coordinate){
        double min = Math.abs(coordinate.getX() - towersCoordinate.getFirst().getX());
        Coordinate point = towersCoordinate.getFirst();
        for(Coordinate coordinate1 : towersCoordinate){
            if(min > Math.abs(coordinate.getX() - coordinate1.getX())) {
                min = Math.abs(coordinate.getX() - coordinate1.getX());
                point = coordinate1;
            }
        }
        return point;
    }
}
