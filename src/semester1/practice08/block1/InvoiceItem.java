package semester1.practice08.block1;

import java.util.Locale;

public class InvoiceItem {
    private String description;
    private int quantity;
    private double unitPrice;
    private double discountPercent;

    public InvoiceItem(String description, int quantity, double unitPrice, double discountPercent) {
        this.description = description;
        this.quantity = Math.max(quantity, 0);
        this.unitPrice = Math.max(unitPrice, 0.0);
        // Знижка тільки від 0 до 50 відсотків
        if (discountPercent < 0) {
            this.discountPercent = 0;
        } else if (discountPercent > 50) {
            this.discountPercent = 50;
        } else {
            this.discountPercent = discountPercent;
        }
    }

    public double getFinalAmount() {
        double total = quantity * unitPrice;
        return total - total * discountPercent / 100;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s: %d шт. x %.2f грн, знижка %.0f%% = %.2f грн",
                description, quantity, unitPrice, discountPercent, getFinalAmount());
    }
}
