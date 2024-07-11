package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.map.Coordinate;

import java.util.Objects;

public class Shot {

    String shot;
    Coordinate start;
    Coordinate end;

    public Shot(String shot, Coordinate start, Coordinate end) {
        this.shot = shot;
        this.start = start;
        this.end = end;
        add();
    }

    private void add() {
        switch (shot) {
            case "arrow" -> {
                ImageView img_arrow = new ImageView(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/arrow.png")).toExternalForm()));
                img_arrow.setFitWidth(15);
                img_arrow.setFitHeight(15);
                img_arrow.setPreserveRatio(false);
                img_arrow.setX(start.getX());
                img_arrow.setY(start.getY() - 100);

                Timeline timeline = new Timeline(
                        new KeyFrame(
                                Duration.ZERO,
                                e -> {
                                    View.getView().getRoot().getChildren().add(img_arrow);
                                    TranslateTransition TT = new TranslateTransition();
                                    TT.setNode(img_arrow);
                                    TT.setDuration(Duration.millis(500));
                                    TT.setToY(-30);
                                    TT.play();
                                }),
                        new KeyFrame(
                                Duration.seconds(0.5),
                                e -> {
                                    img_arrow.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/arrow2.png")).toExternalForm()));
                                    TranslateTransition TT = new TranslateTransition();
                                    TT.setNode(img_arrow);
                                    TT.setDuration(Duration.millis(500));
                                    TT.setToX(end.getX() - img_arrow.getX() + 25);
                                    TT.setToY(end.getY() - img_arrow.getY() + 25);
                                    TT.play();
                                }),
                        new KeyFrame(
                                Duration.seconds(1),
                                e -> View.getView().getRoot().getChildren().remove(img_arrow))
                );
                timeline.playFromStart();
            }
            case "hex" -> {
                ImageView img_hex = new ImageView(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/hex.png")).toExternalForm()));
                img_hex.setFitWidth(20);
                img_hex.setFitHeight(20);
                img_hex.setPreserveRatio(false);
                img_hex.setX(start.getX());
                img_hex.setY(start.getY() - 150);

                Timeline timeline = new Timeline(
                        new KeyFrame(
                                Duration.seconds(0),
                                e -> {
                                    TranslateTransition TT = new TranslateTransition();
                                    TT.setNode(img_hex);
                                    TT.setDuration(Duration.millis(500));
                                    TT.setToX(end.getX() - img_hex.getX() + 25);
                                    TT.setToY(end.getY() - img_hex.getY() + 25);
                                    TT.play();
                                }),
                        new KeyFrame(
                                Duration.seconds(0.5),
                                e -> View.getView().getRoot().getChildren().remove(img_hex))
                );
                timeline.playFromStart();
            }
            case "bomb" -> {
                ImageView img_bomb = new ImageView(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/ston.png")).toExternalForm()));
                img_bomb.setFitWidth(20);
                img_bomb.setFitHeight(20);
                img_bomb.setPreserveRatio(false);
                img_bomb.setX(start.getX());
                img_bomb.setY(start.getY() - 100);

                Timeline timeline = new Timeline(
                        new KeyFrame(
                                Duration.ZERO,
                                e -> {
                                    View.getView().getRoot().getChildren().add(img_bomb);
                                    TranslateTransition TT = new TranslateTransition();
                                    TT.setNode(img_bomb);
                                    TT.setDuration(Duration.millis(500));
                                    TT.setToY(-30);
                                    TT.play();
                                }),
                        new KeyFrame(
                                Duration.seconds(0.5),
                                e -> {
                                    TranslateTransition TT = new TranslateTransition();
                                    TT.setNode(img_bomb);
                                    TT.setDuration(Duration.millis(500));
                                    TT.setToX(end.getX() - img_bomb.getX() + 25);
                                    TT.setToY(end.getY() - img_bomb.getY() + 25);
                                    TT.play();
                                }),
                        new KeyFrame(
                                Duration.seconds(1),
                                e -> View.getView().getRoot().getChildren().remove(img_bomb))
                );
                timeline.playFromStart();
            }
        }
    }
}
