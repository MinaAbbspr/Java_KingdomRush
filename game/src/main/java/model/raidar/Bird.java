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
        super(100, 200, 40, 0, way, vBox, coordinate);
    }


    public void walk(){
        imageView.setImage((new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/output-onlinegiftools (1).gif")).toExternalForm())));
    }
}
