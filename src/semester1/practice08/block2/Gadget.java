package semester1.practice08.block2;

public class Gadget {
    private String brand;
    private double price;

    public Gadget(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Gadget{brand='" + brand + "', price=" + price + "}";
    }
}
