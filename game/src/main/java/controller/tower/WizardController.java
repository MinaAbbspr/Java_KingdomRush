package controller.tower;

import controller.raider.RaiderController;
import controller.raider.ShieldTrollController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import model.Tower.Wizard;
import view.HelloApplication;
import view.Shot;
import view.View;

import java.util.ArrayList;
import java.util.Objects;

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
                                        double DPS = wizard.getDPS();
                                        if(raider instanceof ShieldTrollController && raider.getRaider().getHealth()>300)
                                            DPS = 300;
                                        if(progressBar.getProgress() * raider.getRaider().getFinalHealth() - DPS > 0) {
                                            raider.getRaider().setHealth((int) (progressBar.getProgress() * raider.getRaider().getFinalHealth() - DPS));
                                            progressBar.setProgress((double) (raider.getRaider().getHealth() * 100) /raider.getRaider().getFinalHealth());
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

    public String setImage(){
        switch (wizard.getLevel()){
            case 0 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/mage.png")).toExternalForm());
            }
            case 1 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/wizard1.png")).toExternalForm());
            }
            case 2 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/Wizard2.png")).toExternalForm());
            }
            default -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/wizard3.png")).toExternalForm());
            }
        }
    }
}
