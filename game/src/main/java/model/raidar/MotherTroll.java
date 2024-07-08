package model.raidar;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.map.Coordinate;
import view.View;

import java.util.ArrayList;

public class MotherTroll extends Raider{
    public MotherTroll(ArrayList<Coordinate> pathwayFractures, VBox vBox,Coordinate coordinate) {
        super(150, 300, 50, 50, pathwayFractures, vBox, coordinate);
    }
}
