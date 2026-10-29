package semester1.practice08.block2;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight);
        this.breed = breed;
    }

    public String fetchStick() {
        return getName() + " приносить палицю!";
    }

    @Override
    public String toString() {
        return "Dog{name='" + getName() + "', age=" + getAge() + ", weight=" + getWeight() + ", breed='" + breed + "'}";
    }
}
