package semester1.practice07;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        if (hours < 0 || hours > 23) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }
        if (minutes < 0 || minutes > 59) {
            this.minutes = 0;
        } else {
            this.minutes = minutes;
        }
        if (seconds < 0 || seconds > 59) {
            this.seconds = 0;
        } else {
            this.seconds = seconds;
        }
    }

    // Додає одну секунду
    public void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
        if (hours == 24) {
            hours = 0;
        }
    }

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String toStandardString() {
        int h = hours % 12;
        if (h == 0) {
            h = 12;
        }
        String suffix;
        if (hours < 12) {
            suffix = "AM";
        } else {
            suffix = "PM";
        }
        return String.format("%d:%02d:%02d %s", h, minutes, seconds, suffix);
    }
}
