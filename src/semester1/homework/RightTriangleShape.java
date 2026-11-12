package semester1.homework;

import java.util.Locale;

/** Прямокутний трикутник (за двома катетами): масштабується і обертається. */
public class RightTriangleShape extends AbstractShape2D implements Scalable2D, Rotatable2D {

    private double legA;
    private double legB;
    private double rotationAngle;

    public RightTriangleShape(String name, double centerX, double centerY, double legA, double legB) {
        super(name, centerX, centerY);
        if (legA <= 0 || legB <= 0) {
            throw new IllegalArgumentException("Катети мають бути > 0");
        }
        this.legA = legA;
        this.legB = legB;
    }

    @Override
    public double getArea() {
        return 0.5 * legA * legB;
    }

    @Override
    public double getPerimeter() {
        return legA + legB + Math.hypot(legA, legB);
    }

    @Override
    public void scale(double factor) {
        double k = Math.max(factor, MIN_SCALE_FACTOR);
        legA *= k;
        legB *= k;
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
        return String.format(Locale.US, "legs=%.2fx%.2f, angle=%.1f°", legA, legB, rotationAngle);
    }
}
