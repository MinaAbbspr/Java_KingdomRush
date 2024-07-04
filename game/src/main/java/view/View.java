package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.util.Objects;

public class View {
    private Stage stage;
    private static View view;
    private boolean music;
    private MediaPlayer mediaPlayer;

    public View() {
        this.music = true;
        mediaPlayer = new MediaPlayer(new Media(Objects.requireNonNull(HelloApplication.class.getResource("sound/corsairs-studiokolomna-main-version-23542-02-33.mp3")).toExternalForm()));
    }

    public static View getView() {
        if(view == null)
            view = new View();
        return view;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public void show(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("KINGDOM RUSH");
        stage.setScene(scene);
        stage.show();
    }
}
