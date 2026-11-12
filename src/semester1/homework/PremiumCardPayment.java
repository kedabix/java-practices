package semester1.homework;

/** Оплата преміальною карткою: комісія 1%, кешбек 3% (з лімітом), підтримує повернення. */
public class PremiumCardPayment extends AbstractPaymentTransaction implements CashbackCapable, Refundable {

    private static final double FEE_RATE = 0.01;

    private final String maskedPan;
    private final double cashbackRate = 0.03;
    private boolean refunded;

    public PremiumCardPayment(String txId, double baseAmountUah, String maskedPan) {
        super(txId, baseAmountUah);
        this.maskedPan = maskedPan;
    }

    @Override
    public double calculateFee() {
        return getBaseAmountUah() * FEE_RATE;
    }

    @Override
    public String getPaymentChannel() {
        return "Visa Infinite";
    }

    @Override
    public double getCashbackRate() {
        return cashbackRate;
    }

    @Override
    public boolean requestRefund(String reason) {
        if (isProcessed() && !refunded) {
            refunded = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean isRefunded() {
        return refunded;
    }

    public String getMaskedPan() {
        return maskedPan;
    }
}
