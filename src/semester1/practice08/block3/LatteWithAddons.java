package semester1.practice08.block3;

import java.util.Locale;

public class LatteWithAddons extends Coffee {
    private String milkType;
    private int syrupPumps;

    public LatteWithAddons(String roastType, int volumeMl, double basePrice, String milkType, int syrupPumps) {
        super(roastType, volumeMl, basePrice);
        this.milkType = milkType;
        this.syrupPumps = syrupPumps;
    }

    private boolean isPlantMilk() {
        return milkType.equals("Рослинне");
    }

    // Молоко ~0.45 ккал/мл (звичайне) або 0.3 ккал/мл (рослинне), сироп 20 ккал за натискання
    @Override
    public double getCalories() {
        double milkCalories;
        if (isPlantMilk()) {
            milkCalories = getVolumeMl() * 0.3;
        } else {
            milkCalories = getVolumeMl() * 0.45;
        }
        return super.getCalories() + milkCalories + syrupPumps * 20;
    }

    // Рослинне молоко +20 грн, кожне натискання сиропу +12 грн
    @Override
    public double getPrice() {
        double price = super.getPrice();
        if (isPlantMilk()) {
            price += 20;
        }
        return price + syrupPumps * 12;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "===== ЧЕК КАВ'ЯРНІ =====%nЛате на основі кави: %s, %d мл%nМолоко: %s%nСироп (натискань): %d%nКалорійність: %.0f ккал%nДо сплати: %.2f грн%n=======================",
                getRoastType(), getVolumeMl(), milkType, syrupPumps, getCalories(), getPrice());
    }
}
