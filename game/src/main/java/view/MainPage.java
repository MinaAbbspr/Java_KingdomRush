package view;

import controller.PlayerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPage implements Initializable {

    @FXML
    private Label lbl_diamond;

    @FXML
    private Label lbl_star;

    @FXML
    private VBox level1;

    @FXML
    private VBox level2;

    @FXML
    private VBox level3;

    @FXML
    private VBox level4;

    @FXML
    private ImageView img_l1;

    @FXML
    private ImageView img_l2;

    @FXML
    private ImageView img_l3;

    @FXML
    private ImageView img_l4;

    @FXML
    private HBox hBox_l1;

    @FXML
    private HBox hBox_l2;

    @FXML
    private HBox hBox_l3;

    @FXML
    private HBox hBox_l4;

    @FXML
    void setting(MouseEvent event) throws IOException {
        View.getView().show("setting.fxml");
    }

    @FXML
    void shop(MouseEvent event) throws IOException {
        View.getView().show("shop.fxml");
    }

    @FXML
    void exit(MouseEvent event) {
        PlayerController.getPlayerController().save();
        View.getView().getStage().close();
    }

    @FXML
    void level1(MouseEvent event) throws IOException {
        View.getView().show("level1.fxml");
    }

    @FXML
    void level2(MouseEvent event) throws IOException {
        View.getView().show("level2.fxml");
    }
    @FXML
    void level3(MouseEvent event) throws IOException {
        View.getView().show("level3.fxml");
    }
    @FXML
    void level4(MouseEvent event) throws IOException {
        View.getView().show("level4.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbl_diamond.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getDiamond()));
        lbl_star.setText(PlayerController.getPlayerController().getPlayer().getLevel()*3 + "/12");
        setFlags();
        if(View.getView().isMusic()) {
            View.getView().getMediaPlayer().pause();
            View.getView().setMediaPlayer(new MediaPlayer(new Media(Objects.requireNonNull(HelloApplication.class.getResource("sound/corsairs-studiokolomna-main-version-23542-02-33.mp3")).toExternalForm())));
            View.getView().getMediaPlayer().play();
            View.getView().getMediaPlayer().setCycleCount(50);
        }
    }

    private void setFlags(){
        int level = PlayerController.getPlayerController().getPlayer().getLevel();

        if(level > 0) {
            img_l1.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/grayFlag.png")).toExternalForm()));
            hBox_l1.setVisible(true);
            level2.setVisible(true);
        }
        else
            return;

        if(level > 1){
            img_l2.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/grayFlag.png")).toExternalForm()));
            hBox_l2.setVisible(true);
            level3.setVisible(true);
        }
        else
            return;

        if(level > 2){
            img_l3.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/grayFlag.png")).toExternalForm()));
            hBox_l3.setVisible(true);
            level4.setVisible(true);
        }
        else
            return;

        if(level > 3){
            img_l4.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/grayFlag.png")).toExternalForm()));
            hBox_l4.setVisible(true);
        }
    }
}