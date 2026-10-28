package semester1.practice07;

public class Customer {
    private String name;
    private double walletBalance;

    public Customer(String name, double walletBalance) {
        this.name = name;
        this.walletBalance = walletBalance;
    }

    public boolean pay(double amount) {
        if (amount <= walletBalance) {
            walletBalance -= amount;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public double getWalletBalance() {
        return walletBalance;
    }
}
