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
    }

    @Override
    public void walk(){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_000.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(100),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_001.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(200),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_002.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(300),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_003.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(400),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_004.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(500),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_005.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(600),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_006.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(700),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_007.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(800),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_008.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(900),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_009.png")).toExternalForm())))
        );
        timeline.playFromStart();
    }

    @Override
    public void attack(int counter, int DPS){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(2000),
                        e -> {
                            attackAnimation(counter,DPS);
                        }),
                new KeyFrame(
                        Duration.millis(2*(counter+1)),
                        e -> {
                            attackAnimation(counter,DPS);
                        })
        );
        timeline.playFromStart();
    }
    private void attackAnimation(int counter, int DPS){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack/Troll_01_1_ATTACK_000.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(200),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack/Troll_01_1_ATTACK_001.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(400),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack/Troll_01_1_ATTACK_002.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(600),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack/Troll_01_1_ATTACK_003.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(800),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack/Troll_01_1_ATTACK_004.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(1000),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack/Troll_01_1_ATTACK_005.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(1200),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack/Troll_01_1_ATTACK_006.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(1400),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack/Troll_01_1_ATTACK_007.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(1600),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack/Troll_01_1_ATTACK_008.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(1800),
                        e -> troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack/Troll_01_1_ATTACK_009.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(2000),
                        e -> {
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
