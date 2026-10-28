package semester1.practice07;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isPalindrome(String s) {
        String clean = s.replace(" ", "").toLowerCase();
        for (int i = 0; i < clean.length() / 2; i++) {
            if (clean.charAt(i) != clean.charAt(clean.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static String reverse(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    public static int countVowels(String s) {
        String vowels = "aeiouаеєиіїоуюя";
        int count = 0;
        String lower = s.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            if (vowels.indexOf(lower.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    // Приховує всі цифри, крім останніх 4
    public static String maskCardNumber(String cardNumber) {
        String digits = cardNumber.replace(" ", "");
        String result = "";
        for (int i = 0; i < digits.length(); i++) {
            if (i > 0 && i % 4 == 0) {
                result += " ";
            }
            if (i >= digits.length() - 4) {
                result += digits.charAt(i);
            } else {
                result += "*";
            }
        }
        return result;
    }
}
