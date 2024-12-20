package model.Tower;

import controller.tower.HeroController;
import model.map.Coordinate;

import java.util.ArrayList;

public class Barracks extends Tower{
    private final ArrayList<HeroController> heroes;
    private final ArrayList<Coordinate> pathwayFractures;
    private static final int maxHero = 3;
    public Barracks( Coordinate coordinate,  ArrayList<Coordinate> pathwayFractures) {
        super(0, 70, 200, 0, 40, coordinate);
        this.pathwayFractures = pathwayFractures;
        heroes = new ArrayList<>();
    }

    public ArrayList<HeroController> getHeroes() {
        return heroes;
    }

    public ArrayList<Coordinate> getPathwayFractures() {
        return pathwayFractures;
    }

    public static int getMaxHero(){
        return maxHero;
    }
}
