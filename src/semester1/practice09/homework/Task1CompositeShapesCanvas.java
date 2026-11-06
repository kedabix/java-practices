package semester1.practice09.homework;

import java.util.Locale;

/**
 * Домашня робота №9, Завдання 1 (2 бали): геометричне полотно.
 * Абстрактні 2D-фігури + композиція (HAS-A Point2D) + композиція масиву фігур.
 */
public class Task1CompositeShapesCanvas {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        GeometryCanvas canvas = new GeometryCanvas("Інженерне креслення №1", 5);
        canvas.addShape(new Circle2D("Коло-А", new Point2D(0, 0), 5));
        canvas.addShape(new Rectangle2D("Плита-Б", new Point2D(10, 5), 4, 6));
        canvas.addShape(new RightTriangle2D("Клин-В", new Point2D(-3, 2), 3, 4));

        System.out.println("================ ГЕОМЕТРИЧНЕ ПОЛОТНО (КОМПОЗИЦІЯ + ABSTRACT) ================");
        System.out.println(canvas);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("Сумарна площа креслення:    %.2f кв.од.%n", canvas.getTotalArea());
        System.out.printf("Сумарний периметр:          %.2f од.%n", canvas.getTotalPerimeter());
        AbstractShape2D largest = canvas.findLargestShape();
        System.out.printf("Найбільша фігура:           %s (S = %.2f)%n", largest.getName(), largest.getArea());

        // Перевірка захисного копіювання Point2D
        Point2D original = new Point2D(1, 1);
        Circle2D guarded = new Circle2D("Тест", original, 1);
        original.translate(100, 100);               // зміна вихідної точки ззовні
        guarded.getAnchorPoint().translate(50, 50); // зміна копії, отриманої через геттер
        System.out.println("Захисне копіювання: центр фігури 'Тест' = " + guarded.getAnchorPoint()
                + " (очікується (1.00; 1.00))");

        System.out.println("-> Переміщуємо всі фігури полотна на вектор (+5.0; -2.0)...");
        canvas.moveAllShapes(5.0, -2.0);
        System.out.println("Новий центр 'Коло-А': " + canvas.getShape(0).getAnchorPoint());
        System.out.println("=============================================================================");
    }
}

/** Інкапсульована точка на площині. */
class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** Конструктор копіювання (для захисного копіювання). */
    public Point2D(Point2D other) {
        this(other.x, other.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public double distanceTo(Point2D other) {
        return Math.hypot(x - other.x, y - other.y);
    }

    @Override
    public String toString() {
        return String.format("(%.2f; %.2f)", x, y);
    }
}

/** Абстрактна 2D-фігура: IS-A для нащадків, HAS-A Point2D як опорна точка. */
abstract class AbstractShape2D {
    private final String name;
    private final Point2D anchorPoint;

    public AbstractShape2D(String name, Point2D anchorPoint) {
        this.name = name;
        // захисна копія на вході
        this.anchorPoint = (anchorPoint != null) ? new Point2D(anchorPoint) : new Point2D(0, 0);
    }

    public String getName() {
        return name;
    }

    /** Захисна копія на виході: зовнішній код не зможе змінити центр фігури напряму. */
    public Point2D getAnchorPoint() {
        return new Point2D(anchorPoint);
    }

    public void moveBy(double dx, double dy) {
        anchorPoint.translate(dx, dy); // делегуємо внутрішній точці
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    /** Розміри конкретної фігури для звіту (нащадки перевизначають). */
    protected String describeDimensions() {
        return "";
    }

    @Override
    public String toString() {
        return String.format("%s[name='%s', center=%s%s | S=%.2f, P=%.2f]",
                getClass().getSimpleName(), name, anchorPoint, describeDimensions(), getArea(), getPerimeter());
    }
}

class Circle2D extends AbstractShape2D {
    private final double radius;

    public Circle2D(String name, Point2D center, double radius) {
        super(name, center);
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
    protected String describeDimensions() {
        return String.format(", r=%.2f", radius);
    }
}

class Rectangle2D extends AbstractShape2D {
    private final double width;
    private final double height;

    public Rectangle2D(String name, Point2D center, double width, double height) {
        super(name, center);
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
    protected String describeDimensions() {
        return String.format(", %.2fx%.2f", width, height);
    }
}

class RightTriangle2D extends AbstractShape2D {
    private final double legA;
    private final double legB;

    public RightTriangle2D(String name, Point2D center, double legA, double legB) {
        super(name, center);
        if (legA <= 0 || legB <= 0) {
            throw new IllegalArgumentException("Катети мають бути > 0");
        }
        this.legA = legA;
        this.legB = legB;
    }

    public double getHypotenuse() {
        return Math.sqrt(legA * legA + legB * legB);
    }

    @Override
    public double getArea() {
        return 0.5 * legA * legB;
    }

    @Override
    public double getPerimeter() {
        return legA + legB + getHypotenuse();
    }

    @Override
    protected String describeDimensions() {
        return String.format(", a=%.2f, b=%.2f, c=%.2f", legA, legB, getHypotenuse());
    }
}

/** Полотно компонує масив різнорідних фігур. */
class GeometryCanvas {
    private final String title;
    private final AbstractShape2D[] shapes;
    private int count;

    public GeometryCanvas(String title, int capacity) {
        this.title = title;
        this.shapes = new AbstractShape2D[capacity];
    }

    public boolean addShape(AbstractShape2D shape) {
        if (shape == null || count >= shapes.length) {
            return false;
        }
        shapes[count++] = shape;
        return true;
    }

    public AbstractShape2D getShape(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Немає фігури з індексом " + index);
        }
        return shapes[index];
    }

    public double getTotalArea() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += shapes[i].getArea();
        }
        return sum;
    }

    public double getTotalPerimeter() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += shapes[i].getPerimeter();
        }
        return sum;
    }

    public AbstractShape2D findLargestShape() {
        AbstractShape2D largest = null;
        for (int i = 0; i < count; i++) {
            if (largest == null || shapes[i].getArea() > largest.getArea()) {
                largest = shapes[i];
            }
        }
        return largest;
    }

    public void moveAllShapes(double dx, double dy) {
        for (int i = 0; i < count; i++) {
            shapes[i].moveBy(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Полотно: '").append(title).append("' (Фігур: ").append(count)
                .append("/").append(shapes.length).append(")");
        for (int i = 0; i < count; i++) {
            sb.append("\n  ").append(i + 1).append(". ").append(shapes[i]);
        }
        return sb.toString();
    }
}
