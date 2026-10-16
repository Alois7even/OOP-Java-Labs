import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class WordCount {
    public static void main(String[] args) {
        Path path = Path.of("sample.txt");
        try {
            Files.writeString(path, "Java is fun\nObjects and classes\nStreams are powerful\n");

            List<String> lines = Files.readAllLines(path);
            int words = 0, chars = 0;
            for (String line : lines) {
                chars += line.length();
                if (!line.isBlank()) {
                    words += line.trim().split("\\s+").length;
                }
            }
            System.out.println("Lines: " + lines.size());
            System.out.println("Words: " + words);
            System.out.println("Characters (excluding line breaks): " + chars);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}