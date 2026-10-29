package semester1.practice08.block2;

public class Professor extends Person {
    private String academicTitle;
    private int publicationsCount;

    public Professor(String fullName, int birthYear, String academicTitle, int publicationsCount) {
        super(fullName, birthYear);
        this.academicTitle = academicTitle;
        this.publicationsCount = publicationsCount;
    }

    @Override
    public String toString() {
        return "Professor{" + super.toString() + ", title='" + academicTitle + "', publications=" + publicationsCount + "}";
    }
}
