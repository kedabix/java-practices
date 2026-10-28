package semester1.practice07;

public class CurrencyExchange {
    private static double usdToUahRate = 41.5;
    private static double eurToUahRate = 45.2;

    public static void updateRates(double newUsd, double newEur) {
        if (newUsd > 0 && newEur > 0) {
            usdToUahRate = newUsd;
            eurToUahRate = newEur;
        } else {
            System.out.println("Курси мають бути більшими за 0!");
        }
    }

    public static double uahToUsd(double uah) {
        return uah / usdToUahRate;
    }

    public static double usdToUah(double usd) {
        return usd * usdToUahRate;
    }

    public static double eurToUah(double eur) {
        return eur * eurToUahRate;
    }
}
