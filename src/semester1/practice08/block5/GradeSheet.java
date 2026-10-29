package semester1.practice08.block5;

import java.util.Locale;

public class GradeSheet {
    private String studentName;
    protected int[] grades;

    public GradeSheet(String studentName, int[] grades) {
        this.studentName = studentName;
        // Копія масиву, щоб зовнішній код не міг його змінити
        this.grades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            this.grades[i] = grades[i];
        }
    }

    public String getStudentName() {
        return studentName;
    }

    // Звичайне середнє арифметичне
    protected double calculateAverage() {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum / grades.length;
    }

    public double calculateScore() {
        return calculateAverage();
    }

    protected String gradesToString() {
        String text = "[";
        for (int i = 0; i < grades.length; i++) {
            text += grades[i];
            if (i < grades.length - 1) {
                text += ", ";
            }
        }
        return text + "]";
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "GradeSheet{student='%s', grades=%s, середній бал=%.2f}",
                studentName, gradesToString(), calculateAverage());
    }
}
