package semester1.homework;

import java.util.Locale;

/** Еталонний штамп: final-клас, не масштабується, не обертається і не має нащадків. */
public final class ImmutableReferenceSquare extends AbstractShape2D {

    private final double side;

    public ImmutableReferenceSquare(String name, double centerX, double centerY, double side) {
        super(name, centerX, centerY);
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона має бути > 0");
        }
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String getDimensionsInfo() {
        return String.format(Locale.US, "side=%.2f", side);
    }
}
