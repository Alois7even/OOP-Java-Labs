public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        library.addBook(new Book(1, "Java Programming", "John Smith"));
        library.addBook(new Book(2, "Python Basics", "Mary Jones"));
        library.addBook(new Book(3, "Database Systems", "Peter Brown"));

        // Display all books
        System.out.println("\n--- ALL BOOKS ---");
        library.displayBooks();

        // Search for a book
        System.out.println("\n--- SEARCH BOOK ---");
        library.searchBook(2);

        // Borrow a book
        System.out.println("\n--- BORROW BOOK ---");
        library.borrowBook(1);

        // Display books after borrowing
        System.out.println("\n--- BOOKS AFTER BORROWING ---");
        library.displayBooks();

        // Return a book
        System.out.println("\n--- RETURN BOOK ---");
        library.returnBook(1);

        // Display books after returning
        System.out.println("\n--- BOOKS AFTER RETURNING ---");
        library.displayBooks();
    }
}