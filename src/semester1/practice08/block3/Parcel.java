package semester1.practice08.block3;

import java.util.Locale;

public class Parcel {
    private String trackingCode;
    private double weightKg;

    public Parcel(String trackingCode, double weightKg) {
        this.trackingCode = trackingCode;
        this.weightKg = weightKg;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double calculateShippingCost() {
        return 50.0 + weightKg * 12.0;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Parcel{code='%s', weight=%.1f кг, доставка=%.2f грн}",
                trackingCode, weightKg, calculateShippingCost());
    }
}
