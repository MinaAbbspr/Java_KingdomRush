package controller.tower;

import controller.raider.RaiderController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Tower.Barracks;
import model.Tower.Hero;
import view.HelloApplication;
import view.View;

import java.util.ArrayList;
import java.util.Objects;

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

    public void updateLevel(){
        super.updateLevel();
        for(HeroController hero : barracks.getHeroes())
            hero.updateLevel();
    }

    public void action(ArrayList<RaiderController> raiders){
        barracks.setRaiders(raiders);
        super.setThread(new Thread(() ->{
            if (barracks.getHeroes().size() < Barracks.getMaxHero())
                barracks.getHeroes().add(new HeroController(new Hero(barracks.getPathwayFractures(), barracks)));

            for (HeroController hero : barracks.getHeroes())
                hero.action();
        }));
        getThread().start();
    }
//    public void action(ArrayList<RaiderController> raiders){
//        barracks.setRaiders(raiders);
//        if (barracks.getHeroes().size() < Barracks.getMaxHero())
//            barracks.getHeroes().add(new HeroController(new Hero(barracks.getPathwayFractures(), barracks)));
//
//        for (HeroController hero : barracks.getHeroes())
//            hero.action();
//
//    }

    public void clear(){
        for(HeroController hero : barracks.getHeroes())
            View.getView().getRoot().getChildren().remove(hero.getHero().getvBox());
    }

    public String setImage(){
        switch (barracks.getLevel()){
            case 0 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/barracks.png")).toExternalForm());
            }
            case 1 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/barracks1.png")).toExternalForm());
            }
            case 2 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/barracks2.png")).toExternalForm());
            }
            default -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/barracks3.png")).toExternalForm());
            }
        }
    }
}
