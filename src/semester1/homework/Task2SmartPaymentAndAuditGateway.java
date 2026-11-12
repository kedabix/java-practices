package semester1.homework;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/** Завдання 2: FinTech-шлюз — final шаблонний метод, інтерфейси ролей та аудит через instanceof. */
public class Task2SmartPaymentAndAuditGateway {

    /** Проводить усі платежі та проводить аудит можливостей. */
    public static void audit(AbstractPaymentTransaction[] ledger) {
        double turnover = 0;
        double fees = 0;
        double cashbackPaid = 0;

        // 1. Поліморфне проведення — без жодних перевірок типів
        System.out.println("[1. ПРОВЕДЕННЯ ПАКЕТУ ТРАНЗАКЦІЙ (final process())]:");
        for (AbstractPaymentTransaction tx : ledger) {
            boolean ok = tx.process();
            System.out.printf(Locale.US,
                    "  %s [%s | %s] Сума: %8.2f грн | Комісія: %6.2f грн | Всього: %8.2f грн%n",
                    ok ? "✅" : "❌", tx.getTxId(), tx.getPaymentChannel(),
                    tx.getBaseAmountUah(), tx.calculateFee(), tx.getTotalCharged());
            if (ok) {
                turnover += tx.getBaseAmountUah();
                fees += tx.calculateFee();
            }
        }

        // 2. Аудит можливостей через Pattern Matching instanceof
        System.out.println();
        System.out.println("[2. АВТОМАТИЧНИЙ АУДИТ МОЖЛИВОСТЕЙ (Pattern Matching instanceof)]:");

        for (AbstractPaymentTransaction tx : ledger) {
            if (tx instanceof CashbackCapable c) {
                double raw = tx.getBaseAmountUah() * c.getCashbackRate();
                double credited = c.calculateCashback(tx.getBaseAmountUah());
                cashbackPaid += credited;
                if (raw > CashbackCapable.MAX_CASHBACK_UAH) {
                    System.out.printf(Locale.US,
                            "  💰 [CashbackCapable] %s: розрахунковий %.0f%% = %.0f грн -> нараховано %.2f грн (Ліміт MAX_CASHBACK_UAH!)%n",
                            tx.getTxId(), c.getCashbackRate() * 100, raw, credited);
                } else {
                    String label = (tx instanceof BlockchainVerifiable) ? "крипто-бонусу" : "кешбеку";
                    System.out.printf(Locale.US,
                            "  💰 [CashbackCapable] %s: нараховано %.0f%% %s = %.2f грн%n",
                            tx.getTxId(), c.getCashbackRate() * 100, label, credited);
                }
            }
        }

        for (AbstractPaymentTransaction tx : ledger) {
            if (tx instanceof BlockchainVerifiable b) {
                System.out.printf("  ⛓️ [BlockchainVerifiable] %s: Hash=%s, Підтверджень=%d (Finalized: %b)%n",
                        tx.getTxId(), b.getTxHash(), b.getConfirmations(), b.isFinalized());
            }
        }

        // Тестове повернення коштів — для першої транзакції, що підтримує Refundable
        for (AbstractPaymentTransaction tx : ledger) {
            if (tx instanceof Refundable r) {
                boolean refunded = r.requestRefund("Подвійне списання");
                System.out.printf("  🔄 [Refundable] Спроба повернення %s ('Подвійне списання'): %s%n",
                        tx.getTxId(), refunded ? "УСПІШНО ПОВЕРНЕНО!" : "ВІДХИЛЕНО");
                break;
            }
        }

        System.out.println();
        System.out.println("[ПІДСУМКОВИЙ ЗВІТ ШЛЮЗУ]:");
        System.out.printf(Locale.US, "  Сумарний базовий оборот:  %.2f грн%n", turnover);
        System.out.printf(Locale.US, "  Сумарна комісія шлюзу:      %.2f грн%n", fees);
        System.out.printf(Locale.US, "  Сумарний виплачений кешбек: %.2f грн%n", cashbackPaid);
    }

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        AbstractPaymentTransaction[] ledger = {
                new PremiumCardPayment("TX-101", 20000.0, "4111 **** **** 1111"),
                new CryptoUsdtPayment("TX-102", 8500.0, "0x9f8a...c4", 18),
                new TaxTreasuryPayment("TX-103", 5000.0, "TAX-2026-11")
        };

        System.out.println("================ ПРОЦЕСИНГОВИЙ ЦЕНТР FINTECH (POLYMORPHISM & INTERFACES) ================");
        audit(ledger);
        System.out.println("=========================================================================================");
    }
}
