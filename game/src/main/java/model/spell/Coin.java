package model.spell;

import model.map.Map;

public class Coin implements ISpell{
    private Map map;

    public Coin(Map map) {
        this.map = map;
        drop();
    }

    public Coin() {
    }

    @Override
    public int getPrice() {
        return 850;
    }

    @Override
    public void drop() {
        map.setCoin(map.getCoin() + 200);
    }
}
