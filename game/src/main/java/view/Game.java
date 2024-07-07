package view;

import model.Tower.Tower;
import model.map.Map;
import model.raidar.Raider;

import java.util.ArrayList;

public class Game {
    private static Game game;
    private Map map;
    private ArrayList<Tower> towers;
    private ArrayList<Raider> raiders;

    public Game() {
        towers = new ArrayList<>();
        raiders = new ArrayList<>();
    }

    public static Game getGame() {
        if(game == null)
            game = new Game();
        return game;
    }

    public Map getMap() {
        return map;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public ArrayList<Raider> getRaiders() {
        return raiders;
    }

    public void setMap(Map map) {
        this.map = map;
        clear();
    }

    public void clear(){
        towers.clear();
        raiders.clear();
    }
}
