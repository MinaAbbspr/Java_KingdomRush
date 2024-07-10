package controller.tower;

import controller.raider.RaiderController;
import javafx.scene.image.ImageView;
import model.Tower.Tower;

import java.util.ArrayList;

public abstract class TowerController {
    private Tower tower;
    private Thread thread;

    public TowerController() {
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    public void updateLevel(){
        tower.setLevel(tower.getLevel() + 1);
        tower.setRadius(tower.getRadius() + 20);
        tower.setDPS(tower.getDPS() + 5);
    }

    public void action(ArrayList<RaiderController> raiders){}
    public void clear(){}

    public String setImage(){return null;}

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
