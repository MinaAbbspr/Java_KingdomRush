package controller.tower;

import controller.raider.RaiderController;
import controller.raider.ShieldTrollController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import model.Tower.Archer;
import model.raidar.ShieldTroll;
import view.HelloApplication;
import view.Shot;
import view.View;

import java.util.ArrayList;
import java.util.Objects;

public class ArcherController extends TowerController {
    private final Archer archer;

    public ArcherController(Archer archer) {
        super();
        this.archer = archer;
        super.setTower(archer);
    }

    public void action(ArrayList<RaiderController> raiders){
        archer.setRaiders(raiders);
        setTimeline(new Timeline(
                new KeyFrame(
                    Duration.ZERO,
                    e -> {
                        for (RaiderController raider : archer.getRaiders())
                            if (raider.getRaider().getvBox().isVisible()) {
                                double x = Math.abs(raider.getRaider().getCoordinate().getX() - archer.getCoordinate().getX());
                                double y = Math.abs(raider.getRaider().getCoordinate().getY() - archer.getCoordinate().getY());
                                if (Math.sqrt(x * x + y * y) <= archer.getRadius()) {
                                    new Shot("arrow", archer.getCoordinate(), raider.getRaider().getCoordinate());
                                    ProgressBar progressBar = (ProgressBar) (raider.getRaider().getvBox().getChildren().getFirst());
                                    double DPS = archer.getDPS();
                                    if (raider instanceof ShieldTrollController)
                                        DPS /= 2;
                                    if (progressBar.getProgress() * raider.getRaider().getFinalHealth() - DPS > 0) {
                                        raider.getRaider().setHealth((int) (progressBar.getProgress() * raider.getRaider().getFinalHealth() - DPS));
                                        progressBar.setProgress((double) (raider.getRaider().getHealth() * 100) / raider.getRaider().getFinalHealth());
                                    } else {
                                        raider.getRaider().getvBox().setVisible(false);
                                        View.getView().getMap().setCoin(View.getView().getMap().getCoin() + raider.getRaider().getLoot());
                                    }
                                    break;
                                }
                            }
                    }
        )));
        getTimeline().setCycleCount(Animation.INDEFINITE);
        getTimeline().play();
    }

//    public void action(ArrayList<RaiderController> raiders){
//        archer.setRaiders(raiders);
//        for (RaiderController raider : archer.getRaiders())
//            if (raider.getRaider().getvBox().isVisible()) {
//                double x = Math.abs(raider.getRaider().getCoordinate().getX() - archer.getCoordinate().getX());
//                double y = Math.abs(raider.getRaider().getCoordinate().getY() - archer.getCoordinate().getY());
//                if (Math.sqrt(x * x + y * y) <= archer.getRadius()) {
//                    Timeline timeline = new Timeline(
//                            new KeyFrame(
//                                    Duration.millis(0),
//                                    e -> {
//                                        new Shot("arrow", archer.getCoordinate(), raider.getRaider().getCoordinate());
//                                        ProgressBar progressBar = (ProgressBar) (raider.getRaider().getvBox().getChildren().getFirst());
//                                        double DPS = archer.getDPS();
//                                        if(raider instanceof ShieldTrollController)
//                                            DPS /= 2;
//                                        if(progressBar.getProgress() * raider.getRaider().getFinalHealth() - DPS > 0) {
//                                            raider.getRaider().setHealth((int) (progressBar.getProgress() * raider.getRaider().getFinalHealth() - DPS));
//                                            progressBar.setProgress((double) (raider.getRaider().getHealth() * 100) /raider.getRaider().getFinalHealth());
//                                        } else {
//                                            archer.getRaiders().remove(raider);
//                                            raider.getRaider().getvBox().setVisible(false);
//                                            View.getView().getMap().setCoin(View.getView().getMap().getCoin() + raider.getRaider().getLoot());
//                                            View.getView().getRoot().getChildren().remove(raider.getRaider().getvBox());
//                                        }
//                                    }),
//                            new KeyFrame(
//                                    Duration.millis(2000),
//                                    e -> {
//                                    })
//                    );
//                    timeline.playFromStart();
//                    break;
//                }
//            }
//    }

    public String setImage(){
        switch (archer.getLevel()){
            case 0 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/archer.png")).toExternalForm());
            }
            case 1 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/archer1.png")).toExternalForm());
            }
            case 2 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/archer2.png")).toExternalForm());
            }
            default -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/archer3.png")).toExternalForm());
            }
        }
    }
}
