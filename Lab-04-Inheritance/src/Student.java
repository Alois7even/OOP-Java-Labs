public class Student extends Person {
    private final String course;

    public Student(String name, int age, String course) {
        super(name, age);                         // must be the first statement
        this.course = course;
    }

    public String getCourse() { return course; }
}