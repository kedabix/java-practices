package semester1.practice08.block5;

public class Progression {
    protected double firstTerm;
    protected double step;

    public Progression(double firstTerm, double step) {
        this.firstTerm = firstTerm;
        this.step = step;
    }

    // У базовому класі повертаємо лише перший член; нащадки перевизначають
    public double getTerm(int n) {
        return firstTerm;
    }

    public double[] generateFirstN(int n) {
        double[] result = new double[n];
        for (int i = 1; i <= n; i++) {
            result[i - 1] = getTerm(i);
        }
        return result;
    }

    // Допоміжний метод: перші n членів у вигляді рядка
    protected String termsToString(int n) {
        double[] terms = generateFirstN(n);
        String text = "";
        for (int i = 0; i < terms.length; i++) {
            text += terms[i];
            if (i < terms.length - 1) {
                text += ", ";
            }
        }
        return text;
    }

    @Override
    public String toString() {
        return "Progression{first=" + firstTerm + ", step=" + step + "}";
    }
}
