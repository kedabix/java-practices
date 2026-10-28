package semester1.practice07;

public class ServerConfig {
    public static final String SERVER_NAME = "AlphaEnterprise";
    public static final int MAX_CONNECTIONS = 5;

    private static int activeConnections = 0;

    public static boolean connect() {
        if (activeConnections < MAX_CONNECTIONS) {
            activeConnections++;
            return true;
        }
        return false;
    }

    public static void disconnect() {
        if (activeConnections > 0) {
            activeConnections--;
        }
    }

    public static void printServerStatus() {
        System.out.println("Сервер " + SERVER_NAME + ": підключень " + activeConnections
                + ", вільних слотів " + (MAX_CONNECTIONS - activeConnections));
    }
}
