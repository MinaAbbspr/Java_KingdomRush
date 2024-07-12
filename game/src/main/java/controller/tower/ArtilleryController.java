package controller.tower;

import controller.raider.RaiderController;
import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import model.Tower.Artillery;
import model.raidar.Bird;
import view.HelloApplication;
import view.Shot;
import view.View;

import java.util.*;

public class ArtilleryController extends TowerController{
    private final Artillery artillery;
    private final Random random;
    private static final int maxTarget = 3;
    public ArtilleryController(Artillery artillery) {
        super();
        this.artillery = artillery;
        setTower(artillery);
        this.random = new Random();
    }

    public void action(ArrayList<RaiderController> raiders) {
        artillery.setRaiders(raiders);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
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
                        if (raider.getRaider().getHealth() - DPS > 0) {
                            raider.getRaider().setHealth(raider.getRaider().getHealth() - DPS);
                            Platform.runLater(() -> progressBar.setProgress(((double)raider.getRaider().getHealth() / raider.getRaider().getFinalHealth())));
                        } else {
                            raiders.remove(raider);
                            raider.getRaider().getvBox().setVisible(false);
                            View.getView().getMap().setCoin(View.getView().getMap().getCoin() + raider.getRaider().getLoot());
                        }
                    }
                }

            }
        },1000,2000);
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
