package controller.tower;

import controller.raider.RaiderController;
import model.Tower.Barracks;
import model.Tower.Hero;

import java.util.ArrayList;

public class BarracksController extends TowerController{
    public Barracks barracks;

    public BarracksController(Barracks barracks) {
        super();
        this.barracks = barracks;
        setTower(barracks);
    }

    public void run(boolean run, ArrayList<RaiderController> raiders) {
        barracks.setRun(run);
        barracks.setRaiders(raiders);
        action();
    }

    public void action(){
        if(barracks.getHeroes().size() < Barracks.getMaxHero()){
            barracks.getHeroes().add(new HeroController(new Hero(barracks.getPathwayFractures(),barracks)));
        }
        for(HeroController hero : barracks.getHeroes())
            hero.action();
    }
}
