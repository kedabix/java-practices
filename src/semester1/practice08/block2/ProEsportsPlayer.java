package semester1.practice08.block2;

public class ProEsportsPlayer extends Gamer {
    private String teamName;
    private double prizeMoneyUSD;
    private int tournamentsWon;

    public ProEsportsPlayer(String nickname, int hoursPlayed, String teamName, double prizeMoneyUSD, int tournamentsWon) {
        super(nickname, hoursPlayed);
        this.teamName = teamName;
        this.prizeMoneyUSD = prizeMoneyUSD;
        this.tournamentsWon = tournamentsWon;
    }

    // Захист від ділення на нуль
    public double getAveragePrizePerWin() {
        if (tournamentsWon == 0) {
            return 0.0;
        }
        return prizeMoneyUSD / tournamentsWon;
    }

    @Override
    public String toString() {
        return "ProEsportsPlayer{" + super.toString() + ", team='" + teamName + "', prize=$" + prizeMoneyUSD
                + ", wins=" + tournamentsWon + ", avgPerWin=$" + getAveragePrizePerWin() + "}";
    }
}
