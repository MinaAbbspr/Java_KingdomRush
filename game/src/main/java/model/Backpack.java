package model;

public class Backpack {
    private int health;
    private int freeze;
    private int coin;
    private int littleBoy;

    public Backpack(int health, int freeze, int coin, int littleBoy) {
        this.health = health;
        this.freeze = freeze;
        this.coin = coin;
        this.littleBoy = littleBoy;
    }

    public int getHealth() {
        return health;
    }

    public int getFreeze() {
        return freeze;
    }

    public int getCoin() {
        return coin;
    }

    public int getLittleBoy() {
        return littleBoy;
    }

    public void addHealth() {
        this.health++;
    }

    public void addFreeze() {
        this.freeze++;
    }

    public void addCoin() {
        this.coin++;
    }

    public void addLittleBoy() {
        this.littleBoy++;
    }
}
