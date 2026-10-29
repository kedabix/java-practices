package semester1.practice08.block2;

public class Box3D extends Rectangle {
    private double depth;

    public Box3D(double width, double height, double depth) {
        super(width, height);
        this.depth = depth;
    }

    // Об'єм = площа основи * глибина
    public double getVolume() {
        return super.getArea() * depth;
    }

    @Override
    public String toString() {
        return "Box3D{width=" + getWidth() + ", height=" + getHeight() + ", depth=" + depth
                + ", baseArea=" + getArea() + ", volume=" + getVolume() + "}";
    }
}
