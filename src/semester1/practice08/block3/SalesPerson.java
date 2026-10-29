package semester1.practice08.block3;

import java.util.Locale;

public class SalesPerson extends StaffMember {
    private double salesVolume;
    private double commissionRate;

    public SalesPerson(String name, double baseSalary, double salesVolume, double commissionRate) {
        super(name, baseSalary);
        this.salesVolume = salesVolume;
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculateMonthlyPay() {
        return super.calculateMonthlyPay() + salesVolume * (commissionRate / 100.0);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "SalesPerson{name='%s', base=%.2f, sales=%.2f, commission=%.1f%%, до виплати=%.2f}",
                getName(), getBaseSalary(), salesVolume, commissionRate, calculateMonthlyPay());
    }
}
