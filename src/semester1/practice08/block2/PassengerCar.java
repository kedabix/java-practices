package semester1.practice08.block2;

public class PassengerCar extends Vehicle {
    private int passengerSeats;

    public PassengerCar(String brand, int maxSpeed, double fuelTankCapacity, int passengerSeats) {
        super(brand, maxSpeed, fuelTankCapacity);
        this.passengerSeats = passengerSeats;
    }

    @Override
    public String toString() {
        return "PassengerCar{brand='" + brand + "', maxSpeed=" + maxSpeed + ", tank=" + fuelTankCapacity
                + " л, seats=" + passengerSeats + "}";
    }
}
