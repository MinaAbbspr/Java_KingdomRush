package model.raidar;

import javafx.scene.layout.VBox;
import model.map.Coordinate;

import java.util.ArrayList;

public class ShieldTroll extends Raider{
    public ShieldTroll( ArrayList<Coordinate> way, VBox vBox,Coordinate coordinate) {
        super(400, 40, 40, 25, way, vBox,coordinate);
    }
}
