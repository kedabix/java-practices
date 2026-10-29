package semester1.practice08.block4;

public class AlchemistHero extends StrengthHero {
    private int greevilsGreedBonusGold;

    public AlchemistHero(int baseHp, int strength, int greevilsGreedBonusGold) {
        super("Alchemist", baseHp, strength);
        this.greevilsGreedBonusGold = greevilsGreedBonusGold;
    }

    public String chemicalRage() {
        return "Alchemist вмикає Chemical Rage! Швидкість атаки зростає, HP відновлюється швидше!";
    }

    @Override
    public String toString() {
        return super.toString() + " -> AlchemistHero{greevilsGreedBonusGold=" + greevilsGreedBonusGold + "}";
    }
}
