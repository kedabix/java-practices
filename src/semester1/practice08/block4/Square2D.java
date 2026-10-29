package semester1.practice08.block4;

public class Square2D extends Segment1D {

    public Square2D(double side) {
        super(side);
    }

    public double getPerimeter() {
        return 4 * length;
    }

    public double getArea() {
        return length * length;
    }

    @Override
    public String toString() {
        return "Square2D{" + super.toString() + ", perimeter=" + getPerimeter() + ", area=" + getArea() + "}";
    }
}
