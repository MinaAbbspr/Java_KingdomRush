package model.map;

import java.util.ArrayList;

public abstract class Map {
    private ArrayList<Coordinate> towersCoordinate;
    private Coordinate way;
    private Coordinate endPoint;
    private int  Wave;
    private int coin;

    public Map(Coordinate endPoint, int wave, int coin) {
        this.endPoint = endPoint;
        Wave = wave;
        this.coin = coin;
    }

    public ArrayList<Coordinate> getTowersCoordinate() {
        return towersCoordinate;
    }

    public void setTowersCoordinate(ArrayList<Coordinate> towersCoordinate) {
        this.towersCoordinate = towersCoordinate;
    }

    public Coordinate getWay() {
        return way;
    }

    public void setWay(Coordinate way) {
        this.way = way;
    }

    public Coordinate getEndPoint() {
        return endPoint;
    }

    public int getWave() {
        return Wave;
    }

    public int getCoin() {
        return coin;
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
