class Animal {
    private final String name;
    Animal(String name) { this.name = name; }
    String getName() { return name; }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);                              // explicit call satisfies the compiler
    }
}

public class FixedDog {
    public static void main(String[] args) {
        System.out.println(new Dog("Rex").getName());
    }
}