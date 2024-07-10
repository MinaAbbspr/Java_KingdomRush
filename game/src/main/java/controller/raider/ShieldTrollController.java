package controller.raider;

import javafx.scene.image.Image;
import model.raidar.ShieldTroll;
import view.HelloApplication;

import java.util.Objects;

public class ShieldTrollController extends RaiderController {
    private final ShieldTroll shieldTroll;

    public ShieldTrollController(ShieldTroll shieldTroll) {
        super();
        this.shieldTroll = shieldTroll;
        setRaider(shieldTroll);
        walk();
    }

    @Override
    public void walk(){
        shieldTroll.getImageView().setImage((new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/ShieldTroll/walk.gif")).toExternalForm())));
    }

    @Override
    public void attackAnimation(){
        shieldTroll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/ShieldTroll/attack.gif")).toExternalForm()));
    }
}
