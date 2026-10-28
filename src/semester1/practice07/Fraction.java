package semester1.practice07;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0! Встановлено 1.");
            denominator = 1;
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int g = gcd(Math.abs(numerator), denominator);
        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    public Fraction(int wholeNumber) {
        this(wholeNumber, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    // Алгоритм Евкліда
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void print() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }
}
