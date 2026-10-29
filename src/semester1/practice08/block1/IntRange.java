package semester1.practice08.block1;

public class IntRange {
    private int min;
    private int max;

    public IntRange(int min, int max) {
        setRange(min, max);
    }

    // Якщо min > max, міняємо їх місцями
    public void setRange(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        this.min = min;
        this.max = max;
    }

    public boolean contains(int value) {
        return value >= min && value <= max;
    }

    public int getLength() {
        return max - min;
    }

    @Override
    public String toString() {
        return "[" + min + " .. " + max + "] (довжина: " + getLength() + ")";
    }
}
