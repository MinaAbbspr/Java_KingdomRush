package model.spell;

import model.map.Map;

public class Coin implements ISpell{
    @Override
    public int getPrice() {
        return 850;
    }

    @Override
    public void drop(Object o) {
        Map map = (Map) o;
        map.setCoin(map.getCoin() + 200);
    }
}
