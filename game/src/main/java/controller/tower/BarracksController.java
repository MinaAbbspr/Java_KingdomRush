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

    public void action(ArrayList<RaiderController> raiders){
        barracks.setRaiders(raiders);
        if(barracks.getHeroes().size() < Barracks.getMaxHero()){
            barracks.getHeroes().add(new HeroController(new Hero(barracks.getPathwayFractures(),barracks)));
        }
        for(HeroController hero : barracks.getHeroes())
            hero.action();
    }
}
