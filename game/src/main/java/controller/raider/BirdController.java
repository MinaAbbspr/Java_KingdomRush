package controller.raider;

import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import model.map.Coordinate;
import model.raidar.Bird;
import view.HelloApplication;

import java.util.ArrayList;
import java.util.Objects;

public class BirdController extends RaiderController {
    private final Bird bird;

    public BirdController(Bird bird) {
        super();
        this.bird = bird;
        super.setRaider(bird);
        walk();
    }

    @Override
    public void walk(){
        bird.getImageView().setImage((new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/Bird.gif")).toExternalForm())));
    }
}
