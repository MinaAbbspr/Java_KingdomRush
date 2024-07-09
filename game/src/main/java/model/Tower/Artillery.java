package model.Tower;

import model.map.Coordinate;

public class Artillery extends Tower{
    private final int randomDPS;
    public Artillery(Coordinate coordinate) {
        super(15, 112, 150, 0, 55, coordinate);
        this.randomDPS = 15;
    }

    public int getRandomDPS() {
        return randomDPS;
    }
}
