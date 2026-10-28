package semester1.practice07;

public class MathUtils {
    public static final double PI = 3.1415926535;
    public static final double E = 2.7182818284;

    // Приватний конструктор: об'єкт цього класу створити не можна
    private MathUtils() {
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double power(double base, int exp) {
        if (exp < 0) {
            return 1 / power(base, -exp);
        }
        double result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    // Алгоритм Евкліда
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int clamp(int val, int min, int max) {
        if (val < min) {
            return min;
        }
        if (val > max) {
            return max;
        }
        return val;
    }
}
