package semester1.practice08.block4;

// final class: від цього класу неможливо створити спадкоємця.
// Рядок "class Hacker extends ImmutableServerCredentials {}" не скомпілюється.
public final class ImmutableServerCredentials {
    private final String host;
    private final int port;
    private final String apiKey;

    public ImmutableServerCredentials(String host, int port, String apiKey) {
        this.host = host;
        this.port = port;
        this.apiKey = apiKey;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getApiKey() {
        return apiKey;
    }

    @Override
    public String toString() {
        return "ImmutableServerCredentials{host='" + host + "', port=" + port + ", apiKey='***SECRET***'}";
    }
}
