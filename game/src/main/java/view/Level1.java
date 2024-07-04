package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.map.Coordinate;
import model.map.MapLevel1;

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
    private ImageView board_upgrade;

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
    private Label lbl_upgrade;

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
    private MapLevel1 map;

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
        img_barracks.setVisible(false);
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
            checkCoin();
        }
        setRingCoordinate(map.find(new Coordinate(event.getSceneX(), event.getSceneY())));
    }
    private void setRingCoordinate(Coordinate coordinate){
        img_ring.setX(coordinate.getX() - 70);
        img_ring.setY(coordinate.getY()-92);
        img_archer.setX(coordinate.getX() - 73);
        img_archer.setY(coordinate.getY() - 92);
        img_barracks.setX(coordinate.getX() + 42);
        img_barracks.setY(coordinate.getY() - 92);
        img_wizard.setX(coordinate.getX() - 73);
        img_wizard.setY(coordinate.getY() + 10);
        img_artillery.setX(coordinate.getX() + 42);
        img_artillery.setY(coordinate.getY() + 10);
        lbl_archer.setLayoutX(coordinate.getX() - 59);
        lbl_archer.setLayoutY(coordinate.getY() - 61);
        lbl_barracks.setLayoutX(coordinate.getX() + 57);
        lbl_barracks.setLayoutY(coordinate.getY() - 61);
        lbl_wizard.setLayoutX(coordinate.getX() - 59);
        lbl_wizard.setLayoutY(coordinate.getY() + 39);
        lbl_artillery.setLayoutX(coordinate.getX() + 53);
        lbl_artillery.setLayoutY(coordinate.getY() + 39);
        board_archer.setX(coordinate.getX() - 65);
        board_archer.setY(coordinate.getY() - 61);
        board_shield.setX(coordinate.getX() + 50);
        board_shield.setY(coordinate.getY() - 61);
        board_wizard.setX(coordinate.getX() - 65);
        board_wizard.setY(coordinate.getY() + 39);
        board_artillery.setX(coordinate.getX() + 50);
        board_artillery.setY(coordinate.getY() + 39);
        img_sell.setX(coordinate.getX() - 12);
        img_sell.setY(coordinate.getY() + 34);
        img_upgrade.setX(coordinate.getX() - 18);
        img_upgrade.setY(coordinate.getY() - 112);
        lbl_upgrade.setLayoutX(coordinate.getX() - 7);
        lbl_upgrade.setLayoutY(coordinate.getY() - 81);
        board_upgrade.setLayoutX(coordinate.getX() - 10);
        board_upgrade.setLayoutY(coordinate.getY() - 81);
    }
    private void checkCoin(){
        if(map.getCoin() < 70){
            img_artillery.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayBomb.png")).toExternalForm()));
            img_wizard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayWizard.png")).toExternalForm()));
            img_barracks.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayShield.png")).toExternalForm()));
            img_archer.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayArcher.png")).toExternalForm()));
        }
        else if(map.getCoin() < 90){
            img_artillery.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayBomb.png")).toExternalForm()));
            img_wizard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayWizard.png")).toExternalForm()));
            img_barracks.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/shield.png")).toExternalForm()));
            img_archer.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/archer.png")).toExternalForm()));
        }
        else if(map.getCoin() < 112){
            img_artillery.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayBomb.png")).toExternalForm()));
            img_wizard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/wizardTower-hd.png")).toExternalForm()));
            img_barracks.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/shield.png")).toExternalForm()));
            img_archer.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/archer.png")).toExternalForm()));
        }
        else {
            img_artillery.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/bomb.png")).toExternalForm()));
            img_wizard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/wizardTower-hd.png")).toExternalForm()));
            img_barracks.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/shield.png")).toExternalForm()));
            img_archer.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/archer.png")).toExternalForm()));
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
        map = new MapLevel1();
        lbl_coin.setText(String.valueOf(map.getCoin()));
        lbl_wave.setText("wave 0/" + map.getWave());
    }
}
