package semester1.practice08.block4;

public class User {
    private int id;
    private String email;

    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", email='" + email + "'}";
    }
}
