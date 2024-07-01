package model;

import java.util.ArrayList;

public class Player {
    private int ID;
    private String username;
    private String password;
    private int level;
    private long diamond;
    private Backpack backpack;

    public Player(int ID, String username, String password, int level, long diamond, Backpack backpack) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.level = level;
        this.diamond = diamond;
        this.backpack = backpack;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }

    public long getDiamond() {
        return diamond;
    }

    public Backpack getBackpack() {
        return backpack;
    }
}
