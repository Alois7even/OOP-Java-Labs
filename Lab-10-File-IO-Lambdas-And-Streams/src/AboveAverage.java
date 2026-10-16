import java.util.*;
import java.util.stream.*;

record Student(String name, double mark) {}

public class AboveAverage {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Tariro", 82), new Student("Farai", 55),
                new Student("Chipo", 70), new Student("Rudo", 91), new Student("Kuda", 48));

        double average = students.stream()
                .mapToDouble(Student::mark)
                .average()
                .orElse(0);
        System.out.printf("Class average: %.1f%n", average);

        List<String> above = students.stream()
                .filter(s -> s.mark() > average)
                .map(Student::name)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Above average: " + above);
    }
}