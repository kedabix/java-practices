package semester1.practice08.block4;

public class StrengthHero extends DotaHero {
    private int strength;

    public StrengthHero(String name, int baseHp, int strength) {
        super(name, "Strength", baseHp);
        this.strength = strength;
    }

    // Кожна одиниця сили додає +22 HP
    @Override
    public int getMaxHp() {
        return super.getMaxHp() + strength * 22;
    }

    @Override
    public String toString() {
        return super.toString() + " -> StrengthHero{strength=" + strength + "}";
    }
}
