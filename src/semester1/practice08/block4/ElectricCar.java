package semester1.practice08.block4;

public class ElectricCar extends MotorCar {
    private double batteryCapacityKWh;
    private int rangeKm;

    public ElectricCar(String brand, int year, int horsePower, int doorsCount, double batteryCapacityKWh, int rangeKm) {
        super(brand, year, horsePower, doorsCount); // передаємо дані вгору по ланцюжку
        this.batteryCapacityKWh = batteryCapacityKWh;
        this.rangeKm = rangeKm;
    }

    @Override
    public String toString() {
        return "ElectricCar{" + super.toString() + ", battery=" + batteryCapacityKWh + " кВт*год, range=" + rangeKm + " км}";
    }
}
