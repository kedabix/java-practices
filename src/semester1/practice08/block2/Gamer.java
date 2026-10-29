package semester1.practice08.block2;

public class Gamer {
    private String nickname;
    private int hoursPlayed;

    public Gamer(String nickname, int hoursPlayed) {
        this.nickname = nickname;
        this.hoursPlayed = hoursPlayed;
    }

    public String getNickname() {
        return nickname;
    }

    public int getHoursPlayed() {
        return hoursPlayed;
    }

    @Override
    public String toString() {
        return "Gamer{nickname='" + nickname + "', hoursPlayed=" + hoursPlayed + "}";
    }
}
