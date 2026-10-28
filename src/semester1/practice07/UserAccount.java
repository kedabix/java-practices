package semester1.practice07;

public class UserAccount {
    private static int nextId = 1001;

    private int id;
    private String username;
    private String email;

    public UserAccount(String username, String email) {
        this.id = nextId++;
        this.username = username;
        this.email = email;
    }

    public static int getNextAvailableId() {
        return nextId;
    }

    public static void resetIdSequence(int startId) {
        nextId = startId;
    }

    public int getId() {
        return id;
    }

    public void printAccount() {
        System.out.println("ID: " + id + ", логін: " + username + ", email: " + email);
    }
}
