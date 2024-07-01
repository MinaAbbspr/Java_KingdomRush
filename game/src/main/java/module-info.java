module view.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens view to javafx.fxml;
    exports view;
}