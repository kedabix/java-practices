package semester1.homework;

/** Контракт CAN-DO: транзакцію можна перевірити в блокчейні. */
public interface BlockchainVerifiable {

    String getTxHash();

    int getConfirmations();

    default boolean isFinalized() {
        return getConfirmations() >= 12;
    }
}
