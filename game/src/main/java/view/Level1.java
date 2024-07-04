package view;

import controller.PlayerController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.map.Coordinate;
import model.map.MapLevel1;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
    private ImageView img_tower1;

    @FXML
    private ImageView img_tower2;

    @FXML
    private ImageView img_tower3;

    @FXML
    private ImageView img_tower4;

    @FXML
    private ImageView img_tower5;

    @FXML
    private ImageView img_tower6;

    @FXML
    private ImageView img_tower7;

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
    private ImageView img_health;

    @FXML
    private ImageView img_goldBag;

    @FXML
    private ImageView img_freeze;

    @FXML
    private ImageView img_littleBoy;

    @FXML
    private ImageView img_line;

    @FXML
    private ImageView img_ring;

    @FXML
    private ImageView img_start;

    @FXML
    private ImageView board_pause;

    @FXML
    private ImageView img_exit;

    @FXML
    private ImageView img_quit;

    @FXML
    private ImageView img_restart;

    @FXML
    private Label lbl_quit;

    @FXML
    private ImageView img_music;

    @FXML
    private Label lbl_restart;
    private boolean isBackpackOpen;
    private MapLevel1 map;
    private Map<Coordinate,ImageView> towers;
    private Coordinate coordinate;
    private boolean ringOpen;
    private boolean archer;
    private boolean wizard;
    private boolean barracks;
    private boolean artillery;

    @FXML
    void backpack(MouseEvent event) {
        if(isBackpackOpen){
            img_line.setVisible(false);
            img_freeze.setVisible(false);
            img_littleBoy.setVisible(false);
            img_health.setVisible(false);
            img_goldBag.setVisible(false);
            lbl_bombNumber.setVisible(false);
            lbl_coinNumber.setVisible(false);
            lbl_freezeNumber.setVisible(false);
            lbl_heartNumber.setVisible(false);
            img_backpack.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/backpack.png")).toExternalForm()));
            isBackpackOpen = false;
        }
        else {
            img_line.setVisible(true);
            img_freeze.setVisible(true);
            img_littleBoy.setVisible(true);
            img_health.setVisible(true);
            img_goldBag.setVisible(true);
            lbl_bombNumber.setVisible(true);
            lbl_coinNumber.setVisible(true);
            lbl_freezeNumber.setVisible(true);
            lbl_heartNumber.setVisible(true);
            img_backpack.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/backpack2.png")).toExternalForm()));
            isBackpackOpen = true;
        }
    }

    @FXML
    void showAndCloseRing(MouseEvent event) {
        coordinate = map.find(new Coordinate(event.getSceneX(), event.getSceneY()));
        if(!ringOpen){
            if (towers.get(coordinate).isVisible()) {
                img_ring.setVisible(true);
                img_upgrade.setVisible(true);
                img_sell.setVisible(true);
            } else {
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
            setRingCoordinate();
            ringOpen = true;
        }
        else{
            closeRing();
        }
    }
    private void setRingCoordinate(){
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
            archer = false;
            wizard = false;
            artillery = false;
            barracks = false;
        }
        else if(map.getCoin() < 90){
            img_artillery.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayBomb.png")).toExternalForm()));
            img_wizard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayWizard.png")).toExternalForm()));
            img_barracks.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/shield.png")).toExternalForm()));
            img_archer.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/archer.png")).toExternalForm()));
            archer = true;
            wizard = false;
            artillery = true;
            barracks = false;
        }
        else if(map.getCoin() < 112){
            img_artillery.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayBomb.png")).toExternalForm()));
            img_wizard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/wizardTower-hd.png")).toExternalForm()));
            img_barracks.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/shield.png")).toExternalForm()));
            img_archer.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/archer.png")).toExternalForm()));
            archer = true;
            wizard = true;
            artillery = true;
            barracks = false;
        }
        else {
            img_artillery.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/bomb.png")).toExternalForm()));
            img_wizard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/wizardTower-hd.png")).toExternalForm()));
            img_barracks.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/shield.png")).toExternalForm()));
            img_archer.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/archer.png")).toExternalForm()));
            archer = true;
            wizard = true;
            artillery = true;
            barracks = true;
        }
    }
    void closeRing() {
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
        ringOpen = false;
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

    @FXML
    void buildArcher(MouseEvent event) {
        if(archer){
            ImageView imageView = towers.get(coordinate);
            imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/tower/archer.png")).toExternalForm()));
            imageView.setVisible(true);
            map.setCoin(map.getCoin() - 70);
            new Thread(() -> {
                Platform.runLater(() -> {
                    lbl_coin.setText(String.valueOf(map.getCoin()));
                });
            }).start();
            closeRing();
        }
    }

    @FXML
    void buildArtillery(MouseEvent event) {
        if(artillery){
            ImageView imageView = towers.get(coordinate);
            imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/tower/BigBertha.png")).toExternalForm()));
            imageView.setVisible(true);
            map.setCoin(map.getCoin() - 112);
            new Thread(() -> {
                Platform.runLater(() -> {
                    lbl_coin.setText(String.valueOf(map.getCoin()));
                });
            }).start();
            closeRing();
        }
    }

    @FXML
    void buildBarracks(MouseEvent event) {
        if(barracks){
            ImageView imageView = towers.get(coordinate);
            imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/tower/barracks.png")).toExternalForm()));
            imageView.setVisible(true);
            map.setCoin(map.getCoin() - 70);
            new Thread(() -> {
                Platform.runLater(() -> {
                    lbl_coin.setText(String.valueOf(map.getCoin()));
                });
            }).start();
            closeRing();
        }
    }

    @FXML
    void buildWizard(MouseEvent event) {
        if(wizard){
            ImageView imageView = towers.get(coordinate);
            imageView.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/tower/mage.png")).toExternalForm()));
            imageView.setVisible(true);
            map.setCoin(map.getCoin() - 90);
            new Thread(() -> {
                Platform.runLater(() -> {
                    lbl_coin.setText(String.valueOf(map.getCoin()));
                });
            }).start();
            closeRing();
        }
    }

    @FXML
    void start(MouseEvent event) {

    }

    @FXML
    void pause(MouseEvent event) {
        if(View.getView().isMusic()){
            img_music.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/musicOn.png")).toExternalForm()));
            img_music.setFitWidth(50);
        }
        else{
            img_music.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/musicOFF.png")).toExternalForm()));
            img_music.setFitWidth(55);
        }
        img_restart.setVisible(true);
        img_quit.setVisible(true);
        img_music.setVisible(true);
        img_exit.setVisible(true);
        board_pause.setVisible(true);
        lbl_restart.setVisible(true);
        lbl_quit.setVisible(true);
    }

    @FXML
    void music(MouseEvent event) {
        if(!View.getView().isMusic()){
            View.getView().getMediaPlayer().pause();
            View.getView().setMediaPlayer(new MediaPlayer(new Media(Objects.requireNonNull(HelloApplication.class.getResource("sound/64bd63ab01192d69e1229f3b_8459257530528737799.mp4")).toExternalForm())));
            View.getView().getMediaPlayer().play();
            View.getView().setMusic(true);
            img_music.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/musicOn.png")).toExternalForm()));
            img_music.setFitWidth(50);
        }
        else{
            View.getView().getMediaPlayer().pause();
            View.getView().setMusic(false);
            img_music.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/musicOFF.png")).toExternalForm()));
            img_music.setFitWidth(55);
        }
    }

    @FXML
    void exit(MouseEvent event) {
        img_restart.setVisible(false);
        img_quit.setVisible(false);
        img_music.setVisible(false);
        img_exit.setVisible(false);
        board_pause.setVisible(false);
        lbl_restart.setVisible(false);
        lbl_quit.setVisible(false);
    }

    @FXML
    void quit(MouseEvent event) throws IOException {
        View.getView().show("mainPage.fxml");
    }

    @FXML
    void restart(MouseEvent event) throws IOException {
        View.getView().show("level1.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isBackpackOpen = false;
        ringOpen = false;
        map = new MapLevel1();
        towers = new HashMap<>();

        lbl_coin.setText(String.valueOf(map.getCoin()));
        lbl_wave.setText("wave 0/" + map.getWave());
        lbl_heartNumber.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getHealth()));
        lbl_freezeNumber.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getFreeze()));
        lbl_coinNumber.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getCoin()));
        lbl_bombNumber.setText(String.valueOf(PlayerController.getPlayerController().getPlayer().getBackpack().getLittleBoy()));

        towers.put(map.getTowersCoordinate().getFirst(), img_tower);
        towers.put(map.getTowersCoordinate().get(1), img_tower2);
        towers.put(map.getTowersCoordinate().get(2), img_tower1);
        towers.put(map.getTowersCoordinate().get(3), img_tower3);
        towers.put(map.getTowersCoordinate().get(4), img_tower4);
        towers.put(map.getTowersCoordinate().get(5), img_tower5);
        towers.put(map.getTowersCoordinate().get(6), img_tower7);
        towers.put(map.getTowersCoordinate().get(7), img_tower6);

        if(View.getView().isMusic()) {
            View.getView().getMediaPlayer().pause();
            View.getView().setMediaPlayer(new MediaPlayer(new Media(Objects.requireNonNull(HelloApplication.class.getResource("sound/64bd63ab01192d69e1229f3b_8459257530528737799.mp4")).toExternalForm())));
            View.getView().getMediaPlayer().play();
            View.getView().getMediaPlayer().setCycleCount(50);
        }
    }
}
