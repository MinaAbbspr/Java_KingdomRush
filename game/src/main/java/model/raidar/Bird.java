package model.raidar;

import javafx.scene.layout.VBox;
import model.map.Coordinate;

import java.util.ArrayList;

public class Bird extends Raider{
    public Bird(ArrayList<Coordinate> way, VBox vBox, int level) {
        super(80 * level, 80, 20, 0, way, vBox, way.getFirst());

    }

    public Bird(ArrayList<Coordinate> way, VBox vBox,Coordinate coordinate, int nextIndex, int level) {
        super(80 * level, 100, 20, 0, way, vBox, coordinate);
        setNextIndex(nextIndex);
    }
}
