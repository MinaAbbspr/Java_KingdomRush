package model.raidar;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.map.Coordinate;

import java.util.ArrayList;

public class Bird extends Raider{
    public Bird(ArrayList<Coordinate> way, VBox vBox, Coordinate coordinate) {
        super(80, 80, 20, 0, way, vBox, coordinate);

    }

    public Bird(ArrayList<Coordinate> way, VBox vBox, Coordinate coordinate, int nextIndex) {
        super(80, 80, 20, 0, way, vBox, coordinate);
        setNextIndex(nextIndex);
    }
}
