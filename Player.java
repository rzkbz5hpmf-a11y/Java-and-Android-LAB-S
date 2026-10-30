public class Player {
    private int level;
    private int damage;
    private String weapon;

    public Player(int level, int damage, String weapon) {
        this.level = level;
        this.damage = damage;
        this.weapon = weapon;
    }

    public Player(int level, int damage) {
        this.level = level;
        this.damage = damage;
        this.weapon = "Без оружия";
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public String getWeapon() {
        return weapon;
    }
}
