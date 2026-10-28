package semester1.practice07;

public class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        if (age < 15 || age > 80) {
            this.age = 18;
        } else {
            this.age = age;
        }
        if (gpa < 0.0 || gpa > 5.0) {
            this.gpa = 0.0;
        } else {
            this.gpa = gpa;
        }
    }

    public boolean isHonorStudent() {
        return gpa >= 4.5;
    }

    public void printStudent() {
        String status;
        if (isHonorStudent()) {
            status = "Відмінник";
        } else {
            status = "Звичайний студент";
        }
        System.out.println("Студент: " + name + ", вік: " + age + ", середній бал: " + gpa + " (" + status + ")");
    }
}
