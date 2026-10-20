package semester1.practice06.homework;

// Завдання 1
public class Task1Fraction {
    public static void main(String[] args) {
        System.out.println("=== КАЛЬКУЛЯТОР ЗВИЧАЙНИХ ДРОБІВ ===");
        Fraction fraction = new Fraction();
        fraction.setValues(8, 12);
        System.out.print("Дріб 1: ");
        fraction.printFraction();

        fraction.simplify();
        System.out.print("Після скорочення: ");
        fraction.printFraction();
        System.out.println("(десятковий вигляд: " + Math.round(fraction.toDecimal() * 10000) / 10000.0 + ")");

        System.out.println();
        int a = fraction.getNumerator();
        int b = fraction.getDenominator();
        System.out.println("Додаємо дріб 3/4 до " + a + "/" + b + "...");
        fraction.add(3, 4);
        System.out.println("Формула: " + a + "/" + b + " + 3/4 = (" + a + "*4 + 3*" + b + ") / (" + b + "*4) = " + (a * 4 + 3 * b) + "/" + (b * 4));
        System.out.print("Результат додавання: ");
        fraction.printFraction();
        System.out.println("(десятковий вигляд: " + Math.round(fraction.toDecimal() * 10000) / 10000.0 + ")");
        System.out.println("=====================================");

        // перевірка валідації
        Fraction bad = new Fraction();
        bad.setValues(5, 0);
        bad.printFraction();
        Fraction negative = new Fraction();
        negative.setValues(3, -6);
        negative.simplify();
        negative.printFraction();
    }
}

class Fraction {
    private int numerator;
    private int denominator = 1;

    public void setValues(int num, int den) {
        if (den == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            numerator = num;
            denominator = 1;
        } else if (den < 0) {
            numerator = -num;
            denominator = -den;
        } else {
            numerator = num;
            denominator = den;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void simplify() {
        int g = gcd(numerator, denominator);
        if (g != 0) {
            numerator /= g;
            denominator /= g;
        }
    }

    public double toDecimal() {
        return (double) numerator / denominator;
    }

    public void add(int otherNum, int otherDen) {
        if (otherDen == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            return;
        }
        numerator = numerator * otherDen + otherNum * denominator;
        denominator = denominator * otherDen;
        simplify();
    }

    public void printFraction() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }
}
