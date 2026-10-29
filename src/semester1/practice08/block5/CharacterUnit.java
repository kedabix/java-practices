package semester1.practice08.block5;

public class CharacterUnit {
    private String name;
    protected int hp;
    protected int maxHp;
    protected int armor;

    public CharacterUnit(String name, int maxHp, int armor) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    // Шкода зменшується бронею, але не менше 1
    public void takeDamage(int rawDamage) {
        int damage = Math.max(1, rawDamage - armor);
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    // Смужка здоров'я з 10 клітинок
    protected String healthBar() {
        int filled = hp * 10 / maxHp;
        String bar = "[";
        for (int i = 0; i < 10; i++) {
            if (i < filled) {
                bar += "█";
            } else {
                bar += "░";
            }
        }
        return bar + "]";
    }

    @Override
    public String toString() {
        return name + " " + healthBar() + " " + hp + "/" + maxHp + " HP, броня " + armor;
    }
}
