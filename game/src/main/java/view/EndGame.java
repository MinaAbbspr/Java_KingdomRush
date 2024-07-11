package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndGame implements Initializable {

    @FXML
    private Label lbl_diamon;

    @FXML
    private Label lbl_lose;

    @FXML
    private Label lbl_win;
    static boolean win;

    @FXML
    void exit(MouseEvent event) throws IOException {
        View.getView().show("mainPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(win){
            lbl_diamon.setText(String.valueOf(View.getView().getMap().getDiamondReward()));
            lbl_win.setVisible(true);
            lbl_lose.setVisible(false);
        }
        else {
            lbl_diamon.setText(String.valueOf(0));
            lbl_win.setVisible(false);
            lbl_lose.setVisible(true);
        }
    }
}
