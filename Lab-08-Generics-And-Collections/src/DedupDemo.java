import java.util.*;

public class DedupDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Tariro", "Farai", "Tariro", "Rudo", "Farai", "Chipo");

        Set<String> unique = new LinkedHashSet<>(names);   // keeps first-seen order
        List<String> cleaned = new ArrayList<>(unique);

        System.out.println("Original: " + names);
        System.out.println("Cleaned:  " + cleaned);
    }
}