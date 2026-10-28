package semester1.practice07;

public class Employee {
    private int id;
    private String fullName;
    private String position;
    private double monthlySalary;

    public Employee(int id, String fullName, String position, double monthlySalary) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.monthlySalary = monthlySalary;
    }

    public void raiseSalary(double percent) {
        monthlySalary = monthlySalary + monthlySalary * percent / 100;
    }

    public double getAnnualSalary() {
        return 12 * monthlySalary;
    }

    public void printBadge() {
        System.out.println("=== БЕЙДЖ ===");
        System.out.println("ID: " + id);
        System.out.println("ПІБ: " + fullName);
        System.out.println("Посада: " + position);
        System.out.println("Зарплата: " + monthlySalary + " грн/міс");
    }
}
