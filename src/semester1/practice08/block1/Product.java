package semester1.practice08.block1;

import java.util.Locale;

public class Product {
    private String sku;
    private String title;
    private double price;
    private int stock;

    public Product(String sku, String title, double price, int stock) {
        this.sku = sku;
        this.title = title;
        setPrice(price);
        setStock(stock);
    }

    public String getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0.0) {
            this.price = price;
        } else {
            this.price = 0.0;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
        }
    }

    public double getTotalCost() {
        return price * stock;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "[SKU: %s] %s | Ціна: %.2f грн | Залишок: %d шт. | Разом: %.2f грн",
                sku, title, price, stock, getTotalCost());
    }
}
