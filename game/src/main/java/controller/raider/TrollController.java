package controller.raider;

import controller.raider.RaiderController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.map.Coordinate;
import model.raidar.Troll;
import view.HelloApplication;

import java.util.ArrayList;
import java.util.Objects;

public class TrollController extends RaiderController {
    private Troll troll;
    public TrollController(ArrayList<Coordinate> way, VBox vBox, Coordinate coordinate) {
        super(new Troll(way,vBox,coordinate));
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
}
