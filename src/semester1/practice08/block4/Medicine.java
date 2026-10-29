package semester1.practice08.block4;

import java.util.Locale;

public class Medicine {
    private String name;
    private double price;
    private boolean isExpired;

    public Medicine(String name, double price, boolean isExpired) {
        this.name = name;
        this.price = price;
        this.isExpired = isExpired;
    }

    public boolean isExpired() {
        return isExpired;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Medicine{name='%s', price=%.2f, прострочено=%s}", name, price, isExpired);
    }
}
