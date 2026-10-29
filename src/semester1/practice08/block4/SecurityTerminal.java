package semester1.practice08.block4;

public class SecurityTerminal {

    // final: цей метод заборонено перевизначати в нащадках
    public final String generateAuthHash(String user) {
        return "AUTH-SHA-" + user.toUpperCase();
    }

    public String getWelcomeBanner() {
        return "=== Security Terminal ===";
    }
}
