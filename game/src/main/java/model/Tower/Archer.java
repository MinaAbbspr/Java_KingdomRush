package model.Tower;

import controller.raider.RaiderController;
import javafx.scene.control.ProgressBar;
import model.map.Coordinate;
import view.Shot;
import view.View;

import java.util.ArrayList;

public class Archer extends Tower{
    public Archer(Coordinate coordinate) {
        super(15, 70, 150, 0, 40,coordinate);
    }

    public void run(boolean run, ArrayList<RaiderController> raiders) {
        super.setRun(run);
        super.setRaiders(raiders);
        action();
    }

    public void action(){
        while (super.isRun()){
            for(RaiderController raider : super.getRaiders())
                if(raider.getRaider().getvBox().isVisible()){
                    double x = Math.abs(raider.getRaider().getCoordinate().getX()- super.getCoordinate().getX());
                    double y = Math.abs(raider.getRaider().getCoordinate().getY()- super.getCoordinate().getY());
                    if(Math.sqrt(x*x + y*y) <= super.getRadius()){
                        new Shot("arrow",super.getCoordinate(),raider.getRaider().getCoordinate());
                        ProgressBar progressBar = (ProgressBar)(raider.getRaider().getvBox().getChildren().getFirst());
                        if(progressBar.getProgress() - super.getDPS()/100 >= 0) {
                            progressBar.setProgress(progressBar.getProgress() - super.getDPS() / 100);
                            raider.getRaider().setHealth((int) (progressBar.getProgress() * raider.getRaider().getFinalHealth()));
                        }
                        else {
                            super.getRaiders().remove(raider);
                            raider.getRaider().getvBox().setVisible(false);
                            View.getView().getRoot().getChildren().remove(raider.getRaider().getvBox());
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
