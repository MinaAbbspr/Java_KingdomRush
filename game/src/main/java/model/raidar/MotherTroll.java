package model.raidar;

import controller.raider.RaiderController;
import javafx.scene.layout.VBox;
import model.map.Coordinate;

import java.util.ArrayList;

public class MotherTroll extends Raider{
    private int counter;
    private static final int setFreeBirds = 4;
    private final ArrayList<RaiderController> raiders;
    public MotherTroll(ArrayList<Coordinate> pathwayFractures, VBox vBox,ArrayList<RaiderController> raiders, int level) {
        super(120*level, 70, 50, 50, pathwayFractures, vBox, pathwayFractures.getFirst());
        this.raiders = raiders;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public static int getSetFreeBirds(){
        return setFreeBirds;
    }

    public ArrayList<RaiderController> getRaiders() {
        return raiders;
    }
}
