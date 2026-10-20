package semester1.practice06.homework;

// Завдання 2
public class Task2QuadraticEquation {
    public static void main(String[] args) {
        System.out.println("=== РОЗВ'ЯЗУВАЧ КВАДРАТНИХ РІВНЯНЬ ===");

        System.out.println("Тест 1:");
        QuadraticEquation eq1 = new QuadraticEquation();
        eq1.setCoefficients(1, -5, 6);
        eq1.printSolution();
        System.out.println("--------------------------------------");

        System.out.println("Тест 2:");
        QuadraticEquation eq2 = new QuadraticEquation();
        eq2.setCoefficients(1, -4, 4);
        eq2.printSolution();
        System.out.println("--------------------------------------");

        System.out.println("Тест 3:");
        QuadraticEquation eq3 = new QuadraticEquation();
        eq3.setCoefficients(1, 2, 5);
        eq3.printSolution();
        System.out.println("======================================");
    }
}

class QuadraticEquation {
    private double a = 1.0;
    private double b;
    private double c;

    public void setCoefficients(double a, double b, double c) {
        if (a == 0) {
            System.out.println("Увага: коефіцієнт 'a' не може дорівнювати 0 (це лінійне рівняння)!");
            this.a = 1.0;
        } else {
            this.a = a;
        }
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }

    public double getRoot1() {
        if (!hasRealRoots()) {
            return Double.NaN;
        }
        return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public double getRoot2() {
        if (!hasRealRoots()) {
            return Double.NaN;
        }
        return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public void printSolution() {
        String bText = (b < 0) ? "(" + b + ")" : "" + b;
        String cText = (c < 0) ? "(" + c + ")" : "" + c;
        System.out.println("Рівняння: " + a + "*x^2 + " + bText + "*x + " + cText + " = 0");
        double d = getDiscriminant();
        System.out.printf("Дискримінант D = %.2f%n", d);
        if (d > 0) {
            System.out.println("Рівняння має 2 дійсні корені:");
            System.out.printf("  x1 = %.2f%n", getRoot1());
            System.out.printf("  x2 = %.2f%n", getRoot2());
        } else if (d == 0) {
            System.out.println("Рівняння має один дійсний корінь:");
            System.out.printf("  x = %.2f%n", -b / (2 * a));
        } else {
            System.out.println("Рівняння не має дійсних коренів у множині R.");
        }
    }
}
