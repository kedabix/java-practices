package semester1.practice08.block5;

public class WarehouseItem {
    private String name;
    private int quantity;
    private double[] priceHistory;

    public WarehouseItem(String name, int quantity, double[] priceHistory) {
        this.name = name;
        this.quantity = quantity;
        this.priceHistory = new double[priceHistory.length];
        for (int i = 0; i < priceHistory.length; i++) {
            this.priceHistory[i] = priceHistory[i];
        }
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAveragePurchasePrice() {
        if (priceHistory.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int i = 0; i < priceHistory.length; i++) {
            sum += priceHistory[i];
        }
        return sum / priceHistory.length;
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.US, "WarehouseItem{name='%s', quantity=%d, середня закупівельна ціна=%.2f}",
                name, quantity, getAveragePurchasePrice());
    }
}
