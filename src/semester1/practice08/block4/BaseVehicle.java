package semester1.practice08.block4;

public class BaseVehicle {
    private String brand;
    private int year;

    public BaseVehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "BaseVehicle{brand='" + brand + "', year=" + year + "}";
    }
}
