package semester1.practice10.homework;

/** Контракт CAN-DO: платіж може нараховувати кешбек (з обмеженням зверху). */
public interface CashbackCapable {

    /** Максимальний кешбек за одну транзакцію, грн. */
    double MAX_CASHBACK_UAH = 500.0;

    /** Частка кешбеку (наприклад, 0.03 для 3%). */
    double getCashbackRate();

    default double calculateCashback(double baseAmount) {
        return Math.min(MAX_CASHBACK_UAH, baseAmount * getCashbackRate());
    }
}
