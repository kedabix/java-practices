package semester1.practice07;

public class AreaCalculator {

    // Квадрат
    public double calculateArea(double side) {
        return side * side;
    }

    // Прямокутник
    public double calculateArea(double width, double height) {
        return width * height;
    }

    // Круг
    public double calculateArea(double radius, boolean isCircle) {
        return Math.PI * radius * radius;
    }

    // Трикутник (формула Герона)
    public double calculateArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // Трапеція.
    // УВАГА: сигнатура (double, double, double) уже зайнята трикутником,
    // тому цей метод має іншу назву.
    public double calculateTrapezoidArea(double base1, double base2, double height) {
        return (base1 + base2) / 2 * height;
    }
}
