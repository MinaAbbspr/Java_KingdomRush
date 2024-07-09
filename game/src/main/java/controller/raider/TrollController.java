package controller.raider;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.map.Coordinate;
import model.raidar.Troll;
import view.HelloApplication;
import view.View;

import java.util.ArrayList;
import java.util.Objects;

public class TrollController extends RaiderController {
    private final Troll troll;
    public TrollController(ArrayList<Coordinate> way, VBox vBox, Coordinate coordinate) {
        super();
        this.troll = new Troll(way,vBox,coordinate);
        super.setRaider(troll);
        troll.getImageView().setImage((new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk.gif")).toExternalForm())));
    }

    public void walk(){
        troll.getImageView().setImage((new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk.gif")).toExternalForm())));
    }

    @Override
    public void attack(int counter, int DPS){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(0),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack.gif")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(2000),
                        e -> {
                            walk();
                            ProgressBar progressBar = (ProgressBar)(troll.getvBox().getChildren().getFirst());
                            if(progressBar.getProgress() - (double) DPS /100 >= 0) {
                                progressBar.setProgress(progressBar.getProgress() - (double) DPS /100);
                                troll.setHealth((int) (progressBar.getProgress() * troll.getFinalHealth()));
                            }
                            else {
                                troll.getvBox().setVisible(false);
                                View.getView().getRoot().getChildren().remove(troll.getvBox());
                            }
                        })
        );
        timeline.setCycleCount(counter);
        timeline.playFromStart();
    }
}
