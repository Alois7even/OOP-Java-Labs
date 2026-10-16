record Student(String name, int age) {}

public class RecordDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Tariro", 20);
        Student s2 = new Student("Tariro", 20);
        Student s3 = new Student("Farai", 22);

        System.out.println(s1);                        // generated toString
        System.out.println("s1 == s2? " + (s1 == s2));           // different objects
        System.out.println("s1.equals(s2)? " + s1.equals(s2));   // same values
        System.out.println("s1.equals(s3)? " + s1.equals(s3));
        System.out.println("Name component: " + s1.name());      // accessor, not getName()
    }
}