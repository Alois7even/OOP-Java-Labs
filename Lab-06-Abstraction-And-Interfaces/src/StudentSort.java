import java.util.*;

class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    Student(String name, int marks) { this.name = name; this.marks = marks; }

    String getName() { return name; }
    int getMarks()   { return marks; }

    @Override
    public int compareTo(Student other) {              // natural order: by name
        return name.compareTo(other.name);
    }

    @Override public String toString() { return name + "(" + marks + ")"; }
}

public class StudentSort {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
                new Student("Tariro", 82), new Student("Farai", 55), new Student("Chipo", 70)));

        Collections.sort(list);                        // uses compareTo
        System.out.println("By name:  " + list);

        Comparator<Student> byMarks = Comparator.comparingInt(Student::getMarks);
        list.sort(byMarks);                            // external ordering
        System.out.println("By marks: " + list);

        list.sort(byMarks.reversed());
        System.out.println("Marks desc: " + list);
    }
}