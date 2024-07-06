package model.raidar;

import javafx.scene.image.ImageView;
import model.map.Coordinate;

import java.util.ArrayList;

public class ShieldTroll extends Raider{
    public ShieldTroll( ArrayList<Coordinate> pathwayFractures, ImageView imageView) {
        super(500, 300, 35, pathwayFractures, imageView);
    }
}
