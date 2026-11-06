package semester1.practice09;

import java.util.Arrays;

// =====================================================================
// БЛОК 1 (Завдання 1–8): поглиблена інкапсуляція, незмінність (final),
// інваріанти та захисне копіювання
// =====================================================================

/** Завдання 1: незмінна географічна координата. */
final class ImmutableGeoPoint {
    private final double latitude;
    private final double longitude;

    public ImmutableGeoPoint(double latitude, double longitude) {
        // clamping: значення поза межами притискається до границі
        this.latitude = Math.max(-90.0, Math.min(90.0, latitude));
        this.longitude = Math.max(-180.0, Math.min(180.0, longitude));
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    /** Замість сеттера повертаємо НОВИЙ об'єкт. */
    public ImmutableGeoPoint shift(double dLat, double dLon) {
        return new ImmutableGeoPoint(latitude + dLat, longitude + dLon);
    }

    @Override
    public String toString() {
        return String.format("ImmutableGeoPoint[lat=%.4f, lon=%.4f]", latitude, longitude);
    }
}

/** Завдання 2: захисне копіювання масиву результатів експерименту. */
class LabMeasurement {
    private final String experimentName;
    private final double[] samples;

    public LabMeasurement(String experimentName, double[] samples) {
        this.experimentName = experimentName;
        // захисна копія на вході
        this.samples = (samples == null) ? new double[0] : Arrays.copyOf(samples, samples.length);
    }

    public String getExperimentName() {
        return experimentName;
    }

    /** Захисна копія на виході. */
    public double[] getSamples() {
        return Arrays.copyOf(samples, samples.length);
    }

    @Override
    public String toString() {
        return "LabMeasurement[" + experimentName + ", samples=" + Arrays.toString(samples) + "]";
    }
}

/** Завдання 3: гаманець без відкритих сеттерів і без геттера для секретної фрази. */
class CryptoVault {
    private final String walletAddress;
    private final String secretRecoveryPhrase;
    private double btcBalance;
    private boolean locked;

    public CryptoVault(String walletAddress, String secretRecoveryPhrase, double initialBalance) {
        this.walletAddress = walletAddress;
        this.secretRecoveryPhrase = secretRecoveryPhrase;
        this.btcBalance = Math.max(0, initialBalance);
        this.locked = true; // новий гаманець завжди заблокований
    }

    public boolean unlock(String phrase) {
        if (secretRecoveryPhrase.equals(phrase)) {
            locked = false;
            return true;
        }
        return false;
    }

    public void lock() {
        locked = true;
    }

    public boolean sendBtc(double amount, String destination) {
        if (locked || amount <= 0 || btcBalance < amount
                || destination == null || destination.isBlank()) {
            return false;
        }
        btcBalance -= amount;
        return true;
    }

    public double getBtcBalance() {
        return btcBalance;
    }

    @Override
    public String toString() {
        return String.format("CryptoVault[address=%s, %s, balance=%.4f BTC]",
                walletAddress, locked ? "ЗАБЛОКОВАНО" : "розблоковано", btcBalance);
    }
}

/** Завдання 4: інтервал із самовідновлюваним інваріантом start <= end. */
class ClosedInterval {
    private double start;
    private double end;

    public ClosedInterval(double start, double end) {
        resize(start, end);
    }

    public void resize(double newStart, double newEnd) {
        if (newStart > newEnd) { // відновлюємо інваріант
            double tmp = newStart;
            newStart = newEnd;
            newEnd = tmp;
        }
        this.start = newStart;
        this.end = newEnd;
    }

    public double getLength() {
        return end - start;
    }

    public double getMidpoint() {
        return (start + end) / 2.0;
    }

    public boolean overlaps(ClosedInterval other) {
        return this.start <= other.end && other.start <= this.end;
    }

    @Override
    public String toString() {
        return String.format("[%.2f; %.2f] (центр: %.2f, довжина: %.2f)",
                start, end, getMidpoint(), getLength());
    }
}

/** Завдання 5: незмінний RGB-колір. */
final class RgbColor {
    private final int red;
    private final int green;
    private final int blue;

    public RgbColor(int red, int green, int blue) {
        this.red = clamp(red);
        this.green = clamp(green);
        this.blue = clamp(blue);
    }

    private static int clamp(int val) {
        return Math.max(0, Math.min(255, val));
    }

    public String toHex() {
        return String.format("#%02X%02X%02X", red, green, blue);
    }

    public RgbColor invert() {
        return new RgbColor(255 - red, 255 - green, 255 - blue);
    }

    /** Змішування = середнє арифметичне кожного каналу. */
    public RgbColor mixWith(RgbColor other) {
        return new RgbColor((red + other.red) / 2,
                (green + other.green) / 2,
                (blue + other.blue) / 2);
    }

    @Override
    public String toString() {
        return String.format("RgbColor(%d, %d, %d) %s", red, green, blue, toHex());
    }
}

/** Завдання 6: сейф із лічильником невдалих спроб. */
class HighSecuritySafe {
    private final int pinCode;
    private double storedCash;
    private int failedAttempts;
    private boolean permanentlyBlocked;

    public HighSecuritySafe(int pinCode, double initialCash) {
        this.pinCode = pinCode;
        this.storedCash = Math.max(0, initialCash);
    }

    private boolean checkAccess(int enteredPin) {
        if (permanentlyBlocked) {
            return false;
        }
        if (enteredPin != pinCode) {
            failedAttempts++;
            if (failedAttempts >= 3) {
                permanentlyBlocked = true;
            }
            return false;
        }
        failedAttempts = 0;
        return true;
    }

    public boolean putCash(int pin, double amount) {
        if (!checkAccess(pin) || amount <= 0) {
            return false;
        }
        storedCash += amount;
        return true;
    }

    public boolean takeCash(int pin, double amount) {
        if (!checkAccess(pin) || amount <= 0 || amount > storedCash) {
            return false;
        }
        storedCash -= amount;
        return true;
    }

    public boolean isPermanentlyBlocked() {
        return permanentlyBlocked;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    @Override
    public String toString() {
        return "HighSecuritySafe[невдалих спроб=" + failedAttempts
                + ", заблоковано назавжди=" + permanentlyBlocked + "]";
    }
}

/** Завдання 7: многочлен із захищеним масивом коефіцієнтів c0 + c1*x + c2*x^2 + ... */
class EncapsulatedPolynomial {
    private final double[] coeffs;

    public EncapsulatedPolynomial(double... coefficients) {
        if (coefficients == null || coefficients.length == 0) {
            this.coeffs = new double[]{0.0};
            return;
        }
        // прибираємо старші нулі, щоб ступінь був справжнім
        int last = coefficients.length - 1;
        while (last > 0 && coefficients[last] == 0.0) {
            last--;
        }
        this.coeffs = Arrays.copyOf(coefficients, last + 1); // захисна копія
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    public double getCoefficient(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Степінь не може бути від'ємним: " + power);
        }
        return power > getDegree() ? 0.0 : coeffs[power];
    }

    /** Схема Горнера. */
    public double evaluate(double x) {
        double result = 0.0;
        for (int i = coeffs.length - 1; i >= 0; i--) {
            result = result * x + coeffs[i];
        }
        return result;
    }

    private static String fmt(double v) {
        return v == Math.rint(v) ? String.valueOf((long) v) : String.format("%.2f", v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P(x) = ");
        boolean first = true;
        for (int i = getDegree(); i >= 0; i--) {
            double c = coeffs[i];
            if (c == 0.0 && getDegree() > 0) {
                continue;
            }
            if (first) {
                if (c < 0) {
                    sb.append("-");
                }
            } else {
                sb.append(c < 0 ? " - " : " + ");
            }
            double abs = Math.abs(c);
            if (!(abs == 1.0 && i > 0)) { // "1x" записуємо як "x"
                sb.append(fmt(abs));
            }
            if (i >= 1) {
                sb.append("x");
            }
            if (i >= 2) {
                sb.append("^").append(i);
            }
            first = false;
        }
        return sb.toString();
    }
}

/** Завдання 8: медична картка із захистом персональних даних. */
class MedicalRecord {
    private final String patientId;
    private String fullName;
    private final int bloodGroup; // 1..4
    private final boolean rhPositive;
    private final String[] allergies;

    public MedicalRecord(String patientId, String fullName, int bloodGroup,
                         boolean rhPositive, String[] allergies) {
        if (bloodGroup < 1 || bloodGroup > 4) {
            throw new IllegalArgumentException("Група крові має бути від 1 до 4, а не " + bloodGroup);
        }
        this.patientId = patientId;
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
        this.rhPositive = rhPositive;
        this.allergies = (allergies == null) ? new String[0] : Arrays.copyOf(allergies, allergies.length);
    }

    public String getPatientId() {
        return patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public String[] getAllergies() {
        return Arrays.copyOf(allergies, allergies.length);
    }

    public boolean hasAllergyTo(String substance) {
        for (String a : allergies) {
            if (a.equalsIgnoreCase(substance)) {
                return true;
            }
        }
        return false;
    }

    private String bloodGroupText() {
        return switch (bloodGroup) {
            case 1 -> "I (O)";
            case 2 -> "II (A)";
            case 3 -> "III (B)";
            default -> "IV (AB)";
        };
    }

    @Override
    public String toString() {
        return "MedicalRecord[id=" + patientId + ", ПІБ=" + fullName
                + ", кров=" + bloodGroupText() + (rhPositive ? " Rh+" : " Rh-")
                + ", алергії=" + Arrays.toString(allergies) + "]";
    }
}
