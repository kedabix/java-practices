package semester1.practice08.block4;

public class StudentUser extends User {
    private String groupCode;
    private double gpa;

    public StudentUser(int id, String email, String groupCode, double gpa) {
        super(id, email);
        this.groupCode = groupCode;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "StudentUser{" + super.toString() + ", group='" + groupCode + "', gpa=" + gpa + "}";
    }
}
