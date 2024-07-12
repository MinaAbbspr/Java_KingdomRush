package model.raidar;

import javafx.scene.layout.VBox;
import model.map.Coordinate;

import java.util.ArrayList;

public class Troll extends Raider{

    public Troll( ArrayList<Coordinate> way, VBox vBox,Coordinate coordinate,int level) {
        super(50, 120, 15, 15, way, vBox,coordinate);
    }
}
