package semester1.practice08.block3;

import java.util.Locale;

public class StaffMember {
    private String name;
    private double baseSalary;

    public StaffMember(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double calculateMonthlyPay() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "StaffMember{name='%s', base=%.2f, до виплати=%.2f}",
                name, baseSalary, calculateMonthlyPay());
    }
}
