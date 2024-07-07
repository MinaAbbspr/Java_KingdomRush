package model.raidar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.map.Coordinate;
import view.HelloApplication;

import java.util.ArrayList;
import java.util.Objects;

public class Bird extends Raider{

    ImageView imageView;
    public Bird(ArrayList<Coordinate> way, VBox vBox, Coordinate coordinate) {
        super(100, 200, 40, way, vBox, coordinate);
    }

    @Override
    public void walk(){
        Timeline timeline = new Timeline(
                new KeyFrame(
                Duration.ZERO,
                e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/bird/walk/Walk1.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(200),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/bird/walk/Walk2.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(400),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/bird/walk/Walk3.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(600),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/bird/walk/Walk4.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(800),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/bird/walk/Walk5.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(1000),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/bird/walk/Walk6.png")).toExternalForm())))
        );
        timeline.playFromStart();
    }
}
