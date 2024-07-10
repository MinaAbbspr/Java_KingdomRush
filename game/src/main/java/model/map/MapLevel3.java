package model.map;

import java.util.ArrayList;

public class MapLevel3 extends Map{

    public MapLevel3() {
        super(new Coordinate(680,725), 7, 450,400,2);
        ArrayList <Coordinate> tower = new ArrayList<>();
        tower.add(new Coordinate(1302,383));
        tower.add(new Coordinate(1342,515));
        tower.add(new Coordinate(355,396));
        tower.add(new Coordinate(287,547));
        tower.add(new Coordinate(568,453));
        tower.add(new Coordinate(1174,604));
        tower.add(new Coordinate(1124,424));
        tower.add(new Coordinate(454,319));
        super.setTowersCoordinate(tower);

        ArrayList<Coordinate> way = new ArrayList<>();

    }
}
