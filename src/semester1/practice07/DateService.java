package semester1.practice07;

public class DateService {
    private int day;
    private int month;
    private int year;

    public DateService(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void add(int days) {
        add(days, 0, 0);
    }

    public void add(int days, int months) {
        add(days, months, 0);
    }

    public void add(int days, int months, int years) {
        this.day += days;
        this.month += months;
        this.year += years;

        // Спрощено: у кожному місяці 30 днів
        while (this.day > 30) {
            this.day -= 30;
            this.month++;
        }
        while (this.month > 12) {
            this.month -= 12;
            this.year++;
        }
    }

    public void printDate() {
        System.out.println(String.format("%02d.%02d.%d", day, month, year));
    }
}
