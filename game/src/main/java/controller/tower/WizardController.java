package controller.tower;

import controller.raider.RaiderController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import model.Tower.Wizard;
import view.Shot;
import view.View;

import java.util.ArrayList;

public class WizardController extends TowerController{
    private final Wizard wizard;

    public WizardController(Wizard wizard) {
        super();
        this.wizard = wizard;
        setTower(wizard);
    }

    public void action(ArrayList<RaiderController> raiders){
        wizard.setRaiders(raiders);
        for(RaiderController raider : wizard.getRaiders())
            if(raider.getRaider().getvBox().isVisible()){
                double x = Math.abs(raider.getRaider().getCoordinate().getX()- wizard.getCoordinate().getX());
                double y = Math.abs(raider.getRaider().getCoordinate().getY()- wizard.getCoordinate().getY());
                if(Math.sqrt(x*x + y*y) <= wizard.getRadius()){
                    Timeline timeline = new Timeline(
                            new KeyFrame(
                                    Duration.millis(0),
                                    e -> {
                                        new Shot("hex",wizard.getCoordinate(),raider.getRaider().getCoordinate());
                                        ProgressBar progressBar = (ProgressBar)(raider.getRaider().getvBox().getChildren().getFirst());
                                        if(progressBar.getProgress() - wizard.getDPS()/100 >= 0) {
                                            progressBar.setProgress(progressBar.getProgress() - wizard.getDPS() / 100);
                                            raider.getRaider().setHealth((int) (progressBar.getProgress() * raider.getRaider().getFinalHealth()));
                                        }
                                        else {
                                            wizard.getRaiders().remove(raider);
                                            raider.getRaider().getvBox().setVisible(false);
                                            View.getView().getMap().setCoin(View.getView().getMap().getCoin() + raider.getRaider().getLoot());
                                            View.getView().getRoot().getChildren().remove(raider.getRaider().getvBox());
                                        }
                                    }),
                            new KeyFrame(
                                    Duration.millis(2000),
                                    e -> {})
                    );
                    timeline.playFromStart();
                    break;
                }
            }
    }
}
