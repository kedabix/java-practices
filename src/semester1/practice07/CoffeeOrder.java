package semester1.practice07;

public class CoffeeOrder {
    private String type;
    private String size;
    private int sugarCount;
    private boolean withSyrup;
    private double finalPrice;

    public CoffeeOrder(String type, String size, int sugarCount, boolean withSyrup) {
        this.type = type;
        this.size = size;
        this.sugarCount = sugarCount;
        this.withSyrup = withSyrup;
        this.finalPrice = calculatePrice();
    }

    public CoffeeOrder(String type, String size) {
        this(type, size, 0, false);
    }

    public CoffeeOrder(String type) {
        this(type, "Medium");
    }

    private double calculatePrice() {
        double price;
        if (type.equals("Еспресо")) {
            price = 40;
        } else if (type.equals("Капучино")) {
            price = 55;
        } else if (type.equals("Лате")) {
            price = 60;
        } else {
            price = 40;
        }

        if (size.equals("Medium")) {
            price = price * 1.3;
        } else if (size.equals("Large")) {
            price = price * 1.6;
        }

        if (withSyrup) {
            price = price + 15;
        }
        return price;
    }

    public void printReceipt() {
        System.out.println("--- Чек ---");
        System.out.println("Напій: " + type + " (" + size + ")");
        System.out.println("Цукор: " + sugarCount + ", сироп: " + withSyrup);
        System.out.println("До сплати: " + finalPrice + " грн");
    }
}
