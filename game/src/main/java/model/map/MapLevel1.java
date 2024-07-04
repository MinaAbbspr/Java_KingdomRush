package model.map;

import java.util.ArrayList;

public class MapLevel1 extends Map{

    public MapLevel1() {
        super(new Coordinate(680,725), 7, 220);
        ArrayList <Coordinate> tower = new ArrayList<>();
        tower.add(new Coordinate(278,345));
        tower.add(new Coordinate(663,224));
        tower.add(new Coordinate(933,218));
        tower.add(new Coordinate(575,370));
        tower.add(new Coordinate(682,516));
        tower.add(new Coordinate(833,486));
        tower.add(new Coordinate(847,626));
        tower.add(new Coordinate(1023,587));
        super.setTowersCoordinate(tower);
    }
}
