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
    private final int finalHealth;
    private final int speed;
    private final int loot;
    private boolean hero;
    private final ArrayList<Coordinate> pathwayFractures;
    private final Random random;
    private VBox vBox;
    private Coordinate coordinate;
    private final int DPS;

    public Raider(int health, int speed, int loot, int DPS, ArrayList<Coordinate> pathwayFractures, VBox vBox, Coordinate coordinate) {
        this.health = health;
        this.finalHealth = health;
        this.speed = speed;
        this.loot = loot;
        this.DPS = DPS;
        this.pathwayFractures = pathwayFractures;
        this.vBox = vBox;
        this.hero = false;
        this.random = new Random();
        this.coordinate = coordinate;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setHero(boolean hero) {
        this.hero = hero;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFinalHealth() {
        return finalHealth;
    }

    public int getDPS() {
        return DPS;
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

                                    coordinate = pathwayFractures.get(finalI);
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
