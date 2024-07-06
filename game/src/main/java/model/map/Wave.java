package model.map;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.raidar.Raider;
import model.raidar.Troll;

import java.util.ArrayList;

public class Wave {
    private int number1;
    private int number2;
    private int number3;
    private String kind1;
    private String kind2;
    private String kind3;
    private ArrayList<Coordinate> way;
    private ArrayList<Raider> raiders;

    public Wave(int number1, int number2, int number3, String kind1, String kind2, String kind3, ArrayList<Coordinate> way) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.kind1 = kind1;
        this.kind2 = kind2;
        this.kind3 = kind3;
        this.way = way;
        this.raiders = new ArrayList<>();
    }

    public void run(AnchorPane root){
        switch (kind1){
            case "Bird" -> {}
            case "Troll" -> {
                for(int i=0; i<number1; i++){
                    ImageView imageView = new ImageView();
                    imageView.setFitWidth(100);
                    imageView.setFitHeight(100);
                    imageView.setSmooth(true);
                    AnchorPane.setTopAnchor(imageView,way.getFirst().getY()-50);
                    AnchorPane.setLeftAnchor(imageView,way.getFirst().getX());
                    root.getChildren().add(imageView);
                    raiders.add(new Troll(way,imageView));
                    new Thread(() -> {
                        Platform.runLater(() -> {
                            raiders.getLast().action();
                        });
                    }).start();
                }
            }
        }
    }
}
