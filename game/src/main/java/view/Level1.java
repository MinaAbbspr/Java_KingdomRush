package view;

import controller.PlayerController;
import controller.raider.*;
import controller.tower.*;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.Tower.*;
import model.map.Coordinate;
import model.map.MapLevel1;
import model.map.Wave;
import model.raidar.Bird;
import model.raidar.MotherTroll;
import model.raidar.ShieldTroll;
import model.spell.Bomb;
import model.spell.Coin;
import model.spell.Heart;

import java.io.IOException;
import java.net.URL;
import java.util.*;

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

    @FXML
    private AnchorPane root;
    private MapLevel1 map;
    private TowerController tower;
    private Map<Coordinate,ImageView> towers;
    private ArrayList<TowerController> towerController;
    private ArrayList<RaiderController> enemies;
    private Coordinate coordinate;
    private boolean isBackpackOpen;
    private boolean ringOpen;
    private boolean archer;
    private boolean wizard;
    private boolean barracks;
    private boolean artillery;
    private boolean upgrade;
    private int wave;

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
                lbl_upgrade.setVisible(true);
                board_upgrade.setVisible(true);
                checkCoinForUpdate();
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
    private void checkCoinForUpdate(){
        findTower();
        lbl_upgrade.setText(String.valueOf(tower.getTower().getUpdateCost()));
        if(tower.getTower().getLevel() == map.getLevel()){
            img_upgrade.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayUpgrade.png")).toExternalForm()));
            upgrade = false;
            lbl_upgrade.setVisible(false);
            board_upgrade.setVisible(false);
        }
        else if(tower.getTower().getUpdateCost() > map.getCoin()){
            img_upgrade.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayUpgrade.png")).toExternalForm()));
            upgrade = false;
        }
        else {
            img_upgrade.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/upgrade.png")).toExternalForm()));
            upgrade = true;
        }
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
            artillery = false;
            barracks = true;
        }
        else if(map.getCoin() < 112){
            img_artillery.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/grayBomb.png")).toExternalForm()));
            img_wizard.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/wizardTower-hd.png")).toExternalForm()));
            img_barracks.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/shield.png")).toExternalForm()));
            img_archer.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/icon/archer.png")).toExternalForm()));
            archer = true;
            wizard = true;
            artillery = false;
            barracks = true;
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
    private void closeRing() {
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
        lbl_upgrade.setVisible(false);
        board_upgrade.setVisible(false);
        ringOpen = false;
    }
    private void findTower(){
        for (TowerController tower1 : towerController) {
            if (tower1.getTower().getCoordinate().equals(coordinate)) {
                this.tower = tower1;
                break;
            }
        }
    }

    @FXML
    void sell(MouseEvent event) {
        tower.getTower().setLevel(tower.getTower().getLevel() - 1);
        map.setCoin(map.getCoin() + tower.getTower().getUpdateCost()/2);
        lbl_coin.setText(String.valueOf(map.getCoin()));
        towerController.remove(tower);
        towers.get(coordinate).setVisible(false);
        tower.clear();
        closeRing();
    }

    @FXML
    void upgrade(MouseEvent event) {
        if(upgrade){
            map.setCoin(map.getCoin() - tower.getTower().getUpdateCost());
            lbl_coin.setText(String.valueOf(map.getCoin()));
            tower.updateLevel();
            towers.get(coordinate).setImage(new Image(tower.setImage()));
            closeRing();
        }
    }

    @FXML
    void coin(MouseEvent event) {
        if(PlayerController.getPlayerController().getPlayer().getBackpack().getCoin() > 0){
            PlayerController.getPlayerController().getPlayer().getBackpack().subtractCoin();
            Coin coin = new Coin();
            coin.drop(map);
            lbl_coin.setText(String.valueOf(map.getCoin()));
        }
    }

    @FXML
    void freeze(MouseEvent event) {

    }

    @FXML
    void health(MouseEvent event) {
        if(PlayerController.getPlayerController().getPlayer().getBackpack().getHealth() > 0){
            PlayerController.getPlayerController().getPlayer().getBackpack().subtractHealth();
            Heart heart = new Heart();
            heart.drop(map);
            lbl_heart.setText(String.valueOf(map.getHealth()));
        }
    }

    @FXML
    void bomb(MouseEvent event) {
        if(PlayerController.getPlayerController().getPlayer().getBackpack().getLittleBoy() > 0){
            PlayerController.getPlayerController().getPlayer().getBackpack().subtractLittleBoy();
            Bomb bomb = new Bomb();
            bomb.drop(enemies);
            lbl_coin.setText(String.valueOf(map.getCoin()));
        }
    }

    @FXML
    void buildArcher(MouseEvent event) {
        if(archer){
            ImageView imageView = towers.get(coordinate);
            imageView.setVisible(true);
            map.setCoin(map.getCoin() - 70);
            lbl_coin.setText(String.valueOf(map.getCoin()));
            closeRing();
            towerController.add(new ArcherController(new Archer(coordinate)));
            imageView.setImage(new Image(towerController.getLast().setImage()));
        }
    }

    @FXML
    void buildArtillery(MouseEvent event) {
        if(artillery){
            ImageView imageView = towers.get(coordinate);
            imageView.setVisible(true);
            map.setCoin(map.getCoin() - 112);
            lbl_coin.setText(String.valueOf(map.getCoin()));
            closeRing();
            towerController.add(new ArtilleryController(new Artillery(coordinate)));
            imageView.setImage(new Image(towerController.getLast().setImage()));
        }
    }

    @FXML
    void buildBarracks(MouseEvent event) {
        if(barracks){
            ImageView imageView = towers.get(coordinate);
            imageView.setVisible(true);
            map.setCoin(map.getCoin() - 70);
            lbl_coin.setText(String.valueOf(map.getCoin()));
            closeRing();
            towerController.add(new BarracksController(new Barracks(coordinate, map.getWay())));
            imageView.setImage(new Image(towerController.getLast().setImage()));
        }
    }

    @FXML
    void buildWizard(MouseEvent event) {
        if(wizard){
            ImageView imageView = towers.get(coordinate);
            imageView.setVisible(true);
            map.setCoin(map.getCoin() - 90);
            lbl_coin.setText(String.valueOf(map.getCoin()));
            closeRing();
            towerController.add(new WizardController(new Wizard(coordinate)));
            imageView.setImage(new Image(towerController.getLast().setImage()));
        }
    }

    @FXML
    void start(MouseEvent event) {
        timeLine(wave);
    }
    private void timeLine(int finalI){
        if(wave == map.getWave())
            return;
        Timeline time = new Timeline(
                new KeyFrame(
                        Duration.seconds(finalI * 30),
                        e -> {
                            img_start.setVisible(true);
                            FadeTransition FT = new FadeTransition();
                            FT.setNode(img_start);
                            FT.setDuration(Duration.seconds(0.5));
                            FT.setToValue(0.001);
                            FT.setAutoReverse(true);
                            FT.setCycleCount(7);
                            FT.play();
                            addWave(map.getWaves().get(finalI));
                        }),
                new KeyFrame(
                        Duration.seconds(finalI * 30 + 3.5),
                        e -> {
                            img_start.setVisible(false);
                            lbl_wave.setText("wave " + (finalI+1) + "/" + map.getWave());
                        })
        );
        time.play();
        run(false);
        timeLine(++wave);
    }
    private void addWave(Wave wave){
        addEnemy(wave.getNumber1(), wave.getKind1());
        addEnemy(wave.getNumber2(), wave.getKind2());
        addEnemy(wave.getNumber3(), wave.getKind3());
    }
    private void addEnemy(int number, String kind) {
        switch (kind){
            case "Bird" -> {
                for(int i=0; i<number; i++){
                    enemies.add(new BirdController(new Bird(map.getWay(), makeVBox(),map.getWay().getFirst())));
                    enemies.getLast().getRaider().getvBox().setLayoutY(map.getWay().getFirst().getY()-50);
                    enemies.getLast().getRaider().getvBox().setLayoutX(map.getWay().getFirst().getX());
                    root.getChildren().add(enemies.getLast().getRaider().getvBox());
                }
            }
            case "Troll" -> {
                for(int i=0; i<number; i++){
                    enemies.add(new TrollController(map.getWay(), makeVBox(),map.getWay().getFirst()));
                    enemies.getLast().getRaider().getvBox().setLayoutY(map.getWay().getFirst().getY()-50);
                    enemies.getLast().getRaider().getvBox().setLayoutX(map.getWay().getFirst().getX());
                    root.getChildren().add(enemies.getLast().getRaider().getvBox());
                }
            }
            case "Shield" -> {
                for(int i=0; i<number; i++){
                    enemies.add(new ShieldTrollController(new ShieldTroll(map.getWay(), makeVBox(),map.getWay().getFirst())));
                    enemies.getLast().getRaider().getvBox().setLayoutY(map.getWay().getFirst().getY()-50);
                    enemies.getLast().getRaider().getvBox().setLayoutX(map.getWay().getFirst().getX());
                    root.getChildren().add(enemies.getLast().getRaider().getvBox());
                }
            }
            case "Mother" ->{
                for(int i=0; i<number; i++){
                    enemies.add(new MotherTrollController(new MotherTroll(map.getWay(), makeVBox(),map.getWay().getFirst(),enemies)));
                    enemies.getLast().getRaider().getvBox().setLayoutY(map.getWay().getFirst().getY()-50);
                    enemies.getLast().getRaider().getvBox().setLayoutX(map.getWay().getFirst().getX());
                    root.getChildren().add(enemies.getLast().getRaider().getvBox());
                }
            }
        }
    }
    private VBox makeVBox(){
        ProgressBar progressBar = new ProgressBar(1.0);
        progressBar.setMaxHeight(15);
        progressBar.setMaxWidth(100);
        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(false);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        return new VBox(progressBar, imageView);
    }
    private void run(boolean end){
        if(end)
            return;
        double speed=2;
        if(!enemies.isEmpty())
            speed = (double)200/ enemies.getFirst().getRaider().getSpeed();
        for (int i = 0; i < enemies.size(); i++)
            if (!enemies.get(i).action()) {
                root.getChildren().remove(enemies.get(i).getRaider().getvBox());
                enemies.remove(enemies.get(i));
                i--;
                map.setHealth(map.getHealth()-1);
                lbl_heart.setText(String.valueOf(map.getHealth()));
                if (map.getHealth() == 0) {
                    //gameOver
                }
            }
        for(TowerController tower : towerController){
            tower.action(enemies);
        }
        lbl_coin.setText(String.valueOf(map.getCoin()));
        PauseTransition pause = new PauseTransition(Duration.seconds(speed));
        pause.setOnFinished(e -> run(enemies.isEmpty()));
        pause.play();
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
        wave = 0;
        map = new MapLevel1();
        towers = new HashMap<>();
        towerController = new ArrayList<>();
        enemies = new ArrayList<>();
        View.getView().setRoot(root);
        View.getView().setMap(map);

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
