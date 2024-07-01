package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginSignup implements Initializable {

    @FXML
    private PasswordField txt_passwordL;

    @FXML
    private PasswordField txt_passwordS1;

    @FXML
    private PasswordField txt_passwordS2;

    @FXML
    private TextField txt_usernameL;

    @FXML
    private TextField txt_usernameS;

    @FXML
    private VBox vBox_login;

    @FXML
    private VBox vBox_signup;

    @FXML
    void Login(MouseEvent event) {
        vBox_login.setVisible(true);
        vBox_signup.setVisible(false);
    }

    @FXML
    void Signup(MouseEvent event) {
        vBox_login.setVisible(false);
        vBox_signup.setVisible(true);
    }

    @FXML
    void exit(MouseEvent event) throws IOException {
        View.getView().show("start.fxml");
    }

    @FXML
    void submitLogin(MouseEvent event) {

    }

    @FXML
    void submitSignup(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBox_login.setVisible(true);
        vBox_signup.setVisible(false);
    }
}