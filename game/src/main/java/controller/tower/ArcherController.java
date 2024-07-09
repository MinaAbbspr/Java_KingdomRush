package controller.tower;

import controller.raider.RaiderController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import model.Tower.Archer;
import view.Shot;
import view.View;

import java.util.ArrayList;

public class ArcherController extends TowerController {
    private final Archer archer;

    public ArcherController(Archer archer) {
        super();
        this.archer = archer;
        super.setTower(archer);
    }

    public void action(ArrayList<RaiderController> raiders){
        archer.setRaiders(raiders);
        super.setThread(new Thread(() -> {
            for (RaiderController raider : archer.getRaiders())
                if (raider.getRaider().getvBox().isVisible()) {
                    double x = Math.abs(raider.getRaider().getCoordinate().getX() - archer.getCoordinate().getX());
                    double y = Math.abs(raider.getRaider().getCoordinate().getY() - archer.getCoordinate().getY());
                    if (Math.sqrt(x * x + y * y) <= archer.getRadius()) {
                        Timeline timeline = new Timeline(
                                new KeyFrame(
                                        Duration.millis(0),
                                        e -> {
                                            new Shot("arrow", archer.getCoordinate(), raider.getRaider().getCoordinate());
                                            ProgressBar progressBar = (ProgressBar) (raider.getRaider().getvBox().getChildren().getFirst());
                                            if (progressBar.getProgress() - archer.getDPS() / 100 >= 0) {
                                                progressBar.setProgress(progressBar.getProgress() - archer.getDPS() / 100);
                                                raider.getRaider().setHealth((int) (progressBar.getProgress() * raider.getRaider().getFinalHealth()));
                                            } else {
                                                archer.getRaiders().remove(raider);
                                                raider.getRaider().getvBox().setVisible(false);
                                                View.getView().getRoot().getChildren().remove(raider.getRaider().getvBox());
                                            }
                                        }),
                                new KeyFrame(
                                        Duration.millis(2000),
                                        e -> {
                                        })
                        );
                        timeline.playFromStart();
                        break;
                    }
                }
        }));
        getThread().start();
    }
}
