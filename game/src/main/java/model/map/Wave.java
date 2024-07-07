package model.map;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.raidar.Raider;
import model.raidar.Troll;

import java.util.ArrayList;

public class Wave {
    private final int number1;
    private final int number2;
    private final int number3;
    private final String kind1;
    private final String kind2;
    private final String kind3;

    public Wave(int number1, int number2, int number3, String kind1, String kind2, String kind3) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.kind1 = kind1;
        this.kind2 = kind2;
        this.kind3 = kind3;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int getNumber3() {
        return number3;
    }

    public String getKind1() {
        return kind1;
    }

    public String getKind2() {
        return kind2;
    }

    public String getKind3() {
        return kind3;
    }
}
