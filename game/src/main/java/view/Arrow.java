package view;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.map.Coordinate;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Arrow implements Initializable {

    @FXML
    private ImageView img_arrow;
    static AnchorPane root;
    static Coordinate start;
    static Coordinate end;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        img_arrow = new ImageView(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/arrow.png")).toExternalForm()));
        img_arrow.setX(start.getX());
        img_arrow.setY(start.getY()-300);

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> {
                            TranslateTransition TT = new TranslateTransition();
                            TT.setNode(img_arrow);
                            TT.setDuration(Duration.millis(500));
                            TT.setToY(-40);
                            TT.play();
                        }),
                new KeyFrame(
                        Duration.seconds(0.5),
                        e -> {
                            img_arrow = new ImageView(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/arrow2.png")).toExternalForm()));
                            TranslateTransition TT = new TranslateTransition();
                            TT.setNode(img_arrow);
                            TT.setDuration(Duration.millis(500));
                            TT.setToX(end.getX() - img_arrow.getX());
                            TT.setToY(end.getY() - img_arrow.getY());
                            TT.play();
                            }),
                new KeyFrame(
                        Duration.seconds(1),
                        e -> root.getChildren().remove(img_arrow))
        );
        timeline.playFromStart();
    }
}
