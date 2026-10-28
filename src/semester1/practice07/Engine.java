package semester1.practice07;

public class Engine {
    private String serialNumber;
    private int horsePower;
    private boolean isRunning;

    public Engine(String serialNumber, int horsePower) {
        this.serialNumber = serialNumber;
        this.horsePower = horsePower;
        this.isRunning = false;
    }

    public void start() {
        isRunning = true;
        System.out.println("Двигун " + serialNumber + " запущено");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Двигун " + serialNumber + " зупинено");
    }

    public boolean isRunning() {
        return isRunning;
    }

    public int getHorsePower() {
        return horsePower;
    }
}
