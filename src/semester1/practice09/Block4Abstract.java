package semester1.practice09;

// =====================================================================
// БЛОК 4 (Завдання 25–32): абстрактні класи, абстрактні методи
// та шаблонний метод (Template Method)
// =====================================================================

/** Завдання 25: абстрактна фігура. toString() у базовому класі викликає абстрактні методи. */
abstract class AbstractShape {
    private final String color;

    public AbstractShape(String color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s[колір=%s, площа=%.2f, периметр=%.2f]",
                getClass().getSimpleName(), color, getArea(), getPerimeter());
    }
}

class CircleShape extends AbstractShape {
    private final double radius;

    public CircleShape(String color, double radius) {
        super(color);
        if (radius <= 0) {
            throw new IllegalArgumentException("Радіус має бути > 0");
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class RectangleShape extends AbstractShape {
    private final double width;
    private final double height;

    public RectangleShape(String color, double width, double height) {
        super(color);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Сторони мають бути > 0");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

/** Завдання 26: абстрактна електростанція. */
abstract class AbstractPowerPlant {
    private final String stationName;
    protected double baseCapacityMw;

    public AbstractPowerPlant(String stationName, double baseCapacityMw) {
        this.stationName = stationName;
        this.baseCapacityMw = baseCapacityMw;
    }

    public abstract double generateMegawatts();

    /** Прибуток за добу = потужність * 24 години * тариф. */
    public double calculateDailyProfit(double tariffPerMwh) {
        return generateMegawatts() * 24 * tariffPerMwh;
    }

    public String getStationName() {
        return stationName;
    }
}

class SolarPowerPlant extends AbstractPowerPlant {
    private final double sunIntensityFactor; // 0.0 .. 1.0

    public SolarPowerPlant(String name, double capacityMw, double sunIntensityFactor) {
        super(name, capacityMw);
        this.sunIntensityFactor = Math.max(0.0, Math.min(1.0, sunIntensityFactor));
    }

    @Override
    public double generateMegawatts() {
        return baseCapacityMw * sunIntensityFactor;
    }
}

class WindPowerPlant extends AbstractPowerPlant {
    private final double windSpeedMs;

    public WindPowerPlant(String name, double capacityMw, double windSpeedMs) {
        super(name, capacityMw);
        this.windSpeedMs = windSpeedMs;
    }

    /** < 3 або > 25 м/с турбіна стоїть; від 3 до 12 м/с потужність росте лінійно; далі повна. */
    @Override
    public double generateMegawatts() {
        if (windSpeedMs < 3 || windSpeedMs > 25) {
            return 0;
        }
        double share = Math.min(1.0, (windSpeedMs - 3) / (12 - 3));
        return baseCapacityMw * share;
    }
}

/** Завдання 27: співробітник; calculateNetSalary() — фінальний шаблонний метод. */
abstract class AbstractEmployee {
    private final int id;
    private final String name;
    protected double taxRate = 0.195;

    public AbstractEmployee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract double calculateGrossSalary();

    public final double calculateNetSalary() {
        return calculateGrossSalary() * (1.0 - taxRate);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s #%d %s: брутто %.2f, на руки %.2f",
                getClass().getSimpleName(), id, name, calculateGrossSalary(), calculateNetSalary());
    }
}

class SalariedEmployee extends AbstractEmployee {
    private final double monthlySalary;
    private final double bonus;

    public SalariedEmployee(int id, String name, double monthlySalary, double bonus) {
        super(id, name);
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateGrossSalary() {
        return monthlySalary + bonus;
    }
}

class HourlyContractor extends AbstractEmployee {
    private final int hoursWorked;
    private final double hourlyRate;

    public HourlyContractor(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    /** Години понад 160 оплачуються з коефіцієнтом 1.5. */
    @Override
    public double calculateGrossSalary() {
        int regular = Math.min(hoursWorked, 160);
        int overtime = Math.max(0, hoursWorked - 160);
        return regular * hourlyRate + overtime * hourlyRate * 1.5;
    }
}

/** Завдання 28: послідовність; sumFirstN — шаблонний метод. */
abstract class AbstractSequence {
    private final String title;

    public AbstractSequence(String title) {
        this.title = title;
    }

    public abstract double getTerm(int index);

    public double sumFirstN(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += getTerm(i);
        }
        return sum;
    }

    public String getTitle() {
        return title;
    }
}

class HarmonicSequence extends AbstractSequence {
    public HarmonicSequence() {
        super("Гармонічна: a(n) = 1/n");
    }

    @Override
    public double getTerm(int index) {
        return 1.0 / index;
    }
}

class SquareNumbersSequence extends AbstractSequence {
    public SquareNumbersSequence() {
        super("Квадрати: a(n) = n^2");
    }

    @Override
    public double getTerm(int index) {
        return (double) index * index;
    }
}

/** Завдання 29: абстрактний переказ. */
abstract class AbstractTransaction {
    private final String txId;
    protected final double amount;

    public AbstractTransaction(String txId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума має бути > 0");
        }
        this.txId = txId;
        this.amount = amount;
    }

    public abstract double calculateCommission();

    public final double getTotalDebit() {
        return amount + calculateCommission();
    }

    public String getTxId() {
        return txId;
    }
}

class DomesticTransfer extends AbstractTransaction {
    public DomesticTransfer(String txId, double amount) {
        super(txId, amount);
    }

    /** 0.5%, але не менше 5 грн. */
    @Override
    public double calculateCommission() {
        return Math.max(amount * 0.005, 5.0);
    }
}

class CryptoTransfer extends AbstractTransaction {
    private final double networkGasFee;

    public CryptoTransfer(String txId, double amount, double networkGasFee) {
        super(txId, amount);
        this.networkGasFee = networkGasFee;
    }

    @Override
    public double calculateCommission() {
        return networkGasFee;
    }
}

/** Завдання 30: 3D-тіло. Масу рахує фінальний метод через абстрактний об'єм. */
abstract class Solid3D {
    private final String materialName;
    private final double densityKgPerM3;

    public Solid3D(String materialName, double densityKgPerM3) {
        this.materialName = materialName;
        this.densityKgPerM3 = densityKgPerM3;
    }

    public abstract double getVolume();

    public abstract double getSurfaceArea();

    public final double getMassKg() {
        return densityKgPerM3 * getVolume();
    }

    public String getMaterialName() {
        return materialName;
    }
}

class Sphere3D extends Solid3D {
    private final double radius;

    public Sphere3D(String material, double density, double radius) {
        super(material, density);
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }
}

class Cylinder3D extends Solid3D {
    private final double radius;
    private final double height;

    public Cylinder3D(String material, double density, double radius, double height) {
        super(material, density);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}

/** Завдання 31 (використовується також у завданні 38): датчик телеметрії. */
abstract class AbstractSensor {
    private final String location;
    private final double minSafe;
    private final double maxSafe;

    public AbstractSensor(String location, double minSafe, double maxSafe) {
        if (minSafe > maxSafe) {
            throw new IllegalArgumentException("minSafe не може бути більшим за maxSafe");
        }
        this.location = location;
        this.minSafe = minSafe;
        this.maxSafe = maxSafe;
    }

    public abstract double readValue();

    public abstract String getUnit();

    public final boolean isAlarmTriggered() {
        double v = readValue();
        return v < minSafe || v > maxSafe;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return String.format("%s '%s': %.2f %s (норма %.1f..%.1f)",
                getClass().getSimpleName(), location, readValue(), getUnit(), minSafe, maxSafe);
    }
}

class PressureSensor extends AbstractSensor {
    private double rawReading;
    private final double calibrationFactor;

    public PressureSensor(String location, double minSafe, double maxSafe, double calibrationFactor) {
        super(location, minSafe, maxSafe);
        this.calibrationFactor = calibrationFactor;
    }

    public void setRawReading(double rawReading) {
        this.rawReading = rawReading;
    }

    @Override
    public double readValue() {
        return rawReading * calibrationFactor;
    }

    @Override
    public String getUnit() {
        return "бар";
    }
}

class RadiationSensor extends AbstractSensor {
    private double microSvPerHour;

    public RadiationSensor(String location, double minSafe, double maxSafe) {
        super(location, minSafe, maxSafe);
    }

    public void setMicroSvPerHour(double value) {
        this.microSvPerHour = value;
    }

    @Override
    public double readValue() {
        return microSvPerHour;
    }

    @Override
    public String getUnit() {
        return "мкЗв/год";
    }
}

/** Завдання 32: архіватор. */
abstract class AbstractCompressor {
    private final String algorithmName;

    public AbstractCompressor(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public abstract int estimateCompressedSize(int originalSizeBytes);

    /** Відсоток стиснення. Від'ємне значення означає, що файл ЗБІЛЬШИВСЯ. */
    public double getCompressionRatio(int originalSizeBytes) {
        if (originalSizeBytes <= 0) {
            return 0;
        }
        double compressed = estimateCompressedSize(originalSizeBytes);
        return (1.0 - compressed / originalSizeBytes) * 100.0;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }
}

class ZipCompressor extends AbstractCompressor {
    public ZipCompressor() {
        super("ZIP");
    }

    @Override
    public int estimateCompressedSize(int originalSizeBytes) {
        return (int) Math.round(originalSizeBytes * 0.55); // стискає на 45%
    }
}

class UltraLzmaCompressor extends AbstractCompressor {
    private static final int HEADER_BYTES = 128;

    public UltraLzmaCompressor() {
        super("Ultra LZMA");
    }

    @Override
    public int estimateCompressedSize(int originalSizeBytes) {
        return (int) Math.round(originalSizeBytes * 0.30) + HEADER_BYTES; // стискає на 70% + заголовок
    }
}
