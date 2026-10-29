package semester1.practice08.block4;

import java.util.Locale;

public class PaymentCard {
    private String cardHolder;
    protected double balance;

    public PaymentCard(String cardHolder, double balance) {
        this.cardHolder = cardHolder;
        this.balance = balance;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean pay(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "PaymentCard{holder='%s', balance=%.2f}", cardHolder, balance);
    }
}
