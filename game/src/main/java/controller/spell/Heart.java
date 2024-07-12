package controller.spell;

import model.map.Map;

public class Heart implements ISpell{
    private Map map;

    public Heart(Map map) {
        this.map = map;
        drop();
    }

    public Heart() {
    }

    @Override
    public int getPrice() {
        return 350;
    }

    @Override
    public void drop() {
        map.setHealth(map.getHealth() + 5);
        if(map.getHealth() > 20)
            map.setHealth(20);
    }
}
