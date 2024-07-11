package view;

import controller.PlayerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginSignup implements Initializable {

    @FXML
    private Label lbl_errorL;

    @FXML
    private Label lbl_errorS;


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
        txt_usernameL.setText("");
        txt_passwordL.setText("");
        lbl_errorL.setVisible(false);
        vBox_login.setVisible(true);
        vBox_signup.setVisible(false);
    }

    @FXML
    void Signup(MouseEvent event) {
        txt_usernameS.setText("");
        txt_passwordS1.setText("");
        txt_passwordS2.setText("");
        lbl_errorS.setVisible(false);
        vBox_login.setVisible(false);
        vBox_signup.setVisible(true);
    }

    @FXML
    void exit(MouseEvent event) throws IOException {
        View.getView().show("start.fxml");
    }

    @FXML
    void submitLogin(MouseEvent event) {
        try {
            PlayerController.getPlayerController().Login(txt_usernameL.getText(),txt_passwordL.getText());
            View.getView().show("mainPage.fxml");
        } catch (Exception e) {
            lbl_errorL.setText(e.getMessage());
            lbl_errorL.setVisible(true);
        }
    }

    @FXML
    void submitSignup(MouseEvent event) {
        try {
            PlayerController.getPlayerController().Signup(txt_usernameS.getText(),txt_passwordS1.getText(),txt_passwordS2.getText());
            View.getView().show("mainPage.fxml");
        } catch (Exception e) {
            lbl_errorS.setText(e.getMessage());
            lbl_errorS.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBox_login.setVisible(true);
        vBox_signup.setVisible(false);
    }
}