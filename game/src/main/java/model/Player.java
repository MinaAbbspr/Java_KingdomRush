package model;

import java.util.ArrayList;

public class Player {
    private int ID;
    private String username;
    private String password;
    private int level;
    private long diamond;
    private ArrayList<String> backpack;

    public Player(int ID, String username, String password, int level, long diamond) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.level = level;
        this.diamond = diamond;
        this.backpack = new ArrayList<>();

    }
}
