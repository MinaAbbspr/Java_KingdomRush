package model.map;

import java.util.ArrayList;

public class MapLevel2 extends Map{

    public MapLevel2() {
        super(new Coordinate(1014,721), 7, 300);
        ArrayList <Coordinate> tower = new ArrayList<>();
        tower.add(new Coordinate(928,278));
        tower.add(new Coordinate(761,278));
        tower.add(new Coordinate(590,278));
        tower.add(new Coordinate(792,422));
        tower.add(new Coordinate(982,422));
        tower.add(new Coordinate(738,564));
        tower.add(new Coordinate(928,564));
        tower.add(new Coordinate(1152,611));
        super.setTowersCoordinate(tower);

        ArrayList<Coordinate> way = new ArrayList<>();
        super.setWay(way);

    }
}