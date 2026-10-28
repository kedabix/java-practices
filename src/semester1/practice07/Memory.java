package semester1.practice07;

public class Memory {
    private int sizeGB;
    private int frequencyMHz;
    private double price;

    public Memory(int sizeGB, int frequencyMHz, double price) {
        this.sizeGB = sizeGB;
        this.frequencyMHz = frequencyMHz;
        this.price = price;
    }

    public int getSizeGB() {
        return sizeGB;
    }

    public int getFrequencyMHz() {
        return frequencyMHz;
    }

    public double getPrice() {
        return price;
    }
}
