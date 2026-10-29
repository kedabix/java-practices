package semester1.practice08.block5;

import java.util.Locale;

public class CinemaHall {
    private String hallName;
    protected boolean[][] seats; // true - зайнято, false - вільно
    protected double baseTicketPrice;

    public CinemaHall(String hallName, int rows, int cols, double baseTicketPrice) {
        this.hallName = hallName;
        this.seats = new boolean[rows][cols];
        this.baseTicketPrice = baseTicketPrice;
    }

    // Ряди та місця нумеруються з 1
    public boolean bookSeat(int row, int col) {
        if (row < 1 || row > seats.length || col < 1 || col > seats[0].length) {
            System.out.println("Такого місця не існує: ряд " + row + ", місце " + col);
            return false;
        }
        if (seats[row - 1][col - 1]) {
            System.out.println("Місце вже зайняте: ряд " + row + ", місце " + col);
            return false;
        }
        seats[row - 1][col - 1] = true;
        return true;
    }

    public int getOccupiedCount() {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public double calculateRevenue() {
        return getOccupiedCount() * baseTicketPrice;
    }

    @Override
    public String toString() {
        String text = "Зал \"" + hallName + "\" (X - зайнято, O - вільно)\n";
        for (int i = 0; i < seats.length; i++) {
            text += "Ряд " + (i + 1) + ": ";
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    text += "[X]";
                } else {
                    text += "[O]";
                }
            }
            text += "\n";
        }
        text += String.format(Locale.US, "Зайнято: %d, виручка: %.2f грн", getOccupiedCount(), calculateRevenue());
        return text;
    }
}
