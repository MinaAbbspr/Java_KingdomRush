package controller.tower;

import controller.raider.RaiderController;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.Tower.Hero;
import model.map.Coordinate;
import view.HelloApplication;
import view.View;

import java.io.IOException;
import java.util.Objects;

public class HeroController {
    private final Hero hero;
    private ImageView imageView;


    public HeroController(Hero hero) {
        this.hero = hero;
        showHero();
    }

    public void showHero(){

        hero.setvBox(makeVBox());
        Coordinate coordinate = find();
        hero.getvBox().setLayoutX(coordinate.getX() -hero.getRandom().nextInt(50));
        hero.getvBox().setLayoutY(coordinate.getY() - hero.getRandom().nextInt(25) - 50);
        hero.setCoordinate(new Coordinate(hero.getvBox().getLayoutX(), hero.getvBox().getLayoutY()));
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> {
                            FadeTransition FT = new FadeTransition();
                            FT.setNode(hero.getvBox());
                            FT.setDuration(Duration.seconds(0.5));
                            FT.setToValue(0.001);
                            FT.setAutoReverse(true);
                            FT.setCycleCount(2);
                            FT.play();
                        }),
                new KeyFrame(
                        Duration.millis(500),
                        e -> View.getView().getRoot().getChildren().add(hero.getvBox()))
                );
        timeline.playFromStart();
    }
    private VBox makeVBox(){
        ProgressBar progressBar = new ProgressBar(1.0);
        progressBar.setMaxHeight(15);
        progressBar.setMaxWidth(100);
        imageView = new ImageView();
        imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_000.png")).toExternalForm()));
        imageView.setPreserveRatio(false);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        return new VBox(progressBar, imageView);
    }

    private Coordinate find (){
        double min = Math.abs(hero.getBarracks().getCoordinate().getX() - hero.getPathwayFractures().getFirst().getX());
        Coordinate point = hero.getPathwayFractures().getFirst();
        for(Coordinate coordinate : hero.getPathwayFractures()){
            if(min > Math.abs(hero.getBarracks().getCoordinate().getX() - coordinate.getX())) {
                min = Math.abs(hero.getBarracks().getCoordinate().getX() - coordinate.getX());
                point = coordinate;
            }
        }
        return point;
    }


    public void walk(){
        switch (hero.getBarracks().getLevel()){
            case 0 -> walkLevel0();
            case 1 -> walkLevel1();
            case 2,3 -> walkLevel2();
        }
    }
    private void walkLevel0(){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_000.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed()),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_001.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 2),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_002.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 3),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_003.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 4),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_004.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 5),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_005.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 6),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_006.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 7),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_007.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 8),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_008.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 9),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_009.png")).toExternalForm())))
        );
        timeline.playFromStart();
    }
    private void walkLevel1(){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_000.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed()),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_001.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 2),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_002.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 3),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_003.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 4),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_004.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 5),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_005.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 6),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_006.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 7),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_007.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 8),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_008.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 9),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_009.png")).toExternalForm())))
        );
        timeline.playFromStart();
    }
    private void walkLevel2(){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_000.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed()),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_001.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 2),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_002.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 3),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_003.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 4),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_004.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 5),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_005.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 6),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_006.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 7),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_007.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 8),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_008.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 9),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/walk/Knight_01__WALK_009.png")).toExternalForm())))
        );
        timeline.playFromStart();
    }

    public void action() {
        for(RaiderController raider : hero.getBarracks().getRaiders())
            if(raider.getRaider().getvBox().isVisible()){
                double x = Math.abs(raider.getRaider().getCoordinate().getX()- hero.getBarracks().getCoordinate().getX());
                double y = Math.abs(raider.getRaider().getCoordinate().getY()- hero.getBarracks().getCoordinate().getY());
                if(Math.sqrt(x*x + y*y) <= hero.getBarracks().getRadius() && !raider.getRaider().isHero()){
                    hero.setRaider(true);
                    raider.getRaider().setHero(true);
                    attackTime(raider);
                }
                break;
            }

    }

    private void attackTime(RaiderController raider){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> {
                            if (raider.getRaider().getCoordinate().getX() - hero.getvBox().getLayoutX() < 0) {
                                hero.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                                TranslateTransition TT = new TranslateTransition();
                                TT.setNode(hero.getvBox());
                                TT.setDuration(Duration.millis(hero.getSpeed() * 10));
                                TT.setToX(raider.getRaider().getCoordinate().getX() - hero.getvBox().getLayoutX() + 40);
                                TT.setToY(raider.getRaider().getCoordinate().getY() - hero.getvBox().getLayoutY());
                                TT.play();
                            }
                            else {
                                hero.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
                                TranslateTransition TT = new TranslateTransition();
                                TT.setNode(hero.getvBox());
                                TT.setDuration(Duration.millis(hero.getSpeed() * 10));
                                TT.setToX(raider.getRaider().getCoordinate().getX() - hero.getvBox().getLayoutX() -40);
                                TT.setToY(raider.getRaider().getCoordinate().getY() - hero.getvBox().getLayoutY());
                                TT.play();
                            }
                            walk();
                        }),
                new KeyFrame(
                        Duration.millis(hero.getSpeed() * 10),
                        e -> {
                            int heroCounter = hero.getHealth() / raider.getRaider().getDPS() +1;
                            int raiderCounter = raider.getRaider().getHealth() / hero.getDPS() +1;
                            if(heroCounter > raiderCounter){
                                attack(raiderCounter,raider);
                                raider.attack(raiderCounter,hero.getDPS());
                            }
                            else if(heroCounter == raiderCounter){
                                attack(raiderCounter+1,raider);
                            }
                            else{
                                attack(heroCounter,raider);
                            }
                        })
        );
        timeline.playFromStart();
    }

    private void attack(int counter, RaiderController raider){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> {
                            switch (hero.getBarracks().getLevel()) {
                                case 0 -> attackLevel0(counter, raider.getRaider().getDPS());
                                case 1 -> walkLevel1();
                                case 2, 3 -> walkLevel2();
                            }
                        }),
                new KeyFrame(
                        Duration.seconds(2 * counter),
                        e -> {
                            if (hero.getHealth() > 0) {
                                hero.getBarracks().getRaiders().remove(raider);
                                TranslateTransition TT = new TranslateTransition();
                                TT.setNode(hero.getvBox());
                                TT.setDuration(Duration.millis(hero.getSpeed() * 10));
                                TT.setToX(hero.getCoordinate().getX() - hero.getvBox().getLayoutX());
                                TT.setToY(hero.getCoordinate().getY() - hero.getvBox().getLayoutY());
                                TT.play();
                                walk();
                            }
                            else
                                raider.getRaider().setHero(false);
                        })
        );
        timeline.playFromStart();
    }
     private void attackLevel0(int counter, int DPS){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/attack/Knight_01__ATTACK_000.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(200),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/attack/Knight_01__ATTACK_001.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(400),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/attack/Knight_01__ATTACK_002.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(600),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/attack/Knight_01__ATTACK_003.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(800),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/attack/Knight_01__ATTACK_004.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(1000),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/attack/Knight_01__ATTACK_005.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(1200),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/attack/Knight_01__ATTACK_006.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(1400),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/attack/Knight_01__ATTACK_007.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(1600),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/attack/Knight_01__ATTACK_008.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.millis(1800),
                        e -> imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/attack/Knight_01__ATTACK_009.png")).toExternalForm()))),
                new KeyFrame(
                        Duration.seconds(2),
                        e -> {
                            ProgressBar progressBar = (ProgressBar)(hero.getvBox().getChildren().getFirst());
                            if(progressBar.getProgress() - (double) DPS /100 >= 0) {
                                progressBar.setProgress(progressBar.getProgress() - (double) DPS / 100);
                                hero.setHealth((int) (progressBar.getProgress() * hero.getFinalHealth()));
                            }
                            else {
                                hero.setHealth(0);
                                hero.getBarracks().getHeroes().remove(this);
                                hero.getvBox().setVisible(false);
                                View.getView().getRoot().getChildren().remove(hero.getvBox());
                            }
                        }
                )
        );
        timeline.setCycleCount(counter);
        timeline.playFromStart();
    }

}
