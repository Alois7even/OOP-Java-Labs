import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveReadLines {
    public static void main(String[] args) {
        Path path = Path.of("notes.txt");
        Scanner in = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(in.nextLine());
        }

        try {
            Files.write(path, lines);                       // creates or overwrites
            System.out.println("Saved to " + path.toAbsolutePath());

            System.out.println("--- reading back ---");
            for (String line : Files.readAllLines(path)) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}