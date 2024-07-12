package controller.spell;

import controller.raider.RaiderController;
import view.View;

import java.util.ArrayList;

public class Bomb implements ISpell{
    private ArrayList<RaiderController> raiders;
    public Bomb(ArrayList<RaiderController> raiders) {
        this.raiders = raiders;
        drop();
    }

    public Bomb() {
    }

    @Override
    public int getPrice() {
        return 999;
    }

    @Override
    public void drop() {
        for(RaiderController raider : raiders){
            raider.getRaider().getvBox().setVisible(false);
            View.getView().getMap().setCoin(View.getView().getMap().getCoin() + raider.getRaider().getLoot());
            View.getView().getRoot().getChildren().remove(raider.getRaider().getvBox());
        }
        raiders.clear();
    }
}
