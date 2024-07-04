package view;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        View.getView().setStage(stage);
        View.getView().show("start.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}

//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

//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