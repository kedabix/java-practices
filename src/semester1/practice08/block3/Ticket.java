package semester1.practice08.block3;

import java.util.Locale;

public class Ticket {
    private String eventName;
    private double basePrice;

    public Ticket(String eventName, double basePrice) {
        this.eventName = eventName;
        this.basePrice = basePrice;
    }

    public double getFinalPrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Ticket{event='%s', basePrice=%.2f, finalPrice=%.2f}",
                eventName, basePrice, getFinalPrice());
    }
}
