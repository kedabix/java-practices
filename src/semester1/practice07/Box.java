package semester1.practice07;

public class Box {
    private double width;
    private double height;
    private double depth;
    private String material;

    public Box(double width, double height, double depth, String material) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.material = material;
    }

    // Куб
    public Box(double size, String material) {
        this(size, size, size, material);
    }

    // Конструктор копіювання
    public Box(Box other) {
        this(other.width, other.height, other.depth, other.material);
    }

    public double getVolume() {
        return width * height * depth;
    }

    public double getSurfaceArea() {
        return 2 * (width * height + width * depth + height * depth);
    }

    public void printBox() {
        System.out.println("Коробка " + width + "x" + height + "x" + depth + ", матеріал: " + material
                + ", об'єм: " + getVolume() + ", площа поверхні: " + getSurfaceArea());
    }
}
