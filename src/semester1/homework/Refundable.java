package semester1.homework;

/** Контракт CAN-DO: платіж можна повернути. */
public interface Refundable {

    boolean requestRefund(String reason);

    boolean isRefunded();
}
