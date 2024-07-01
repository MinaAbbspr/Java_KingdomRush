package view;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class Start {

    @FXML
    void exit(MouseEvent event) {
        View.getView().getStage().close();
    }

    @FXML
    void start(MouseEvent event) {

    }

}
