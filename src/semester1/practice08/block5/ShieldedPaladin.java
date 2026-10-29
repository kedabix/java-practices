package semester1.practice08.block5;

public class ShieldedPaladin extends CharacterUnit {
    private int shieldPoints;

    public ShieldedPaladin(String name, int maxHp, int armor, int shieldPoints) {
        super(name, maxHp, armor);
        this.shieldPoints = shieldPoints;
    }

    // Спочатку шкоду поглинає щит, залишок (якщо щит пробито) іде у HP
    @Override
    public void takeDamage(int rawDamage) {
        if (shieldPoints >= rawDamage) {
            shieldPoints -= rawDamage;
        } else {
            int remainingDamage = rawDamage - shieldPoints;
            shieldPoints = 0;
            super.takeDamage(remainingDamage);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Щит: " + shieldPoints;
    }
}
