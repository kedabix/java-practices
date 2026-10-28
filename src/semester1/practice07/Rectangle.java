package semester1.practice07;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this(1.0, 1.0);
    }

    // Квадрат
    public Rectangle(double size) {
        this(size, size);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return width == height;
    }
}
