package semester1.practice08.block4;

public class CustomTerminal extends SecurityTerminal {
    private String adminUser;

    public CustomTerminal(String adminUser) {
        this.adminUser = adminUser;
    }

    // Звичайний метод перевизначати можна
    @Override
    public String getWelcomeBanner() {
        return "*** Custom Terminal *** | Токен: " + generateAuthHash(adminUser);
    }

    // Якщо написати так:
    //
    // @Override
    // public String generateAuthHash(String user) { return "hacked"; }
    //
    // буде ПОМИЛКА КОМПІЛЯЦІЇ: метод generateAuthHash оголошений як final
    // у батьківському класі, тому його не можна перевизначити.
}
