package semester1.practice07;

public class Order {
    private Customer customer;
    private ShopProduct[] items;
    private int itemCount;

    public Order(Customer customer, int maxItems) {
        this.customer = customer;
        this.items = new ShopProduct[maxItems];
        this.itemCount = 0;
    }

    public void addProduct(ShopProduct p) {
        if (itemCount < items.length) {
            items[itemCount] = p;
            itemCount++;
        } else {
            System.out.println("Замовлення заповнене, товар не додано: " + p.getTitle());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    public boolean checkout() {
        double total = calculateTotal();
        if (this.customer.pay(total)) {
            System.out.println("=== ЧЕК для " + customer.getName() + " ===");
            for (int i = 0; i < itemCount; i++) {
                System.out.println(items[i].getTitle() + " - " + items[i].getPrice() + " грн");
            }
            System.out.println("Разом: " + total + " грн. Залишок на балансі: " + customer.getWalletBalance() + " грн");
            return true;
        }
        System.out.println(customer.getName() + ": недостатньо коштів! Потрібно " + total
                + " грн, а є " + customer.getWalletBalance() + " грн");
        return false;
    }
}
