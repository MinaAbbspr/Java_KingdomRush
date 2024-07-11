package model.map;

public class Wave {
    private final int number;
    private final String kind;

    public Wave(int number, String kind) {
        this.number = number;
        this.kind = kind;
    }

    public int getNumber() {
        return number;
    }

    public String getKind() {
        return kind;
    }
}
