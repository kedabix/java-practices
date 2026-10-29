package semester1.practice08.block5;

public class GeometricProgression extends Progression {

    public GeometricProgression(double firstTerm, double ratio) {
        super(firstTerm, ratio);
    }

    // b_n = b_1 * q^(n - 1)
    @Override
    public double getTerm(int n) {
        return firstTerm * Math.pow(step, n - 1);
    }

    @Override
    public String toString() {
        return "Геометрична прогресія: b_n = " + firstTerm + " * " + step + "^(n-1)"
                + " | перші 5 членів: [" + termsToString(5) + "]";
    }
}
