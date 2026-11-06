package semester1.practice09;

// =====================================================================
// БЛОК 2 (Завдання 9–16): композиція та агрегація (HAS-A, 1-до-1),
// делегування викликів
// =====================================================================

/** Завдання 9: точка на площині (використовується також у завданнях 12 і 17). */
class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D other) { // конструктор копіювання
        this(other.x, other.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public double distanceTo(Point2D other) {
        return Math.hypot(x - other.x, y - other.y);
    }

    @Override
    public String toString() {
        return String.format("(%.2f; %.2f)", x, y);
    }
}

/** Завдання 9: коло НЕ успадковує точку, а ВОЛОДІЄ нею (композиція). */
class CompositeCircle {
    private double radius;
    private final Point2D center;

    public CompositeCircle(double centerX, double centerY, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радіус має бути > 0");
        }
        this.center = new Point2D(centerX, centerY); // об'єкт створюється всередині
        this.radius = radius;
    }

    public boolean containsPoint(Point2D p) {
        return center.distanceTo(p) <= radius; // делегування
    }

    @Override
    public String toString() {
        return "CompositeCircle[center=" + center + ", r=" + radius + "]";
    }
}

/** Завдання 10: двигун. */
class Engine {
    private static final int IDLE_RPM = 800;
    private static final int MAX_RPM = 7000;

    private final String fuelType;
    private final int volumeCc;
    private int rpm;
    private boolean started;

    public Engine(String fuelType, int volumeCc) {
        this.fuelType = fuelType;
        this.volumeCc = volumeCc;
    }

    public void start() {
        started = true;
        rpm = IDLE_RPM;
    }

    public void stop() {
        started = false;
        rpm = 0;
    }

    public void setRpm(int rpm) {
        if (started) {
            this.rpm = Math.max(0, Math.min(MAX_RPM, rpm));
        }
    }

    public boolean isStarted() {
        return started;
    }

    public int getRpm() {
        return rpm;
    }

    @Override
    public String toString() {
        return "Engine[" + fuelType + ", " + volumeCc + " см3, " + rpm + " об/хв, "
                + (started ? "заведений" : "заглушений") + "]";
    }
}

/** Завдання 10: автомобіль компонує двигун і делегує йому стан. */
class Automobile {
    private static final double MAX_SPEED = 220.0;

    private final String model;
    private double speed;
    private final Engine engine;

    public Automobile(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public void accelerate(double deltaSpeed) {
        if (!engine.isStarted()) {
            System.out.println("  " + model + ": двигун не заведений, розгін неможливий");
            return;
        }
        if (deltaSpeed <= 0) {
            return;
        }
        speed = Math.min(MAX_SPEED, speed + deltaSpeed);
        engine.setRpm((int) (800 + speed * 30)); // оберти ростуть разом зі швидкістю
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return String.format("Automobile[%s, %.0f км/год, %s]", model, speed, engine);
    }
}

/** Завдання 11: акумулятор. */
class Battery {
    private final int capacityMah;
    private int chargePercent;

    public Battery(int capacityMah, int chargePercent) {
        this.capacityMah = capacityMah;
        this.chargePercent = Math.max(0, Math.min(100, chargePercent));
    }

    public void drain(int percent) {
        chargePercent = Math.max(0, chargePercent - Math.max(0, percent));
    }

    public void charge(int percent) {
        chargePercent = Math.min(100, chargePercent + Math.max(0, percent));
    }

    public int getChargePercent() {
        return chargePercent;
    }

    @Override
    public String toString() {
        return capacityMah + " мА·год, заряд " + chargePercent + "%";
    }
}

/** Завдання 11: дисплей. */
class Display {
    private final double diagonalInches;
    private int brightnessPercent;

    public Display(double diagonalInches, int brightnessPercent) {
        this.diagonalInches = diagonalInches;
        setBrightnessPercent(brightnessPercent);
    }

    public void setBrightnessPercent(int value) {
        this.brightnessPercent = Math.max(10, Math.min(100, value));
    }

    public int getBrightnessPercent() {
        return brightnessPercent;
    }

    @Override
    public String toString() {
        return diagonalInches + "\", яскравість " + brightnessPercent + "%";
    }
}

/** Завдання 11: пристрій компонує батарею і дисплей. */
class SmartDevice {
    private final Battery battery;
    private final Display display;
    private boolean poweredOn = true;

    public SmartDevice(Battery battery, Display display) {
        this.battery = battery;
        this.display = display;
    }

    public void watchVideo(int minutes) {
        if (!poweredOn) {
            System.out.println("  Пристрій вимкнений");
            return;
        }
        int lossPer10Min = display.getBrightnessPercent() > 70 ? 2 : 1;
        battery.drain((minutes / 10) * lossPer10Min);
        if (battery.getChargePercent() == 0) {
            poweredOn = false;
            System.out.println("  Батарея розряджена, пристрій вимкнувся");
        }
    }

    public Display getDisplay() {
        return display;
    }

    @Override
    public String toString() {
        return "SmartDevice[" + (poweredOn ? "увімкнений" : "вимкнений")
                + "; батарея: " + battery + "; дисплей: " + display + "]";
    }
}

/** Завдання 12: відрізок із двох точок із захисним копіюванням. */
class LineSegment {
    private final Point2D start;
    private final Point2D end;

    public LineSegment(Point2D start, Point2D end) {
        this.start = new Point2D(start.getX(), start.getY()); // захисні копії
        this.end = new Point2D(end.getX(), end.getY());
    }

    public double getLength() {
        return start.distanceTo(end);
    }

    public Point2D getMidpoint() {
        return new Point2D((start.getX() + end.getX()) / 2.0, (start.getY() + end.getY()) / 2.0);
    }

    @Override
    public String toString() {
        return "LineSegment[" + start + " -> " + end + ", довжина=" + String.format("%.2f", getLength()) + "]";
    }
}

/** Завдання 13: банківський рахунок. */
class BankAccount {
    private final String iban;
    private double balance;

    public BankAccount(String iban, double balance) {
        this.iban = iban;
        this.balance = Math.max(0, balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("BankAccount[%s, %.2f грн]", iban, balance);
    }
}

/** Завдання 13: картка АГРЕГУЄ рахунок (рахунок живе і без картки). */
class PlasticCard {
    private final String cardNumber;
    private final String expiryDate;
    private boolean blocked;
    private final BankAccount linkedAccount;

    public PlasticCard(String cardNumber, String expiryDate, BankAccount linkedAccount) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.linkedAccount = linkedAccount;
    }

    public void block() {
        blocked = true;
    }

    public boolean payAtTerminal(double amount) {
        if (blocked) {
            return false;
        }
        return linkedAccount.withdraw(amount); // делегування
    }

    @Override
    public String toString() {
        String masked = "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
        return "PlasticCard[" + masked + ", до " + expiryDate + (blocked ? ", ЗАБЛОКОВАНА" : "") + "]";
    }
}

/** Завдання 14: зброя з міцністю. */
class WeaponItem {
    private final String name;
    private final int bonusDamage;
    private int durability;

    public WeaponItem(String name, int bonusDamage, int durability) {
        this.name = name;
        this.bonusDamage = bonusDamage;
        this.durability = Math.max(0, Math.min(100, durability));
    }

    /** Повертає бонус цього удару, після чого міцність падає на 10. */
    public int useWeapon() {
        int bonus = (durability == 0) ? 0 : bonusDamage;
        durability = Math.max(0, durability - 10);
        return bonus;
    }

    public int getDurability() {
        return durability;
    }

    @Override
    public String toString() {
        return name + " (+" + bonusDamage + ", міцність " + durability + ")";
    }
}

/** Завдання 14: герой може змінювати зброю на льоту. */
class HeroCharacter {
    private final String nickname;
    private final int baseStrength;
    private WeaponItem equippedWeapon;

    public HeroCharacter(String nickname, int baseStrength) {
        this.nickname = nickname;
        this.baseStrength = baseStrength;
    }

    public void equip(WeaponItem newWeapon) {
        this.equippedWeapon = newWeapon;
    }

    public void unequip() {
        this.equippedWeapon = null;
    }

    public int attack() {
        int bonus = (equippedWeapon != null) ? equippedWeapon.useWeapon() : 0;
        return baseStrength + bonus;
    }

    @Override
    public String toString() {
        return nickname + " (сила " + baseStrength + ", зброя: "
                + (equippedWeapon != null ? equippedWeapon : "немає") + ")";
    }
}

/** Завдання 15: адреса доставки. */
class DeliveryAddress {
    private final String city;
    private final String street;
    private final int postOfficeNumber;

    public DeliveryAddress(String city, String street, int postOfficeNumber) {
        this.city = city;
        this.street = street;
        this.postOfficeNumber = postOfficeNumber;
    }

    public DeliveryAddress(DeliveryAddress other) { // копіювання
        this(other.city, other.street, other.postOfficeNumber);
    }

    public boolean isValid() {
        return city != null && !city.isBlank() && street != null && !street.isBlank()
                && postOfficeNumber > 0;
    }

    @Override
    public String toString() {
        return city + ", " + street + ", відділення №" + postOfficeNumber;
    }
}

/** Завдання 15: змінити адресу можна лише до відправки. */
class ParcelOrder {
    private final String orderId;
    private final double weightKg;
    private DeliveryAddress destination;
    private boolean shipped;

    public ParcelOrder(String orderId, double weightKg, DeliveryAddress destination) {
        this.orderId = orderId;
        this.weightKg = weightKg;
        this.destination = new DeliveryAddress(destination); // захисна копія
    }

    public boolean changeDestination(DeliveryAddress newAddress) {
        if (shipped || newAddress == null || !newAddress.isValid()) {
            return false;
        }
        this.destination = new DeliveryAddress(newAddress);
        return true;
    }

    public void markAsShipped() {
        shipped = true;
    }

    @Override
    public String toString() {
        return String.format("ParcelOrder[%s, %.1f кг, куди: %s, %s]",
                orderId, weightKg, destination, shipped ? "ВІДПРАВЛЕНО" : "готується");
    }
}

/** Завдання 16: датчик температури. */
class TemperatureSensor {
    private double currentTemp;

    public TemperatureSensor(double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }
}

/** Завдання 16: обігрівач. */
class HeatingUnit {
    private boolean heatingOn;
    private final double powerKw;

    public HeatingUnit(double powerKw) {
        this.powerKw = powerKw;
    }

    public void turnOn() {
        heatingOn = true;
    }

    public void turnOff() {
        heatingOn = false;
    }

    public boolean isHeatingOn() {
        return heatingOn;
    }

    public double getPowerKw() {
        return powerKw;
    }
}

/** Завдання 16: контролер компонує датчик і обігрівач. */
class ClimateController {
    private final TemperatureSensor sensor;
    private final HeatingUnit heater;
    private final double targetTemp;

    public ClimateController(double startTemp, double targetTemp, double heaterPowerKw) {
        this.sensor = new TemperatureSensor(startTemp);
        this.heater = new HeatingUnit(heaterPowerKw);
        this.targetTemp = targetTemp;
    }

    /** У реальному житті датчик сам вимірює; тут задаємо температуру вручну. */
    public void updateRoomTemperature(double temp) {
        sensor.setCurrentTemp(temp);
    }

    public void regulate() {
        double current = sensor.getCurrentTemp();
        if (current < targetTemp - 0.5) {
            heater.turnOn();
        } else if (current >= targetTemp) {
            heater.turnOff();
        } // між цими значеннями стан не змінюється (гістерезис)
    }

    @Override
    public String toString() {
        return String.format("ClimateController[зараз %.1f°C, ціль %.1f°C, обігрів %s (%.1f кВт)]",
                sensor.getCurrentTemp(), targetTemp,
                heater.isHeatingOn() ? "УВІМКНЕНО" : "вимкнено", heater.getPowerKw());
    }
}
