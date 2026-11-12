package semester1.practice10;

import java.util.Arrays;
import java.util.Locale;

public class Practice10 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("=== БЛОК 1: Динамічний поліморфізм, Upcasting та Поліморфні масиви ===");
        runBlock1();

        System.out.println("\n=== БЛОК 2: Інтерфейси, Константи, default/static та Множинна реалізація ===");
        runBlock2();

        System.out.println("\n=== БЛОК 3: abstract class проти interface та Синергія ===");
        runBlock3();

        System.out.println("\n=== БЛОК 4: Оператор instanceof, Downcasting та Pattern Matching ===");
        runBlock4();

        System.out.println("\n=== БЛОК 5: Ключове слово final та Комплексна синергія ===");
        runBlock5();
    }

    // =========================================================================
    // БЛОК 1: Динамічний поліморфізм, Upcasting та Поліморфні масиви (1–8)
    // =========================================================================
    private static void runBlock1() {
        // Завдання 1
        PaymentInstrument[] payments = {
                new BankCardInstrument("Іван Петренко"),
                new CryptoTokenInstrument("Олена Коваль", 45.0),
                new IbanDirectInstrument("ТОВ Вектор")
        };
        double totalSpent = 0;
        for (PaymentInstrument p : payments) {
            totalSpent += p.processPayment(10_000.0);
        }
        System.out.printf("Завдання 1: Сумарні витрати на 3 платежі по 10 000 грн = %.2f грн%n", totalSpent);

        // Завдання 2
        Shape2D[] shapes = {
                new CircleShape(5.0),
                new RectangleShape(4.0, 6.0),
                new EquilateralTriangleShape(8.0)
        };
        Shape2D maxShape = findMaxAreaShape(shapes);
        System.out.printf("Завдання 2: Найбільша площа = %.2f (Периметр = %.2f)%n", maxShape.getArea(), maxShape.getPerimeter());

        // Завдання 3
        VectorMathOverload overload = new VectorMathOverload();
        System.out.printf("Завдання 3 (Overloading): 1D=%.2f, 2D=%.2f, ND=%.2f%n",
                overload.norm(-5.0), overload.norm(3.0, 4.0), overload.norm(new double[]{1, 2, 2}));
        BinaryOperation[] ops = {new AddOp(), new MultiplyOp(), new HypotenuseOp()};
        System.out.print("Завдання 3 (Overriding для 3 і 4): ");
        for (BinaryOperation op : ops) {
            System.out.printf("%.2f ", op.apply(3.0, 4.0));
        }
        System.out.println();

        // Завдання 4
        NotificationSender[] senders = {
                new EmailSender("admin@duikt.edu.ua"),
                new SmsSender("+380501234567"),
                new TelegramBotSender("@student_knd12")
        };
        broadcastAlert(senders, "Увага! Повітряна тривога в Київській області. Пройдіть в укриття негайно!");

        // Завдання 5
        ShippingTariff[] tariffs = {new RoadTruckTariff(), new AirCargoTariff(), new RailFreightTariff()};
        ShippingTariff bestTariff = tariffs[0];
        for (ShippingTariff t : tariffs) {
            if (t.calculateCost(250, 600) < bestTariff.calculateCost(250, 600)) {
                bestTariff = t;
            }
        }
        System.out.printf("Завдання 5: Найвигідніший тариф коштує %.2f грн%n", bestTariff.calculateCost(250, 600));

        // Завдання 6
        DifferentiableFunction[] funcs = {
                new QuadraticParabola(2, -3, 1),
                new NaturalLogFunction(5),
                new ExponentialGrowth(1.5, 0.5)
        };
        System.out.println("Завдання 6 (x = 2.0):");
        for (DifferentiableFunction fn : funcs) {
            System.out.printf("  f(2) = %.4f | f'(2) = %.4f%n", fn.f(2.0), fn.derivativeAt(2.0));
        }

        // Завдання 7
        UiWidget[] widgets = {
                new ButtonWidget("btn-save", 120, 40, "Зберегти"),
                new TextInputWidget("inp-name", 250, 35, "Введіть ім'я"),
                new ProgressBarWidget("pb-load", 300, 20, 75)
        };
        System.out.println("Завдання 7 HTML:\n" + buildHtmlPage(widgets));

        // Завдання 8
        IndustrialAsset[] assets = {
                new LinearDepreciationAsset("Верстат ЧПК", 500_000, 10),
                new DecliningBalanceAsset("Промисловий робот", 800_000, 8, 0.25)
        };
        double totalBookValue = 0;
        for (IndustrialAsset a : assets) {
            totalBookValue += a.getBookValueAfterYears(3);
        }
        System.out.printf("Завдання 8: Залишкова вартість цеху через 3 роки = %.2f грн%n", totalBookValue);
    }

    // --- Класи Блоку 1 ---
    static abstract class PaymentInstrument {
        private final String payerName;
        public PaymentInstrument(String payerName) { this.payerName = payerName; }
        public String getPayerName() { return payerName; }
        public abstract double calculateFee(double amount);
        public double processPayment(double amount) { return amount + calculateFee(amount); }
    }
    static class BankCardInstrument extends PaymentInstrument {
        public BankCardInstrument(String payerName) { super(payerName); }
        @Override public double calculateFee(double amount) { return amount * 0.015 + 5.0; }
    }
    static class CryptoTokenInstrument extends PaymentInstrument {
        private final double gasFeeUah;
        public CryptoTokenInstrument(String payerName, double gasFeeUah) { super(payerName); this.gasFeeUah = gasFeeUah; }
        @Override public double calculateFee(double amount) { return gasFeeUah; }
    }
    static class IbanDirectInstrument extends PaymentInstrument {
        public IbanDirectInstrument(String payerName) { super(payerName); }
        @Override public double calculateFee(double amount) { return amount <= 50_000 ? 0.0 : amount * 0.005; }
    }

    static abstract class Shape2D {
        public abstract double getArea();
        public abstract double getPerimeter();
    }
    static class CircleShape extends Shape2D {
        private final double r;
        public CircleShape(double r) { this.r = r; }
        @Override public double getArea() { return Math.PI * r * r; }
        @Override public double getPerimeter() { return 2 * Math.PI * r; }
        public double getDiameter() { return 2 * r; }
    }
    static class RectangleShape extends Shape2D {
        private final double a, b;
        public RectangleShape(double a, double b) { this.a = a; this.b = b; }
        @Override public double getArea() { return a * b; }
        @Override public double getPerimeter() { return 2 * (a + b); }
        public double getDiagonal() { return Math.hypot(a, b); }
        public boolean isSquare() { return Math.abs(a - b) < 1e-9; }
    }
    static class EquilateralTriangleShape extends Shape2D {
        private final double a;
        public EquilateralTriangleShape(double a) { this.a = a; }
        @Override public double getArea() { return (Math.sqrt(3) / 4.0) * a * a; }
        @Override public double getPerimeter() { return 3 * a; }
    }
    public static Shape2D findMaxAreaShape(Shape2D[] shapes) {
        Shape2D max = shapes[0];
        for (Shape2D s : shapes) if (s.getArea() > max.getArea()) max = s;
        return max;
    }

    static class VectorMathOverload {
        public double norm(double x) { return Math.abs(x); }
        public double norm(double x, double y) { return Math.hypot(x, y); }
        public double norm(double[] v) {
            double sum = 0;
            for (double val : v) sum += val * val;
            return Math.sqrt(sum);
        }
    }
    static abstract class BinaryOperation { public abstract double apply(double a, double b); }
    static class AddOp extends BinaryOperation { @Override public double apply(double a, double b) { return a + b; } }
    static class MultiplyOp extends BinaryOperation { @Override public double apply(double a, double b) { return a * b; } }
    static class HypotenuseOp extends BinaryOperation { @Override public double apply(double a, double b) { return Math.hypot(a, b); } }

    static class NotificationSender {
        protected final String recipient;
        public NotificationSender(String recipient) { this.recipient = recipient; }
        public String send(String message) { return "To " + recipient + ": " + message; }
    }
    static class EmailSender extends NotificationSender {
        public EmailSender(String recipient) { super(recipient); }
        @Override public String send(String message) { return "[EMAIL -> " + recipient + "] Subject: ALERT | " + message; }
    }
    static class SmsSender extends NotificationSender {
        public SmsSender(String recipient) { super(recipient); }
        @Override public String send(String message) {
            String shortMsg = message.length() > 70 ? message.substring(0, 67) + "..." : message;
            return "[SMS -> " + recipient + "] " + shortMsg;
        }
    }
    static class TelegramBotSender extends NotificationSender {
        public TelegramBotSender(String recipient) { super(recipient); }
        @Override public String send(String message) { return "[TG -> " + recipient + "] 🚨 *" + message + "*"; }
    }
    public static void broadcastAlert(NotificationSender[] senders, String alertText) {
        System.out.println("Завдання 4 Розсилка:");
        for (NotificationSender s : senders) System.out.println("  " + s.send(alertText));
    }

    static abstract class ShippingTariff { public abstract double calculateCost(double weightKg, double distanceKm); }
    static class RoadTruckTariff extends ShippingTariff {
        @Override public double calculateCost(double w, double d) { return 15.0 * d + 2.5 * w; }
    }
    static class AirCargoTariff extends ShippingTariff {
        @Override public double calculateCost(double w, double d) { return 45.0 * d + 18.0 * w + 500.0; }
    }
    static class RailFreightTariff extends ShippingTariff {
        @Override public double calculateCost(double w, double d) { return 1200.0 + 4.0 * d + 0.8 * w; }
    }

    static abstract class DifferentiableFunction {
        public abstract double f(double x);
        public double derivativeAt(double x) {
            double h = 1e-5;
            return (f(x + h) - f(x - h)) / (2 * h);
        }
    }
    static class QuadraticParabola extends DifferentiableFunction {
        private final double a, b, c;
        public QuadraticParabola(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
        @Override public double f(double x) { return a * x * x + b * x + c; }
    }
    static class NaturalLogFunction extends DifferentiableFunction {
        private final double k;
        public NaturalLogFunction(double k) { this.k = k; }
        @Override public double f(double x) { return x > 0 ? k * Math.log(x) : Double.NaN; }
    }
    static class ExponentialGrowth extends DifferentiableFunction {
        private final double a, lambda;
        public ExponentialGrowth(double a, double lambda) { this.a = a; this.lambda = lambda; }
        @Override public double f(double x) { return a * Math.exp(lambda * x); }
    }

    static abstract class UiWidget {
        protected String id;
        protected int width, height;
        public UiWidget(String id, int width, int height) { this.id = id; this.width = width; this.height = height; }
        public abstract String renderHtml();
    }
    static class ButtonWidget extends UiWidget {
        private final String label;
        public ButtonWidget(String id, int w, int h, String label) { super(id, w, h); this.label = label; }
        @Override public String renderHtml() { return String.format("<button id='%s' style='width:%dpx;height:%dpx'>%s</button>", id, width, height, label); }
    }
    static class TextInputWidget extends UiWidget {
        private final String placeholder;
        public TextInputWidget(String id, int w, int h, String ph) { super(id, w, h); this.placeholder = ph; }
        @Override public String renderHtml() { return String.format("<input id='%s' placeholder='%s' style='width:%dpx;height:%dpx'/>", id, placeholder, width, height); }
    }
    static class ProgressBarWidget extends UiWidget {
        private final int percent;
        public ProgressBarWidget(String id, int w, int h, int p) { super(id, w, h); this.percent = Math.max(0, Math.min(100, p)); }
        @Override public String renderHtml() { return String.format("<progress id='%s' value='%d' max='100'></progress>", id, percent); }
    }
    private static String buildHtmlPage(UiWidget[] elements) {
        StringBuilder sb = new StringBuilder("<html><body>\n");
        for (UiWidget w : elements) sb.append("  ").append(w.renderHtml()).append("\n");
        return sb.append("</body></html>").toString();
    }

    static abstract class IndustrialAsset {
        private final String name;
        protected final double initialCost;
        protected final int usefulLifeYears;
        public IndustrialAsset(String name, double cost, int life) { this.name = name; this.initialCost = cost; this.usefulLifeYears = life; }
        public abstract double getBookValueAfterYears(int years);
    }
    static class LinearDepreciationAsset extends IndustrialAsset {
        public LinearDepreciationAsset(String name, double cost, int life) { super(name, cost, life); }
        @Override public double getBookValueAfterYears(int years) {
            return Math.max(0, initialCost * (1.0 - (double) years / usefulLifeYears));
        }
    }
    static class DecliningBalanceAsset extends IndustrialAsset {
        private final double rate;
        public DecliningBalanceAsset(String name, double cost, int life, double rate) { super(name, cost, life); this.rate = rate; }
        @Override public double getBookValueAfterYears(int years) {
            return initialCost * Math.pow(1.0 - rate, years);
        }
    }

    // =========================================================================
    // БЛОК 2: Інтерфейси, Константи, default/static та Множинна реалізація (9–16)
    // =========================================================================
    private static void runBlock2() {
        // Завдання 9
        Measurable[] items = {new BankVault(1250.5), new HighwayRoute(480.0), new CpuCore(4.8)};
        System.out.printf("Завдання 9: Середнє значення вимірювань = %.2f%n", computeAverage(items));

        // Завдання 10
        EnergyConvertible body = new KineticBody(1000.0, 30.0);
        EnergyConvertible cell = new BatteryCell(500.0);
        System.out.printf("Завдання 10: Кінетична енергія = %.4f кВт·год, Батарея = %.4f кВт·год%n",
                body.getEnergyKwh(), cell.getEnergyKwh());

        // Завдання 11
        AmphibiousRescueDrone drone = new AmphibiousRescueDrone();
        testFlight(drone);
        testDiving(drone);
        logPosition(drone);

        // Завдання 12
        DataValidator emailVal = new EmailValidator();
        DataValidator numVal = new PositiveNumberValidator();
        System.out.println("Завдання 12: " + emailVal.validateOrDefault("bad-email", "default@mail.com")
                + " | " + numVal.validateOrDefault("42.5", "0"));

        // Завдання 13
        EmergencyBeacon beacon = new EmergencyBeacon();
        System.out.println("Завдання 13 (Diamond resolved): " + beacon.emitAlert());

        // Завдання 14
        EscrowSmartContract contract = new EscrowSmartContract();
        System.out.println("Завдання 14: Підпис=" + contract.verifySignature("0xKEY")
                + ", Виконання=" + contract.executeContract(21000) + ", Аудит=" + contract.getAuditTrail());

        // Завдання 15
        Transformable2D[] scene = {new BoundingBox(0, 0, 10, 20), new CircleRegion(5, 5, 4)};
        applyGlobalTransform(scene, 10, -5, 2.0);
        System.out.println("Завдання 15: Об'єкти сцени трансформовано.");

        // Завдання 16
        DataExportable[] records = {
                new StudentGradeRecord("Марюха Євгеній", 12, 95.5),
                new WeatherObservation("Київ", 14.2, 65)
        };
        System.out.println("Завдання 16 (JSON / CSV):");
        for (DataExportable r : records) {
            System.out.println("  JSON: " + r.toJson() + " | CSV: " + r.toCsvRow());
        }
    }

    // --- Класи та інтерфейси Блоку 2 ---
    interface Measurable { double getMeasure(); }
    static class BankVault implements Measurable {
        private final double goldKg;
        public BankVault(double goldKg) { this.goldKg = goldKg; }
        @Override public double getMeasure() { return goldKg; }
    }
    static class HighwayRoute implements Measurable {
        private final double lengthKm;
        public HighwayRoute(double lengthKm) { this.lengthKm = lengthKm; }
        @Override public double getMeasure() { return lengthKm; }
    }
    static class CpuCore implements Measurable {
        private final double ghz;
        public CpuCore(double ghz) { this.ghz = ghz; }
        @Override public double getMeasure() { return ghz; }
    }
    public static double computeAverage(Measurable[] items) {
        double sum = 0;
        for (Measurable m : items) sum += m.getMeasure();
        return sum / items.length;
    }

    interface EnergyConvertible {
        double SPEED_OF_LIGHT = 299_792_458.0;
        double JOULES_PER_KWH = 3_600_000.0;
        double getEnergyJoules();
        default double getEnergyKwh() { return getEnergyJoules() / JOULES_PER_KWH; }
    }
    static class KineticBody implements EnergyConvertible {
        private final double mass, velocity;
        public KineticBody(double mass, double velocity) { this.mass = mass; this.velocity = velocity; }
        @Override public double getEnergyJoules() { return 0.5 * mass * velocity * velocity; }
    }
    static class BatteryCell implements EnergyConvertible {
        private final double wattHours;
        public BatteryCell(double wattHours) { this.wattHours = wattHours; }
        @Override public double getEnergyJoules() { return wattHours * 3600.0; }
    }

    interface Flyable { void takeOff(); double getMaxAltitude(); }
    interface Swimmable { void dive(double depthMeters); double getMaxDepth(); }
    interface GpsTrackable { String getCoordinates(); }
    static class AmphibiousRescueDrone implements Flyable, Swimmable, GpsTrackable {
        @Override public void takeOff() { System.out.println("Завдання 11: Дрон злетів у повітря."); }
        @Override public double getMaxAltitude() { return 3000.0; }
        @Override public void dive(double depth) { System.out.println("Завдання 11: Дрон занурився на " + depth + " м."); }
        @Override public double getMaxDepth() { return 50.0; }
        @Override public String getCoordinates() { return "50.4501° N, 30.5234° E"; }
    }
    private static void testFlight(Flyable f) { f.takeOff(); }
    private static void testDiving(Swimmable s) { s.dive(15.0); }
    private static void logPosition(GpsTrackable g) { System.out.println("Завдання 11 GPS: " + g.getCoordinates()); }

    interface DataValidator {
        boolean isValid(String input);
        default String validateOrDefault(String input, String fallback) {
            return isValid(input) ? input : fallback;
        }
        static boolean isNotNullOrBlank(String s) {
            return s != null && !s.isBlank();
        }
    }
    static class EmailValidator implements DataValidator {
        @Override public boolean isValid(String input) {
            return DataValidator.isNotNullOrBlank(input) && input.contains("@") && input.contains(".");
        }
    }
    static class PositiveNumberValidator implements DataValidator {
        @Override public boolean isValid(String input) {
            if (!DataValidator.isNotNullOrBlank(input)) return false;
            try { return Double.parseDouble(input) > 0; } catch (NumberFormatException e) { return false; }
        }
    }

    interface AcousticSignal { default String emitAlert() { return "🔊 Звукова сирена 110 дБ"; } }
    interface OpticalSignal { default String emitAlert() { return "🚨 Стробоскопічний маячок"; } }
    static class EmergencyBeacon implements AcousticSignal, OpticalSignal {
        @Override public String emitAlert() {
            return AcousticSignal.super.emitAlert() + " + " + OpticalSignal.super.emitAlert();
        }
    }

    interface Authenticatable { boolean verifySignature(String key); }
    interface Auditable { String getAuditTrail(); }
    interface BlockchainSmartContract extends Authenticatable, Auditable { boolean executeContract(double gasLimit); }
    static class EscrowSmartContract implements BlockchainSmartContract {
        @Override public boolean verifySignature(String key) { return key != null && key.startsWith("0x"); }
        @Override public String getAuditTrail() { return "TX_VERIFIED_2026"; }
        @Override public boolean executeContract(double gasLimit) { return gasLimit >= 21000; }
    }

    interface Transformable2D { void translate(double dx, double dy); void scale(double factor); }
    static class BoundingBox implements Transformable2D {
        double x, y, w, h;
        public BoundingBox(double x, double y, double w, double h) { this.x = x; this.y = y; this.w = w; this.h = h; }
        @Override public void translate(double dx, double dy) { x += dx; y += dy; }
        @Override public void scale(double factor) { w *= factor; h *= factor; }
    }
    static class CircleRegion implements Transformable2D {
        double x, y, r;
        public CircleRegion(double x, double y, double r) { this.x = x; this.y = y; this.r = r; }
        @Override public void translate(double dx, double dy) { x += dx; y += dy; }
        @Override public void scale(double factor) { r *= factor; }
    }
    private static void applyGlobalTransform(Transformable2D[] objects, double dx, double dy, double scaleFactor) {
        for (Transformable2D o : objects) { o.translate(dx, dy); o.scale(scaleFactor); }
    }

    interface DataExportable { String toJson(); String toCsvRow(); }
    static class StudentGradeRecord implements DataExportable {
        String name; int group; double gpa;
        public StudentGradeRecord(String name, int group, double gpa) { this.name = name; this.group = group; this.gpa = gpa; }
        @Override public String toJson() { return String.format("{\"name\":\"%s\",\"group\":%d,\"gpa\":%.1f}", name, group, gpa); }
        @Override public String toCsvRow() { return name + "," + group + "," + gpa; }
    }
    static class WeatherObservation implements DataExportable {
        String city; double tempC; int humidity;
        public WeatherObservation(String city, double tempC, int humidity) { this.city = city; this.tempC = tempC; this.humidity = humidity; }
        @Override public String toJson() { return String.format("{\"city\":\"%s\",\"temp\":%.1f,\"humidity\":%d}", city, tempC, humidity); }
        @Override public String toCsvRow() { return city + "," + tempC + "," + humidity; }
    }

    // =========================================================================
    // БЛОК 3: abstract class проти interface та Синергія (17–24)
    // =========================================================================
    private static void runBlock3() {
        // Завдання 17
        AbstractBird[] birds = {new Falcon(1.2), new EmperorPenguin(30.0)};
        FlyableUnit[] flyers = {new Falcon(1.1), new CargoPlane()};
        System.out.println("Завдання 17: Птахів=" + birds.length + ", Літаючих юнітів=" + flyers.length);

        // Завдання 18
        AbstractSmartAppliance[] home = {
                new SmartLedChandelier("Вітальня", "Philips Hue", 60),
                new SmartUnderfloorHeating("Ванна", "Devi", 1200)
        };
        double totalWatts = 0;
        for (AbstractSmartAppliance app : home) totalWatts += app.getCurrentWatts();
        System.out.printf("Завдання 18: Загальне споживання будинку = %.1f Вт%n", totalWatts);

        // Завдання 19
        AbstractFinancialInstrument[] portfolio = {
                new TechGrowthStock("NVDA", 10, 4500),
                new BlueChipStock("KO", 20, 2400, 0.03),
                new FixedTermDeposit("UAH-DEP", 50000, 0.14)
        };
        System.out.println("Завдання 19: Інструментів у портфелі = " + portfolio.length);

        // Завдання 20
        Vec2D v = new Vec2D(1.0, 0.0);
        Rotation2DOperator rot = new Rotation2DOperator(Math.PI / 2);
        Vec2D rotated = rot.transform(v);
        Vec2D restored = rot.inverseTransform(rotated);
        System.out.printf("Завдання 20: Поворот (1,0) -> (%.2f, %.2f) -> Назад (%.2f, %.2f)%n",
                rotated.x, rotated.y, restored.x, restored.y);

        // Завдання 21
        AbstractVehicle[] fleet = {
                new ElectricCityBus("AA1111EE", 45, 350),
                new DieselDumpTruck("AA2222BB", 20.0),
                new CargoPassengerVan("AA3333CC", 1.5, 6)
        };
        System.out.println("Завдання 21: Одиниць у автопарку = " + fleet.length);

        // Завдання 22
        AbstractMilitaryUnit[] squad = {new HeavySniper(), new CombatMedic(), new PaladinCaptain()};
        System.out.println("Завдання 22: Бійців у загоні = " + squad.length);

        // Завдання 23
        AbstractLabDevice[] lab = {new ElectronicScale("LAB-01"), new GlassThermometer("LAB-02")};
        for (AbstractLabDevice d : lab) d.performMeasurement();

        // Завдання 24
        TextProcessor[] pipeline = {new WhitespaceTrimmerProcessor(), new CaesarCipherProcessor(3)};
        String text = "   Hello   Java 21   ";
        for (TextProcessor tp : pipeline) text = tp.process(text);
        System.out.println("Завдання 24: Результат конвеєра = '" + text + "'");
    }

    // --- Класи Блоку 3 ---
    static abstract class AbstractBird {
        protected final String species; protected double weightKg;
        public AbstractBird(String species, double weightKg) { this.species = species; this.weightKg = weightKg; }
        public abstract String makeSound();
    }
    interface FlyableUnit { double getFlightSpeedKmh(); }
    interface SwimmingUnit { double getDiveDepthMeters(); }
    static class Falcon extends AbstractBird implements FlyableUnit {
        public Falcon(double w) { super("Сокіл", w); }
        @Override public String makeSound() { return "Кі-кі-кі!"; }
        @Override public double getFlightSpeedKmh() { return 320.0; }
    }
    static class EmperorPenguin extends AbstractBird implements SwimmingUnit {
        public EmperorPenguin(double w) { super("Імператорський пінгвін", w); }
        @Override public String makeSound() { return "Трубний крик"; }
        @Override public double getDiveDepthMeters() { return 500.0; }
    }
    static class CargoPlane implements FlyableUnit {
        @Override public double getFlightSpeedKmh() { return 850.0; }
    }

    static abstract class AbstractSmartAppliance {
        private final String room, model; protected boolean poweredOn = true;
        public AbstractSmartAppliance(String room, String model) { this.room = room; this.model = model; }
        public abstract double getCurrentWatts();
    }
    interface Dimmable { void setBrightness(int percent); }
    interface HeatingCapable { void setTargetTemperature(double celsius); }
    static class SmartLedChandelier extends AbstractSmartAppliance implements Dimmable {
        private double maxWatts; private int brightness = 80;
        public SmartLedChandelier(String room, String model, double maxWatts) { super(room, model); this.maxWatts = maxWatts; }
        @Override public void setBrightness(int percent) { this.brightness = percent; }
        @Override public double getCurrentWatts() { return poweredOn ? maxWatts * (brightness / 100.0) : 0; }
    }
    static class SmartUnderfloorHeating extends AbstractSmartAppliance implements HeatingCapable {
        private double watts;
        public SmartUnderfloorHeating(String room, String model, double watts) { super(room, model); this.watts = watts; }
        @Override public void setTargetTemperature(double celsius) { /* logic */ }
        @Override public double getCurrentWatts() { return poweredOn ? watts : 0; }
    }

    static abstract class AbstractFinancialInstrument {
        private final String ticker; protected int quantity;
        public AbstractFinancialInstrument(String ticker, int quantity) { this.ticker = ticker; this.quantity = quantity; }
        public abstract double getMarketValueUah();
    }
    interface Tradable { boolean buy(int qty); boolean sell(int qty); }
    interface DividendPaying { double calculateAnnualDividend(); }
    static class TechGrowthStock extends AbstractFinancialInstrument implements Tradable {
        private final double price;
        public TechGrowthStock(String t, int q, double p) { super(t, q); this.price = p; }
        @Override public double getMarketValueUah() { return quantity * price; }
        @Override public boolean buy(int qty) { quantity += qty; return true; }
        @Override public boolean sell(int qty) { if (quantity >= qty) { quantity -= qty; return true; } return false; }
    }
    static class BlueChipStock extends TechGrowthStock implements DividendPaying {
        private final double divYield;
        public BlueChipStock(String t, int q, double p, double divYield) { super(t, q, p); this.divYield = divYield; }
        @Override public double calculateAnnualDividend() { return getMarketValueUah() * divYield; }
    }
    static class FixedTermDeposit extends AbstractFinancialInstrument implements DividendPaying {
        private final double rate;
        public FixedTermDeposit(String t, int amount, double rate) { super(t, amount); this.rate = rate; }
        @Override public double getMarketValueUah() { return quantity; }
        @Override public double calculateAnnualDividend() { return quantity * rate; }
    }

    static class Vec2D {
        final double x, y;
        public Vec2D(double x, double y) { this.x = x; this.y = y; }
    }
    static abstract class AbstractVectorOperator {
        private final String name;
        public AbstractVectorOperator(String name) { this.name = name; }
        public abstract Vec2D transform(Vec2D v);
    }
    interface InvertibleOperator { Vec2D inverseTransform(Vec2D v); }
    static class Rotation2DOperator extends AbstractVectorOperator implements InvertibleOperator {
        private final double alpha;
        public Rotation2DOperator(double alpha) { super("Rotation2D"); this.alpha = alpha; }
        @Override public Vec2D transform(Vec2D v) {
            return new Vec2D(v.x * Math.cos(alpha) - v.y * Math.sin(alpha), v.x * Math.sin(alpha) + v.y * Math.cos(alpha));
        }
        @Override public Vec2D inverseTransform(Vec2D v) {
            return new Vec2D(v.x * Math.cos(-alpha) - v.y * Math.sin(-alpha), v.x * Math.sin(-alpha) + v.y * Math.cos(-alpha));
        }
    }
    static class ProjectionXOperator extends AbstractVectorOperator {
        public ProjectionXOperator() { super("ProjectionX"); }
        @Override public Vec2D transform(Vec2D v) { return new Vec2D(v.x, 0); }
    }

    static abstract class AbstractVehicle {
        private final String plateNumber; protected double mileageKm;
        public AbstractVehicle(String plate) { this.plateNumber = plate; }
    }
    interface CargoCarrier { double getMaxPayloadTons(); }
    interface PassengerCarrier { int getSeatCount(); }
    interface ElectricPowered { double getBatteryCapacityKwh(); }
    static class ElectricCityBus extends AbstractVehicle implements PassengerCarrier, ElectricPowered {
        private final int seats; private final double kwh;
        public ElectricCityBus(String p, int seats, double kwh) { super(p); this.seats = seats; this.kwh = kwh; }
        @Override public int getSeatCount() { return seats; }
        @Override public double getBatteryCapacityKwh() { return kwh; }
    }
    static class DieselDumpTruck extends AbstractVehicle implements CargoCarrier {
        private final double tons;
        public DieselDumpTruck(String p, double tons) { super(p); this.tons = tons; }
        @Override public double getMaxPayloadTons() { return tons; }
    }
    static class CargoPassengerVan extends AbstractVehicle implements CargoCarrier, PassengerCarrier {
        private final double tons; private final int seats;
        public CargoPassengerVan(String p, double tons, int seats) { super(p); this.tons = tons; this.seats = seats; }
        @Override public double getMaxPayloadTons() { return tons; }
        @Override public int getSeatCount() { return seats; }
    }

    static abstract class AbstractMilitaryUnit {
        private final String unitName; protected int hp = 100;
        public AbstractMilitaryUnit(String name) { this.unitName = name; }
        public abstract int getMoveSpeed();
    }
    interface RangedAttacker { int getAttackRange(); int fireShot(); }
    interface FieldHealer { int healAlly(); }
    static class HeavySniper extends AbstractMilitaryUnit implements RangedAttacker {
        public HeavySniper() { super("Sniper"); }
        @Override public int getMoveSpeed() { return 4; }
        @Override public int getAttackRange() { return 100; }
        @Override public int fireShot() { return 85; }
    }
    static class CombatMedic extends AbstractMilitaryUnit implements FieldHealer {
        public CombatMedic() { super("Medic"); }
        @Override public int getMoveSpeed() { return 6; }
        @Override public int healAlly() { return 40; }
    }
    static class PaladinCaptain extends AbstractMilitaryUnit implements RangedAttacker, FieldHealer {
        public PaladinCaptain() { super("Paladin"); }
        @Override public int getMoveSpeed() { return 5; }
        @Override public int getAttackRange() { return 20; }
        @Override public int fireShot() { return 45; }
        @Override public int healAlly() { return 30; }
    }

    static abstract class AbstractLabDevice {
        private final String inventoryCode;
        public AbstractLabDevice(String code) { this.inventoryCode = code; }
        public abstract void performMeasurement();
    }
    interface Calibratable { void calibrate(double referenceValue); }
    interface SelfDiagnostic { boolean runSelfCheck(); }
    static class ElectronicScale extends AbstractLabDevice implements Calibratable, SelfDiagnostic {
        public ElectronicScale(String code) { super(code); }
        @Override public void performMeasurement() { System.out.println("Завдання 23: Зважування: 100.002 г"); }
        @Override public void calibrate(double ref) { }
        @Override public boolean runSelfCheck() { return true; }
    }
    static class GlassThermometer extends AbstractLabDevice {
        public GlassThermometer(String code) { super(code); }
        @Override public void performMeasurement() { System.out.println("Завдання 23: Температура: 22.5 °C"); }
    }

    interface TextProcessor { String process(String text); }
    interface ReversibleProcessor extends TextProcessor { String reverseProcess(String text); }
    static class WhitespaceTrimmerProcessor implements TextProcessor {
        @Override public String process(String text) { return text.trim().replaceAll("\\s+", " "); }
    }
    static class CaesarCipherProcessor implements ReversibleProcessor {
        private final int shift;
        public CaesarCipherProcessor(int shift) { this.shift = shift; }
        @Override public String process(String text) { return shiftText(text, shift); }
        @Override public String reverseProcess(String text) { return shiftText(text, -shift); }
        private String shiftText(String s, int k) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) sb.append((char) (c + k));
            return sb.toString();
        }
    }

    // =========================================================================
    // БЛОК 4: Оператор instanceof, Downcasting та Pattern Matching (25–32)
    // =========================================================================
    private static void runBlock4() {
        // Завдання 25
        Shape2D[] shapes = {new CircleShape(3.0), new RectangleShape(5.0, 5.0), null};
        for (Shape2D s : shapes) {
            if (s instanceof CircleShape c) {
                System.out.printf("Завдання 25: Коло, діаметр = %.2f%n", c.getDiameter());
            } else if (s instanceof RectangleShape r) {
                System.out.printf("Завдання 25: Прямокутник, діагональ = %.2f, квадрат = %b%n", r.getDiagonal(), r.isSquare());
            }
        }
        Shape2D nullShape = null;
        System.out.println("Завдання 25: null instanceof Shape2D = " + (nullShape instanceof Shape2D));

        // Завдання 26
        Object[] warehouse = {new Laptop(), new DesktopMonitor(), new ElectricScooter(), new WiredPrinter()};
        int chargedCount = chargeAllPossible(warehouse);
        System.out.println("Завдання 26: Успішно заряджено пристроїв = " + chargedCount);

        // Завдання 27
        AbstractWorker[] staff = {
                new FullTimeDeveloper(80_000, 20_000, 50_000),
                new FopContractor(70_000, 15_000),
                new InternStudent(15_000)
        };
        auditWorkers(staff);

        // Завдання 28
        ShipModule[] modules = {new ShieldGenerator(), new WarpDrive(), new LifeSupportModule()};
        runShipInspection(modules);

        // Завдання 29
        MediaItem[] library = {
                new VideoFile("Movie 4K", 15000.0, 2160),
                new AudioFile("Symphony FLAC", 450.0, 1411),
                new EBookFile("Clean Code", 12.0, 464)
        };
        double heavyMediaSize = 0;
        for (MediaItem item : library) {
            if (item instanceof VideoFile v && v.is4K()) heavyMediaSize += v.sizeMb;
            else if (item instanceof AudioFile a && a.isLossless()) heavyMediaSize += a.sizeMb;
        }
        System.out.printf("Завдання 29: Обсяг 4K + Lossless = %.1f МБ%n", heavyMediaSize);

        // Завдання 30
        AbstractCustomer[] customers = {new VipCustomer(), new StudentCustomer()};
        for (AbstractCustomer c : customers) {
            System.out.printf("Завдання 30 (Рефакторинг): Ціна зі знижкою = %.2f грн%n",
                    1000.0 * (1.0 - c.getDiscountPercent() / 100.0));
        }

        // Завдання 31
        Matrix2x2[] matrices = {new RotationMatrix2x2(Math.PI / 4), new SingularMatrix2x2()};
        for (Matrix2x2 m : matrices) {
            if (m instanceof InvertibleMatrix inv) {
                Matrix2x2 inverted = inv.inverse();
                System.out.printf("Завдання 31: Знайдено обернену матрицю (det = %.2f)%n", inverted.determinant());
            }
        }

        // Завдання 32
        Object[] containers = {
                new ChemicalContainer(3),
                new FrozenFoodContainer(-18.0),
                new ElectronicsContainer()
        };
        for (Object c : containers) {
            if (c instanceof HazardousCargo h) {
                System.out.println("Завдання 32: У спецбокс! Клас небезпеки = " + h.getHazardClass());
            } else if (c instanceof RefrigeratedCargo r) {
                System.out.println("Завдання 32: Підключено живлення! Температура = " + r.getRequiredTempC() + " °C");
            }
        }
    }

    // --- Класи Блоку 4 ---
    interface Rechargeable { void chargeToFull(); }
    static class Laptop implements Rechargeable { @Override public void chargeToFull() {} }
    static class ElectricScooter implements Rechargeable { @Override public void chargeToFull() {} }
    static class DesktopMonitor {}
    static class WiredPrinter {}
    public static int chargeAllPossible(Object[] items) {
        int count = 0;
        for (Object item : items) {
            if (item instanceof Rechargeable r) { r.chargeToFull(); count++; }
        }
        return count;
    }

    static abstract class AbstractWorker {
        protected double baseSalary;
        public AbstractWorker(double s) { this.baseSalary = s; }
    }
    interface BonusEligible { double calculateQuarterBonus(); }
    interface MedicalInsured { double getInsuranceCoverage(); }
    static class FullTimeDeveloper extends AbstractWorker implements BonusEligible, MedicalInsured {
        private final double bonus, insurance;
        public FullTimeDeveloper(double s, double b, double i) { super(s); this.bonus = b; this.insurance = i; }
        @Override public double calculateQuarterBonus() { return bonus; }
        @Override public double getInsuranceCoverage() { return insurance; }
    }
    static class FopContractor extends AbstractWorker implements BonusEligible {
        private final double bonus;
        public FopContractor(double s, double b) { super(s); this.bonus = b; }
        @Override public double calculateQuarterBonus() { return bonus; }
    }
    static class InternStudent extends AbstractWorker {
        public InternStudent(double s) { super(s); }
    }
    private static void auditWorkers(AbstractWorker[] staff) {
        double baseTotal = 0, bonusTotal = 0; int insuredCount = 0;
        for (AbstractWorker w : staff) {
            baseTotal += w.baseSalary;
            if (w instanceof BonusEligible b) bonusTotal += b.calculateQuarterBonus();
            if (w instanceof MedicalInsured) insuredCount++;
        }
        System.out.printf("Завдання 27 Аудит: База=%.0f, Премії=%.0f, Застраховано=%d%n", baseTotal, bonusTotal, insuredCount);
    }

    static abstract class ShipModule { String name; boolean damaged; }
    static class ShieldGenerator extends ShipModule { void rechargeShields(int mj) {} }
    static class WarpDrive extends ShipModule { boolean checkAntimatterContainment() { return true; } }
    static class LifeSupportModule extends ShipModule { double getOxygenPercent() { return 20.9; } }
    private static void runShipInspection(ShipModule[] modules) {
        for (ShipModule m : modules) {
            if (m instanceof ShieldGenerator sg) sg.rechargeShields(500);
            else if (m instanceof WarpDrive wd) System.out.println("Завдання 28 Warp OK: " + wd.checkAntimatterContainment());
            else if (m instanceof LifeSupportModule ls) System.out.println("Завдання 28 O2: " + ls.getOxygenPercent() + "%");
        }
    }

    static class MediaItem {
        String title; double sizeMb;
        public MediaItem(String title, double sizeMb) { this.title = title; this.sizeMb = sizeMb; }
    }
    static class VideoFile extends MediaItem {
        int height;
        public VideoFile(String t, double s, int h) { super(t, s); this.height = h; }
        boolean is4K() { return height >= 2160; }
    }
    static class AudioFile extends MediaItem {
        int bitrate;
        public AudioFile(String t, double s, int b) { super(t, s); this.bitrate = b; }
        boolean isLossless() { return bitrate >= 1000; }
    }
    static class EBookFile extends MediaItem {
        int pages;
        public EBookFile(String t, double s, int p) { super(t, s); this.pages = p; }
    }

    static abstract class AbstractCustomer { public abstract double getDiscountPercent(); }
    static class VipCustomer extends AbstractCustomer { @Override public double getDiscountPercent() { return 20.0; } }
    static class StudentCustomer extends AbstractCustomer { @Override public double getDiscountPercent() { return 10.0; } }

    static class Matrix2x2 {
        double a11, a12, a21, a22;
        public Matrix2x2(double a11, double a12, double a21, double a22) {
            this.a11 = a11; this.a12 = a12; this.a21 = a21; this.a22 = a22;
        }
        public double determinant() { return a11 * a22 - a12 * a21; }
    }
    interface InvertibleMatrix { Matrix2x2 inverse(); }
    interface OrthogonalMatrix { boolean checkOrthogonality(); }
    static class RotationMatrix2x2 extends Matrix2x2 implements InvertibleMatrix, OrthogonalMatrix {
        public RotationMatrix2x2(double a) { super(Math.cos(a), -Math.sin(a), Math.sin(a), Math.cos(a)); }
        @Override public Matrix2x2 inverse() {
            double d = determinant();
            return new Matrix2x2(a22 / d, -a12 / d, -a21 / d, a11 / d);
        }
        @Override public boolean checkOrthogonality() { return Math.abs(determinant() - 1.0) < 1e-9; }
    }
    static class SingularMatrix2x2 extends Matrix2x2 {
        public SingularMatrix2x2() { super(1, 2, 2, 4); }
    }

    interface HazardousCargo { int getHazardClass(); }
    interface RefrigeratedCargo { double getRequiredTempC(); }
    static class ChemicalContainer implements HazardousCargo {
        private final int cls;
        public ChemicalContainer(int cls) { this.cls = cls; }
        @Override public int getHazardClass() { return cls; }
    }
    static class FrozenFoodContainer implements RefrigeratedCargo {
        private final double temp;
        public FrozenFoodContainer(double temp) { this.temp = temp; }
        @Override public double getRequiredTempC() { return temp; }
    }
    static class ElectronicsContainer {}

    // =========================================================================
    // БЛОК 5: Ключове слово final та Комплексна синергія (33–40)
    // =========================================================================
    private static void runBlock5() {
        // Завдання 33
        double[] rawCoeffs = {1.0, 2.5, 3.0};
        FinalCalibrationTable table = new FinalCalibrationTable("SN-998877", rawCoeffs);
        rawCoeffs[0] = 999.0; // Спроба змінити зовнішній масив не вплине на таблицю
        System.out.println("Завдання 33: Захищений коефіцієнт[0] = " + table.getCoefficients()[0]);

        // Завдання 34
        AbstractSecurityProtocol jwt = new JwtSecurityProtocol();
        System.out.println("Завдання 34 (Valid): " + jwt.runSecureCommand("Bearer_123", "DROP_CACHE"));
        System.out.println("Завдання 34 (Invalid): " + jwt.runSecureCommand("bad", "DROP_CACHE"));

        // Завдання 35
        MetricSpaceElement v1 = new ImmutableVector3D(0, 0, 0);
        MetricSpaceElement v2 = new ImmutableVector3D(3, 4, 12);
        System.out.printf("Завдання 35: Норма v2 = %.2f, Відстань = %.2f%n", v2.getNorm(), v1.distanceTo(v2));

        // Завдання 36
        PrintableDocument[] docs = {
                new FiscalReceipt("CHK-2026-001", 1200.0),
                new WarehouseReport("Звіт по залишках №4")
        };
        for (PrintableDocument d : docs) System.out.println("Завдання 36: " + d.formatForPrinter());

        // Завдання 37
        PowerProducer[] grid = {
                new NuclearStation("NPP-1", 1000.0),
                new SolarFarmStation("SPP-1", 200.0),
                new HydroDamStation("HPP-1", 300.0)
        };
        SmartGridController.manageGrid(grid, 0.75);

        // Завдання 38
        CubicFunction cubic = new CubicFunction(); // x^3 - 2x - 5
        double integral = cubic.integrateTrapezoid(0.0, 3.0, 1000);
        double root = cubic.findRootBisection(2.0, 3.0, 1e-6);
        System.out.printf("Завдання 38: Інтеграл [0;3] = %.4f, Корінь = %.6f%n", integral, root);

        // Завдання 39
        AbstractCombatUnit[] fighters = {
                new BerserkerAssasin("Берсерк"),
                new TrollWarlord("Троль"),
                new RoyalPaladin("Паладин")
        };
        simulateBattleRound(fighters);
    }

    // --- Класи Блоку 5 ---
    static class FinalCalibrationTable {
        public static final double GRAVITY_G = 9.80665;
        private final String sensorSerial;
        private final double[] coefficients;

        public FinalCalibrationTable(String sensorSerial, double[] coefficients) {
            this.sensorSerial = sensorSerial;
            this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
        }
        public double[] getCoefficients() { return Arrays.copyOf(coefficients, coefficients.length); }
        public String getSensorSerial() { return sensorSerial; }
    }

    static abstract class AbstractSecurityProtocol {
        protected abstract boolean authenticateUser(String token);
        protected abstract String executePayload(String command);
        public final String runSecureCommand(String token, String command) {
            if (token == null || !authenticateUser(token)) return "403 FORBIDDEN";
            return "[AUDITED] " + executePayload(command);
        }
    }
    static class JwtSecurityProtocol extends AbstractSecurityProtocol {
        @Override protected boolean authenticateUser(String token) { return token.startsWith("Bearer_"); }
        @Override protected String executePayload(String command) { return "JWT Executed: " + command; }
    }
    static class ApiKeySecurityProtocol extends AbstractSecurityProtocol {
        @Override protected boolean authenticateUser(String token) { return token.length() == 32; }
        @Override protected String executePayload(String command) { return "API Executed: " + command; }
    }

    interface MetricSpaceElement { double distanceTo(MetricSpaceElement other); double getNorm(); }
    public static final class ImmutableVector3D implements MetricSpaceElement {
        private final double x, y, z;
        public ImmutableVector3D(double x, double y, double z) { this.x = x; this.y = y; this.z = z; }
        @Override public double getNorm() { return Math.sqrt(x * x + y * y + z * z); }
        @Override public double distanceTo(MetricSpaceElement other) {
            if (other instanceof ImmutableVector3D o) {
                return Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2) + Math.pow(z - o.z, 2));
            }
            return Math.abs(this.getNorm() - other.getNorm());
        }
    }

    interface PrintableDocument { String formatForPrinter(); }
    public static final class FiscalReceipt implements PrintableDocument {
        private final String fiscalNumber;
        private final double totalAmount;
        private final double vatAmount;
        public FiscalReceipt(String fiscalNumber, double totalAmount) {
            this.fiscalNumber = fiscalNumber;
            this.totalAmount = totalAmount;
            this.vatAmount = totalAmount - (totalAmount / 1.2);
        }
        @Override public String formatForPrinter() {
            return String.format("ЧЕК #%s | Сума: %.2f грн (у т.ч. ПДВ: %.2f грн)", fiscalNumber, totalAmount, vatAmount);
        }
    }
    static class WarehouseReport implements PrintableDocument {
        private final String title;
        public WarehouseReport(String title) { this.title = title; }
        @Override public String formatForPrinter() { return "ЗВІТ: " + title; }
    }

    interface PowerProducer { double produceMw(); }
    interface WeatherDependent { void updateWeatherCondition(double factor); }
    static abstract class AbstractPowerStation implements PowerProducer {
        private final String stationId;
        public AbstractPowerStation(String stationId) { this.stationId = stationId; }
        public final double getNetOutputMw() { return produceMw() * 0.95; }
    }
    static class NuclearStation extends AbstractPowerStation {
        private final double baseMw;
        public NuclearStation(String id, double mw) { super(id); this.baseMw = mw; }
        @Override public double produceMw() { return baseMw; }
    }
    static class SolarFarmStation extends AbstractPowerStation implements WeatherDependent {
        private final double maxMw; private double factor = 1.0;
        public SolarFarmStation(String id, double mw) { super(id); this.maxMw = mw; }
        @Override public void updateWeatherCondition(double factor) { this.factor = factor; }
        @Override public double produceMw() { return maxMw * factor; }
    }
    static class HydroDamStation extends AbstractPowerStation implements WeatherDependent {
        private final double maxMw; private double factor = 1.0;
        public HydroDamStation(String id, double mw) { super(id); this.maxMw = mw; }
        @Override public void updateWeatherCondition(double factor) { this.factor = factor; }
        @Override public double produceMw() { return maxMw * factor; }
    }
    static class SmartGridController {
        public static void manageGrid(PowerProducer[] producers, double weatherFactor) {
            double totalNetMw = 0;
            for (PowerProducer p : producers) {
                if (p instanceof WeatherDependent wd) wd.updateWeatherCondition(weatherFactor);
                if (p instanceof AbstractPowerStation aps) totalNetMw += aps.getNetOutputMw();
                else totalNetMw += p.produceMw();
            }
            System.out.printf("Завдання 37: Чиста генерація мережі = %.2f МВт%n", totalNetMw);
        }
    }

    interface Integrable1D {
        double evaluate(double x);
        default double integrateTrapezoid(double a, double b, int n) {
            double h = (b - a) / n;
            double sum = 0.5 * (evaluate(a) + evaluate(b));
            for (int i = 1; i < n; i++) sum += evaluate(a + i * h);
            return sum * h;
        }
    }
    interface RootFindable { double findRootBisection(double left, double right, double eps); }
    static abstract class AbstractAnalyticFunction implements Integrable1D {}
    static class CubicFunction extends AbstractAnalyticFunction implements RootFindable {
        @Override public double evaluate(double x) { return x * x * x - 2 * x - 5; }
        @Override public double findRootBisection(double left, double right, double eps) {
            while ((right - left) / 2.0 > eps) {
                double mid = (left + right) / 2.0;
                if (evaluate(mid) == 0.0) return mid;
                if (evaluate(left) * evaluate(mid) < 0) right = mid;
                else left = mid;
            }
            return (left + right) / 2.0;
        }
    }

    static abstract class AbstractCombatUnit {
        private final String name; protected int hp = 200;
        public AbstractCombatUnit(String name) { this.name = name; }
        public final boolean isAlive() { return hp > 0; }
        public abstract int calculateDamage();
    }
    interface CriticalStriker { double getCritMultiplier(); }
    interface SelfRegenerating { int regenerateHp(); }
    interface ShieldBearer { int absorbDamage(int incoming); }

    static class BerserkerAssasin extends AbstractCombatUnit implements CriticalStriker {
        public BerserkerAssasin(String name) { super(name); }
        @Override public int calculateDamage() { return 40; }
        @Override public double getCritMultiplier() { return 2.0; }
    }
    static class TrollWarlord extends AbstractCombatUnit implements CriticalStriker, SelfRegenerating {
        public TrollWarlord(String name) { super(name); }
        @Override public int calculateDamage() { return 30; }
        @Override public double getCritMultiplier() { return 1.5; }
        @Override public int regenerateHp() { hp += 15; return 15; }
    }
    static class RoyalPaladin extends AbstractCombatUnit implements ShieldBearer, SelfRegenerating {
        public RoyalPaladin(String name) { super(name); }
        @Override public int calculateDamage() { return 25; }
        @Override public int regenerateHp() { hp += 10; return 10; }
        @Override public int absorbDamage(int incoming) { return (int) (incoming * 0.5); }
    }
    private static void simulateBattleRound(AbstractCombatUnit[] units) {
        for (int i = 0; i < units.length; i++) {
            AbstractCombatUnit attacker = units[i];
            AbstractCombatUnit defender = units[(i + 1) % units.length];
            if (!attacker.isAlive() || !defender.isAlive()) continue;

            if (attacker instanceof SelfRegenerating reg) reg.regenerateHp();

            int dmg = attacker.calculateDamage();
            if (attacker instanceof CriticalStriker crit) dmg = (int) (dmg * crit.getCritMultiplier());
            if (defender instanceof ShieldBearer shield) dmg = shield.absorbDamage(dmg);

            defender.hp -= dmg;
        }
        System.out.printf("Завдання 39 (Після раунду HP): %s=%d, %s=%d, %s=%d%n",
                units[0].name, units[0].hp, units[1].name, units[1].hp, units[2].name, units[2].hp);
    }
}