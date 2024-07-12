package model.raidar;

import javafx.scene.layout.VBox;
import model.map.Coordinate;

import java.util.ArrayList;

public class Troll extends Raider{

    public Troll( ArrayList<Coordinate> way, VBox vBox,int level) {
        super(50, 160, 15, 15, way, vBox,way.getFirst());
    }
}
