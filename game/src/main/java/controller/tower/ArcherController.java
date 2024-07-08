package controller.tower;

import controller.raider.RaiderController;
import javafx.scene.control.ProgressBar;
import model.Tower.Archer;
import model.Tower.Tower;
import view.Shot;
import view.View;

import java.util.ArrayList;

public class ArcherController extends TowerController {
    private Archer archer;

    public ArcherController(Archer archer) {
        super();
        this.archer = archer;
        super.setTower(archer);
    }

    public void run(boolean run, ArrayList<RaiderController> raiders) {
        archer.setRun(run);
        archer.setRaiders(raiders);
        action();
    }

    public void action(){
        while (archer.isRun()){
            for(RaiderController raider : archer.getRaiders())
                if(raider.getRaider().getvBox().isVisible()){
                    double x = Math.abs(raider.getRaider().getCoordinate().getX()- archer.getCoordinate().getX());
                    double y = Math.abs(raider.getRaider().getCoordinate().getY()- archer.getCoordinate().getY());
                    if(Math.sqrt(x*x + y*y) <= archer.getRadius()){
                        new Shot("arrow",archer.getCoordinate(),raider.getRaider().getCoordinate());
                        ProgressBar progressBar = (ProgressBar)(raider.getRaider().getvBox().getChildren().getFirst());
                        if(progressBar.getProgress() - archer.getDPS()/100 >= 0) {
                            progressBar.setProgress(progressBar.getProgress() - archer.getDPS() / 100);
                            raider.getRaider().setHealth((int) (progressBar.getProgress() * raider.getRaider().getFinalHealth()));
                        }
                        else {
                            archer.getRaiders().remove(raider);
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
