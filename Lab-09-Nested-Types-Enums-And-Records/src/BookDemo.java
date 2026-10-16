import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private final String isbn;
    private final String title;

    Book(String isbn, String title) { this.isbn = isbn; this.title = title; }

    @Override
    public boolean equals(Object o) {                  // must take Object, not Book
        if (this == o) return true;
        if (!(o instanceof Book other)) return false;
        return isbn.equals(other.isbn);                // identity = ISBN only
    }

    @Override
    public int hashCode() { return Objects.hash(isbn); }   // uses the SAME field as equals

    @Override
    public String toString() { return title + " [" + isbn + "]"; }
}

public class BookDemo {
    public static void main(String[] args) {
        Set<Book> shelf = new HashSet<>();
        System.out.println(shelf.add(new Book("978-0134685991", "Effective Java")));
        System.out.println(shelf.add(new Book("978-0134685991", "Effective Java (2nd copy)")));
        System.out.println(shelf.add(new Book("978-0132350884", "Clean Code")));
        System.out.println("Set size: " + shelf.size());
    }
}