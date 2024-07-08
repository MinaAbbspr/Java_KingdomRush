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

public class Troll extends Raider{
    private ImageView imageView;

    public Troll( ArrayList<Coordinate> way, VBox vBox,Coordinate coordinate) {
        super(100, 100, 15, 15, way, vBox,coordinate);
    }

    public void setvBox(VBox vBox) {
        this.imageView = (ImageView) vBox.getChildren().getLast();
        super.setvBox(vBox);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
