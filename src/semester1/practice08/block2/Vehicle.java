package semester1.practice08.block2;

public class Vehicle {
    protected String brand;
    protected int maxSpeed;
    protected double fuelTankCapacity;

    public Vehicle(String brand, int maxSpeed, double fuelTankCapacity) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public String toString() {
        return "Vehicle{brand='" + brand + "', maxSpeed=" + maxSpeed + ", tank=" + fuelTankCapacity + " л}";
    }
}
