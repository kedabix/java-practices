package semester1.practice08.block5;

public class ArithmeticProgression extends Progression {

    public ArithmeticProgression(double firstTerm, double difference) {
        super(firstTerm, difference);
    }

    // a_n = a_1 + (n - 1) * d
    @Override
    public double getTerm(int n) {
        return firstTerm + (n - 1) * step;
    }

    @Override
    public String toString() {
        return "Арифметична прогресія: a_n = " + firstTerm + " + (n-1)*" + step
                + " | перші 5 членів: [" + termsToString(5) + "]";
    }
}
