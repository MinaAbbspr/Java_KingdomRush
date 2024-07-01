package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class View {
    private Stage stage;
    private static View view;

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

    public void show(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("KINGDOM RUSH");
        stage.setScene(scene);
        stage.show();
    }
}
