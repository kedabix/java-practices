package semester1.practice10.homework;

/** Контракт CAN-DO: платіж можна повернути. */
public interface Refundable {

    boolean requestRefund(String reason);

    boolean isRefunded();
}
