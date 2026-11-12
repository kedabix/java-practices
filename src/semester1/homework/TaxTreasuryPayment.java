package semester1.homework;

/** Державний платіж: без комісії та кешбеку, допускає бюджетне повернення. Клас final. */
public final class TaxTreasuryPayment extends AbstractPaymentTransaction implements Refundable {

    private final String taxCode;
    private boolean refunded;

    public TaxTreasuryPayment(String txId, double baseAmountUah, String taxCode) {
        super(txId, baseAmountUah);
        this.taxCode = taxCode;
    }

    @Override
    public double calculateFee() {
        return 0.0;
    }

    @Override
    public String getPaymentChannel() {
        return "ДержКазначейство";
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

    public String getTaxCode() {
        return taxCode;
    }
}
