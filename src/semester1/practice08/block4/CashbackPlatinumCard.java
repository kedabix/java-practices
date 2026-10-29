package semester1.practice08.block4;

import java.util.Locale;

public class CashbackPlatinumCard extends DebitCard {
    private double cashbackPercent;
    private double accumulatedCashback;

    public CashbackPlatinumCard(String cardHolder, double balance, double dailyLimit, double cashbackPercent) {
        super(cardHolder, balance, dailyLimit);
        this.cashbackPercent = cashbackPercent;
        this.accumulatedCashback = 0.0;
    }

    @Override
    public boolean pay(double amount) {
        boolean success = super.pay(amount);
        if (success) {
            accumulatedCashback += amount * cashbackPercent / 100.0;
        }
        return success;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "CashbackPlatinumCard{holder='%s', balance=%.2f, cashback=%.1f%%, накопичено=%.2f}",
                getCardHolder(), balance, cashbackPercent, accumulatedCashback);
    }
}
