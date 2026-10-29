package semester1.practice08.block4;

public class PostgraduateStudent extends StudentUser {
    private String thesisTopic;
    private String supervisorName;

    public PostgraduateStudent(int id, String email, String groupCode, double gpa,
                               String thesisTopic, String supervisorName) {
        super(id, email, groupCode, gpa);
        this.thesisTopic = thesisTopic;
        this.supervisorName = supervisorName;
    }

    // Допуск до захисту: gpa >= 85 і тема не порожня
    public boolean canDefendThesis() {
        return getGpa() >= 85.0 && thesisTopic != null && !thesisTopic.isEmpty();
    }

    @Override
    public String toString() {
        return "PostgraduateStudent{" + super.toString() + ", thesis='" + thesisTopic + "', supervisor='"
                + supervisorName + "', допущений до захисту=" + canDefendThesis() + "}";
    }
}
