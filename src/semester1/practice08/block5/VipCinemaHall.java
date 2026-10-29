package semester1.practice08.block5;

import java.util.Locale;

public class VipCinemaHall extends CinemaHall {
    private double complimentaryBarCost;

    public VipCinemaHall(String hallName, int rows, int cols, double baseTicketPrice, double complimentaryBarCost) {
        super(hallName, rows, cols, baseTicketPrice);
        this.complimentaryBarCost = complimentaryBarCost;
    }

    // Квитки останнього ряду дорожчі: +50% до ціни та вартість напоїв з бару
    @Override
    public double calculateRevenue() {
        int lastRow = seats.length - 1;
        int occupiedInLastRow = 0;
        for (int j = 0; j < seats[lastRow].length; j++) {
            if (seats[lastRow][j]) {
                occupiedInLastRow++;
            }
        }
        double extraPerTicket = baseTicketPrice * 0.5 + complimentaryBarCost;
        return super.calculateRevenue() + occupiedInLastRow * extraPerTicket;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(Locale.US, "\nVIP: напої в останньому ряду коштують %.2f грн на квиток",
                complimentaryBarCost);
    }
}
