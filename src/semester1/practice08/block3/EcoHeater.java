package semester1.practice08.block3;

public class EcoHeater extends Appliance {
    private boolean ecoModeActive;

    public EcoHeater(String model, double powerWatts, boolean ecoModeActive) {
        super(model, powerWatts);
        this.ecoModeActive = ecoModeActive;
    }

    // В еко-режимі споживання менше на 25%
    @Override
    public double getDailyConsumptionKWh(int hours) {
        double normal = super.getDailyConsumptionKWh(hours);
        if (ecoModeActive) {
            return normal * 0.75;
        }
        return normal;
    }

    @Override
    public String toString() {
        return "EcoHeater{model='" + getModel() + "', power=" + getPowerWatts() + " Вт, еко-режим: "
                + (ecoModeActive ? "увімкнено" : "вимкнено") + "}";
    }
}
