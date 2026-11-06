package semester1.practice09.homework;

import java.util.Arrays;
import java.util.Locale;

/**
 * Домашня робота №9, Завдання 2 (3 бали): конфігуратор робочої станції.
 * Інкапсуляція, композиція вузлів (HAS-A) та абстрактні комплектуючі (IS-A).
 */
public class Task2WorkstationConfigurator {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Motherboard board = new Motherboard("ASUS ROG B650", "AM5", 4);
        PowerSupplyUnit psu = new PowerSupplyUnit("Seasonics 750W Gold", 750, 0.90);
        WorkstationPC pc = new WorkstationPC("DeepLearning-Rig", board, psu);

        System.out.println("================ КОНФІГУРАТОР РОБОЧОЇ СТАНЦІЇ (КОМПОЗИЦІЯ) ================");
        System.out.println("[ПЕРЕВІРКА СУМІСНОСТІ]:");
        pc.installComponent(new ProcessorUnit("Intel Core i9", 31000, "LGA1700", 24, 5.8, 253));
        pc.installComponent(new ProcessorUnit("AMD Ryzen 9 7950X", 23900, "AM5", 16, 5.7, 170));
        pc.installComponent(new GraphicsAccelerator("NVIDIA RTX 4080 Super", 49900, 16, 552, 320));
        pc.installComponent(new NvmeSsdDrive("Samsung 990 Pro 2TB", 5100, 2000, 7450,
                new int[]{7400, 7450, 7430}));

        System.out.println();
        System.out.println(pc);

        System.out.println();
        System.out.println("[ТЕСТ ПЕРЕВАНТАЖЕННЯ БЖ]:");
        pc.installComponent(new GraphicsAccelerator("NVIDIA RTX 4090", 89900, 24, 512, 450));

        System.out.println();
        System.out.println("[ЗАХИСНЕ КОПІЮВАННЯ В NvmeSsdDrive]:");
        int[] samples = {7000, 7100, 7200};
        NvmeSsdDrive drive = new NvmeSsdDrive("Test SSD", 1000, 1000, 7000, samples);
        samples[0] = 0;                    // зміна вхідного масиву ззовні
        drive.getSpeedSamples()[1] = 0;    // зміна копії, отриманої через геттер
        System.out.println("  Результати тестів диска: " + Arrays.toString(drive.getSpeedSamples())
                + " (очікується [7000, 7100, 7200])");
        System.out.println("===========================================================================");
    }
}

/** Материнська плата. */
class Motherboard {
    private final String model;
    private final String socketType;
    private final int maxExpansionSlots;

    public Motherboard(String model, String socketType, int maxExpansionSlots) {
        if (maxExpansionSlots < 1 || maxExpansionSlots > 8) {
            throw new IllegalArgumentException("Кількість слотів має бути від 1 до 8");
        }
        this.model = model;
        this.socketType = socketType;
        this.maxExpansionSlots = maxExpansionSlots;
    }

    public boolean isSocketCompatible(String cpuSocket) {
        return socketType.equalsIgnoreCase(cpuSocket);
    }

    public String getModel() {
        return model;
    }

    public String getSocketType() {
        return socketType;
    }

    public int getMaxExpansionSlots() {
        return maxExpansionSlots;
    }
}

/** Блок живлення. */
class PowerSupplyUnit {
    private final String model;
    private final int maxOutputWatts;
    private final double efficiencyCoefficient;

    public PowerSupplyUnit(String model, int maxOutputWatts, double efficiencyCoefficient) {
        if (maxOutputWatts <= 0) {
            throw new IllegalArgumentException("Потужність БЖ має бути > 0");
        }
        if (efficiencyCoefficient < 0.80 || efficiencyCoefficient > 0.96) {
            throw new IllegalArgumentException("ККД має бути в межах [0.80; 0.96]");
        }
        this.model = model;
        this.maxOutputWatts = maxOutputWatts;
        this.efficiencyCoefficient = efficiencyCoefficient;
    }

    /** Безпечна тривала потужність: 15% запасу міцності. */
    public int getSafeContinuousWatts() {
        return (int) (maxOutputWatts * 0.85);
    }

    /** Скільки станція тягне з розетки з урахуванням ККД. */
    public double calculateWallPowerDraw(int internalLoadWatts) {
        return internalLoadWatts / efficiencyCoefficient;
    }

    public String getModel() {
        return model;
    }

    public double getEfficiencyCoefficient() {
        return efficiencyCoefficient;
    }
}

/** Абстрактна комплектуюча. */
abstract class AbstractHardwareComponent {
    private final String modelName;
    private final double priceUah;

    public AbstractHardwareComponent(String modelName, double priceUah) {
        if (priceUah < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною");
        }
        this.modelName = modelName;
        this.priceUah = priceUah;
    }

    public abstract int getPowerWatts();

    public abstract double getBenchmarkScore();

    public abstract String getCategory();

    public String getModelName() {
        return modelName;
    }

    public double getPriceUah() {
        return priceUah;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%d Вт | Score: %.1f)",
                getCategory(), modelName, getPowerWatts(), getBenchmarkScore());
    }
}

class ProcessorUnit extends AbstractHardwareComponent {
    private final String socket;
    private final int cores;
    private final double boostClockGhz;
    private final int tdpWatts;

    public ProcessorUnit(String modelName, double priceUah, String socket,
                         int cores, double boostClockGhz, int tdpWatts) {
        super(modelName, priceUah);
        this.socket = socket;
        this.cores = cores;
        this.boostClockGhz = boostClockGhz;
        this.tdpWatts = tdpWatts;
    }

    public String getSocket() {
        return socket;
    }

    @Override
    public int getPowerWatts() {
        return tdpWatts;
    }

    @Override
    public double getBenchmarkScore() {
        return cores * boostClockGhz * 120.0;
    }

    @Override
    public String getCategory() {
        return "CPU";
    }
}

class GraphicsAccelerator extends AbstractHardwareComponent {
    private final int vramGb;
    private final int tensorCores;
    private final int boardPowerWatts;

    public GraphicsAccelerator(String modelName, double priceUah, int vramGb,
                               int tensorCores, int boardPowerWatts) {
        super(modelName, priceUah);
        this.vramGb = vramGb;
        this.tensorCores = tensorCores;
        this.boardPowerWatts = boardPowerWatts;
    }

    @Override
    public int getPowerWatts() {
        return boardPowerWatts;
    }

    @Override
    public double getBenchmarkScore() {
        return vramGb * 250.0 + tensorCores * 1.5;
    }

    @Override
    public String getCategory() {
        return "GPU";
    }
}

class NvmeSsdDrive extends AbstractHardwareComponent {
    private final int capacityGb;
    private final int readSpeedMbSec;
    private final int[] speedSamples;

    public NvmeSsdDrive(String modelName, double priceUah, int capacityGb,
                        int readSpeedMbSec, int[] speedSamples) {
        super(modelName, priceUah);
        this.capacityGb = capacityGb;
        this.readSpeedMbSec = readSpeedMbSec;
        // захисна копія на вході
        this.speedSamples = (speedSamples == null)
                ? new int[0] : Arrays.copyOf(speedSamples, speedSamples.length);
    }

    /** Захисна копія на виході. */
    public int[] getSpeedSamples() {
        return Arrays.copyOf(speedSamples, speedSamples.length);
    }

    public int getCapacityGb() {
        return capacityGb;
    }

    @Override
    public int getPowerWatts() {
        return 12;
    }

    @Override
    public double getBenchmarkScore() {
        return readSpeedMbSec * 0.25;
    }

    @Override
    public String getCategory() {
        return "NVMe SSD";
    }
}

/** Робоча станція компонує плату, БЖ та масив комплектуючих. */
class WorkstationPC {
    private final String buildName;
    private final Motherboard motherboard;
    private final PowerSupplyUnit psu;
    private final AbstractHardwareComponent[] components;
    private int componentCount;

    public WorkstationPC(String buildName, Motherboard motherboard, PowerSupplyUnit psu) {
        this.buildName = buildName;
        this.motherboard = motherboard;
        this.psu = psu;
        this.components = new AbstractHardwareComponent[motherboard.getMaxExpansionSlots()];
    }

    public boolean installComponent(AbstractHardwareComponent comp) {
        if (comp == null) {
            return false;
        }
        // 1) вільний слот
        if (componentCount >= motherboard.getMaxExpansionSlots()) {
            System.out.println("\u274C Відмова: немає вільних слотів для " + comp.getModelName() + "!");
            return false;
        }
        // 2) сумісність сокета для процесора
        if (comp instanceof ProcessorUnit cpu && !motherboard.isSocketCompatible(cpu.getSocket())) {
            System.out.println("\u274C Відмова: Процесор " + cpu.getModelName() + " (" + cpu.getSocket()
                    + ") несумісний із платою " + motherboard.getModel()
                    + " (Сокет " + motherboard.getSocketType() + ")!");
            return false;
        }
        // 3) запас потужності БЖ
        int newTotal = getTotalPowerWatts() + comp.getPowerWatts();
        if (newTotal > psu.getSafeContinuousWatts()) {
            System.out.println("\u26D4 Відмова: " + comp.getModelName() + " перевантажить БЖ ("
                    + newTotal + " Вт > безпечних " + psu.getSafeContinuousWatts() + " Вт)!");
            return false;
        }
        components[componentCount++] = comp;
        System.out.println("\u2705 Встановлено: " + comp);
        return true;
    }

    public int getTotalPowerWatts() {
        int sum = 0;
        for (int i = 0; i < componentCount; i++) {
            sum += components[i].getPowerWatts();
        }
        return sum;
    }

    public double getTotalSystemScore() {
        double sum = 0;
        for (int i = 0; i < componentCount; i++) {
            sum += components[i].getBenchmarkScore();
        }
        return sum;
    }

    public double getTotalBuildPrice() {
        double sum = 0;
        for (int i = 0; i < componentCount; i++) {
            sum += components[i].getPriceUah();
        }
        return sum;
    }

    @Override
    public String toString() {
        int load = getTotalPowerWatts();
        boolean stable = load <= psu.getSafeContinuousWatts();
        StringBuilder sb = new StringBuilder();
        sb.append("[ПАСПОРТ ЗБІРКИ '").append(buildName).append("']:\n");
        sb.append(String.format("  Материнська плата: %s (Socket: %s, Слотів: %d/%d)%n",
                motherboard.getModel(), motherboard.getSocketType(),
                componentCount, motherboard.getMaxExpansionSlots()));
        sb.append(String.format("  Блок живлення:     %s (Безпечний ліміт 85%%: %d Вт, ККД: %d%%)%n",
                psu.getModel(), psu.getSafeContinuousWatts(),
                Math.round(psu.getEfficiencyCoefficient() * 100)));
        sb.append(String.format("  Внутрішнє споживання: %d Вт (З розетки з урахуванням ККД: %.2f Вт) -> %s%n",
                load, psu.calculateWallPowerDraw(load), stable ? "СТАБІЛЬНО!" : "ПЕРЕВАНТАЖЕННЯ!"));
        sb.append(String.format("  Сумарний індекс продуктивності: %.2f балів%n", getTotalSystemScore()));
        sb.append(String.format("  Загальна вартість конфігурації: %.2f грн", getTotalBuildPrice()));
        return sb.toString();
    }
}
