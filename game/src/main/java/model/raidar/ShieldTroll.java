package model.raidar;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.map.Coordinate;
import view.View;

import java.util.ArrayList;

public class ShieldTroll extends Raider{
    public ShieldTroll( ArrayList<Coordinate> pathwayFractures, VBox vBox) {
        super(500, 300, 35, pathwayFractures, vBox);
    }
}
