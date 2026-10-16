public class PeopleDemo {
    public static void main(String[] args) {
        Person p = new Person("Kudzai", 40);
        Student s = new Student("Tariro", 20, "Computer Science");
        Teacher t = new Teacher("Mr Moyo", 45, "Mathematics");

        p.display();
        s.display();                              // inherited from Person
        t.display();                              // inherited from Person
        System.out.println(s.getName() + " studies " + s.getCourse());
        System.out.println(t.getName() + " teaches " + t.getSubject());
    }
}