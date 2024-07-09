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
        barracks.getHeroes().add(new HeroController(new Hero(barracks.getPathwayFractures(),barracks)));
        barracks.getHeroes().add(new HeroController(new Hero(barracks.getPathwayFractures(),barracks)));
        barracks.getHeroes().add(new HeroController(new Hero(barracks.getPathwayFractures(),barracks)));
    }

//    public void action(ArrayList<RaiderController> raiders){
//        barracks.setRaiders(raiders);
//        super.setThread(new Thread(() ->{
//            if (barracks.getHeroes().size() < Barracks.getMaxHero())
//                barracks.getHeroes().add(new HeroController(new Hero(barracks.getPathwayFractures(), barracks)));
//
//            for (HeroController hero : barracks.getHeroes())
//                hero.action();
//        }));
//        getThread().start();
//    }
    public void action(ArrayList<RaiderController> raiders){
        barracks.setRaiders(raiders);
        if (barracks.getHeroes().size() < Barracks.getMaxHero())
            barracks.getHeroes().add(new HeroController(new Hero(barracks.getPathwayFractures(), barracks)));

        for (HeroController hero : barracks.getHeroes())
            hero.action();

    }
}
