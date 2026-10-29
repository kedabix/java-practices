package semester1.practice08.block1;

import java.util.Locale;

public class WeatherDay {
    private String date;
    private double[] hourlyTemps;

    public WeatherDay(String date, double[] hourlyTemps) {
        this.date = date;
        // Зберігаємо КОПІЮ масиву, щоб зовні його не можна було змінити
        this.hourlyTemps = new double[hourlyTemps.length];
        for (int i = 0; i < hourlyTemps.length; i++) {
            this.hourlyTemps[i] = hourlyTemps[i];
        }
    }

    public double getMinTemp() {
        double min = hourlyTemps[0];
        for (int i = 1; i < hourlyTemps.length; i++) {
            if (hourlyTemps[i] < min) {
                min = hourlyTemps[i];
            }
        }
        return min;
    }

    public double getMaxTemp() {
        double max = hourlyTemps[0];
        for (int i = 1; i < hourlyTemps.length; i++) {
            if (hourlyTemps[i] > max) {
                max = hourlyTemps[i];
            }
        }
        return max;
    }

    public double getAverageTemp() {
        double sum = 0;
        for (int i = 0; i < hourlyTemps.length; i++) {
            sum += hourlyTemps[i];
        }
        return sum / hourlyTemps.length;
    }

    @Override
    public String toString() {
        String values = "[";
        for (int i = 0; i < hourlyTemps.length; i++) {
            values += hourlyTemps[i];
            if (i < hourlyTemps.length - 1) {
                values += ", ";
            }
        }
        values += "]";
        return String.format(Locale.US, "WeatherDay{date=%s, temps=%s, average=%.1f}", date, values, getAverageTemp());
    }
}
