package semester1.practice08.block3;

public class Weapon {
    private String title;
    private int baseDamage;

    public Weapon(String title, int baseDamage) {
        this.title = title;
        this.baseDamage = baseDamage;
    }

    public String getTitle() {
        return title;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int calculateDamage() {
        return baseDamage;
    }

    @Override
    public String toString() {
        return "Weapon{title='" + title + "', damage=" + calculateDamage() + "}";
    }
}
