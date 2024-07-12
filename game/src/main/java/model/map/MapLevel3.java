package model.map;

import java.util.ArrayList;
import java.util.Random;

public class MapLevel3 extends Map{
    private final Random random;

    public MapLevel3() {
        super(new Coordinate(928,800), 4, 550,400,2);
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
        way.add(new Coordinate(775,217));
        way.add(new Coordinate(775,287));
        way.add(new Coordinate(747,341));
        way.add(new Coordinate(690,353));
        way.add(new Coordinate(635,335));
        way.add(new Coordinate(563,295));
        way.add(new Coordinate(504,245));
        way.add(new Coordinate(444,226));
        way.add(new Coordinate(373,235));
        way.add(new Coordinate(287,260));
        way.add(new Coordinate(209,295));
        way.add(new Coordinate(149,361));
        way.add(new Coordinate(209,398));
        way.add(new Coordinate(289,412));
        way.add(new Coordinate(373,424));
        way.add(new Coordinate(398,474));
        way.add(new Coordinate(387,535));
        way.add(new Coordinate(347,585));
        way.add(new Coordinate(233,623));
        way.add(new Coordinate(153,604));
        way.add(new Coordinate(65,594));
        way.add(new Coordinate(0,594));
        super.getWays().add(way);

        ArrayList<Coordinate> way1 = new ArrayList<>();
        way1.add(new Coordinate(775,217));
        way1.add(new Coordinate(775,287));
        way1.add(new Coordinate(747,341));
        way1.add(new Coordinate(813,369));
        way1.add(new Coordinate(914,361));
        way1.add(new Coordinate(968,353));
        way1.add(new Coordinate(1017,317));
        way1.add(new Coordinate(1100,287));
        way1.add(new Coordinate(1200,271));
        way1.add(new Coordinate(1300,278));
        way1.add(new Coordinate(1384,295));
        way1.add(new Coordinate(1388,353));
        way1.add(new Coordinate(1414,400));
        way1.add(new Coordinate(1342,414));
        way1.add(new Coordinate(1266,424));
        way1.add(new Coordinate(1188,441));
        way1.add(new Coordinate(1149,474));
        way1.add(new Coordinate(1182,513));
        way1.add(new Coordinate(1252,554));
        way1.add(new Coordinate(1288,613));
        way1.add(new Coordinate(1240,654));
        way1.add(new Coordinate(1145,657));
        way1.add(new Coordinate(1043,645));
        way1.add(new Coordinate(961,675));
        way1.add(new Coordinate(928,741));
        way1.add(new Coordinate(928,800));
        super.getWays().add(way1);

        super.getWaves().add(new Wave(6,"Troll"));
        super.getWaves().add(new Wave(6,"Bird"));
        super.getWaves().add(new Wave(5,"Shield"));
        super.getWaves().add(new Wave(2,"Mother"));

        this.random = new Random();
    }

    public ArrayList<Coordinate> getWay(){
        return super.getWays().get(random.nextInt(super.getWays().size()));
    }
}
