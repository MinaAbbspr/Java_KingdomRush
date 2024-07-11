package controller.raider;

import javafx.scene.image.Image;
import model.raidar.Bird;
import view.HelloApplication;

import java.util.Objects;

public class BirdController extends RaiderController {
    private final Bird bird;

    public BirdController(Bird bird) {
        super();
        this.bird = bird;
        super.setRaider(bird);
        walk();
        bird.getImageView().setFitWidth(70);
        bird.getImageView().setFitHeight(70);
    }

    @Override
    public void walk(){
        bird.getImageView().setImage((new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/bird/Bird.gif")).toExternalForm())));
    }
}
