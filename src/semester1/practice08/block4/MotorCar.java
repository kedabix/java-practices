package semester1.practice08.block4;

public class MotorCar extends BaseVehicle {
    private int horsePower;
    private int doorsCount;

    public MotorCar(String brand, int year, int horsePower, int doorsCount) {
        super(brand, year);
        this.horsePower = horsePower;
        this.doorsCount = doorsCount;
    }

    @Override
    public String toString() {
        return "MotorCar{" + super.toString() + ", horsePower=" + horsePower + ", doors=" + doorsCount + "}";
    }
}
