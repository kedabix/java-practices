package semester1.practice08.block3;

public class Point3D extends Point2D {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public double distanceToOrigin() {
        // super.distanceToOrigin() = sqrt(x^2 + y^2), тож піднесемо до квадрата і додамо z^2
        double flat = super.distanceToOrigin();
        return Math.sqrt(flat * flat + z * z);
    }

    @Override
    public String toString() {
        return "(" + getX() + "; " + getY() + "; " + z + ")";
    }
}
