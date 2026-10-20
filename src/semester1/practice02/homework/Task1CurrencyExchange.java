package semester1.practice02.homework;

// Завдання 1
public class Task1CurrencyExchange {
    public static void main(String[] args) {
        double usdAmount = 250.0;
        final double EXCHANGE_RATE = 41.25;
        final double COMMISSION_PERCENT = 1.5; // 1.5%

        double totalUah = usdAmount * EXCHANGE_RATE;
        double commission = totalUah * COMMISSION_PERCENT / 100;
        double netAmount = totalUah - commission;
        long cashAmount = Math.round(netAmount);

        System.out.println("================ КВИТАНЦІЯ ОБМІНУ ================");
        System.out.printf("Сума до обміну:             %.2f USD%n", usdAmount);
        System.out.println("Курс валют:                 " + EXCHANGE_RATE + " UAH/USD");
        System.out.printf("Нараховано до комісії:      %.2f UAH%n", totalUah);
        System.out.printf("Комісія банку (" + COMMISSION_PERCENT + "%%):       %.2f UAH%n", commission);
        System.out.println("--------------------------------------------------");
        System.out.printf("Чиста сума до видачі:       %.2f UAH%n", netAmount);
        System.out.println("До видачі готівкою:         " + cashAmount + " UAH");
        System.out.println("==================================================");
    }
}
