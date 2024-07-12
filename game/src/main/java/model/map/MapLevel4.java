package model.map;

import java.util.ArrayList;
import java.util.Random;

public class MapLevel4 extends Map{
    private final Random random;
    public MapLevel4() {
        super(new Coordinate(1550,583), 4, 1000,700,3);
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

        ArrayList<Coordinate> way = new ArrayList<>();
        way.add(new Coordinate(520,100));
        way.add(new Coordinate(534,169));
        way.add(new Coordinate(549,197));
        way.add(new Coordinate(452,198));
        way.add(new Coordinate(352,202));
        way.add(new Coordinate(232,202));
        way.add(new Coordinate(109,253));
        way.add(new Coordinate(149,312));
        way.add(new Coordinate(239,340));
        way.add(new Coordinate(346,344));
        way.add(new Coordinate(466,344));
        way.add(new Coordinate(574,344));
        way.add(new Coordinate(678,344));
        way.add(new Coordinate(734,388));
        way.add(new Coordinate(808,443));
        way.add(new Coordinate(907,479));
        way.add(new Coordinate(1012,491));
        way.add(new Coordinate(1038,556));
        way.add(new Coordinate(1145,573));
        way.add(new Coordinate(1252,583));
        way.add(new Coordinate(1352,578));
        way.add(new Coordinate(1436,578));
        way.add(new Coordinate(1515,583));
        way.add(new Coordinate(1550,583));
        super.getWays().add(way);

        ArrayList<Coordinate> way1 = new ArrayList<>();
        way1.add(new Coordinate(1356,214));
        way1.add(new Coordinate(1240,202));
        way1.add(new Coordinate(1182,217));
        way1.add(new Coordinate(1092,253));
        way1.add(new Coordinate(984,285));
        way1.add(new Coordinate(878,312));
        way1.add(new Coordinate(808,361));
        way1.add(new Coordinate(761,413));
        way1.add(new Coordinate(838,463));
        way1.add(new Coordinate(938,482));
        way1.add(new Coordinate(1024,493));
        way1.add(new Coordinate(1059,573));
        way1.add(new Coordinate(1159,573));
        way1.add(new Coordinate(1252,578));
        way1.add(new Coordinate(1349,578));
        way1.add(new Coordinate(1445,578));
        way1.add(new Coordinate(1550,583));
        super.getWays().add(way1);

        ArrayList<Coordinate> way2 = new ArrayList<>();
        way2.add(new Coordinate(0,513));
        way2.add(new Coordinate(72,534));
        way2.add(new Coordinate(149,573));
        way2.add(new Coordinate(246,583));
        way2.add(new Coordinate(346,578));
        way2.add(new Coordinate(452,573));
        way2.add(new Coordinate(534,543));
        way2.add(new Coordinate(628,503));
        way2.add(new Coordinate(718,503));
        way2.add(new Coordinate(808,472));
        way2.add(new Coordinate(914,472));
        way2.add(new Coordinate(1012,491));
        way2.add(new Coordinate(1024,556));
        way2.add(new Coordinate(1124,573));
        way2.add(new Coordinate(1225,583));
        way2.add(new Coordinate(1356,583));
        way2.add(new Coordinate(1445,583));
        way2.add(new Coordinate(1500,583));
        way2.add(new Coordinate(1550,583));
        super.getWays().add(way2);

        super.getWaves().add(new Wave(7,"Troll"));
        super.getWaves().add(new Wave(5,"Bird"));
        super.getWaves().add(new Wave(2,"Shield"));
        super.getWaves().add(new Wave(2,"Mother"));

        this.random = new Random();
    }
    public ArrayList<Coordinate> getWay(){
        return super.getWays().get(random.nextInt(super.getWays().size()));
    }
}
