package model.spell;

import controller.raider.RaiderController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;

public class Freeze implements ISpell{
    private ArrayList<RaiderController> raiders;
    public Freeze(ArrayList<RaiderController> raiders) {
        this.raiders = raiders;
        drop();
    }

    public Freeze() {
    }
    @Override
    public int getPrice() {
        return 250;
    }

    @Override
    public void drop() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO,
                        e -> {
                            for(RaiderController raider : raiders)
                                raider.getRaider().setFreeze(true);
                        }),
                new KeyFrame(Duration.seconds(5),
                        e -> {
                            for(RaiderController raider : raiders)
                                raider.getRaider().setFreeze(false);
                        }));
        timeline.play();
    }
}
