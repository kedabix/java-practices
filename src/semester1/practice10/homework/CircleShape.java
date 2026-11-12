package semester1.practice10.homework;

import semester1.practice10.homework.AbstractShape2D;
import semester1.practice10.homework.Scalable2D;

import java.util.Locale;

/** Коло: масштабується, але обертання навколо центра нічого не змінює. */
public class CircleShape extends AbstractShape2D implements Scalable2D {

    private double radius;

    public CircleShape(String name, double centerX, double centerY, double radius) {
        super(name, centerX, centerY);
        if (radius <= 0) {
            throw new IllegalArgumentException("Радіус має бути > 0");
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void scale(double factor) {
        radius *= Math.max(factor, MIN_SCALE_FACTOR);
    }

    @Override
    public String getDimensionsInfo() {
        return String.format(Locale.US, "r=%.2f", radius);
    }
}
