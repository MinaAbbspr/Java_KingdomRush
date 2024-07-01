module view.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;


    opens view to javafx.fxml;
    exports view;
}