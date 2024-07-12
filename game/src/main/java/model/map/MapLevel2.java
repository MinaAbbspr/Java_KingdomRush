package model.map;

import java.util.ArrayList;

public class MapLevel2 extends Map{

    public MapLevel2() {
        super(new Coordinate(974,800), 4, 400,300,1);
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
        way.add(new Coordinate(892,0));
        way.add(new Coordinate(922,66));
        way.add(new Coordinate(936,150));
        way.add(new Coordinate(824,164));
        way.add(new Coordinate(700,160));
        way.add(new Coordinate(590,160));
        way.add(new Coordinate(502,173));
        way.add(new Coordinate(411,194));
        way.add(new Coordinate(349,244));
        way.add(new Coordinate(490,278));
        way.add(new Coordinate(590,303));
        way.add(new Coordinate(700,303));
        way.add(new Coordinate(800,303));
        way.add(new Coordinate(900,303));
        way.add(new Coordinate(1000,303));
        way.add(new Coordinate(1100,312));
        way.add(new Coordinate(1188,369));
        way.add(new Coordinate(1089,422));
        way.add(new Coordinate(1003,450));
        way.add(new Coordinate(892,450));
        way.add(new Coordinate(792,450));
        way.add(new Coordinate(664,450));
        way.add(new Coordinate(578,466));
        way.add(new Coordinate(490,505));
        way.add(new Coordinate(464,544));
        way.add(new Coordinate(614,576));
        way.add(new Coordinate(724,594));
        way.add(new Coordinate(854,594));
        way.add(new Coordinate(943,594));
        way.add(new Coordinate(962,665));
        way.add(new Coordinate(988,707));
        way.add(new Coordinate(974,746));
        way.add(new Coordinate(974,800));
        super.getWays().add(way);

        super.getWaves().add(new Wave(5,"Bird"));
        super.getWaves().add(new Wave(7,"Troll"));
        super.getWaves().add(new Wave(5,"Shield"));
        super.getWaves().add(new Wave(3,"Mother"));
    }

    public ArrayList<Coordinate> getWay(){
        return super.getWays().getFirst();
    }
}
