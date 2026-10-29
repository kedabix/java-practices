package semester1.practice08.block1;

public class Student {
    private String name;
    private int course;
    private double gpa;

    public Student(String name, int course, double gpa) {
        this.name = name;
        setCourse(course);
        setGpa(gpa);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    // Курс має бути від 1 до 6, інакше ставимо 1
    public void setCourse(int course) {
        if (course >= 1 && course <= 6) {
            this.course = course;
        } else {
            this.course = 1;
        }
    }

    public double getGpa() {
        return gpa;
    }

    // Середній бал від 0 до 100, інакше ставимо 60
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 100.0) {
            this.gpa = gpa;
        } else {
            this.gpa = 60.0;
        }
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', course=" + course + ", gpa=" + gpa + "}";
    }
}
