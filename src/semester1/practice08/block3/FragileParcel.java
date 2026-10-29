package semester1.practice08.block3;

import java.util.Locale;

public class FragileParcel extends Parcel {
    private boolean requiresWoodenBox;
    private double insuranceValue;

    public FragileParcel(String trackingCode, double weightKg, boolean requiresWoodenBox, double insuranceValue) {
        super(trackingCode, weightKg);
        this.requiresWoodenBox = requiresWoodenBox;
        this.insuranceValue = insuranceValue;
    }

    @Override
    public double calculateShippingCost() {
        double cost = super.calculateShippingCost();
        cost += insuranceValue * 0.015; // страховий збір 1.5%
        if (requiresWoodenBox) {
            cost += 120.0; // обрешітка
        }
        return cost;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "FragileParcel{code='%s', weight=%.1f кг, страхова вартість=%.2f, дерев'яна обрешітка=%s, доставка=%.2f грн}",
                getTrackingCode(), getWeightKg(), insuranceValue, requiresWoodenBox ? "так" : "ні", calculateShippingCost());
    }
}
