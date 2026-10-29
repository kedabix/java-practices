package semester1.practice08.block4;

public class Segment1D {
    protected double length;

    public Segment1D(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            this.length = 1.0;
        }
    }

    @Override
    public String toString() {
        return "Segment1D{length=" + length + "}";
    }
}
