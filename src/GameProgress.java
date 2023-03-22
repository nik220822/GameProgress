import java.io.Serializable;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int mana;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int mana, int weapons, int lvl, double distance) {
        this.health = health;
        this.mana = mana;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", mana=" + mana +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
}
