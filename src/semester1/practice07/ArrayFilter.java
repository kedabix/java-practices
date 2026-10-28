package semester1.practice07;

public class ArrayFilter {

    // Усі елементи, строго більші за threshold
    public int[] filter(int[] arr, int threshold) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > threshold) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > threshold) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    // Елементи з діапазону [min; max]
    public int[] filter(int[] arr, int min, int max) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && arr[i] <= max) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && arr[i] <= max) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    // Парні або непарні
    public int[] filter(int[] arr, boolean keepEvens) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isEven = arr[i] % 2 == 0;
            if (isEven == keepEvens) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isEven = arr[i] % 2 == 0;
            if (isEven == keepEvens) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }
}
