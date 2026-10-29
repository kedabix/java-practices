package semester1.practice08.block3;

import java.util.Locale;

public class StandardTransfer {
    protected double amount;

    public StandardTransfer(double amount) {
        this.amount = amount;
    }

    // Стандартна комісія 1%
    public double getFee() {
        return amount * 0.01;
    }

    public double getTotalWithFee() {
        return amount + getFee(); // тут викличеться getFee() нащадка, якщо об'єкт - нащадок!
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "StandardTransfer{amount=%.2f, fee=%.2f, total=%.2f}",
                amount, getFee(), getTotalWithFee());
    }
}
