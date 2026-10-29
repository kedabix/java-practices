package semester1.practice08.block2;

public class CargoTruck extends Vehicle {
    private double maxLoadTons;

    public CargoTruck(String brand, int maxSpeed, double fuelTankCapacity, double maxLoadTons) {
        super(brand, maxSpeed, fuelTankCapacity);
        this.maxLoadTons = maxLoadTons;
    }

    // Витрата пального на 100 км при повному завантаженні:
    // базові 20 л + 1.5 л за кожну тонну вантажу
    public double getFuelConsumptionFullLoad() {
        return 20.0 + maxLoadTons * 1.5;
    }

    @Override
    public String toString() {
        return "CargoTruck{brand='" + brand + "', maxSpeed=" + maxSpeed + ", tank=" + fuelTankCapacity
                + " л, maxLoad=" + maxLoadTons + " т, витрата з вантажем=" + getFuelConsumptionFullLoad() + " л/100км}";
    }
}
