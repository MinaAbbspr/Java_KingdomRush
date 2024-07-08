package model.Tower;

import controller.HeroController;
import controller.raider.RaiderController;
import model.map.Coordinate;

import java.util.ArrayList;

public class Barracks extends Tower{
    private final ArrayList<HeroController> heroes;
    private final ArrayList<Coordinate> pathwayFractures;
    private static final int maxHero = 2;
    public Barracks( Coordinate coordinate,  ArrayList<Coordinate> pathwayFractures) {
        super(10, 70, 200, 0, 40, coordinate);
        this.pathwayFractures = pathwayFractures;
        heroes = new ArrayList<>();
    }

    public void run(boolean run, ArrayList<RaiderController> raiders) {
        super.setRun(run);
        super.setRaiders(raiders);
        action();
    }

    public void action(){
        while (super.isRun()){
            if(heroes.size() < maxHero){
                heroes.add(new HeroController(new Hero(pathwayFractures,this)));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public ArrayList<HeroController> getHeroes() {
        return heroes;
    }
}
