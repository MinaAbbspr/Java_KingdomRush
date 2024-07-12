package model.raidar;

import javafx.scene.layout.VBox;
import model.map.Coordinate;
import view.View;

import java.util.ArrayList;

public class Bird extends Raider{
    public Bird(ArrayList<Coordinate> way, VBox vBox, Coordinate coordinate, int level) {
        super(80 * level, 80, 20, 0, way, vBox, coordinate);

    }

    public Bird(ArrayList<Coordinate> way, VBox vBox, Coordinate coordinate, int nextIndex, int level) {
        super(80 * level, 100, 20, 0, way, vBox, coordinate);
        setNextIndex(nextIndex);
    }
}
