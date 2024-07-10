package model.spell;

import controller.raider.RaiderController;
import view.View;

import java.util.ArrayList;

public class Bomb implements ISpell{
    @Override
    public int getPrice() {
        return 999;
    }

    @Override
    public void drop(Object o) {
        ArrayList<RaiderController> raiders = (ArrayList<RaiderController>) o;
        for(RaiderController raider : raiders){
            raider.getRaider().getvBox().setVisible(false);
            View.getView().getMap().setCoin(View.getView().getMap().getCoin() + raider.getRaider().getLoot());
            View.getView().getRoot().getChildren().remove(raider.getRaider().getvBox());
        }
        raiders.clear();
    }
}
