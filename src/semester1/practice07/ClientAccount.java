package semester1.practice07;

public class ClientAccount {
    private String iban;
    private String owner;
    private double balance;

    public ClientAccount(String iban, String owner, double balance) {
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
    }

    public boolean transferTo(ClientAccount recipient, double amount) {
        if (recipient == null || recipient == this) {
            System.out.println("Помилка: некоректний отримувач");
            return false;
        }
        if (amount <= 0 || this.balance < amount) {
            System.out.println("Помилка: недостатньо коштів або некоректна сума");
            return false;
        }
        this.balance -= amount;
        recipient.balance += amount;
        System.out.println("Переказ " + amount + " грн: " + this.owner + " -> " + recipient.owner);
        return true;
    }

    public void printAccount() {
        System.out.println("Рахунок " + iban + ", власник: " + owner + ", баланс: " + balance + " грн");
    }
}
