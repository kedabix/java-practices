package semester1.practice08.block5;

import java.util.Locale;

public class DiscountedWarehouseItem extends WarehouseItem {
    private String markdownReason;
    private double discountPercent;

    public DiscountedWarehouseItem(String name, int quantity, double[] priceHistory,
                                   String markdownReason, double discountPercent) {
        super(name, quantity, priceHistory);
        this.markdownReason = markdownReason;
        this.discountPercent = discountPercent;
    }

    // Ціна розпродажу відносно середньої закупівельної ціни
    public double getSalePrice() {
        return getAveragePurchasePrice() * (1 - discountPercent / 100.0);
    }

    // Вартість усієї партії за ціною розпродажу
    public double getClearanceTotal() {
        return getSalePrice() * getQuantity();
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Discounted{%s, причина: %s, знижка=%.0f%%, ціна розпродажу=%.2f, партія=%.2f}",
                super.toString(), markdownReason, discountPercent, getSalePrice(), getClearanceTotal());
    }
}
