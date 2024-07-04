package view;

import controller.PlayerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Setting implements Initializable {

    @FXML
    private ImageView img_music;

    @FXML
    private Label lbl_error;

    @FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_username;


    @FXML
    void exit(MouseEvent event) throws IOException {
        View.getView().show("mainPage.fxml");
    }

    @FXML
    void music(MouseEvent event) {
        if(!View.getView().isMusic()){
            View.getView().getMediaPlayer().pause();
            View.getView().setMediaPlayer(new MediaPlayer(new Media(Objects.requireNonNull(HelloApplication.class.getResource("sound/corsairs-studiokolomna-main-version-23542-02-33.mp3")).toExternalForm())));
            View.getView().getMediaPlayer().play();
            View.getView().setMusic(true);
            img_music.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/musicOn.png")).toExternalForm()));
            img_music.setFitWidth(50);
        }
        else{
            View.getView().getMediaPlayer().pause();
            View.getView().setMusic(false);
            img_music.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/musicOFF.png")).toExternalForm()));
            img_music.setFitWidth(55);
        }
    }

    @FXML
    void save(MouseEvent event) {
        try {
            PlayerController.getPlayerController().checkChanges(txt_username.getText(),txt_password.getText());
            lbl_error.setText("information changed successfully");
            lbl_error.setTextFill(Color.GREEN);
        } catch (Exception e) {
            lbl_error.setText(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txt_username.setText(PlayerController.getPlayerController().getPlayer().getUsername());
        txt_password.setText(PlayerController.getPlayerController().getPlayer().getPassword());
        if(View.getView().isMusic()){
            img_music.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/musicOn.png")).toExternalForm()));
            img_music.setFitWidth(50);
        }
        else{
            img_music.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/musicOFF.png")).toExternalForm()));
            img_music.setFitWidth(55);
        }
    }
}