package model.map;

import java.util.ArrayList;

public class MapLevel4 extends Map{

    public MapLevel4() {
        super(new Coordinate(406,543), 9, 220,500,3);
        ArrayList <Coordinate> tower = new ArrayList<>();
        tower.add(new Coordinate(306,303));
        tower.add(new Coordinate(503,303));
        tower.add(new Coordinate(792,312));
        tower.add(new Coordinate(1297,312));
        tower.add(new Coordinate(952,443));
        tower.add(new Coordinate(1152,523));
        tower.add(new Coordinate(648,463));
        tower.add(new Coordinate(406,543));
        super.setTowersCoordinate(tower);

    }
}
