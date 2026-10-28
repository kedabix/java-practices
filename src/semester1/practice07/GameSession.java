package semester1.practice07;

public class GameSession {
    private static int activeSessionsCount = 0;
    private static int tokenCounter = 1;
    public static final int MAX_SESSIONS = 3;

    private String sessionToken;
    private String hostPlayer;
    private boolean isActive;

    // Приватний конструктор: сесію можна створити тільки через createSession
    private GameSession(String host) {
        this.sessionToken = "SESSION-" + tokenCounter;
        tokenCounter++;
        this.hostPlayer = host;
        this.isActive = true;
    }

    public static GameSession createSession(String host) {
        if (activeSessionsCount >= MAX_SESSIONS) {
            System.out.println("Помилка: усі сервера перевантажені!");
            return null;
        }
        activeSessionsCount++;
        return new GameSession(host);
    }

    public void terminate() {
        if (isActive) {
            isActive = false;
            activeSessionsCount--;
            System.out.println("Сесію " + sessionToken + " завершено");
        }
    }

    public void printSession() {
        System.out.println("Сесія " + sessionToken + ", хост: " + hostPlayer + ", активна: " + isActive);
    }
}
