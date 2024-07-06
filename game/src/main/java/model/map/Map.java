package model.map;

import java.util.ArrayList;

public abstract class Map {
    private ArrayList<Coordinate> towersCoordinate;
    private ArrayList<Coordinate> way;
    private ArrayList<Wave> waves;
    private final Coordinate endPoint;
    private final int wave;
    private int coin;

    public Map(Coordinate endPoint, int wave, int coin) {
        this.endPoint = endPoint;
        this.wave = wave;
        this.coin = coin;
        this.waves = new ArrayList<>();
    }

    public ArrayList<Coordinate> getTowersCoordinate() {
        return towersCoordinate;
    }

    public void setTowersCoordinate(ArrayList<Coordinate> towersCoordinate) {
        this.towersCoordinate = towersCoordinate;
    }

    public ArrayList<Coordinate> getWay() {
        return way;
    }

    public void setWay(ArrayList<Coordinate> way) {
        this.way = way;
    }

    public ArrayList<model.map.Wave> getWaves() {
        return waves;
    }

    public void setWaves(ArrayList<model.map.Wave> waves) {
        this.waves = waves;
    }

    public Coordinate getEndPoint() {
        return endPoint;
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
