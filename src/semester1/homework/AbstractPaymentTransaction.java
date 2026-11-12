package semester1.homework;

/** Базовий клас (IS-A) для всіх платежів із незмінним шаблонним методом process(). */
public abstract class AbstractPaymentTransaction {

    private final String txId;
    private final double baseAmountUah;
    private boolean processed;

    protected AbstractPaymentTransaction(String txId, double baseAmountUah) {
        this.txId = txId;
        this.baseAmountUah = baseAmountUah;
    }

    public abstract double calculateFee();

    public abstract String getPaymentChannel();

    /**
     * Фінальний шаблонний метод: нащадки не можуть змінити порядок перевірок.
     * Повертає false, якщо сума некоректна або платіж уже проведено.
     */
    public final boolean process() {
        if (baseAmountUah <= 0 || processed) {
            return false;
        }
        processed = true;
        return true;
    }

    public final double getTotalCharged() {
        return baseAmountUah + calculateFee();
    }

    public String getTxId() {
        return txId;
    }

    public double getBaseAmountUah() {
        return baseAmountUah;
    }

    public boolean isProcessed() {
        return processed;
    }
}
