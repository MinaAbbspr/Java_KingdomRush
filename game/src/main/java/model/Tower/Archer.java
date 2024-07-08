package model.Tower;

import javafx.scene.control.ProgressBar;
import model.map.Coordinate;
import model.raidar.Raider;
import view.Shot;
import view.View;

import java.util.ArrayList;

public class Archer extends Tower{
    public Archer(Coordinate coordinate) {
        super(15, 70, 150, 0, 40,coordinate);
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
                        if(progressBar.getProgress() - super.getDPS()/100 >= 0) {
                            progressBar.setProgress(progressBar.getProgress() - super.getDPS() / 100);
                            raider.setHealth((int) (progressBar.getProgress() * raider.getFinalHealth()));
                        }
                        else {
                            super.getRaiders().remove(raider);
                            raider.getvBox().setVisible(false);
                            View.getView().getRoot().getChildren().remove(raider.getvBox());
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
}
