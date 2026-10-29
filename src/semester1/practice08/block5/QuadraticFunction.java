package semester1.practice08.block5;

public class QuadraticFunction extends LinearFunction {
    private double a;

    public QuadraticFunction(double a, double k, double b) {
        super(k, b);
        if (a == 0) {
            System.out.println("Старший коефіцієнт не може бути 0! Встановлено 1.0");
            this.a = 1.0;
        } else {
            this.a = a;
        }
    }

    // y = a*x^2 + (k*x + b), де (k*x + b) вже вміє рахувати батько
    @Override
    public double evaluate(double x) {
        return a * x * x + super.evaluate(x);
    }

    // Вершина параболи: x0 = -k / (2a)
    public double getVertexX() {
        return -k / (2 * a);
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + k + "x + " + b;
    }
}
