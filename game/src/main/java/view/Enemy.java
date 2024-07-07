package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.raidar.Raider;

import java.net.URL;
import java.util.ResourceBundle;

public class Enemy implements Initializable {

    @FXML
    private ImageView img_enemy;

    @FXML
    private VBox vBox;

    @FXML
    private ProgressBar lifeBar;

    static Raider raider;
    private Raider enemy;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        enemy = raider;
        enemy.setvBox(vBox);

        new Thread(() -> {
            enemy.action();
        }).start();
    }
}
