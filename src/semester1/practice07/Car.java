package semester1.practice07;

public class Car {
    private String brand;
    private String model;
    private int year;
    private double mileage;
    private boolean engineStarted;

    public Car(String brand, String model, int year, double mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.engineStarted = false;
    }

    // Нове авто: пробіг 0
    public Car(String brand, String model, int year) {
        this(brand, model, year, 0.0);
    }

    public Car() {
        this("Unknown", "Standard", 2024);
    }

    public void startEngine() {
        engineStarted = true;
        System.out.println("Двигун " + brand + " " + model + " заведено");
    }

    public void stopEngine() {
        engineStarted = false;
        System.out.println("Двигун " + brand + " " + model + " заглушено");
    }

    public void drive(double distance) {
        if (engineStarted) {
            mileage += distance;
            System.out.println("Проїхали " + distance + " км. Пробіг: " + mileage + " км");
        } else {
            System.out.println("Спершу заведіть двигун!");
        }
    }
}
