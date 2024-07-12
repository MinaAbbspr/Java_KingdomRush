package controller.tower;

import controller.raider.RaiderController;
import javafx.animation.*;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.Tower.Hero;
import model.map.Coordinate;
import model.raidar.Bird;
import view.HelloApplication;
import view.View;

import java.util.Objects;

public class HeroController {
    private final Hero hero;
    private ImageView imageView;


    public HeroController(Hero hero) {
        this.hero = hero;
        updateLevel();
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
        imageView.setPreserveRatio(false);
        stand();
        return new VBox(progressBar, imageView);
    }
    private Coordinate find (){
        double min = Math.abs(hero.getBarracks().getCoordinate().getX() - hero.getPathwayFractures().getFirst().getX())+Math.abs(hero.getBarracks().getCoordinate().getY() - hero.getPathwayFractures().getFirst().getY());
        Coordinate point = hero.getPathwayFractures().getFirst();
        for(Coordinate coordinate : hero.getPathwayFractures()){
            if(min > Math.abs(hero.getBarracks().getCoordinate().getX() - coordinate.getX())+Math.abs(hero.getBarracks().getCoordinate().getY() - hero.getPathwayFractures().getFirst().getY())) {
                min = Math.abs(hero.getBarracks().getCoordinate().getX() - coordinate.getX()) + Math.abs(hero.getBarracks().getCoordinate().getY() - hero.getPathwayFractures().getFirst().getY());
                point = coordinate;
            }
        }
        return point;
    }

    public Hero getHero() {
        return hero;
    }

    public void updateLevel(){
        hero.setDPS(hero.getDPS() + hero.getBarracks().getLevel() * 10);
    }


    public void walk() {
//        imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/walk.gif")).toExternalForm()));
//        imageView.setFitHeight(50);
//        imageView.setFitWidth(50);
    }

    public void attack(){
        imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/attack.gif")).toExternalForm()));
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
    }

    public void stand(){
        imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/knight/0/Knight_01__WALK_001.png")).toExternalForm()));
        imageView.setPreserveRatio(false);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
    }

    public void action() {
        if(!hero.isRaider() && hero.isAlive())
            for (RaiderController raider : hero.getBarracks().getRaiders())
                if (raider.getRaider().getvBox().isVisible() && !raider.getRaider().isHero()) {
                    double x = Math.abs(raider.getRaider().getCoordinate().getX() - hero.getBarracks().getCoordinate().getX());
                    double y = Math.abs(raider.getRaider().getCoordinate().getY() - hero.getBarracks().getCoordinate().getY());
                    if (Math.sqrt(x * x + y * y) <= hero.getBarracks().getRadius() && !raider.getRaider().isHero() && !(raider.getRaider() instanceof Bird)) {
                        hero.setRaider(true);
                        raider.getRaider().setHero(true);
                        attackTime(raider);
                        break;
                    }
                }
    }

    private void attackTime(RaiderController raider){
        int counter;
        int heroCounter = hero.getHealth() / raider.getRaider().getDPS() +1;
        int raiderCounter = raider.getRaider().getHealth() / hero.getDPS() +1;
        if(heroCounter > raiderCounter)
            counter = raiderCounter;
        else if(heroCounter == raiderCounter)
            counter = raiderCounter +1;
        else
            counter = heroCounter;
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> {
                            if (raider.getRaider().getCoordinate().getX() - hero.getvBox().getLayoutX() < 0) {
                                hero.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                                TranslateTransition TT = new TranslateTransition();
                                TT.setNode(hero.getvBox());
                                TT.setDuration(Duration.seconds(2));
                                TT.setToX(raider.getRaider().getCoordinate().getX() - hero.getvBox().getLayoutX() + 25);
                                TT.setToY(raider.getRaider().getCoordinate().getY() - hero.getvBox().getLayoutY());
                                TT.play();
                            }
                            else {
                                hero.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
                                TranslateTransition TT = new TranslateTransition();
                                TT.setNode(hero.getvBox());
                                TT.setDuration(Duration.seconds(2));
                                TT.setToX(raider.getRaider().getCoordinate().getX() - hero.getvBox().getLayoutX() -25);
                                TT.setToY(raider.getRaider().getCoordinate().getY() - hero.getvBox().getLayoutY());
                                TT.play();
                            }
                            walk();
                        }),
                new KeyFrame(
                        Duration.seconds(2),
                        e -> {
                            attack();
                            raider.attackAnimation();
                            attackAnimation(counter,raider,hero);
                            //raider.attack(counter,hero.getDPS());
                        }),
                new KeyFrame(
                        Duration.seconds(2 * counter + 2),
                        e -> {
                            if (hero.getHealth() > 0) {
                                hero.setRaider(false);
                                TranslateTransition TT = new TranslateTransition();
                                TT.setNode(hero.getvBox());
                                TT.setDuration(Duration.seconds(2));
                                TT.setToX(hero.getCoordinate().getX() - hero.getvBox().getLayoutX());
                                TT.setToY(hero.getCoordinate().getY() - hero.getvBox().getLayoutY());
                                TT.play();
                                walk();
                            }
                            else {
                                raider.walk();
                                raider.getRaider().setHero(false);
                            }
                        }),
                new KeyFrame(
                        Duration.seconds(2 * counter + 4),
                        e -> stand())
        );
        timeline.play();
    }

    private void attackAnimation(int counter, RaiderController raider, Hero hero){
        if(counter == 0)
            return;

        if (raider.getRaider().getHealth() - hero.getDPS() > 0) {
            raider.getRaider().setHealth(raider.getRaider().getHealth() - hero.getDPS());
            ProgressBar progressBar = (ProgressBar) (raider.getRaider().getvBox().getChildren().getFirst());
            progressBar.setProgress((double) raider.getRaider().getHealth() / raider.getRaider().getFinalHealth());
        } else {
            raider.getRaider().getvBox().setVisible(false);
            View.getView().getMap().setCoin(View.getView().getMap().getCoin() + raider.getRaider().getLoot());
        }
        if(hero.getHealth() - raider.getRaider().getDPS() > 0) {
            hero.setHealth(hero.getHealth() - raider.getRaider().getDPS());
            ProgressBar progressBar = (ProgressBar)(hero.getvBox().getChildren().getFirst());
            progressBar.setProgress((double) hero.getHealth() / hero.getFinalHealth());
        }
        else {
            hero.setHealth(0);
            hero.setAlive(false);
            hero.getvBox().setVisible(false);
        }
        int finalCounter = --counter;

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> attackAnimation(finalCounter,raider,hero));
        pause.play();
    }

}
