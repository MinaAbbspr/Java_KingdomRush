package controller.raider;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.util.Duration;
import model.raidar.Raider;
import view.HelloApplication;
import view.View;

import java.util.Objects;

public abstract class RaiderController {
    private Raider raider;

    public RaiderController() {
    }

    public Raider getRaider() {
        return raider;
    }

    public void setRaider(Raider raider) {
        this.raider = raider;
    }

    public void walk(){}
    public void attackAnimation(){}
    public void attack(int counter, int DPS){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(0),
                        e -> attackAnimation()),
                new KeyFrame(
                        Duration.millis(2000),
                        e -> {
                            walk();
                            ProgressBar progressBar = (ProgressBar)(raider.getvBox().getChildren().getFirst());
                            if(progressBar.getProgress() - (double) DPS /100 >= 0) {
                                raider.setHealth((int) (progressBar.getProgress() * raider.getFinalHealth() - DPS));
                                progressBar.setProgress((double) (raider.getHealth() * 100) /raider.getFinalHealth());
                            }
                            else {
                                raider.getvBox().setVisible(false);
                                View.getView().getMap().setCoin(View.getView().getMap().getCoin() + raider.getLoot());
                                View.getView().getRoot().getChildren().remove(raider.getvBox());
                            }
                        })
        );
        timeline.setCycleCount(counter);
        timeline.playFromStart();
    }

    public boolean action() {
        if(raider.isHero()){
            return true;
        }
        else if (raider.getPathwayFractures().get(raider.getNextIndex()).getX() - raider.getvBox().getLayoutX() < 0)
                raider.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        else
            raider.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        raider.setCoordinate(raider.getPathwayFractures().get(raider.getNextIndex()));
        TranslateTransition TT = new TranslateTransition();
        TT.setNode(raider.getvBox());
        TT.setToX(raider.getPathwayFractures().get(raider.getNextIndex()).getX() - raider.getvBox().getLayoutX() -raider.getRandom().nextInt(5));
        TT.setToY(raider.getPathwayFractures().get(raider.getNextIndex()).getY() - raider.getvBox().getLayoutY() - raider.getRandom().nextInt(25) - 25);
        TT.setDuration(Duration.millis(TT.getToX()/raider.getSpeed()));
        TT.play();
        raider.setNextIndex();
        return raider.getNextIndex() < raider.getPathwayFractures().size();
    }
}
