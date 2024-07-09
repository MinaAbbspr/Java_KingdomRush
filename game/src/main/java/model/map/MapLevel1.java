package model.map;

import java.util.ArrayList;

public class MapLevel1 extends Map{

    public MapLevel1() {
        super(new Coordinate(638,724), 1, 220);
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
        way.add(new Coordinate(1550,260));
        way.add(new Coordinate(1450,260));
        way.add(new Coordinate(1350,260));
        way.add(new Coordinate(1250,260));
        way.add(new Coordinate(1144,253));
        way.add(new Coordinate(1117,197));
        way.add(new Coordinate(1092,144));
        way.add(new Coordinate(951,102));
        way.add(new Coordinate(799,123));
        way.add(new Coordinate(738,241));
        way.add(new Coordinate(611,260));
        way.add(new Coordinate(490,264));
        way.add(new Coordinate(369,334));
        way.add(new Coordinate(490,391));
        way.add(new Coordinate(611,405));
        way.add(new Coordinate(749,384));
        way.add(new Coordinate(922,391));
        way.add(new Coordinate(914,464));
        way.add(new Coordinate(903,505));
        way.add(new Coordinate(807,524));
        way.add(new Coordinate(684,543));
        way.add(new Coordinate(638,593));
        way.add(new Coordinate(638,654));
        way.add(new Coordinate(638,724));
        way.add(new Coordinate(638,800));
        super.getWays().add(way);

        super.getWaves().add(new Wave(4,0,0,"Troll","",""));
    }

    public ArrayList<Coordinate> getWay(){
        return super.getWays().getFirst();
    }
}
