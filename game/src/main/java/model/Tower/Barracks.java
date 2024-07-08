package model.Tower;

import controller.HeroController;
import javafx.scene.control.ProgressBar;
import model.map.Coordinate;
import model.raidar.Raider;
import view.Shot;

import java.util.ArrayList;

public class Barracks extends Tower{
    private ArrayList<HeroController> heroes;
    private static final int maxHero = 3;
    public Barracks( Coordinate coordinate) {
        super(10, 70, 200, 0, 40, coordinate);
        heroes = new ArrayList<>();
    }

    public void run(boolean run, ArrayList<Raider> raiders) {
        super.setRun(run);
        super.setRaiders(raiders);
        action();
    }

    public void action(){
        while (super.isRun()){
            for(Raider raider : super.getRaiders())
                if(raider.getvBox().isVisible()){
                    double x = Math.abs(raider.getCoordinate().getX()- super.getCoordinate().getX());
                    double y = Math.abs(raider.getCoordinate().getY()- super.getCoordinate().getY());
                    if(Math.sqrt(x*x + y*y) <= super.getRadius()){
                        new Shot("arrow",super.getCoordinate(),raider.getCoordinate());
                        ProgressBar progressBar = (ProgressBar)(raider.getvBox().getChildren().getFirst());
                        if(progressBar.getProgress() - super.getDPS()/100 >= 0)
                            progressBar.setProgress(progressBar.getProgress() - super.getDPS()/100);
                        else {
                            super.getRaiders().remove(raider);
                            raider.getvBox().setVisible(false);
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
        }
    }

    public ArrayList<HeroController> getHeroes() {
        return heroes;
    }
}
