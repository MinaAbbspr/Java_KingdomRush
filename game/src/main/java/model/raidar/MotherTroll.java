package model.raidar;

import javafx.scene.image.ImageView;
import model.map.Coordinate;

import java.util.ArrayList;

public class MotherTroll extends Raider{
    public MotherTroll(ArrayList<Coordinate> pathwayFractures, ImageView imageView) {
        super(150, 300, 50, pathwayFractures, imageView);
    }
}
