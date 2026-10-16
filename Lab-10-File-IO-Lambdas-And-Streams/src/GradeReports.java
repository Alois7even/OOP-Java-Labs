import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

record Learner(String name, int roll, double gpa) {
    String toCsv() { return name + "," + roll + "," + gpa; }

    static Learner fromCsv(String line) {
        String[] p = line.split(",");
        return new Learner(p[0], Integer.parseInt(p[1]), Double.parseDouble(p[2]));
    }

    String band() {                                   // assumed cut-offs
        if (gpa >= 3.5) return "A";
        if (gpa >= 3.0) return "B";
        return "C";
    }
}

public class GradeReports {
    public static void main(String[] args) {
        Path csv = Path.of("learners.csv");
        try {
            // Create sample data so the program runs on its own
            Files.write(csv, List.of("Ada,1,3.9", "Kuda,2,3.2", "Tariro,3,3.8",
                    "Farai,4,2.7", "Rudo,5,3.1", "Chipo,6,2.4"));

            List<Learner> learners = Files.readAllLines(csv).stream()
                    .filter(line -> !line.isBlank())
                    .map(Learner::fromCsv)
                    .collect(Collectors.toList());

            Map<String, List<Learner>> byBand = learners.stream()
                    .collect(Collectors.groupingBy(Learner::band, TreeMap::new, Collectors.toList()));

            for (Map.Entry<String, List<Learner>> e : byBand.entrySet()) {
                Path report = Path.of("report-" + e.getKey() + ".txt");
                List<String> lines = e.getValue().stream()
                        .map(l -> l.name() + " (GPA " + l.gpa() + ")")
                        .collect(Collectors.toList());
                Files.write(report, lines);
                System.out.println(report + ": " + lines);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}