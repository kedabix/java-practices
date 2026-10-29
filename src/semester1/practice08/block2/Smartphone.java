package semester1.practice08.block2;

public class Smartphone extends Gadget {
    private int memoryGb;
    private boolean has5G;

    // Повний конструктор
    public Smartphone(String brand, double price, int memoryGb, boolean has5G) {
        super(brand, price);
        this.memoryGb = memoryGb;
        this.has5G = has5G;
    }

    // Середній: 5G є за замовчуванням
    public Smartphone(String brand, double price, int memoryGb) {
        this(brand, price, memoryGb, true);
    }

    // Мінімальний: тільки бренд
    public Smartphone(String brand) {
        this(brand, 9999.0, 128, false);
    }

    @Override
    public String toString() {
        return "Smartphone{brand='" + getBrand() + "', price=" + getPrice() + ", memory=" + memoryGb
                + "GB, 5G=" + has5G + "}";
    }
}
