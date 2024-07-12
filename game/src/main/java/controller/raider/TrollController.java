package controller.raider;

import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import model.map.Coordinate;
import model.raidar.Troll;
import view.HelloApplication;

import java.util.ArrayList;
import java.util.Objects;

public class TrollController extends RaiderController {
    private final Troll troll;
    public TrollController(ArrayList<Coordinate> way, VBox vBox,int level) {
        super();
        this.troll = new Troll(way,vBox,level);
        super.setRaider(troll);
        walk();
    }


    @Override
    public void walk(){
        troll.getImageView().setImage((new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/walk.gif")).toExternalForm())));
    }

    @Override
    public void attackAnimation(){
        troll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Troll/attack.gif")).toExternalForm()));
    }
}
