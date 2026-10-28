package semester1.practice07;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initialBalance < 0) {
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Поповнено на " + amount + " грн");
        } else {
            System.out.println("Сума поповнення має бути більшою за 0");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Операцію відхилено: неможливо зняти " + amount + " грн");
            return false;
        }
        balance -= amount;
        System.out.println("Знято " + amount + " грн");
        return true;
    }

    public void printAccount() {
        System.out.println("Рахунок " + accountNumber + ", власник: " + ownerName + ", баланс: " + balance + " грн");
    }
}
