package controller.raider;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.NodeOrientation;
import javafx.util.Duration;
import model.raidar.Raider;

public abstract class RaiderController {
    private Raider raider;

    public RaiderController(Raider raider) {
        this.raider = raider;
    }

    public Raider getRaider() {
        return raider;
    }

    public void setRaider(Raider raider) {
        this.raider = raider;
    }

    public void walk(){}

    public void action() {
        for (int i = 1; i < raider.getPathwayFractures().size(); i++) {
            int finalI = i;
            Timeline timeline = new Timeline(
                    new KeyFrame(
                            Duration.millis(raider.getSpeed() * 10 * (finalI-1)),
                            e -> {
                                if (!raider.isHero()) {
                                    if (raider.getPathwayFractures().get(finalI).getX() - raider.getvBox().getLayoutX() < 0)
                                        raider.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                                    else
                                        raider.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

                                    raider.setCoordinate(raider.getPathwayFractures().get(finalI));
                                    TranslateTransition TT = new TranslateTransition();
                                    TT.setNode(raider.getvBox());
                                    TT.setDuration(Duration.millis(raider.getSpeed() * 10));
                                    TT.setToX(raider.getPathwayFractures().get(finalI).getX() - raider.getvBox().getLayoutX() -raider.getRandom().nextInt(5));
                                    TT.setToY(raider.getPathwayFractures().get(finalI).getY() - raider.getvBox().getLayoutY() - raider.getRandom().nextInt(25) - 25);
                                    TT.play();
                                    walk();
                                }
                            })
            );
            timeline.playFromStart();
        }
    }
}
