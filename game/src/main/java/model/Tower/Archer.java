package model.Tower;

import controller.raider.RaiderController;
import javafx.scene.control.ProgressBar;
import model.map.Coordinate;
import view.Shot;
import view.View;

import java.util.ArrayList;

public class Archer extends Tower{
    public Archer(Coordinate coordinate) {
        super(15, 70, 150, 0, 40,coordinate);
    }


}
