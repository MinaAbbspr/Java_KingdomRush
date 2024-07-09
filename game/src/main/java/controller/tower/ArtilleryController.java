package controller.tower;

import controller.raider.RaiderController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import model.Tower.Artillery;
import view.Shot;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class ArtilleryController extends TowerController{
    private final Artillery artillery;
    private Random random;
    private static final int maxTarget = 3;
    public ArtilleryController(Artillery artillery) {
        this.artillery = artillery;
        this.random = new Random();
    }

    public void action(ArrayList<RaiderController> raiders) {
        artillery.setRaiders(raiders);
        ArrayList<RaiderController> targets = new ArrayList<>();
        for (RaiderController raider : artillery.getRaiders())
            if (raider.getRaider().getvBox().isVisible()) {
                double x = Math.abs(raider.getRaider().getCoordinate().getX() - artillery.getCoordinate().getX());
                double y = Math.abs(raider.getRaider().getCoordinate().getY() - artillery.getCoordinate().getY());
                if (Math.sqrt(x * x + y * y) <= artillery.getRadius()) {
                    targets.add(raider);
                    if (targets.size() == maxTarget)
                        break;
                }
            }
        if (!targets.isEmpty()){
            Timeline timeline = new Timeline(
                    new KeyFrame(
                            Duration.ZERO,
                            e -> {
                                new Shot("bomb", artillery.getCoordinate(), targets.getFirst().getRaider().getCoordinate());
                                for(RaiderController raider : targets) {
                                    ProgressBar progressBar = (ProgressBar) (raider.getRaider().getvBox().getChildren().getFirst());
                                    int DPS = (int) (artillery.getDPS() + random.nextInt(artillery.getRandomDPS()));
                                    if (progressBar.getProgress() - (double) DPS / 100 >= 0) {
                                        progressBar.setProgress(progressBar.getProgress() - (double) DPS / 100);
                                        raider.getRaider().setHealth((int) (progressBar.getProgress() * raider.getRaider().getFinalHealth()));
                                    } else {
                                        artillery.getRaiders().remove(raider);
                                        raider.getRaider().getvBox().setVisible(false);
                                        View.getView().getRoot().getChildren().remove(raider.getRaider().getvBox());
                                    }
                                }
                            }),
                    new KeyFrame(
                            Duration.millis(1500),
                            e -> {
                            })
            );
            timeline.playFromStart();
        }
    }

}
