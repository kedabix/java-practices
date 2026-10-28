package semester1.practice07;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.category = category;
        if (price < 0) {
            this.price = 0.0;
        } else {
            this.price = price;
        }
        if (quantity < 0) {
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public void applyDiscount(double percent) {
        if (percent >= 0 && percent <= 100) {
            price = price - price * percent / 100;
        } else {
            System.out.println("Знижка має бути від 0% до 100%");
        }
    }

    public void printProduct() {
        System.out.println("--- Товар ---");
        System.out.println("Назва: " + name);
        System.out.println("Категорія: " + category);
        System.out.println("Ціна: " + price + " грн");
        System.out.println("Кількість: " + quantity);
        System.out.println("Вартість партії: " + getTotalValue() + " грн");
    }
}
