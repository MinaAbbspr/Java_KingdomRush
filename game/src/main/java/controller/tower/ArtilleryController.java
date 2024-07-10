package controller.tower;

import controller.raider.RaiderController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import model.Tower.Artillery;
import model.raidar.Bird;
import view.HelloApplication;
import view.Shot;
import view.View;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class ArtilleryController extends TowerController{
    private final Artillery artillery;
    private Random random;
    private static final int maxTarget = 3;
    public ArtilleryController(Artillery artillery) {
        super();
        this.artillery = artillery;
        setTower(artillery);
        this.random = new Random();
    }

    public void action(ArrayList<RaiderController> raiders) {
        artillery.setRaiders(raiders);
        setThread(new Thread(() -> {
            ArrayList<RaiderController> targets = new ArrayList<>();
            for (RaiderController raider : artillery.getRaiders())
                if (raider.getRaider().getvBox().isVisible()) {
                    double x = Math.abs(raider.getRaider().getCoordinate().getX() - artillery.getCoordinate().getX());
                    double y = Math.abs(raider.getRaider().getCoordinate().getY() - artillery.getCoordinate().getY());
                    if (Math.sqrt(x * x + y * y) <= artillery.getRadius() && !(raider.getRaider() instanceof Bird)) {
                        targets.add(raider);
                        if (targets.size() == maxTarget)
                            break;
                    }
                }
            if (!targets.isEmpty()) {
                new Shot("bomb", artillery.getCoordinate(), targets.getFirst().getRaider().getCoordinate());
                for (RaiderController raider : targets) {
                    ProgressBar progressBar = (ProgressBar) (raider.getRaider().getvBox().getChildren().getFirst());
                    int DPS = (int) (artillery.getDPS() + random.nextInt(artillery.getRandomDPS()));
                    if (progressBar.getProgress() * raider.getRaider().getFinalHealth() - DPS > 0) {
                        raider.getRaider().setHealth((int) (progressBar.getProgress() * raider.getRaider().getFinalHealth() - DPS));
                        progressBar.setProgress((double) (raider.getRaider().getHealth() * 100) / raider.getRaider().getFinalHealth());
                    } else {
                        artillery.getRaiders().remove(raider);
                        raider.getRaider().getvBox().setVisible(false);
                        View.getView().getMap().setCoin(View.getView().getMap().getCoin() + raider.getRaider().getLoot());
                        View.getView().getRoot().getChildren().remove(raider.getRaider().getvBox());
                    }
                }
            }
        }));
        getThread().start();
    }

    public String setImage(){
        switch (artillery.getLevel()){
            case 0 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/artillery.png")).toExternalForm());
            }
            case 1 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/artillery1(1).png")).toExternalForm());
            }
            case 2 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/artillery2.png")).toExternalForm());
            }
            default -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/artillery3.png")).toExternalForm());
            }
        }
    }

}
