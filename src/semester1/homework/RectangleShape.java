package semester1.homework;

import java.util.Locale;

/** Прямокутник: підтримує і масштабування, і обертання. */
public class RectangleShape extends AbstractShape2D implements Scalable2D, Rotatable2D {

    private double width;
    private double height;
    private double rotationAngle;

    public RectangleShape(String name, double centerX, double centerY, double width, double height) {
        super(name, centerX, centerY);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Сторони мають бути > 0");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void scale(double factor) {
        double k = Math.max(factor, MIN_SCALE_FACTOR);
        width *= k;
        height *= k;
    }

    @Override
    public void rotate(double deltaDegrees) {
        rotationAngle = ((rotationAngle + deltaDegrees) % 360 + 360) % 360;
    }

    @Override
    public double getRotationAngle() {
        return rotationAngle;
    }

    @Override
    public String getDimensionsInfo() {
        return String.format(Locale.US, "%.2fx%.2f, angle=%.1f°", width, height, rotationAngle);
    }
}
