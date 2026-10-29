package semester1.practice08.block3;

public class EnchantedSword extends Weapon {
    private String element;
    private int magicPower;
    private int enchantmentLevel;

    public EnchantedSword(String title, int baseDamage, String element, int magicPower, int enchantmentLevel) {
        super(title, baseDamage);
        this.element = element;
        this.magicPower = magicPower;
        this.enchantmentLevel = enchantmentLevel;
    }

    @Override
    public int calculateDamage() {
        return super.calculateDamage() + magicPower * enchantmentLevel;
    }

    @Override
    public String toString() {
        int magicDamage = magicPower * enchantmentLevel;
        return "EnchantedSword{title='" + getTitle() + "', element=" + element
                + ", фізична шкода=" + getBaseDamage() + ", магічна шкода=" + magicDamage
                + " (" + magicPower + " x " + enchantmentLevel + "), всього=" + calculateDamage() + "}";
    }
}
