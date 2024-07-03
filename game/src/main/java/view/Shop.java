package view;

import controller.PlayerController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Shop implements Initializable {

    @FXML
    private ImageView img_blackboard;

    @FXML
    private ImageView img_error;

    @FXML
    private Label lbl_coin;

    @FXML
    private Label lbl_freeze;

    @FXML
    private Label lbl_heart;

    @FXML
    private Label lbl_littleBoy;

    @FXML
    private Label lbl_diamond;

    private String blackboard;

    @FXML
    void buy(MouseEvent event) {
        try {
            PlayerController.getPlayerController().buy(blackboard);
            new Thread(() -> {
                    Platform.runLater(() -> {
                        lbl_diamond.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getDiamond()));
                        lbl_coin.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getCoin()));
                        lbl_freeze.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getFreeze()));
                        lbl_heart.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getHealth()));
                        lbl_littleBoy.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getLittleBoy()));
                    });
            }).start();

        } catch (Exception e) {
            img_error.setVisible(true);
            TranslateTransition TT = new TranslateTransition();
            TT.setNode(img_error);
            TT.setToY( 333);
            TT.setDuration(Duration.millis(500));
            TT.play();
        }
    }

    @FXML
    void closeError(MouseEvent event) {
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> {
                            TranslateTransition TT = new TranslateTransition();
                            TT.setNode(img_error);
                            TT.setToY(-355);
                            TT.setDuration(Duration.millis(500));
                            TT.play();
                        }),
                new KeyFrame(
                        Duration.millis(500),
                        e -> img_error.setVisible(false))
        );
        timeline.playFromStart();
    }

    @FXML
    void coin(MouseEvent event) {
        img_blackboard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/coin3.jpg")).toExternalForm()));
        blackboard = "coin";
    }

    @FXML
    void exit(MouseEvent event) throws IOException {
        View.getView().show("mainPage.fxml");
    }

    @FXML
    void freeze(MouseEvent event) {
        img_blackboard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/bigfreeze3.png.jpg")).toExternalForm()));
        blackboard = "freeze";
    }

    @FXML
    void heart(MouseEvent event) {
        img_blackboard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/heart3.jpg")).toExternalForm()));
        blackboard = "health";
    }

    @FXML
    void littleBoy(MouseEvent event) {
        img_blackboard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/bigBomb3.jpg")).toExternalForm()));
        blackboard = "littleBoy";
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        blackboard = "health";
        lbl_diamond.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getDiamond()));
        lbl_coin.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getCoin()));
        lbl_freeze.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getFreeze()));
        lbl_heart.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getHealth()));
        lbl_littleBoy.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getLittleBoy()));
    }
}