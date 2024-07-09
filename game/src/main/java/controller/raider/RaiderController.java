package controller.raider;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.NodeOrientation;
import javafx.util.Duration;
import model.raidar.Raider;

public abstract class RaiderController {
    private Raider raider;

    public RaiderController() {
    }

    public Raider getRaider() {
        return raider;
    }

    public void setRaider(Raider raider) {
        this.raider = raider;
    }

    public void walk(){}
    public void attack(int counter, int DPS){}

    public boolean action() {
        if(raider.isHero()){
            return true;
        }
        else if (raider.getPathwayFractures().get(raider.getNextIndex()).getX() - raider.getvBox().getLayoutX() < 0)
                raider.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        else
            raider.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        raider.setCoordinate(raider.getPathwayFractures().get(raider.getNextIndex()));
        TranslateTransition TT = new TranslateTransition();
        TT.setNode(raider.getvBox());
        TT.setDuration(Duration.millis(raider.getSpeed() * 10));
        TT.setToX(raider.getPathwayFractures().get(raider.getNextIndex()).getX() - raider.getvBox().getLayoutX() -raider.getRandom().nextInt(5));
        TT.setToY(raider.getPathwayFractures().get(raider.getNextIndex()).getY() - raider.getvBox().getLayoutY() - raider.getRandom().nextInt(25) - 25);
        TT.play();
        walk();
        raider.setNextIndex();
        return raider.getNextIndex() < raider.getPathwayFractures().size();
    }
}
