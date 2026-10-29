package semester1.practice08.block1;

import java.util.Locale;

public class Circle {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    // Інваріант: радіус завжди більший за 0
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1.0;
        }
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Circle{radius=%.2f, area=%.2f, circumference=%.2f}",
                radius, getArea(), getCircumference());
    }
}
