package controller.raider;

import javafx.animation.TranslateTransition;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.raidar.Bird;
import model.raidar.MotherTroll;
import view.HelloApplication;
import view.View;

import java.util.Objects;

public class MotherTrollController extends RaiderController{
    private final MotherTroll motherTroll;

    public MotherTrollController(MotherTroll motherTroll) {
        super();
        this.motherTroll = motherTroll;
        setRaider(motherTroll);
    }
    @Override
    public void walk(){
        motherTroll.getImageView().setImage((new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/MotherTroll/walk.gif")).toExternalForm())));
    }

    @Override
    public void attackAnimation(){
        motherTroll.getImageView().setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/MotherTroll/attack.gif")).toExternalForm()));
    }

    @Override
    public boolean action() {
        if(motherTroll.isHero()){
            return true;
        }
        else if(motherTroll.getCounter() == MotherTroll.getSetFreeBirds()){
            for(int i=0; i<3; i++){
                motherTroll.getRaiders().add(new BirdController(new Bird(motherTroll.getPathwayFractures(), makeVBox(),motherTroll.getCoordinate(),motherTroll.getNextIndex())));
                motherTroll.getRaiders().getLast().getRaider().getvBox().setLayoutY(motherTroll.getCoordinate().getY()-50);
                motherTroll.getRaiders().getLast().getRaider().getvBox().setLayoutX(motherTroll.getCoordinate().getX());
                View.getView().getRoot().getChildren().add(motherTroll.getRaiders().getLast().getRaider().getvBox());
            }
            motherTroll.setCounter(0);
        }
        else if (motherTroll.getPathwayFractures().get(motherTroll.getNextIndex()).getX() - motherTroll.getvBox().getLayoutX() < 0)
            motherTroll.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        else
            motherTroll.getvBox().getChildren().getLast().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        motherTroll.setCoordinate(motherTroll.getPathwayFractures().get(motherTroll.getNextIndex()));
        TranslateTransition TT = new TranslateTransition();
        TT.setNode(motherTroll.getvBox());
        TT.setToX(motherTroll.getPathwayFractures().get(motherTroll.getNextIndex()).getX() - motherTroll.getvBox().getLayoutX() -motherTroll.getRandom().nextInt(5));
        TT.setToY(motherTroll.getPathwayFractures().get(motherTroll.getNextIndex()).getY() - motherTroll.getvBox().getLayoutY() - motherTroll.getRandom().nextInt(25) - 25);
        TT.setDuration(Duration.millis(TT.getToX()/motherTroll.getSpeed()));
        TT.play();
        motherTroll.setNextIndex();
        motherTroll.setCounter(motherTroll.getCounter()+1);
        return motherTroll.getNextIndex() < motherTroll.getPathwayFractures().size();
    }

    private VBox makeVBox(){
        ProgressBar progressBar = new ProgressBar(1.0);
        progressBar.setMaxHeight(15);
        progressBar.setMaxWidth(100);
        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(false);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        return new VBox(progressBar, imageView);
    }
}
