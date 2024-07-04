package model.raidar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import view.HelloApplication;

import java.util.Objects;

public class Troll extends Raider{
    ImageView imageView;

    public Troll(ImageView imageView) {
        super(100, 100, 15);
        this.imageView = imageView;
    }

    @Override
    public void walk(){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_000.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(100),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_001.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(200),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_002.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(300),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_003.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(400),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_004.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(500),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_005.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(600),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_006.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(700),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_007.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(800),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_008.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(900),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk/Troll_01_1_WALK_009.png")).toExternalForm())))
        );
        timeline.playFromStart();
    }
}
