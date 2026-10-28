package semester1.practice07;

public class SmartBulb {
    private int brightness;
    private int colorTemp;
    private boolean isOn;

    public SmartBulb(int brightness, int colorTemp, boolean isOn) {
        if (brightness < 0) {
            brightness = 0;
        }
        if (brightness > 100) {
            brightness = 100;
        }
        if (colorTemp < 2700) {
            colorTemp = 2700;
        }
        if (colorTemp > 6500) {
            colorTemp = 6500;
        }
        this.brightness = brightness;
        this.colorTemp = colorTemp;
        this.isOn = isOn;
    }

    public SmartBulb(int brightness) {
        this(brightness, 4000, true);
    }

    public SmartBulb() {
        this(50);
    }

    public void printStatus() {
        System.out.println("Лампочка: яскравість " + brightness + "%, температура " + colorTemp + "K, увімкнена: " + isOn);
    }
}
