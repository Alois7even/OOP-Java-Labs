
interface Greeter {
    default void hello() { System.out.println("Hello from Greeter"); }
}

interface Welcomer {
    default void hello() { System.out.println("Hello from Welcomer"); }
}

// Without the override below, this class would NOT compile:
// "types Greeter and Welcomer are incompatible; class inherits unrelated defaults for hello()"
class Host implements Greeter, Welcomer {
    @Override
    public void hello() {
        Greeter.super.hello();                         // choose one explicitly
        Welcomer.super.hello();                        // or call both
        System.out.println("Hello from Host itself");
    }
}

public class DefaultConflict {
    public static void main(String[] args) {
        new Host().hello();
    }
}