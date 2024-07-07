package model.raidar;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.NodeOrientation;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.map.Coordinate;

import java.util.ArrayList;
import java.util.Random;

public abstract class Raider {
    private int health;
    private final int speed;
    private final int loot;
    private boolean hero;
    private final ArrayList<Coordinate> pathwayFractures;
    private final Random random;
    private VBox vBox;

    public Raider(int health, int speed, int loot, ArrayList<Coordinate> pathwayFractures, VBox vBox) {
        this.health = health;
        this.speed = speed;
        this.loot = loot;
        this.pathwayFractures = pathwayFractures;
        this.vBox = vBox;
        this.hero = false;
        this.random = new Random();
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public void walk(){}

    public void action() {
        for (int i = 1; i < pathwayFractures.size(); i++) {
            int finalI = i;
            Timeline timeline = new Timeline(
                    new KeyFrame(
                            Duration.millis(speed * 10 * (finalI-1)),
                            e -> {
                                if (!this.hero) {
                                    if (pathwayFractures.get(finalI).getX() - vBox.getLayoutX() < 0)
                                        vBox.getChildren().getLast().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                                    else
                                        vBox.getChildren().getLast().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

                                    TranslateTransition TT = new TranslateTransition();
                                    TT.setNode(vBox);
                                    TT.setDuration(Duration.millis(speed * 10));
                                    TT.setToX(pathwayFractures.get(finalI).getX() - vBox.getLayoutX() -random.nextInt(5));
                                    TT.setToY(pathwayFractures.get(finalI).getY() - vBox.getLayoutY() - random.nextInt(25) - 25);
                                    TT.play();
                                    walk();
                                }
                            })
            );
            timeline.playFromStart();
        }
    }
}
