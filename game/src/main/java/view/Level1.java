package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Level1 implements Initializable {

    @FXML
    private ImageView board_shield;

    @FXML
    private ImageView board_archer;

    @FXML
    private ImageView board_artillery;

    @FXML
    private ImageView board_wizard;

    @FXML
    private ImageView img_archer;

    @FXML
    private ImageView img_artillery;

    @FXML
    private ImageView img_barracks;

    @FXML
    private ImageView img_tower;

    @FXML
    private ImageView img_upgrade;

    @FXML
    private ImageView img_wizard;

    @FXML
    private Label lbl_archer;

    @FXML
    private Label lbl_artillery;

    @FXML
    private Label lbl_barracks;

    @FXML
    private Label lbl_bombNumber;

    @FXML
    private Label lbl_coin;

    @FXML
    private Label lbl_coinNumber;

    @FXML
    private Label lbl_freezeNumber;

    @FXML
    private Label lbl_heart;

    @FXML
    private Label lbl_heartNumber;

    @FXML
    private Label lbl_wave;

    @FXML
    private Label lbl_wizard;

    @FXML
    private ImageView img_sell;

    @FXML
    private ImageView img_backpack;

    @FXML
    private ImageView img_line;

    @FXML
    private ImageView img_ring;
    private boolean isBackpackOpen;

    @FXML
    void backpack(MouseEvent event) {
        if(isBackpackOpen){
            img_line.setVisible(false);
            lbl_bombNumber.setVisible(false);
            lbl_coinNumber.setVisible(false);
            lbl_freezeNumber.setVisible(false);
            lbl_heartNumber.setVisible(false);
            img_backpack.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/backpack.png")).toExternalForm()));
            isBackpackOpen = false;
        }
        else {
            img_line.setVisible(true);
            lbl_bombNumber.setVisible(true);
            lbl_coinNumber.setVisible(true);
            lbl_freezeNumber.setVisible(true);
            lbl_heartNumber.setVisible(true);
            img_backpack.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/backpack2.png")).toExternalForm()));
            isBackpackOpen = true;
        }
    }

    @FXML
    void closeRing(MouseEvent event) {
        img_ring.setVisible(false);
        img_backpack.setVisible(false);
        img_archer.setVisible(false);
        img_artillery.setVisible(false);
        img_wizard.setVisible(false);
        board_archer.setVisible(false);
        board_shield.setVisible(false);
        board_artillery.setVisible(false);
        board_wizard.setVisible(false);
        lbl_archer.setVisible(false);
        lbl_artillery.setVisible(false);
        lbl_barracks.setVisible(false);
        lbl_wizard.setVisible(false);
        img_upgrade.setVisible(false);
        img_sell.setVisible(false);
    }

    @FXML
    void showRing(MouseEvent event) {
        if(img_tower.isVisible()){
            img_ring.setVisible(true);
            img_upgrade.setVisible(true);
            img_sell.setVisible(true);
        }
        else{
            img_ring.setVisible(true);
            img_barracks.setVisible(true);
            img_archer.setVisible(true);
            img_artillery.setVisible(true);
            img_wizard.setVisible(true);
            board_archer.setVisible(true);
            board_shield.setVisible(true);
            board_artillery.setVisible(true);
            board_wizard.setVisible(true);
            lbl_archer.setVisible(true);
            lbl_artillery.setVisible(true);
            lbl_barracks.setVisible(true);
            lbl_wizard.setVisible(true);
            //check coin
        }
    }
    @FXML
    void sell(MouseEvent event) {
    }

    @FXML
    void coin(MouseEvent event) {

    }

    @FXML
    void freeze(MouseEvent event) {

    }

    @FXML
    void health(MouseEvent event) {

    }

    @FXML
    void bomb(MouseEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isBackpackOpen = false;
    }
}
