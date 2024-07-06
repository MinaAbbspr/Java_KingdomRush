package model.raidar;

import javafx.animation.TranslateTransition;
import javafx.geometry.NodeOrientation;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.map.Coordinate;

import java.util.ArrayList;
import java.util.Random;

public abstract class Raider {
    private int health;
    private int speed;
    private int loot;
    private boolean hero;
    private ArrayList<Coordinate> pathwayFractures;
    private Random random;
    private ImageView imageView;

    public Raider(int health, int speed, int loot, ArrayList<Coordinate> pathwayFractures, ImageView imageView) {
        this.health = health;
        this.speed = speed;
        this.loot = loot;
        this.pathwayFractures = pathwayFractures;
        this.imageView = imageView;
        this.hero = false;
        this.random = new Random();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void walk(){}

//    public void action() {
//        for(int i=1; i<pathwayFractures.size(); i++){
//            if(!this.hero){
//                if(pathwayFractures.get(i).getX() - imageView.getLayoutX() < 0)
//                    imageView.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
//                else
//                    imageView.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
//
//                TranslateTransition TT = new TranslateTransition();
//                TT.setNode(imageView);
//                TT.setDuration(Duration.millis(speed*10));
//                TT.setToX( pathwayFractures.get(i).getX() - imageView.getLayoutX());
//                TT.setToY( pathwayFractures.get(i).getY() - imageView.getLayoutY() + random.nextInt(25)+25);
//                TT.play();
//                walk();
//
//            }
//        }
//    }

    public void action() {
        for(int i=1; i<pathwayFractures.size(); i++){
            if(!this.hero){
                if(pathwayFractures.get(i).getX() - imageView.getLayoutX() < 0)
                    imageView.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                else
                    imageView.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

                TranslateTransition TT = new TranslateTransition();
                TT.setNode(imageView);
                TT.setDuration(Duration.millis(speed*10));
                TT.setToX( pathwayFractures.get(i).getX() - imageView.getLayoutX());
                TT.setToY( pathwayFractures.get(i).getY() - imageView.getLayoutY() + random.nextInt(25)+25);
                TT.play();
                walk();

            }
        }
    }
}
