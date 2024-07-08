package controller.tower;

import controller.raider.RaiderController;
import model.Tower.Tower;

import java.util.ArrayList;

public abstract class TowerController {
    private Tower tower;

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
    }

    public void run(boolean run, ArrayList<RaiderController> raiders) {}

    public void action(){}

}