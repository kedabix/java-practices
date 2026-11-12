package semester1.homework;

import java.util.Locale;

/** Базовий клас (IS-A) для всіх двовимірних фігур. */
public abstract class AbstractShape2D {

    private final String name;
    private double centerX;
    private double centerY;

    protected AbstractShape2D(String name, double centerX, double centerY) {
        this.name = name;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    /** Короткий опис розмірів фігури (наприклад, "r=5.00"). */
    public abstract String getDimensionsInfo();

    /**
     * Коефіцієнт компактності Q = 4*pi*S / P^2.
     * Для кола Q = 1, для квадрата Q = pi/4. Метод final — перевизначати заборонено.
     */
    public final double getIsoperimetricQuotient() {
        double p = getPerimeter();
        return 4 * Math.PI * getArea() / (p * p);
    }

    public String getName() {
        return name;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "%s['%s', center=(%.1f; %.1f), %s | S=%.2f, P=%.2f, Q=%.4f]",
                getClass().getSimpleName(), name, centerX, centerY, getDimensionsInfo(),
                getArea(), getPerimeter(), getIsoperimetricQuotient());
    }
}
