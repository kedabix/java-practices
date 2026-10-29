package semester1.practice08.block2;

public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary); // завжди першим рядком
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public String toString() {
        // name приватне, тому беремо через getName(); salary protected - доступне напряму
        return "Developer{name='" + getName() + "', salary=" + salary + ", language='" + programmingLanguage + "'}";
    }
}
