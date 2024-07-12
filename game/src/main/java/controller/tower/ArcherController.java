package controller.tower;

import controller.raider.RaiderController;
import controller.raider.ShieldTrollController;
import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import model.Tower.Archer;
import view.HelloApplication;
import view.Shot;
import view.View;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class ArcherController extends TowerController {
    private final Archer archer;

    public ArcherController(Archer archer) {
        super();
        this.archer = archer;
        super.setTower(archer);
    }

    public void action(ArrayList<RaiderController> raiders){
        archer.setRaiders(raiders);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                 for (RaiderController raider : archer.getRaiders())
                     if (raider.getRaider().getvBox().isVisible()) {
                         double x = Math.abs(raider.getRaider().getCoordinate().getX() - archer.getCoordinate().getX());
                         double y = Math.abs(raider.getRaider().getCoordinate().getY() - archer.getCoordinate().getY());
                         if (Math.sqrt(x * x + y * y) <= archer.getRadius()) {
                             new Shot("arrow", archer.getCoordinate(), raider.getRaider().getCoordinate());
                             double DPS = archer.getDPS();
                             if (raider instanceof ShieldTrollController) {
                                 DPS /= 2;
                             }
                             if (raider.getRaider().getHealth() - DPS > 0) {
                                 raider.getRaider().setHealth((int) (raider.getRaider().getHealth() - DPS));
                                 ProgressBar progressBar = (ProgressBar) (raider.getRaider().getvBox().getChildren().getFirst());
                                 progressBar.setProgress((double) (raider.getRaider().getHealth() * 100) / raider.getRaider().getFinalHealth());
                             } else {
                                 raider.getRaider().getvBox().setVisible(false);
                                 View.getView().getMap().setCoin(View.getView().getMap().getCoin() + raider.getRaider().getLoot());
                                 raiders.remove(raider);
                             }
                             break;
                         }
                     }

         }},1000, 1000);
    }

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
