package model.raidar;

import javafx.scene.layout.VBox;
import model.map.Coordinate;

import java.util.ArrayList;

public class Troll extends Raider{

    public Troll( ArrayList<Coordinate> way, VBox vBox,Coordinate coordinate) {
        super(50, 100, 15, 15, way, vBox,coordinate);
    }
}
