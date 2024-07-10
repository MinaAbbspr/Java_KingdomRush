package model.spell;

import model.map.Map;

public class Heart implements ISpell{
    @Override
    public int getPrice() {
        return 350;
    }

    @Override
    public void drop(Object o) {
        Map map = (Map) o;
        map.setHealth(map.getHealth() + 5);
        if(map.getHealth() > 20)
            map.setHealth(20);
    }
}
