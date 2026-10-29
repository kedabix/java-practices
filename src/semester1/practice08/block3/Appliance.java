package semester1.practice08.block3;

public class Appliance {
    private String model;
    private double powerWatts;

    public Appliance(String model, double powerWatts) {
        this.model = model;
        this.powerWatts = powerWatts;
    }

    public String getModel() {
        return model;
    }

    public double getPowerWatts() {
        return powerWatts;
    }

    public double getDailyConsumptionKWh(int hours) {
        return (powerWatts * hours) / 1000.0;
    }

    @Override
    public String toString() {
        return "Appliance{model='" + model + "', power=" + powerWatts + " Вт}";
    }
}
