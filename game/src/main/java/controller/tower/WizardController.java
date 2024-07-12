package controller.tower;

import controller.raider.RaiderController;
import controller.raider.ShieldTrollController;
import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import model.Tower.Wizard;
import view.HelloApplication;
import view.Shot;
import view.View;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class WizardController extends TowerController{
    private final Wizard wizard;

    public WizardController(Wizard wizard) {
        super();
        this.wizard = wizard;
        setTower(wizard);
    }

    public void action(ArrayList<RaiderController> raiders){
        wizard.setRaiders(raiders);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (RaiderController raider : wizard.getRaiders())
                    if (raider.getRaider().getvBox().isVisible()) {
                        double x = Math.abs(raider.getRaider().getCoordinate().getX() - wizard.getCoordinate().getX());
                        double y = Math.abs(raider.getRaider().getCoordinate().getY() - wizard.getCoordinate().getY());
                        if (Math.sqrt(x * x + y * y) <= wizard.getRadius()) {
                            new Shot("hex", wizard.getCoordinate(), raider.getRaider().getCoordinate());
                            double DPS = wizard.getDPS();
                            if (raider instanceof ShieldTrollController && raider.getRaider().getHealth() > 300) {
                                DPS = 300;
                            }
                            if (raider.getRaider().getHealth() - DPS > 0) {
                                raider.getRaider().setHealth((int) (raider.getRaider().getHealth() - DPS));
                                ProgressBar progressBar = (ProgressBar) (raider.getRaider().getvBox().getChildren().getFirst());
                                Platform.runLater(() -> progressBar.setProgress((double)raider.getRaider().getHealth() / raider.getRaider().getFinalHealth()));
                            } else {
                                raider.getRaider().getvBox().setVisible(false);
                                View.getView().getMap().setCoin(View.getView().getMap().getCoin() + raider.getRaider().getLoot());
                                raiders.remove(raider);
                            }
                            break;
                        }
                    }
            }
        },1000,1000);
    }

    public String setImage(){
        switch (wizard.getLevel()){
            case 0 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/mage.png")).toExternalForm());
            }
            case 1 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/wizard1.png")).toExternalForm());
            }
            case 2 -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/Wizard2.png")).toExternalForm());
            }
            default -> {
                return (Objects.requireNonNull(HelloApplication.class.getResource("images/tower/wizard3.png")).toExternalForm());
            }
        }
    }
}
