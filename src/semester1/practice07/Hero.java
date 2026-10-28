package semester1.practice07;

public class Hero {
    private String name;
    private int health;
    private int attackPower;
    private int defense;

    public Hero(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    public void attack(Hero target) {
        int damage = this.attackPower - target.defense;
        if (damage <= 0) {
            damage = 1;
        }
        target.health -= damage;
        if (target.health < 0) {
            target.health = 0;
        }
        System.out.println(this.name + " б'є " + target.name + " на " + damage + " шкоди. У " + target.name
                + " залишилось " + target.health + " HP");
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return name;
    }
}
