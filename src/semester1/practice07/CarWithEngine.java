package semester1.practice07;

public class CarWithEngine {
    private String brand;
    private String model;
    private Engine engine;

    public CarWithEngine(String brand, String model, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
    }

    public void startCar() {
        this.engine.start();
        System.out.println(brand + " готовий до руху!");
    }

    public void turnOff() {
        this.engine.stop();
    }

    public void printSpecs() {
        System.out.println("Авто: " + brand + " " + model + ", потужність двигуна: "
                + engine.getHorsePower() + " к.с., двигун працює: " + engine.isRunning());
    }
}
