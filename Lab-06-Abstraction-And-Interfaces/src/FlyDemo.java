interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override public void fly() { System.out.println("Bird flaps its wings and flies"); }
}

class Aeroplane implements Flyable {
    @Override public void fly() { System.out.println("Aeroplane takes off from the runway"); }
}

public class FlyDemo {
    public static void main(String[] args) {
        Flyable[] things = { new Bird(), new Aeroplane() };
        for (Flyable f : things) f.fly();
    }
}