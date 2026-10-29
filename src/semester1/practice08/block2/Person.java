package semester1.practice08.block2;

public class Person {
    private String fullName;
    private int birthYear;

    public Person(String fullName, int birthYear) {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge(int currentYear) {
        return currentYear - birthYear;
    }

    @Override
    public String toString() {
        return "Person{name='" + fullName + "', birthYear=" + birthYear + "}";
    }
}
