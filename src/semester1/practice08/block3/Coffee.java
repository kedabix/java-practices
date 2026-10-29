package semester1.practice08.block3;

import java.util.Locale;

public class Coffee {
    private String roastType;
    private int volumeMl;
    private double basePrice;

    public Coffee(String roastType, int volumeMl, double basePrice) {
        this.roastType = roastType;
        this.volumeMl = volumeMl;
        this.basePrice = basePrice;
    }

    public String getRoastType() {
        return roastType;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    // Чорна кава майже не має калорій: ~2 ккал на 100 мл
    public double getCalories() {
        return volumeMl / 100.0 * 2;
    }

    public double getPrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Кава (%s) %d мл | %.0f ккал | %.2f грн",
                roastType, volumeMl, getCalories(), getPrice());
    }
}
