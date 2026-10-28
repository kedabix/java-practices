package semester1.practice07;

public class SalaryCalculator {

    public double calculate(double baseRate) {
        return baseRate;
    }

    public double calculate(double baseRate, double fixedBonus) {
        return baseRate + fixedBonus;
    }

    public double calculate(double baseRate, double bonusPercent, boolean isTaxDeducted) {
        double total = baseRate + baseRate * bonusPercent / 100;
        if (isTaxDeducted) {
            total = total - total * 0.195;
        }
        return total;
    }

    public double calculate(double baseRate, int overtimeHours, double overtimeHourlyRate) {
        return baseRate + overtimeHours * overtimeHourlyRate;
    }
}
