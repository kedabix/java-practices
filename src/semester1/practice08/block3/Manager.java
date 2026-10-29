package semester1.practice08.block3;

import java.util.Locale;

public class Manager extends StaffMember {
    private double teamBonus;

    public Manager(String name, double baseSalary, double teamBonus) {
        super(name, baseSalary);
        this.teamBonus = teamBonus;
    }

    @Override
    public double calculateMonthlyPay() {
        return super.calculateMonthlyPay() + teamBonus;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Manager{name='%s', base=%.2f, teamBonus=%.2f, до виплати=%.2f}",
                getName(), getBaseSalary(), teamBonus, calculateMonthlyPay());
    }
}
