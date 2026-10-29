package semester1.practice08.block4;

public class Cube3D extends Square2D {

    public Cube3D(double side) {
        super(side);
    }

    // Тут площа - це площа повної поверхні куба (6 граней)
    @Override
    public double getArea() {
        return 6 * super.getArea();
    }

    public double getVolume() {
        return length * length * length;
    }

    @Override
    public String toString() {
        return "Cube3D{side=" + length + ", surfaceArea=" + getArea() + ", volume=" + getVolume() + "}";
    }
}
