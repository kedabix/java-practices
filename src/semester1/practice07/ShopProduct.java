package semester1.practice07;

// Це "Product" із завдання 38. Названо ShopProduct, бо клас Product
// уже використовується в завданні 5 (у одному пакеті не може бути двох однакових імен).
public class ShopProduct {
    private int id;
    private String title;
    private double price;

    public ShopProduct(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
