package semester1.practice07;

public class Computer {
    private String title;
    private Processor cpu;
    private Memory ram;
    private double casePrice;

    public Computer(String title, Processor cpu, Memory ram, double casePrice) {
        this.title = title;
        this.cpu = cpu;
        this.ram = ram;
        this.casePrice = casePrice;
    }

    public double calculateTotalPrice() {
        return cpu.getPrice() + ram.getPrice() + casePrice;
    }

    public void upgradeMemory(Memory newRam) {
        System.out.println("Апгрейд пам'яті: " + this.ram.getSizeGB() + "GB -> " + newRam.getSizeGB() + "GB");
        this.ram = newRam;
    }

    public void printSpecs() {
        System.out.println("Комп'ютер \"" + title + "\": процесор " + cpu.getModel() + " (" + cpu.getFrequencyGHz()
                + " GHz), пам'ять " + ram.getSizeGB() + "GB " + ram.getFrequencyMHz() + "MHz, ціна: "
                + calculateTotalPrice() + " грн");
    }
}
