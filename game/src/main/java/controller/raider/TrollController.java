package controller.raider;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.map.Coordinate;
import model.raidar.Troll;
import view.HelloApplication;
import view.View;

import java.util.ArrayList;
import java.util.Objects;

public class TrollController extends RaiderController {
    private final Troll troll;
    public TrollController(ArrayList<Coordinate> way, VBox vBox, Coordinate coordinate) {
        super();
        this.troll = new Troll(way,vBox,coordinate);
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
