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

        ArrayList<Coordinate> way = new ArrayList<>();
        way.add(new Coordinate(1550,319));
        way.add(new Coordinate(450,319));
        way.add(new Coordinate(1350,319));
        way.add(new Coordinate(1250,319));
        way.add(new Coordinate(1188,319));
        way.add(new Coordinate(1117,306));
        way.add(new Coordinate(1057,295));
        way.add(new Coordinate(1022,226));
        way.add(new Coordinate(1003,178));
        way.add(new Coordinate(965,169));
        way.add(new Coordinate(898,169));
        super.setWay(way);

        super.getWaves().add(new Wave(4,0,0,"Troll","","",super.getWay()));
    }
}
