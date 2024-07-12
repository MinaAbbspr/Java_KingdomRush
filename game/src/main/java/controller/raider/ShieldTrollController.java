package controller.raider;

import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import model.map.Coordinate;
import model.raidar.ShieldTroll;
import view.HelloApplication;

import java.util.ArrayList;
import java.util.Objects;

public class ShieldTrollController extends RaiderController {
    private final ShieldTroll shieldTroll;

    public ShieldTrollController(ArrayList<Coordinate> way, VBox vBox, int level) {
        super();
        this.shieldTroll = new ShieldTroll(way,vBox,level);
        super.setRaider(shieldTroll);
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
