package semester1.practice08.block4;

import java.util.Locale;

public class DebitCard extends PaymentCard {
    private double dailyLimit;

    public DebitCard(String cardHolder, double balance, double dailyLimit) {
        super(cardHolder, balance);
        this.dailyLimit = dailyLimit;
    }

    @Override
    public boolean pay(double amount) {
        if (amount > dailyLimit) {
            return false; // перевищено ліміт
        }
        return super.pay(amount);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "DebitCard{holder='%s', balance=%.2f, dailyLimit=%.2f}",
                getCardHolder(), balance, dailyLimit);
    }
}
