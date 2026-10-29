package semester1.practice08.block1;

import java.util.Locale;

public class CardWallet {
    private String cardNumber;
    private String pinCode;
    private double balance;

    public CardWallet(String cardNumber, String pinCode, double balance) {
        if (cardNumber != null && cardNumber.length() == 16) {
            this.cardNumber = cardNumber;
        } else {
            this.cardNumber = "0000000000000000";
        }
        this.pinCode = pinCode;
        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0.0;
        }
    }

    // Геттера для pinCode немає навмисно! PIN можна лише змінити.
    public boolean changePin(String oldPin, String newPin) {
        if (pinCode.equals(oldPin) && newPin != null && newPin.length() == 4) {
            pinCode = newPin;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        String last4 = cardNumber.substring(12);
        return String.format(Locale.US, "CardWallet{card='**** **** **** %s', balance=%.2f UAH}", last4, balance);
    }
}
