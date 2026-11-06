package semester1.practice09;

import java.util.Arrays;

// =====================================================================
// БЛОК 5 (Завдання 33–40): синергія — інкапсуляція + композиція
// + абстрактні класи
// =====================================================================

/** Завдання 33: абстрактна деталь ПК. */
abstract class AbstractPcPart {
    private final String model;
    private final double priceUah;

    public AbstractPcPart(String model, double priceUah) {
        this.model = model;
        this.priceUah = priceUah;
    }

    public abstract int getPowerConsumptionWatts();

    public String getModel() {
        return model;
    }

    public double getPriceUah() {
        return priceUah;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + model + " (" + getPowerConsumptionWatts() + " Вт)";
    }
}

class ProcessorPart extends AbstractPcPart {
    private final int cores;
    private final int watts;

    public ProcessorPart(String model, double price, int cores, int watts) {
        super(model, price);
        this.cores = cores;
        this.watts = watts;
    }

    @Override
    public int getPowerConsumptionWatts() {
        return watts;
    }

    public int getCores() {
        return cores;
    }
}

class VideoCardPart extends AbstractPcPart {
    private final int vramGb;
    private final int watts;

    public VideoCardPart(String model, double price, int vramGb, int watts) {
        super(model, price);
        this.vramGb = vramGb;
        this.watts = watts;
    }

    @Override
    public int getPowerConsumptionWatts() {
        return watts;
    }

    public int getVramGb() {
        return vramGb;
    }
}

/** Завдання 33: ПК компонує масив деталей. */
class DesktopPC {
    private final int psuMaxWatts;
    private final AbstractPcPart[] parts = new AbstractPcPart[8];
    private int partCount;

    public DesktopPC(int psuMaxWatts) {
        this.psuMaxWatts = psuMaxWatts;
    }

    public boolean addPart(AbstractPcPart part) {
        if (part == null || partCount >= parts.length) {
            return false;
        }
        parts[partCount++] = part;
        return true;
    }

    public int getTotalPowerWatts() {
        int sum = 0;
        for (int i = 0; i < partCount; i++) {
            sum += parts[i].getPowerConsumptionWatts();
        }
        return sum;
    }

    public double getTotalPrice() {
        double sum = 0;
        for (int i = 0; i < partCount; i++) {
            sum += parts[i].getPriceUah();
        }
        return sum;
    }

    /** Система стабільна, якщо споживання + 20% запасу не перевищує потужність БЖ. */
    public boolean isStable() {
        return getTotalPowerWatts() * 1.2 <= psuMaxWatts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DesktopPC (БЖ " + psuMaxWatts + " Вт):\n");
        for (int i = 0; i < partCount; i++) {
            sb.append("  ").append(parts[i]).append("\n");
        }
        sb.append(String.format("  Споживання: %d Вт (з запасом 20%%: %.0f Вт) -> %s",
                getTotalPowerWatts(), getTotalPowerWatts() * 1.2,
                isStable() ? "СТАБІЛЬНО" : "НЕ ВИСТАЧАЄ ПОТУЖНОСТІ БЖ"));
        return sb.toString();
    }
}

/** Завдання 34: абстрактний двигун космічного корабля. */
abstract class AbstractThruster {
    private final String thrusterId;

    public AbstractThruster(String thrusterId) {
        this.thrusterId = thrusterId;
    }

    public abstract double getThrustKn();

    public abstract double getFuelBurnRate(); // кг/с

    public String getThrusterId() {
        return thrusterId;
    }
}

class ChemicalThruster extends AbstractThruster {
    private final double thrustKn;
    private final double burnRateKgPerS;

    public ChemicalThruster(String id, double thrustKn, double burnRateKgPerS) {
        super(id);
        this.thrustKn = thrustKn;
        this.burnRateKgPerS = burnRateKgPerS;
    }

    @Override
    public double getThrustKn() {
        return thrustKn;
    }

    @Override
    public double getFuelBurnRate() {
        return burnRateKgPerS;
    }
}

/** Іонний двигун: тяга F = 2*eta*P / v, мала, але дуже економна. */
class IonThruster extends AbstractThruster {
    private final double powerKw;
    private final double efficiency;
    private final double exhaustVelocityKmS;

    public IonThruster(String id, double powerKw, double efficiency, double exhaustVelocityKmS) {
        super(id);
        this.powerKw = powerKw;
        this.efficiency = efficiency;
        this.exhaustVelocityKmS = exhaustVelocityKmS;
    }

    private double thrustNewtons() {
        return 2 * efficiency * powerKw / exhaustVelocityKmS;
    }

    @Override
    public double getThrustKn() {
        return thrustNewtons() / 1000.0;
    }

    @Override
    public double getFuelBurnRate() {
        return thrustNewtons() / (exhaustVelocityKmS * 1000.0);
    }
}

/** Завдання 34: корабель компонує двигуни. */
class Spacecraft {
    private final String shipName;
    private final double dryMassTons;
    private final AbstractThruster[] thrusters = new AbstractThruster[6];
    private int count;

    public Spacecraft(String shipName, double dryMassTons) {
        this.shipName = shipName;
        this.dryMassTons = dryMassTons;
    }

    public boolean addThruster(AbstractThruster t) {
        if (t == null || count >= thrusters.length) {
            return false;
        }
        thrusters[count++] = t;
        return true;
    }

    public double getTotalThrustKn() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += thrusters[i].getThrustKn();
        }
        return sum;
    }

    /** a = F / m. Один кН на одну тонну дає рівно 1 м/с2. */
    public double getInitialAcceleration() {
        return getTotalThrustKn() / dryMassTons;
    }

    public double getTotalFuelBurnRate() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += thrusters[i].getFuelBurnRate();
        }
        return sum;
    }

    public String getShipName() {
        return shipName;
    }
}

/** Завдання 35: ділянка зі спорудами (фігури з завдання 25). */
class LandPlot {
    private final double totalPlotAreaM2;
    private final AbstractShape[] structures = new AbstractShape[20];
    private int count;

    public LandPlot(double totalPlotAreaM2) {
        this.totalPlotAreaM2 = totalPlotAreaM2;
    }

    public double getBuiltArea() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += structures[i].getArea();
        }
        return sum;
    }

    /** Забудова не може перевищувати 60% площі ділянки. */
    public boolean addStructure(AbstractShape s) {
        if (s == null || count >= structures.length) {
            return false;
        }
        if (getBuiltArea() + s.getArea() > totalPlotAreaM2 * 0.6) {
            return false;
        }
        structures[count++] = s;
        return true;
    }

    public double getFreeGreenArea() {
        return totalPlotAreaM2 - getBuiltArea();
    }
}

/** Завдання 36: фінансовий актив. */
abstract class AbstractAsset {
    private final String ticker;
    protected double investedAmount;

    public AbstractAsset(String ticker, double investedAmount) {
        this.ticker = ticker;
        this.investedAmount = Math.max(0, investedAmount);
    }

    public abstract double calculateAnnualReturn();

    public double getInvestedAmount() {
        return investedAmount;
    }

    public String getTicker() {
        return ticker;
    }
}

class GovernmentBond extends AbstractAsset {
    private static final double COUPON_RATE = 0.155; // 15.5%

    public GovernmentBond(String ticker, double investedAmount) {
        super(ticker, investedAmount);
    }

    @Override
    public double calculateAnnualReturn() {
        return investedAmount * COUPON_RATE;
    }
}

class DividendStock extends AbstractAsset {
    private static final double DIVIDEND_TAX = 0.18;

    private final double expectedPriceGrowth; // частка, 0.08 = 8%
    private final double dividendYield;       // частка

    public DividendStock(String ticker, double investedAmount, double expectedPriceGrowth, double dividendYield) {
        super(ticker, investedAmount);
        this.expectedPriceGrowth = expectedPriceGrowth;
        this.dividendYield = dividendYield;
    }

    @Override
    public double calculateAnnualReturn() {
        double growth = investedAmount * expectedPriceGrowth;
        double dividends = investedAmount * dividendYield * (1 - DIVIDEND_TAX);
        return growth + dividends;
    }
}

/** Завдання 36: портфель інвестора. */
class InvestmentPortfolio {
    private final String investorName;
    private final AbstractAsset[] assets = new AbstractAsset[10];
    private int count;

    public InvestmentPortfolio(String investorName) {
        this.investorName = investorName;
    }

    public boolean addAsset(AbstractAsset asset) {
        if (asset == null || count >= assets.length) {
            return false;
        }
        assets[count++] = asset;
        return true;
    }

    public double getTotalInvested() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += assets[i].getInvestedAmount();
        }
        return sum;
    }

    public double getExpectedAnnualProfit() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += assets[i].calculateAnnualReturn();
        }
        return sum;
    }

    public double getValueAfterYear() {
        return getTotalInvested() + getExpectedAnnualProfit();
    }

    public String getInvestorName() {
        return investorName;
    }
}

/** Завдання 37: юніт рейду. */
abstract class AbstractHeroUnit {
    private final String name;
    protected int hp;

    public AbstractHeroUnit(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public abstract int getCombatPower();

    public abstract String getRole();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getRole() + " " + name + " (HP " + hp + ", сила " + getCombatPower() + ")";
    }
}

class TankWarrior extends AbstractHeroUnit {
    private final int armor;

    public TankWarrior(String name, int hp, int armor) {
        super(name, hp);
        this.armor = armor;
    }

    @Override
    public int getCombatPower() {
        return hp / 2 + armor * 3;
    }

    @Override
    public String getRole() {
        return "Tank";
    }
}

class ArcaneMage extends AbstractHeroUnit {
    private final int intelligence;
    private final int spellPower;

    public ArcaneMage(String name, int hp, int intelligence, int spellPower) {
        super(name, hp);
        this.intelligence = intelligence;
        this.spellPower = spellPower;
    }

    @Override
    public int getCombatPower() {
        return intelligence * 2 + spellPower * 3;
    }

    @Override
    public String getRole() {
        return "Mage";
    }
}

/** Завдання 37: загін. */
class RaidParty {
    private final String guildName;
    private final AbstractHeroUnit[] members = new AbstractHeroUnit[10];
    private int memberCount;

    public RaidParty(String guildName) {
        this.guildName = guildName;
    }

    public boolean addMember(AbstractHeroUnit hero) {
        if (hero == null || memberCount >= members.length) {
            return false;
        }
        members[memberCount++] = hero;
        return true;
    }

    public int getTotalPower() {
        int sum = 0;
        for (int i = 0; i < memberCount; i++) {
            sum += members[i].getCombatPower();
        }
        return sum;
    }

    public boolean hasTank() {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getRole().equals("Tank")) {
                return true;
            }
        }
        return false;
    }

    /** Готовий, якщо є хоча б один танк, а сумарна сила перевищує складність підземелля. */
    public boolean isReadyForRaid(int dungeonDifficulty) {
        return hasTank() && getTotalPower() > dungeonDifficulty;
    }

    public String getGuildName() {
        return guildName;
    }
}

/** Завдання 38: сирена. */
class EmergencySiren {
    private boolean sounding;

    public void activate() {
        sounding = true;
    }

    public void deactivate() {
        sounding = false;
    }

    public boolean isSounding() {
        return sounding;
    }
}

/** Завдання 38: лабораторія компонує сирену і датчики (з завдання 31). */
class SmartLab {
    private final EmergencySiren siren = new EmergencySiren();
    private final AbstractSensor[] sensors = new AbstractSensor[8];
    private int sensorCount;

    public boolean addSensor(AbstractSensor sensor) {
        if (sensor == null || sensorCount >= sensors.length) {
            return false;
        }
        sensors[sensorCount++] = sensor;
        return true;
    }

    public void runDiagnostics() {
        boolean alarm = false;
        for (int i = 0; i < sensorCount; i++) {
            boolean bad = sensors[i].isAlarmTriggered();
            System.out.println("  " + (bad ? "[ТРИВОГА] " : "[ОК]      ") + sensors[i]);
            alarm |= bad;
        }
        if (alarm) {
            siren.activate();
        } else {
            siren.deactivate();
        }
        System.out.println("  Сирена: " + (siren.isSounding() ? "ВМИКНЕНА" : "вимкнена"));
    }

    public boolean isSirenSounding() {
        return siren.isSounding();
    }
}

/** Завдання 39: фільтр сигналу. */
abstract class AbstractFilter {
    private final String filterName;

    public AbstractFilter(String filterName) {
        this.filterName = filterName;
    }

    public abstract double processSample(double x);

    public String getFilterName() {
        return filterName;
    }
}

class AmplifierFilter extends AbstractFilter {
    private final double gain;

    public AmplifierFilter(double gain) {
        super("Підсилювач x" + gain);
        this.gain = gain;
    }

    @Override
    public double processSample(double x) {
        return x * gain;
    }
}

class ClippingFilter extends AbstractFilter {
    private final double threshold;

    public ClippingFilter(double threshold) {
        super("Обмежувач +-" + threshold);
        this.threshold = Math.abs(threshold);
    }

    @Override
    public double processSample(double x) {
        return Math.max(-threshold, Math.min(threshold, x));
    }
}

/** Завдання 39: конвеєр фільтрів. */
class SignalProcessor {
    private final AbstractFilter[] pipeline;

    public SignalProcessor(AbstractFilter... filters) {
        this.pipeline = (filters == null) ? new AbstractFilter[0] : Arrays.copyOf(filters, filters.length);
    }

    /** Вхідний масив НЕ змінюється: працюємо з копією. */
    public double[] process(double[] signal) {
        if (signal == null) {
            return new double[0];
        }
        double[] result = Arrays.copyOf(signal, signal.length);
        for (AbstractFilter filter : pipeline) {
            for (int i = 0; i < result.length; i++) {
                result[i] = filter.processSample(result[i]);
            }
        }
        return result;
    }

    public int getFilterCount() {
        return pipeline.length;
    }
}
