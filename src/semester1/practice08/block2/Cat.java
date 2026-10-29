package semester1.practice08.block2;

public class Cat extends Animal {
    private boolean isIndoor;

    public Cat(String name, int age, double weight, boolean isIndoor) {
        super(name, age, weight);
        this.isIndoor = isIndoor;
    }

    public String purr() {
        return getName() + " муркоче: мррр...";
    }

    @Override
    public String toString() {
        return "Cat{name='" + getName() + "', age=" + getAge() + ", weight=" + getWeight() + ", indoor=" + isIndoor + "}";
    }
}
