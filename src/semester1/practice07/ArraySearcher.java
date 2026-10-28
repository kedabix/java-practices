package semester1.practice07;

public class ArraySearcher {

    public int find(int[] arr, int target) {
        return find(arr, target, 0);
    }

    public int find(int[] arr, int target, int startIndex) {
        for (int i = startIndex; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int find(String[] arr, String target) {
        return find(arr, target, false);
    }

    public int find(String[] arr, String target, boolean ignoreCase) {
        for (int i = 0; i < arr.length; i++) {
            if (ignoreCase) {
                if (arr[i].equalsIgnoreCase(target)) {
                    return i;
                }
            } else {
                if (arr[i].equals(target)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
