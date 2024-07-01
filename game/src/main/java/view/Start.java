package view;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Start {

    @FXML
    void exit(MouseEvent event) {
        View.getView().getStage().close();
    }

    @FXML
    void start(MouseEvent event) throws IOException {
        View.getView().show("loginSignup.fxml");
    }

}
